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

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class AgregarPelicula extends AbstractProcess {

    private PeliculasBl peliculasBl;

    @Autowired
    public AgregarPelicula(PeliculasBl peliculasBl) {
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
        AbstractProcess result = this;
        Long chatId = update.getMessage().getChatId();
        List<PeliculasDto> peliculaList = peliculasBl.findLast10PermissionsByChatId();//cambiar
        StringBuffer sb = new StringBuffer();
        if (this.getStatus().equals("STARTED")) {
            sb.append("PARA AGREGAR A UNA PELICULA COLOQUE LA INFORMACION CON EL SIGUIENTE FORMATO:\r\n\n");
            sb.append("Nombre/Duración/Horario Inicio/Horario Final: \r\n");
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
                    setStatus("STARTED");
                    return new AccesoPeliculas();
                } catch (Exception ex) {

                }
            } else { // Si me enviaron algo diferente de un texto.

                sb.append("PARA AGREGAR A UNA PELICULA COLOQUE LA INFORMACION CON EL SIGUIENTE FORMATO:\r\n\n");
                sb.append("Nombre/Duración/Horario Inicio/Horario Final: \r\n");
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
