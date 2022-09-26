package com.botcine.bot_cine.bl;

import com.botcine.bot_cine.dao.ReservaCDao;
import com.botcine.bot_cine.dto.ReservaCDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaCBl {
    private ReservaCDao reservaCDao;

    public void saveReservaC(Integer paquetes_cpr, Integer cantidad, Double precio_final){
        reservaCDao.saveReservaC(paquetes_cpr, cantidad, precio_final);
    }


}
