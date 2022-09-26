package com.botcine.bot_cine.chat.CandyBar;

import com.botcine.bot_cine.bl.CandyBarBl;
import com.botcine.bot_cine.chat.AbstractProcess;
import com.botcine.bot_cine.chat.AccesoCandyBar;
import com.botcine.bot_cine.chat.AccesoCliente;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import com.botcine.bot_cine.dto.CandyBarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class ListaProducto extends AbstractProcess {
    private CandyBarBl candyBarBl;

    @Autowired
    public ListaProducto(CandyBarBl candyBarBl){
        this.candyBarBl = candyBarBl;
        this.setName("Lista de productos");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, CineLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();
        List<CandyBarDto> menuList = candyBarBl.findLast10PermissionsByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Lista de productos:\r\n\n");
        System.out.println(menuList.size());

        for (CandyBarDto menu: menuList){
            sb.append(menu.toString()).append("\n\r");
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(sb.toString());

        try {
            bot.execute(sendMessage);
        } catch (Exception ex) {
            // relanzamos la excepción
            throw new RuntimeException(ex);
        }
        return context.getBean(AccesoCandyBar.class);

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
