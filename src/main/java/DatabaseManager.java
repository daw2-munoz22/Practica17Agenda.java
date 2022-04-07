
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jupiter
 */
public class DatabaseManager {
    private String direccion = "jdbc:sqlite:";
    private Connection con = null;
    
    
    public DatabaseManager(String ruta) throws SQLException{
        direccion += ruta;
        con = DriverManager.getConnection(direccion);  
        System.out.println("Connection to SQLite has been established.");     
    }
    
}
