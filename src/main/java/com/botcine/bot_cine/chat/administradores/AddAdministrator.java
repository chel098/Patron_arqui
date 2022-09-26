package com.botcine.bot_cine.chat.administradores;

import com.botcine.bot_cine.bl.AdministratorBl;
import com.botcine.bot_cine.chat.AbstractProcess;
import com.botcine.bot_cine.chat.AccesoAdministradores;
import com.botcine.bot_cine.chat.AccesoPeliculas;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import com.botcine.bot_cine.dto.AdministradorDto;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class AddAdministrator extends AbstractProcess {

    private AdministratorBl administratorBl;

    public AddAdministrator(AdministratorBl administratorBl) {
        this.administratorBl = administratorBl;
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
            sb.append("PARA AGREGAR A UN ADMINISTRADOR COLOQUE LA INFORMACION CON EL SIGUIENTE FORMATO:\r\n\n");
            sb.append("Nombre/Apellido/Usuario/Password/chat_id: \r\n");
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
                    administratorBl.saveAdministrador(c[0], c[1], c[2],c[3],c[4]);
                    setStatus("STARTED");
                    return new AccesoAdministradores();
                } catch (Exception ex) {

                }
            } else { // Si me enviaron algo diferente de un texto.

                sb.append("PARA AGREGAR A UN ADMINISTRADOR COLOQUE LA INFORMACION CON EL SIGUIENTE FORMATO:\r\n\n");
                sb.append("Nombre/Apellido/Usuario/Password/chat_id: \r\n");
                sb.append("NO SE OLVIDE COLOCAR UN / DESPUES DE INGRESAR UN DATO \r\n");
                sendStringBuffer(bot, chatId, sb);
                setStatus("AWAITING_USER_RESPONSE");
            }
        }
        return result;}

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
