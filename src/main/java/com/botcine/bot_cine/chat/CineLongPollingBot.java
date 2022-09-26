package com.botcine.bot_cine.chat;

import com.botcine.bot_cine.bl.PeliculasBl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CineLongPollingBot extends TelegramLongPollingBot {

    /**
     * Atributo que sirve para guardar el proceso actual de los diferentes usuarios.
     */
    private Map<Long, AbstractProcess> usersSession;
    private boolean test = false;
    private List<BotApiMethod> testMessages = new ArrayList<>();
    private ApplicationContext context;

    private static Logger LOGGER = LoggerFactory.getLogger(PeliculasBl.class);



    public CineLongPollingBot(ApplicationContext context) {
        this.context = context;
        usersSession = new HashMap<>();
    }

    public CineLongPollingBot(ApplicationContext context,boolean test) {
        this.test = test;
        this.context = context;
        usersSession = new HashMap<>();
    }

    @Override
    public String getBotUsername() {
        return "proyecto_software_cine_bot";
    }

    @Override
    public String getBotToken() {
        return "5295491011:AAGA-gL5tYr84Otn7FY4h-CnITkgFvRwMhA";
    }

    public void sendMyMessage(BotApiMethod method) throws TelegramApiException {
        LOGGER.info("Enviando mensaje: " + method);
        if (test) {
            // no enviamos
            testMessages.add(method);
        } else {
            this.execute(method);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Primero identifico al usuario por chat Id Long
        Long chatId = update.getMessage().getChatId();
        LOGGER.info("\n\n===========> Recibiendo chatId: " + chatId);
        // Busco si ya existe Proceso en el map userSession
        AbstractProcess currentProcess = usersSession.get(chatId);

        if (currentProcess == null) { // Primera vez que se contacto con nostros.
            LOGGER.info("Creando proceso para el  chatId: " + chatId);
            // Debo crear el proceso por defecto
            currentProcess = new MenuProcessImpl();
            usersSession.put(chatId, currentProcess);
            LOGGER.info("Derivando la conversación al proceso: " + currentProcess.getName());
            AbstractProcess nextProcess = currentProcess.handle(context, update, this);

            if (!nextProcess.equals(currentProcess)) { // Si el siguiente proceso es diferente lo iniciamos
                LOGGER.info("Iniciando siguiente proceso: " + nextProcess.getName());
                nextProcess.handle(context, update, this);
            } else {
                LOGGER.info("No hay cambio de proceso, así que termina conversación");
            }
            usersSession.put(chatId, nextProcess);

        } else { // Ya existe un proceso

            AbstractProcess nextProcess = currentProcess.handle(context, update, this);

            if (!nextProcess.equals(currentProcess)) { // Si el siguiente proceso es diferente
                LOGGER.info("Iniciando siguiente proceso: " + nextProcess.getName());
                nextProcess = nextProcess.handle(context, update, this);
            } else {
                LOGGER.info("No hay cambio de proceso, así que termina conversación");
            }
            usersSession.put(chatId, nextProcess);
        }
    }

    public List<BotApiMethod> getTestMessages() {
        return testMessages;
    }
}
