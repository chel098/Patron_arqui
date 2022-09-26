package com.botcine.bot_cine.chat;

import com.botcine.bot_cine.bl.CandyBarBl;
import com.botcine.bot_cine.dto.CandyBarDto;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.HashMap;
import java.util.List;

@Service
public class MenuCandyBar extends AbstractProcess{
    private CandyBarBl candyBarBl;

    @Autowired
    public MenuCandyBar(CandyBarBl candyBarBl){
        this.candyBarBl = candyBarBl;
        this.setName("Menú CandyBar");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, CineLongPollingBot bot) {

        Long chatId = update.getMessage().getChatId();
        List<CandyBarDto> menuList = candyBarBl.findLast10PermissionsByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("MENU CANDY-BAR\r\n");
        sb.append("Lista de productos diponibles:\r\n\n");
        System.out.println(menuList.size());

        for (CandyBarDto menu: menuList){
            sb.append(menu.toString()).append("\n\r");
        }
        sb.append("\nPara reservar un producto ingrese con el siguiente formato:\r\n");
        sb.append("Nombre del producto/cantidad\r\n");
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(sb.toString());

        try {
            bot.execute(sendMessage);
        } catch (Exception ex) {
            // relanzamos la excepción
            throw new RuntimeException(ex);
        }

        return context.getBean(Reservaciones.class);
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
