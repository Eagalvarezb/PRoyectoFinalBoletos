/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.umg.proyectofinalboletos.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umg.proyectofinalboletos.model.Login;
import com.umg.proyectofinalboletos.model.response.Login_Response;
import com.umg.proyectofinalboletos.view.Login_View;
import com.umg.proyectofinalboletos.view.Dashboard;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.EntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;

import javax.swing.JOptionPane;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author mk
 * 
 */

public class LoginService {
    private static final String BASE_URL = "https://proyectofinalboletos.onrender.com/api/usuarios";
    private static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public void login(String nombre_usuario, String contrasena_hash, Login_View view) {
    try (CloseableHttpClient client = HttpClients.createDefault()) {

            Login l = new Login();
            l.setNombre_usuario(nombre_usuario);
            l.setContrasena_hash(contrasena_hash);

            HttpPost request = new HttpPost(BASE_URL + "/login");
            String json = mapper.writeValueAsString(l);
            request.setEntity(EntityBuilder.create().setText(json).setContentType(ContentType.APPLICATION_JSON).build());

            try (ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request)) {

                int statusCode = response.getCode();
                String responseBody = response.getEntity() != null ? new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8) : "";

                System.out.println("Código HTTP: " + statusCode);
                System.out.println("Respuesta del servidor: " + responseBody);

                if (statusCode == 200) {
                    Login_Response result = mapper.readValue(responseBody, Login_Response.class);

                        if (result != null && result.getId_usuario() > 0) {
                            new Dashboard().setVisible(true);
                            view.dispose();
                        }else{
                            JOptionPane.showMessageDialog(view, "Credenciales inválidas o usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
                }else if (statusCode == 404){
                    JOptionPane.showMessageDialog(view, "Usuario o contraseña incorrectos.", "Acceso denegado", JOptionPane.WARNING_MESSAGE);
                }else if (statusCode >= 500){
                        JOptionPane.showMessageDialog(view, "Error en el servidor, inténtalo más tarde.", "Error del servidor", JOptionPane.ERROR_MESSAGE);
                }else{
                        JOptionPane.showMessageDialog(view,"Respuesta inesperada del servidor (" + statusCode + ").", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view,
                    "Error al conectar con el servidor: " + e.getMessage(),
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
