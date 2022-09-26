package com.botcine.bot_cine.chat;

import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.HashMap;


public class Asientos extends AbstractProcess {
    public Asientos() {
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
        sb.append("ASIENTOS\r\n");
        sb.append("1. A1, A2\r\n");
        sb.append("2. B3, B4\r\n");
        sb.append("3. C4, C5\r\n");
        sb.append("4. D15, D16, D17\r\n");
        sb.append("5. F13, F16, F17, F19\r\n");
        sb.append("0. Volver\r\n");
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
                        case 1 : result = new ConfirmationMessage();
                            break;
                        case 2 : result = new ConfirmationMessage();
                            break;
                        case 3 : result = new ConfirmationMessage();
                            break;
                        case 4 : result = new ConfirmationMessage();
                            break;
                        case 5 : result = new ConfirmationMessage();
                            break;
                        case 0 : result = new CantidadAsientos();
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




