/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.proyectofinalboletos.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umg.proyectofinalboletos.model.Matches;
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
public class MatchesService {
    private static final String BASE_URL = "http://localhost:8081/api/partidos";
    private static final ObjectMapper mapper = new ObjectMapper();

    // GET todos
    public List<Matches> getAll() throws Exception {
       try (CloseableHttpClient client = HttpClients.createDefault()) {
        HttpGet request = new HttpGet(BASE_URL + "/");
        ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
        InputStream is = response.getEntity().getContent();
        JsonNode node = mapper.readTree(is);

        if (node.has("partidos") && node.get("partidos").isArray()) {
            return mapper.convertValue(node.get("partidos"), new TypeReference<List<Matches>>() {});
        } else {
            return List.of();
        }
    }
    }

    // GET uno por id
    public Matches getOne(int id) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL + "/" + id);
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();

            JsonNode node = mapper.readTree(is);

            if (node.has("partido") && node.get("partido").isObject()) {
                return mapper.treeToValue(node.get("partido"), Matches.class);
            } else {
                return null;
            }
        }
    }

// POST crear
    public Matches create(Matches a) throws Exception {
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
            JsonNode node = mapper.readTree(is);

            if (node.has("message")) {
                System.out.println("Mensaje backend: " + node.get("message").asText());
            }

            if (node.has("partido")) {
                return mapper.treeToValue(node.get("partido"), Matches.class);
            }
            return null;
        }
    }

// PUT actualizar
    public String update(int id, Matches a) throws Exception {
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
            JsonNode node = mapper.readTree(is);

            if (node.has("message")) {
                return node.get("message").asText();
            } else {
                return "Partido actualizado, pero no se recibió mensaje del servidor.";
            }
        }
    }

// DELETE
    public String delete(int id) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpDelete request = new HttpDelete(BASE_URL + "/" + id);
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            JsonNode node = mapper.readTree(is);

            if (node.has("message")) {
                return node.get("message").asText();
            } else {
                return "Partido eliminado, pero no se recibió mensaje del servidor.";
            }
        }
    }
}
