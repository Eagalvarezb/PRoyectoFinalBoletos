/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.proyectofinalboletos.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umg.proyectofinalboletos.model.Place;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.entity.EntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;

import java.io.InputStream;
import java.util.List;
/**
 *
 * @author eagab
 * 
 * @editor MK
 * 
 */
public class PlaceService {
    private static final String BASE_URL = "https://proyectofinalboletos.onrender.com/api/localidades";
    private static final ObjectMapper mapper = new ObjectMapper();
    
    // GET todos
    public List<Place> getAll() throws Exception { 
        try (CloseableHttpClient client = HttpClients.createDefault()) { 
            HttpGet request = new HttpGet(BASE_URL + "/"); 
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request); 
            InputStream is = response.getEntity().getContent(); 
            return mapper.readValue(is, new TypeReference<List<Place>>() {}
            ); 
        } 
    }

    // GET uno por id
    public Place getOne(int id) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL + "/" + id);
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();

            // Validar que la respuesta tenga contenido
            if (is == null) {
                return null;
            }

            // Leer JSON directamente como objeto Place
            return mapper.readValue(is, Place.class);
        }
    }

    // POST crear
    public Place create(Place a) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(BASE_URL + "/");
            String json = mapper.writeValueAsString(a);
            request.setEntity(EntityBuilder.create()
                    .setText(json)
                    .setContentType(ContentType.APPLICATION_JSON)
                    .build()
            );

            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            return mapper.readValue(is, Place.class);
        }
    }

    // PUT actualizar
    public Place update(int id, Place a) throws Exception {
    try (CloseableHttpClient client = HttpClients.createDefault()) {
        HttpPut request = new HttpPut(BASE_URL + "/" + id);
        String json = mapper.writeValueAsString(a);
        request.setEntity(EntityBuilder.create()
                .setText(json)
                .setContentType(ContentType.APPLICATION_JSON)
                .build()
        );

        ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
        InputStream is = response.getEntity().getContent();
        return mapper.readValue(is, Place.class);
    }
    }

    // DELETE
    public void delete(int id) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpDelete request = new HttpDelete(BASE_URL + "/" + id);
            client.execute(request).close();
        }
    }
}
