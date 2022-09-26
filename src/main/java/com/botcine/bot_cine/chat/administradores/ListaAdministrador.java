package com.botcine.bot_cine.chat.administradores;

import com.botcine.bot_cine.bl.AdministratorBl;
import com.botcine.bot_cine.chat.AbstractProcess;
import com.botcine.bot_cine.chat.AccesoAdministradores;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import com.botcine.bot_cine.dto.AdministradorDto;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class ListaAdministrador extends AbstractProcess {

    private AdministratorBl administratorBl;

    public ListaAdministrador(AdministratorBl administratorBl) {
        this.administratorBl = administratorBl;
        this.setName("Agregar película");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, CineLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();
        //List<AdministradorDto> administradorDtoList = administratorBl.listAdmins();
        StringBuffer sb = new StringBuffer();
        sb.append("Lista de administradores:\r\n\n");

        sb.append("Ingrese cualquier caracter para volver al menu\n\r");
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(sb.toString());

        try {
            bot.execute(sendMessage);
        } catch (Exception ex) {
            // relanzamos la excepción
            throw new RuntimeException(ex);
        }
        return new AccesoAdministradores();
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
