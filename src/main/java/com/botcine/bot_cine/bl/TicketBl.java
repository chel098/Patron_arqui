package com.botcine.bot_cine.bl;

import com.botcine.bot_cine.dao.CarteleraDao;
import com.botcine.bot_cine.dao.TicketDao;
import com.botcine.bot_cine.dto.CarteleraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketBl {

    private TicketDao ticketDao;

    @Autowired
    public TicketBl(TicketDao ticketDao) {

        this.ticketDao = ticketDao;
    }

    public void saveCartelera(Integer cantidad, String nombre_pelicula, String horario, String asientos){
        ticketDao.saveCartelera(cantidad,nombre_pelicula,horario, asientos);
    }
}
