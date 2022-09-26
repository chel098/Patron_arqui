package com.botcine.bot_cine.chat;

import com.botcine.bot_cine.chat.peliculas.AgregarPelicula;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

public class AccesoCliente extends AbstractProcess {
    public AccesoCliente(){
        this.setName("Acceso al menu de Clientes");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }


    private void showMainMenu(CineLongPollingBot bot, Long chatId) {
        StringBuffer sb = new StringBuffer();
        sb.append("MENU DE CLIENTE\r\n");
        sb.append("1. Ver Cartelera\r\n");
        sb.append("2. Ver menu de CandyBar\r\n");
        sb.append("3. Historial de compras de tickets\r\n");
        sb.append("0. Salir\r\n");
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

                       // case 1 : result = new MenuCartelera();
                           // break;
                     //   case 2 : result = new MenuCandyBar();

                        case 1 :
                            this.setStatus("STARTED");
                            result = context.getBean(MenuCartelera.class);
                            break;
                        case 2 :
                            this.setStatus("STARTED");
                            result = context.getBean(MenuCandyBar.class);
                            break;
                        case 3 :
                            this.setStatus("STARTED");
                            result = context.getBean(HistorialCompraCartelera.class);
                            break;
                        case 4 : result = new HistorialCompraCandyBar();
                            break;
                        case 0 : result = new MenuAdministrador();
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
