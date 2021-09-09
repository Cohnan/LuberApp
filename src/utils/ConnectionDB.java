package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.*;
import org.json.simple.parser.*;


/**
 * Establece una conexion con la base de datos que se indique en el archivo json
 * db_credentials.json utilizando la API de JDBC.
 * @author Sebastian Puerto & Katherine Casanova
 */
public class ConnectionDB {
    
    //Get JSON Simple: https://code.google.com/archive/p/json-simple/downloads
    
    /**
     * Establece y retorna una conexion con la base de datos indicada en el json
     * db_credentials.json
     * @return 
     */
    public static Connection getConnection() {
        JSONParser parser = new JSONParser();
        Connection conn = null;
        // conectar
        try {
            String credentials_path = System.getProperty("user.dir") + "/src/utils/db_credentials.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));
            
            String host     = (String)jsonObject.get("db_ip");
            String port     = (String)jsonObject.get("dp_port");
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_pssword");
            String schema   = (String)jsonObject.get("schema");
            String dbURL = "jdbc:mysql://" + host + ":" + port + "/" + schema;
            
            conn = DriverManager.getConnection(dbURL, username, password);
            if( conn != null ) 
                System.out.println ( "Conexion establecida." );
        } 
        catch( SQLException | FileNotFoundException ex ) {
            ex.printStackTrace();
        } 
        catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        
        return conn;
    }
    
    public static void main(String[] args){
        getConnection();
    }
}
