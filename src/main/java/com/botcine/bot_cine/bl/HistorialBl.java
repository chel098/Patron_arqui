package com.botcine.bot_cine.bl;

import com.botcine.bot_cine.dao.HistorialDao;
import com.botcine.bot_cine.dto.CarteleraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialBl {
    private HistorialDao historialDao;

    @Autowired
    public HistorialBl(HistorialDao historialDao) {

        this.historialDao = historialDao;
    }

    public List<CarteleraDto> findLast10PermissionsByChatId(Long chatId) {

        List<CarteleraDto> hi = historialDao.findAllPeliculas();
        return hi;
    }

}
