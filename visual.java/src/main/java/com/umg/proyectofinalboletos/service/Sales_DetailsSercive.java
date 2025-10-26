/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.proyectofinalboletos.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umg.proyectofinalboletos.model.Sales_Details;
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
 */
public class Sales_DetailsSercive {
    private static final String BASE_URL = "";//agregar la url 
    private static final ObjectMapper mapper = new ObjectMapper();

    // GET Sales_Details
    public List<Sales_Details> getSales_Details() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL);
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            return mapper.readValue(is, new TypeReference<List<Sales_Details>>() {});
        }
    }

    // POST crear Sales_Details
    public Sales_Details createSales_Details(Sales_Details sd) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(BASE_URL + "/create");
            String json = mapper.writeValueAsString(sd);

            request.setEntity(EntityBuilder.create()
                    .setText(json)
                    .setContentType(ContentType.APPLICATION_JSON)
                    .build());

            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            return mapper.readValue(is, Sales_Details.class);
        }
    }  
    
    //Put actualizar Sales_Details
    public Sales_Details updateSales_Details(int id, Sales_Details sd)throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()){
            HttpPut request = new HttpPut (BASE_URL + "/update/" + id);
            String json = mapper.writeValueAsString(sd);
            
            request.setEntity(EntityBuilder.create()
                   .setText(json)
                   .setContentType(ContentType.APPLICATION_JSON)
                   .build()); 
            ClassicHttpResponse response = (ClassicHttpResponse)client.execute(request);
            InputStream is = response.getEntity().getContent();
            return mapper.readValue(is, Sales_Details.class);
        }
    }
    
    //Delete eleminar Sales_Details
    public void deleteSales_Details(int id) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()){
            HttpDelete request = new HttpDelete(BASE_URL+ "/delete/" + id);
            client.execute(request).close();
        }
    }
}
