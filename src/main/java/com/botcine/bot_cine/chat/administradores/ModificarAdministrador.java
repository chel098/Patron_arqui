package com.botcine.bot_cine.chat.administradores;

import com.botcine.bot_cine.chat.AbstractProcess;
import com.botcine.bot_cine.chat.CineLongPollingBot;
import com.botcine.bot_cine.dto.AdministradorDto;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
@Service
public class ModificarAdministrador extends AbstractProcess {


    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, CineLongPollingBot bot) {
        /*int c=1;
        Long chatId = update.getMessage().getChatId();

        List<AdministradorDto> adminList = administradorBl.listadoDeAdministradores(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("ADMINISTRADORES\n\r");
        sb.append("Ingrese el número del administrador que desea modificar\n\r\n");
        for(AdministradorDto admins: adminList) {
            sb.append(c + "\n\r");
            sb.append(admins.toString()).append("\n\r");
            c++;
        }
        sendStringBuffer(bot, chatId, sb);
        return new DatosModificarAdministrador();
        */
         return null;
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
