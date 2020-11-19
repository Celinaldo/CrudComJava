/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author jr
 */
public class ConectionFactory {
    private final String url = "jdbc:mysql://localhost/mercado";
    private final String user = "root";
    private final String password = "yeda281289";
    
    
    
    
    
    public Connection getConexao(){
        try {
            DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return getConexao();
        
    }
  
}
