package com.botcine.bot_cine.bl;

import com.botcine.bot_cine.dao.PeliculasDao;
import com.botcine.bot_cine.dto.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculasBl {

    private PeliculasDao peliculasDao;

    @Autowired
    public PeliculasBl(PeliculasDao peliculasDao) {
        this.peliculasDao = peliculasDao;
    }

    public List<PeliculasDto> findLast10PermissionsByChatId() {

        List<PeliculasDto> Pel = peliculasDao.findAllPeliculas();
        return Pel;
    }

    public BusquedaDto findByName(String nombre) {
        return peliculasDao.showPeliculas(nombre);
    }

    public HorariosDto findByPeliculasId(Integer peliculasId, Integer horarioId) {
        return peliculasDao.showHorario(peliculasId, horarioId);
    }

    public AsientosDto findByIds(Integer peliculasId, Integer horarioId) {
        return peliculasDao.showAsientos(peliculasId, horarioId);
    }

    public void saveTicket(String date, String seast, Integer peliculas_horario_id_peliculas_horario) {
        peliculasDao.saveTicket(date, seast, peliculas_horario_id_peliculas_horario);
    }

    public PeliculasDto findDatosPago(Integer datosPagoId) {
        return peliculasDao.showdatosPago(datosPagoId);
    }

    public void saveDatosPago(String payment, Integer card, Integer lastDigist, String expirationDate, String name, Integer nit, Integer compra_ticket_compraticketid) {
        peliculasDao.addDatosPago(payment, card, lastDigist, expirationDate, name, nit, compra_ticket_compraticketid);
    }

}
