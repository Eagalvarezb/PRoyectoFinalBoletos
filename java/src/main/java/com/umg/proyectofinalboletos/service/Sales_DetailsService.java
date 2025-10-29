/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.proyectofinalboletos.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.umg.proyectofinalboletos.model.Sales_Details;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.entity.EntityBuilder;
import org.apache.hc.client5.http.impl.classic.*;
import org.apache.hc.core5.http.*;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author eagab
 * 
 * @editor MK
 * 
 */

public class Sales_DetailsService {
    private static final String BASE_URL = "https://proyectofinalboletos.onrender.com/api/detalle";
    private static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // GET todos
    public List<Sales_Details> getAll() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL + "/");
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            return mapper.readValue(is, new TypeReference<List<Sales_Details>>() {});
        }
    }

    // GET uno por id
    public Sales_Details getOne(int id) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL + "/" + id);
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            return mapper.readValue(is, Sales_Details.class);
        }
    }

    // POST crear
    public String create(Sales_Details a) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(BASE_URL + "/");
            String json = mapper.writeValueAsString(a);
            request.setEntity(EntityBuilder.create()
                    .setText(json)
                    .setContentType(ContentType.APPLICATION_JSON)
                    .build());

            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            String responseText = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            JsonNode jsonNode = mapper.readTree(responseText);
            if (jsonNode.has("message")) {
                return jsonNode.get("message").asText();
            } else if (response.getCode() == 201 || response.getCode() == 200) {
                return "Registro creado correctamente.";
            } else {
                return "Error desconocido al crear registro.";
            }
        }
    }

    // PUT actualizar
    public String update(int id, Sales_Details a) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPut request = new HttpPut(BASE_URL + "/" + id);

            ObjectNode jsonNode = mapper.createObjectNode();
            jsonNode.put("id_venta", a.getId_venta());
            jsonNode.put("id_localidad", a.getId_localidad());
            jsonNode.put("id_partido", a.getId_partido());
            jsonNode.put("id_inventario", a.getId_inventario());
            jsonNode.put("cantidad", a.getCantidad());
            jsonNode.put("precio_unitario", a.getPrecio_unitario());

            String json = mapper.writeValueAsString(jsonNode);
            request.setEntity(EntityBuilder.create()
                    .setText(json)
                    .setContentType(ContentType.APPLICATION_JSON)
                    .build());

            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            String responseText = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            JsonNode respJson = mapper.readTree(responseText);
            if (respJson.has("message")) {
                return respJson.get("message").asText();
            } else if (response.getCode() == 200) {
                return "Registro actualizado correctamente.";
            } else {
                return "Error desconocido al actualizar.";
            }
        }
    }

    // DELETE
    public String delete(int id) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpDelete request = new HttpDelete(BASE_URL + "/" + id);
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            String responseText = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            JsonNode jsonNode = mapper.readTree(responseText);
            if (jsonNode.has("message")) {
                return jsonNode.get("message").asText();
            } else if (response.getCode() == 200) {
                return "Registro eliminado correctamente.";
            } else {
                return "Error desconocido al eliminar.";
            }
        }
    }
}
