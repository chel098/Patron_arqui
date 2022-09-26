package com.botcine.bot_cine.chat.administradores;

import com.botcine.bot_cine.chat.AbstractProcess;
import com.botcine.bot_cine.chat.AccesoAdministradores;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class DatosModificarAdministrador extends AbstractProcess {
    public DatosModificarAdministrador() {
        this.setName("Modificación de datos del administrador");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, CineLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();
        StringBuffer sb = new StringBuffer();
        sb.append("PARA MODIFICAR UN ADMINISTRADOR, DEBERA INGRESAR LOS DATOS EN EL SIGUIENTE ORDEN:\r\n\n");
        sb.append("Nombre: \r\n");
        sb.append("Apellido: \r\n");
        sb.append("Usuario: \r\n");
        sb.append("Password: \r\n");

        sendStringBuffer(bot, chatId, sb);
        return new AccesoAdministradores();
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
