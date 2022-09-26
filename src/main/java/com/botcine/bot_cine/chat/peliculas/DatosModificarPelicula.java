package com.botcine.bot_cine.chat.peliculas;

import com.botcine.bot_cine.chat.AbstractProcess;

import com.botcine.bot_cine.chat.AccesoPeliculas;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class DatosModificarPelicula extends AbstractProcess {
    public DatosModificarPelicula() {
        this.setName("Modificación de datos pelicula");
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
        sb.append("PARA MODIFICAR UNA PELÍCULA, DEBERA INGRESAR LOS DATOS EN EL SIGUIENTE ORDEN:\r\n\n");
        sb.append("Nombre: \r\n");
        sb.append("Duración: \r\n");
        sb.append("Genero: \r\n");


        sendStringBuffer(bot, chatId, sb);
        return new AccesoPeliculas();
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
