/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.proyectofinalboletos.model;

/**
 *
 * @author mk
 */
public class Login {
    private String nombre_usuario;
    private String contrasena_hash;

    public Login(String nombre_usuario, String contrasena_hash) {
        this.nombre_usuario = nombre_usuario;
        this.contrasena_hash = contrasena_hash;
    }

    public Login() {
     
    }

    public String getNombre_usuario() { return nombre_usuario; }
    public void setNombre_usuario(String nombre_usuario) { this.nombre_usuario = nombre_usuario; }

    public String getContrasena_hash() { return contrasena_hash; }
    public void setContrasena_hash(String contrasena_hash) { this.contrasena_hash = contrasena_hash; }

}
