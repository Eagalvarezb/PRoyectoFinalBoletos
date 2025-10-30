/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.proyectofinalboletos.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.umg.proyectofinalboletos.model.Ticket_Inventory;
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

public class Ticket_InventoryService {
    private static final String BASE_URL = "http://localhost:8081/api/inventarios";
    private static final ObjectMapper mapper = new ObjectMapper();

    // GET todos
    public List<Ticket_Inventory> getAll() throws Exception { 
        try (CloseableHttpClient client = HttpClients.createDefault()) { 
            HttpGet request = new HttpGet(BASE_URL + "/"); 
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request); 
            InputStream is = response.getEntity().getContent(); 
            return mapper.readValue(is, new TypeReference<List<Ticket_Inventory>>() {}
            ); 
        } 
    }

    // GET uno por id
    public Ticket_Inventory getOne(int id) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL + "/" + id);
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();

            // Leer el JSON directo, sin "data"
            return mapper.readValue(is, Ticket_Inventory.class);
        }
    }

    // POST crear
    public Ticket_Inventory create(Ticket_Inventory a) throws Exception {
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
            return mapper.readValue(is, Ticket_Inventory.class);
        }
    }

    // PUT actualizar
    public Ticket_Inventory update(int id, Ticket_Inventory a) throws Exception {
    try (CloseableHttpClient client = HttpClients.createDefault()) {
        HttpPut request = new HttpPut(BASE_URL + "/" + id);

        // Solo enviar los campos actualizables
        ObjectNode jsonNode = mapper.createObjectNode();
        jsonNode.put("id_partido", a.getIdPartido());
        jsonNode.put("id_localidad", a.getIdLocalidad());
        jsonNode.put("cantidad_total", a.getCantidadTotal());
        jsonNode.put("cantidad_disponible", a.getCantidadDisponible());

        String json = mapper.writeValueAsString(jsonNode);

        request.setEntity(EntityBuilder.create()
                .setText(json)
                .setContentType(ContentType.APPLICATION_JSON)
                .build()
        );

        ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
        InputStream is = response.getEntity().getContent();
        return mapper.readValue(is, Ticket_Inventory.class);
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
