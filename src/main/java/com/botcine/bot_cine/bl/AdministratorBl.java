package com.botcine.bot_cine.bl;

import com.botcine.bot_cine.dao.AdministradorDao;
import com.botcine.bot_cine.dto.AdministradorDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdministratorBl {

    private AdministradorDao administradorDao;

    public AdministratorBl(AdministradorDao administradorDao) {
        this.administradorDao = administradorDao;
    }

    public List<AdministradorDto> listAdmins(Integer pagina){
        return administradorDao.findAllAdministradores(pagina);
    }



    public void deleteAdministrator(Integer idAdministrator) {
        administradorDao.deleteAdministrator(idAdministrator);
    }

    public void deleteAdministrator2(Integer idAdministrador) {
        administradorDao.deleteAdministrator2(idAdministrador);
    }

    public AdministradorDto findById(Integer idAdministrador) {
        return administradorDao.findById(idAdministrador);

    }

    public void saveAdministrador(String nombre, String apellido, String fecha_nacimiento, String usuario, String password) {
        administradorDao.saveAdministrador(nombre, apellido, fecha_nacimiento, usuario, password);
    }

    public void updateAdministrator(String nombre, String apellido, String fecha_nacimiento, String usuario, String password, Integer idAdministrador) {
        administradorDao.updateAdministrator(nombre,apellido,fecha_nacimiento,usuario,password,idAdministrador);
    }
}
