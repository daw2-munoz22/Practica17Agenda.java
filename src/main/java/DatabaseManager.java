
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.lang.String;

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
    
    
    public DatabaseManager(String ruta){
        direccion += ruta;
       
        System.out.println("Connection to SQLite has been established.");     
    }
    public Connection getConnection() throws SQLException{
        try {
            con = DriverManager.getConnection(direccion);
            System.out.println("FUNCIONA"); 
            return con;
        } catch(SQLException e){
            System.out.println("Ha fallado la conexion. Por favor solucionalo y vuelve a intentarlo"); 
            return null;           
        }           
    }
   
    public void getDriver() throws SQLException{//Funcion para obtener Estado del driver
       try{          
           //Similar "Abstract.DataBoundObject(PHP)"
           Connection conectar = getConnection();
           if(conectar != null){//Comprovar conexion               
               DatabaseMetaData driver = conectar.getMetaData();//Obtener los datos del driver           
               System.out.println("El driver es " + driver.getDriverName());
           }
       }catch(SQLException e){
           System.out.println("El error es: "+e.getMessage());
       }      
       
    }

    public void createDatabaseQuery() throws SQLException{
        String query1 = "CREATE TABLE IF NOT EXISTS Dades (Id integer PRIMARY KEY AUTOINCREMENT, Nom text, Mail text, Cognom1 text, Cognom2 text, Telefon text);";
        try{
            Connection conectar = getConnection();
            Statement ejecutar = conectar.createStatement();
            ejecutar.execute(query1);
        }catch(SQLException e){
             System.out.println("El error es: "+e.getMessage());
        }
    }
    
    public PreparedStatement insertDatabaseQuery(String nom, String cognom1, String cognom2, String telefon, String mail) throws SQLException{
        //Bienvenido al mundo del PDO (PHP)
        String query2 = "INSERT INTO Dades (Nom, Mail, Cognom1, Cognom2, Telefon) VALUES (?,?,?,?,?)";
       Connection conectar = getConnection();
       PreparedStatement ejecutar = conectar.prepareStatement(query2);
       ejecutar.setString(1, nom);
       ejecutar.setString(2, mail);
       ejecutar.setString(3, cognom1);
       ejecutar.setString(4, cognom2);
       ejecutar.setString(5, telefon);
       ejecutar.executeUpdate();
       return ejecutar;
    }
    public ArrayList<Select> SelectTableQuery() throws SQLException{
        String query3 = "SELECT * FROM Dades;";
        Connection conectar = getConnection();
       
        Statement stmt = conectar.createStatement();                       
        ResultSet rs = stmt.executeQuery(query3);
                          
        ArrayList<Select> Agenda = new ArrayList<Select>();       
        while (rs.next()) {                                                   
           
            Select proyeccion = new Select(
                   rs.getInt("id"), 
                   rs.getString("nom"),
                   rs.getString("cognom1"),
                   rs.getString("mail"),
                   rs.getString("telefon"),
                   rs.getString("cognom2")
           );
           Agenda.add(proyeccion);
           
           return Agenda;
        }
        return null;
    }      
    
    public boolean Delete(int identificador) throws SQLException{
        try{
            String query4 = "DELETE FROM Dades WHERE ID =" + identificador;
            return true;
        }catch(SQLException e){
            return false;
        }
                  
    }
}
