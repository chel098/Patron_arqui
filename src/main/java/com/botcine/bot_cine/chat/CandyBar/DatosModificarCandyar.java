package com.botcine.bot_cine.chat.CandyBar;

import com.botcine.bot_cine.chat.AbstractProcess;
import com.botcine.bot_cine.chat.AccesoCandyBar;
import com.botcine.bot_cine.chat.AccesoPeliculas;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Update;

public class DatosModificarCandyar extends AbstractProcess {
    public DatosModificarCandyar(){
        this.setName("Modificación de productos");
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
        sb.append("PARA MODIFICAR UN PRODUCTO, DEBERA INGRESAR LOS DATOS EN EL SIGUIENTE ORDEN:\r\n\n");
        sb.append("Nombre: \r\n");
        sb.append("Precio: \r\n");


        sendStringBuffer(bot, chatId, sb);
        return new AccesoCandyBar();
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
