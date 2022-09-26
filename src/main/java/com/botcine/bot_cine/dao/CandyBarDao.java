package com.botcine.bot_cine.dao;


import com.botcine.bot_cine.dto.CandyBarDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CandyBarDao {

    @Select("SELECT cpr, nombre, precio " +
            "FROM paquetes")
    public List<CandyBarDto> findAllCandyBar();

    @Insert("INSERT INTO paquetes(nombre, precio)"+" VALUES (#{nombre}, #{precio} )")
    void saveProductos (@Param("nombre") String nombre, @Param("precio") Double precio);
}
