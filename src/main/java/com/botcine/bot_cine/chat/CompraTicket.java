package com.botcine.bot_cine.chat;

import com.botcine.bot_cine.bl.CarteleraBl;
import com.botcine.bot_cine.bl.TicketBl;
import com.botcine.bot_cine.dto.CarteleraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class CompraTicket extends AbstractProcess {

    private TicketBl ticketBl;

    @Autowired
    public CompraTicket(TicketBl ticketBl) {
        this.ticketBl = ticketBl;
        this.setName("Agregar película");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override

    public AbstractProcess handle(ApplicationContext context, Update update, CineLongPollingBot bot) {
        AbstractProcess result = this;
        Long chatId = update.getMessage().getChatId();
        StringBuffer sb = new StringBuffer();
        if (this.getStatus().equals("STARTED")) {
            sb.append("PARA AGREGAR REALIZAR LA COMPRA DE UN TICKET SIGA EL SIGUIENTE FORMATO:\r\n\n");
            sb.append("Cantidad/Nombre Pelicula/Horario/Asientos: \r\n");
            sb.append("NO SE OLVIDE COLOCAR UN / DESPUES DE INGRESAR UN DATO \r\n");
            sendStringBuffer(bot, chatId, sb);
            setStatus("AWAITING_USER_RESPONSE");
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            Message message = update.getMessage();
            if (message.hasText()) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {

                    String c[] = text.split("/");
                    ticketBl.saveCartelera(Integer.parseInt(c[0]), c[1], c[2], c[3]);
                    setStatus("STARTED");
                    return new ConfirmationMessage();
                } catch (Exception ex) {

                }
            } else { // Si me enviaron algo diferente de un texto.

                sb.append("PARA AGREGAR REALIZAR LA COMPRA DE UN TICKET SIGA EL SIGUIENTE FORMATO:\r\n\n");
                sb.append("Cantidad/Nombre Pelicula/Horario/Asientos: \r\n");
                sb.append("NO SE OLVIDE COLOCAR UN / DESPUES DE INGRESAR UN DATO \r\n");
                sendStringBuffer(bot, chatId, sb);
                setStatus("AWAITING_USER_RESPONSE");
            }
        }
        return result;
    }

    @Override
    public AbstractProcess onError() {
        return null;
    }

    @Override
    public AbstractProcess onSuccess() {
        return null;
    }

    @Override
    public AbstractProcess onTimeout() {
        return null;
    }


}




