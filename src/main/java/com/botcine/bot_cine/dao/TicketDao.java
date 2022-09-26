package com.botcine.bot_cine.dao;
import com.botcine.bot_cine.dto.CarteleraDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketDao {

    @Insert("INSERT INTO compra_ticket(cantidad, nombre_pelicula, horario, asientos)" +
            " VALUES (#{cantidad}, #{nombre_pelicula}, #{horario}, #{asientos})")

    void saveCartelera(@Param("cantidad") Integer cantidad, @Param("nombre_pelicula") String nombre_pelicula, @Param("horario") String horario, @Param("asientos") String asientos);

}
