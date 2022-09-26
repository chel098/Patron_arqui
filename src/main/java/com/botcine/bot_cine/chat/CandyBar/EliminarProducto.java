package com.botcine.bot_cine.chat.CandyBar;

import com.botcine.bot_cine.bl.CandyBarBl;
import com.botcine.bot_cine.chat.AbstractProcess;
import com.botcine.bot_cine.chat.AccesoCandyBar;
import com.botcine.bot_cine.chat.AccesoPeliculas;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import com.botcine.bot_cine.dto.CandyBarDto;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class EliminarProducto extends AbstractProcess {
    private CandyBarBl candyBarBl;

    public EliminarProducto(CandyBarBl candyBarBl){
        this.setName("Eliminar un producto");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, CineLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();
        int c=1;

        List<CandyBarDto> candy = candyBarBl.findLast10PermissionsByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("PRODUCTOS\n\r");
        sb.append("Ingrese el número del que desea eliminar\n\r\n");
        for(CandyBarDto prod:candy){
            sb.append(c).append("\n\r");
            sb.append(prod.toString()).append("\n\r");
            c++;
        }
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
