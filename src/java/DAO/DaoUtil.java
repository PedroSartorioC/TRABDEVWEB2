/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoUtil {
    
    public Connection conecta(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lanchonete?zeroDateTimeBehavior=convertToNull";
            String usuario = "root"; 
            String senha = "root"; 
            return DriverManager.getConnection(url, usuario, senha);
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    }
    
}
