package com.botcine.bot_cine.chat;

import com.botcine.bot_cine.chat.widgets.AbstractWidget;
import com.botcine.bot_cine.chat.widgets.MenuWidgetImpl;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MenuProcessImpl extends AbstractProcess {
    public MenuProcessImpl() {
        this.setName("Menú principal");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    // Retornar un Widget de tipo menu
//    @Override
//    public AbstractWidget onInit() {
//        MenuWidgetImpl menuWidget = new MenuWidgetImpl(messages);
//        return menuWidget;
//    }



    private void showMainMenu(CineLongPollingBot bot, Long chatId) {
        StringBuffer sb = new StringBuffer();
        sb.append("BIENVENIDO AL BOT DE RESERVAS HIGH SCHOOL MUSICAL\r\n");
        sb.append("Ingrese la opcion de cliente para hacer la reserva \r\n");
        sb.append("1. CLIENTE\r\n");
        sb.append("2. ADMINISTRADOR\r\n");
        sb.append("Elija una opción:\r\n");
        sendStringBuffer(bot, chatId, sb);


        this.setStatus("AWAITING_USER_RESPONSE");
    }


    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, CineLongPollingBot bot) {
        AbstractProcess result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();

        if (this.getStatus().equals("STARTED")) {

            showMainMenu(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {
                    int opcion = Integer.parseInt(text);
                    switch (opcion){
                        case 1 : result = new AccesoCliente();
                            break;

                        case 2 : result = new MenuAdministrador();
                            break;



                        default: showMainMenu(bot, chatId);
                    }
                } catch (NumberFormatException ex) {
                    showMainMenu(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMainMenu(bot, chatId);
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


