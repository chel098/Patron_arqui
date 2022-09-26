package com.botcine.bot_cine.dto;

public class AdministradorDto {
    Integer id_admin;
    String nombre;
    String apellido;
    String fecha_nacimiento;
    String usuario;
    String password;
    Integer status;
    public AdministradorDto(Integer id_admin, String nombre, String apellido, String fecha_nacimiento, String usuario, String password, Integer status) {
        this.id_admin = id_admin;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.usuario = usuario;
        this.password = password;
        this.status = status;
    }

    public Integer getId_admin() {
        return id_admin;
    }

    public void setId_admin(Integer id_admin) {
        this.id_admin = id_admin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdministradorDto{" +
                "id_admin=" + id_admin +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
