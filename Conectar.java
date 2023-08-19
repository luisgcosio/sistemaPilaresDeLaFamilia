package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Conectar {
    
    Connection cn;
    Statement st;
    
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/pilaresdelafamilia","root","");
            System.out.print("Conectado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cn;
    }
    
}
