package com.botcine.bot_cine.dao;

import com.botcine.bot_cine.dto.AdministradorDto;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdministradorDao {
    @Select("SELECT id_admin, nombre, apellido, fecha_nacimiento, usuario, password, status FROM administrador where status = 1 LIMIT 5 OFFSET 5* #{pagina} ;")
    List<AdministradorDto> findAllAdministradores(@Param("pagina") Integer pagina);
    @Insert("INSERT INTO administrador(nombre, apellido, fecha_nacimiento, usuario, password)" +
            " VALUES (#{nombre}, #{apellido}, #{fecha_nacimiento} , #{usuario}, #{password})")

    void saveAdministrador(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("fecha_nacimiento") String fecha_nacimiento, @Param("usuario") String usuario, @Param("password") String password);

    @Update("UPDATE administrador " +
            "            SET nombre      = #{nombre}, " +
            "               apellido    = #{apellido}, " +
            "               fecha_nacimiento    = #{fecha_nacimiento}, " +
            "                usuario     = #{usuario} , " +
            "               password    = #{password} " +
            "               WHERE id_admin = #{idAdministrador};")

    void updateAdministrator(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("fecha_nacimiento") String fecha_nacimiento, @Param("usuario") String usuario, @Param("password") String password,@Param ("idAdministrador") Integer idAdministrador);

    @Delete("DELETE " +
            "FROM administrador " +
            "WHERE id_admin = #{idAdministrador};")
    void deleteAdministrator(@Param ("idAdministrador") Integer idAdministrador);

    @Update("UPDATE administrador " +
            "SET status = 0 " +
            "WHERE id_admin = #{idAdministrador};")
    void deleteAdministrator2(Integer idAdministrador);

    @Select("SELECT id_admin, nombre, apellido, fecha_nacimiento, usuario, password, status FROM administrador where status = 1 and id_admin = #{idAdministrador};")
    AdministradorDto findById(Integer idAdministrador);



}
