package com.botcine.bot_cine.chat.CandyBar;

import com.botcine.bot_cine.bl.CandyBarBl;
import com.botcine.bot_cine.bl.PeliculasBl;
import com.botcine.bot_cine.chat.AbstractProcess;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import com.botcine.bot_cine.chat.peliculas.DatosModificarPelicula;
import com.botcine.bot_cine.dto.CandyBarDto;
import com.botcine.bot_cine.dto.PeliculasDto;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class ModificarProducto extends AbstractProcess {
    private CandyBarBl candyBarBl;
    public ModificarProducto(CandyBarBl candyBarBl){
        this.setName("Modificar datos del candybar");
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
        List<CandyBarDto> candy = candyBarBl.findLast10PermissionsByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("CANDY-BAR\n\r");
        sb.append("Ingrese el número del producto que desea modificar\n\r\n");
        for(CandyBarDto prod: candy) {
            sb.append(c+ ":");
            sb.append(prod.toString()).append("\n\r");
            c++;
        }
        sendStringBuffer(bot, chatId, sb);
        return new DatosModificarCandyar();

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
