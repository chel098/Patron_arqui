package com.botcine.bot_cine.chat;

import com.botcine.bot_cine.bl.ReservaCBl;
import com.botcine.bot_cine.dto.PeliculasDto;
import com.botcine.bot_cine.dto.ReservaCDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class Reservaciones extends AbstractProcess {
    private ReservaCBl reservaCBl;

    @Autowired
    public Reservaciones (ReservaCBl reservaCBl){
        this.reservaCBl=reservaCBl;
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
            sb.append("PARA AGREGAR UN PRODUCTO INGRESE CON EL SIGUIENTE FORMATO:\r\n\n");
            sb.append("Nombre/Precio : \r\n");
            sendStringBuffer(bot, chatId, sb);
            setStatus("AWAITING_USER_RESPONSE");
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            Message message = update.getMessage();
            if (message.hasText()) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {

                    String c[] = text.split("/");
                    reservaCBl.saveReservaC(Integer.parseInt(c[0]),Integer.parseInt(c[1]),Double.parseDouble(c[2]));
                    setStatus("STARTED");
                    return new AccesoCandyBar();
                } catch (Exception ex) {

                }
            } else { // Si me enviaron algo diferente de un texto.

                sb.append("PARA AGREGAR UN PRODUCTO INGRESE CON EL SIGUIENTE FORMATO:\r\n\n");
                sb.append("Nombre/Precio : \r\n");
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
