package com.botcine.bot_cine.dao;

import com.botcine.bot_cine.dto.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeliculasDao {

    @Select("SELECT peliculasId, name, image, language, adaptation, gender, duration, definition " +
            "FROM peliculas")
    public List<PeliculasDto> findAllPeliculas();

    @Select("SELECT peliculasId, name "+
            "FROM peliculas WHERE name = #{name}")
    BusquedaDto showPeliculas(@Param("name") String nombre);

    @Select("SELECT a.peliculasId, b.horarioId, a.name, a.image, b.schedule " +
            "FROM peliculas a, horarios b, peliculas_horario c " +
            "WHERE #{peliculaId} = a.peliculasId " +
            "AND #{horarioId} = b.horarioId")
    HorariosDto showHorario(@Param ("peliculaId") Integer peliculasId,@Param ("horarioId") Integer horarioId);

    @Select("SELECT a.peliculasId, b.horarioId, c.seats "+
            "FROM peliculas a, horarios b, asientos c " +
            "WHERE c.status = true " +
            "AND #{peliculaId} = a.peliculasId " +
            "AND #{horarioId} = b.horarioId ")
    AsientosDto showAsientos(@Param ("peliculaId") Integer peliculasId,@Param ("horarioId") Integer horarioId);

    @Insert("INSERT INTO compra_ticket(date, seats, peliculas_horario_id_peliculas_horario)" +
            " VALUES (#{date}, #{seats}, #{peliculas_horario_id_peliculas_horario})")
    void saveTicket(@Param("date") String date, @Param("seats") String seast,
                    @Param("peliculas_horario_id_peliculas_horario") Integer peliculas_horarios_id_peliculas_horario );

    @Select("SELECT a.peliculasId, b.horarioId, a.name, ")
    PeliculasDto showdatosPago(Integer datosPagoId);

    @Insert("INSERT INTO datos_pago(payment, card, lastdigist, expirationdate, name, nit, compra_ticket_compraticketid)" +
            " VALUES (#{payment}, #{card}, #{lastdigist}, #{expirationdate}, #{name}, #{nit}, #{compra_ticket_compraticketid})")
    void addDatosPago(@Param("payment") String payment, @Param("card") Integer card,
                      @Param("lastdigist") Integer lastDigist, @Param("expirationdate") String expirationDate,
                      @Param("name") String name, @Param("nit") Integer nit,
                      @Param("compra_ticket_compraticketid") Integer compra_ticket_compraticketid);
}

