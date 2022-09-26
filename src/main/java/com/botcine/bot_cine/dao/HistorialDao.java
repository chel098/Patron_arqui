package com.botcine.bot_cine.dao;

import com.botcine.bot_cine.dto.CarteleraDto;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistorialDao {
    @Select("SELECT cpt, cantidad, nombre_pelicula, horario, asientos, cantidad*45 as Total " +
                "FROM compra_ticket")
    public List<CarteleraDto> findAllPeliculas();
}
