package com.botcine.bot_cine.chat.peliculas;

import com.botcine.bot_cine.bl.PeliculasBl;
import com.botcine.bot_cine.chat.AbstractProcess;
import com.botcine.bot_cine.chat.AccesoPeliculas;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import com.botcine.bot_cine.dto.AsientosDto;
import com.botcine.bot_cine.dto.PeliculasDto;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class ModificarPelicula extends AbstractProcess {

    private PeliculasBl peliculasBl;

    public ModificarPelicula(PeliculasBl peliculasBl) {
        this.peliculasBl = peliculasBl;
        this.setName("Modificar datos de las películas");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }


    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, CineLongPollingBot bot) {
        int c=1;
        Long chatId = update.getMessage().getChatId();
        List<PeliculasDto> peliculaList = peliculasBl.findLast10PermissionsByChatId();//cambiat
        StringBuffer sb = new StringBuffer();
        sb.append("PELÍCULAS\n\r");
        sb.append("Ingrese el número de la película que desea modificar\n\r\n");
        for(PeliculasDto pelicula: peliculaList) {
            sb.append(c+ ":");
            sb.append(pelicula.toString()).append("\n\r");
            c++;
        }
        sendStringBuffer(bot, chatId, sb);
        return new DatosModificarPelicula();
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
