package com.botcine.bot_cine.api;

import com.botcine.bot_cine.bl.AdministratorBl;
import com.botcine.bot_cine.dto.AdministradorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdministradorApi {
    private AdministratorBl administratorBl;

    @Autowired
    public AdministradorApi(AdministratorBl administratorBl) {
        this.administratorBl = administratorBl;
    }

    @GetMapping(value = "/administrators/pagina/{pagina}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdministradorDto> listAll(@PathVariable ("pagina") Integer pagina) {
        return administratorBl.listAdmins(pagina);
    }

    @PostMapping(path="/administrators", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public String addAdministrador(@RequestBody AdministradorDto administradorDto) {
        administratorBl.saveAdministrador(administradorDto.getNombre(),administradorDto.getApellido(),administradorDto.getFecha_nacimiento(),administradorDto.getUsuario(),administradorDto.getPassword());
        return "Administrador Registrado";
    }

    @PutMapping(path= "/administrators/{idAdministrador}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateAdministrador(@PathVariable ("idAdministrador") Integer idAdministrador,@RequestBody AdministradorDto administradorDto){
        administratorBl.updateAdministrator(administradorDto.getNombre(),administradorDto.getApellido(),administradorDto.getFecha_nacimiento(),administradorDto.getUsuario(),administradorDto.getPassword(),idAdministrador);
        return "Administrador Actualizado";
    }

    @DeleteMapping(path= "/administrators/{idAdministrador}", produces = MediaType.APPLICATION_JSON_VALUE )
    public String deleteAdministrador(@PathVariable ("idAdministrador")Integer idAdministrador){
        administratorBl.deleteAdministrator(idAdministrador);
        return "Eliminado exitoso";
    }

    @PutMapping(path= "/administrators/delete/{idAdministrador}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteAdministrador2(@PathVariable ("idAdministrador") Integer idAdministrador){
        administratorBl.deleteAdministrator2(idAdministrador);
        return "Eliminado status";
    }

    @GetMapping(value = "/administrators/{idAdministrador}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdministradorDto findById(@PathVariable ("idAdministrador") Integer idAdministrador) {
        return administratorBl.findById(idAdministrador);
    }

}
