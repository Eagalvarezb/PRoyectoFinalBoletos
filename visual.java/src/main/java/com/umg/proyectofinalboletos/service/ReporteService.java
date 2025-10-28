/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.proyectofinalboletos.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
/**
 *
 * @author mk
 */
public class ReporteService {
    private static final String DB_URL = "jdbc:postgresql://ep-spring-union-a4nvuj13-pooler.us-east-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require";
    private static final String DB_USER = "neondb_owner";
    private static final String DB_PASS = "npg_tnK3IO2zYcuZ";

    public static void showReport(String jrxmlPath, Map<String, Object> params) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            
            // Compilar JRXML a JasperReport
            JasperReport report = JasperCompileManager.compileReport(jrxmlPath);
            
            // Llenar el reporte con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, conn);
            
            // Mostrar en ventana nueva
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
