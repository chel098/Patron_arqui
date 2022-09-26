package com.botcine.bot_cine.chat.peliculas;

import com.botcine.bot_cine.bl.PeliculasBl;
import com.botcine.bot_cine.chat.AbstractProcess;
import com.botcine.bot_cine.chat.AccesoPeliculas;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import com.botcine.bot_cine.dto.AsientosDto;
import com.botcine.bot_cine.dto.PeliculasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class ListaPeliculas extends AbstractProcess {

    private PeliculasBl peliculasBl;

    @Autowired
    public ListaPeliculas(PeliculasBl peliculasBl) {
        this.peliculasBl = peliculasBl;
        this.setName("Agregar película");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }


    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, CineLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();
        List<PeliculasDto> peliculaList = peliculasBl.findLast10PermissionsByChatId();//cambiar
        StringBuffer sb = new StringBuffer();
        sb.append("Lista de peliculas:\r\n\n");

        System.out.println(peliculaList.size());
        for(PeliculasDto pelicula: peliculaList) {
            sb.append(pelicula.toString()).append("\n\r");
        }
        sb.append("Ingrese cualquier caracter para volver al menu\n\r");

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(sb.toString());

        try {
            bot.execute(sendMessage);
        } catch (Exception ex) {
            // relanzamos la excepción
            throw new RuntimeException(ex);
        }
        return context.getBean(AccesoPeliculas.class);
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
