package com.botcine.bot_cine.api;

import com.botcine.bot_cine.bl.PeliculasBl;
import com.botcine.bot_cine.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class PeliculasApi {
    private PeliculasBl  peliculasBl;
    @Autowired
    public PeliculasApi(PeliculasBl peliculasBl) {
        this.peliculasBl = peliculasBl;
    }

    @GetMapping(path = "/peliculas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PeliculasDto> findLast10PermissionsByChatId() {
        return peliculasBl.findLast10PermissionsByChatId();
    }

    @GetMapping(path = "/peliculas/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BusquedaDto findById(@PathVariable("{nombre}") String nombre) {
        return peliculasBl.findByName(nombre);
    }

    @GetMapping(path = "/peliculas/{peliculasId}/horario/{horarioId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HorariosDto findHorarioById(@PathVariable ("peliculasId") Integer peliculasId, @PathVariable ("horarioId") Integer horarioId) {
        return peliculasBl.findByPeliculasId(peliculasId, horarioId);
    }

    @GetMapping(path = "/peliculas/{peliculasId}/horario/{horarioId}&state=true", produces = MediaType.APPLICATION_JSON_VALUE)
    public AsientosDto findByIds(@PathVariable("peliculasId") Integer peliculasId, @PathVariable("horarioId") Integer horarioId) {
        return peliculasBl.findByIds(peliculasId, horarioId);
    }

    @PostMapping(path="/compraTicket")
    public void addTicket(@RequestBody CompraTicketDto  compraTicketDto) {
        peliculasBl.saveTicket(compraTicketDto.getDate(), compraTicketDto.getSeats(), compraTicketDto.getPeliculas_horario_id_peliculas_horario());
    }

    @GetMapping(path = "/datosPago/{datosPagoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PeliculasDto findByIdPago(@PathVariable("datosPagoId") Integer datosPagoId){
        return peliculasBl.findDatosPago(datosPagoId);
    }

    @PostMapping(path="/datosPago", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public String addDatosPago (@RequestBody DatosPagoDto datosPagoDto) {
        peliculasBl.saveDatosPago(datosPagoDto.getPayment(), datosPagoDto.getCard(), datosPagoDto.getLastDigist(),
                datosPagoDto.getExpirationDate(), datosPagoDto.getName(), datosPagoDto.getNit(), datosPagoDto.getCompra_ticket_compraticketid());
        return "Datos del Pago Registrado";
    }
}
