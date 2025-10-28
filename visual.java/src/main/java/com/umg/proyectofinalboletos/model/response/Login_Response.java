package com.umg.proyectofinalboletos.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MK
 */

@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos extras como contrasena_hash
public class Login_Response {

    @JsonProperty("id_usuario")
    private int id_usuario;

    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }
}
