package com.botcine.bot_cine.dao;

import com.botcine.bot_cine.dto.CarteleraDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarteleraDao {

    @Select("SELECT cp, nombre, duracion, horario_inicio, horario_final" +
            "FROM peliculas ")
    public List<CarteleraDto> findAllPeliculas();


}


