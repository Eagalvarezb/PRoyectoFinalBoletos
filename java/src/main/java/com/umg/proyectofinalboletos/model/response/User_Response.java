package com.umg.proyectofinalboletos.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.umg.proyectofinalboletos.model.User;
import java.util.Date;

/**
 * @author MK
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User_Response {
    private int id_usuario;
    private String nombre_usuario;
    private String nombre_completo;
    private String rol;
    private Date fecha_creacion;

    public User_Response() {}

    public User_Response(int id_usuario, String nombre_usuario, String nombre_completo, String rol, Date fecha_creacion) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.nombre_completo = nombre_completo;
        this.rol = rol;
        this.fecha_creacion = fecha_creacion;
    }
    
    public User_Response(User user) {
        this.id_usuario = user.getId_usuario();
        this.nombre_usuario = user.getNombre_usuario();
        this.nombre_completo = user.getNombre_completo();
        this.rol = user.getRol();
        this.fecha_creacion = user.getFecha_creacion();
    }   

    // Getters y setters
    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }

    public String getNombre_usuario() { return nombre_usuario; }
    public void setNombre_usuario(String nombre_usuario) { this.nombre_usuario = nombre_usuario; }

    public String getNombre_completo() { return nombre_completo; }
    public void setNombre_completo(String nombre_completo) { this.nombre_completo = nombre_completo; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public Date getFecha_creacion() { return fecha_creacion; }
    public void setFecha_creacion(Date fecha_creacion) { this.fecha_creacion = fecha_creacion; }

}
