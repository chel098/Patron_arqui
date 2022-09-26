package com.botcine.bot_cine.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface ReservaCDao {

    @Insert("INSERT INTO compra_paquetes(Paquetes_CPR, Cantidad, precio_final)"
            + " VALUES ( #{Paquetes_CPR}, #{Cantidad}, #{precio_final}) ")
    void saveReservaC(@Param("Paquetes_CPR") Integer paquetes_cpr, @Param("Cantidad") Integer cantidad, @Param("precio_final") Double precio_final);
}
