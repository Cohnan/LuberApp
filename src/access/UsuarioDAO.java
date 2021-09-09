package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import utils.ConnectionDB;

import model.UsuarioModel;

/**
 * Objeto para el acceso a la tabla Usuario de la base de datos de Luber, y para
 * la interpretacion de estos datos utilizando los Modelos internos al proyecto.
 * Cada metodo corresponde a la ejecucion de un Query distinto.
 * @author Sebastian Puerto & Katherine Casanova
 */
public class UsuarioDAO {
    
    private Connection conn;
    
    /**
     * Establece y guarda conexion con la base de datos.
     */
    public UsuarioDAO(){
        this.conn = ConnectionDB.getConnection();
    }
    
    /**
     * Ejecuta el Query 'SELECT * FROM usuario', y retorna todas las filas re-
     * sultantes como un ArrayList de UsuarioModelo's, de modo que cada elemento
     * de la lista es un modelo de una fila o usuario de la tabla Usuario.
     * @return listaUsuarios Arraylist de usuarios retornados por el Query
     */
    public ArrayList<UsuarioModel> getAllUsers() {
        ArrayList<UsuarioModel> listaUsuarios = new ArrayList<>();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT * FROM usuario;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                UsuarioModel usuario = new UsuarioModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                listaUsuarios.add( usuario );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return listaUsuarios;
    }

    /**
     * Ejecuta el Query INSERT INTO usuario ...
     * @param usuario Modelo de Usuario a insertar en la base de datos
     */
    public void insertUsuario(UsuarioModel usuario){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, usuario.getUsu_cc());
            statement.setString(2, usuario.getUsu_nombre());
            statement.setString(3, usuario.getUsu_apellido());
            statement.setString(4, usuario.getUsu_email());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    /**
     * Ejecuta el Query UPDATE usuario ... WHERE usu_cc = .
     * @param usuario Modelo de Usuario con la informacion nueva completa.
     * OJO: no permite la actualizacion de la cedula de un usuario.
     */
    public void updateUsuario(UsuarioModel usuario) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE usuario SET usu_cc=?, usu_nombre=?, usu_apellido=?, usu_email=? WHERE usu_cc=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, usuario.getUsu_cc());
            statement.setString(2, usuario.getUsu_nombre());
            statement.setString(3, usuario.getUsu_apellido());
            statement.setString(4, usuario.getUsu_email());
            statement.setInt(5, usuario.getUsu_cc());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            
            else if (rowsUpdated == 0) {
                JOptionPane.showMessageDialog(null, "No se encontro el usuario con la cedula registrada.\n Por favor en el campo 'Cedula' utilice una cedula existente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }

    
    /**
     * Ejecuta el Query DELETE FROM USUARIO WHERE usu_cc = .
     * @param cc Cedula (identificador unico) del usuario a remover.
     * OJO: no permite la eliminacion de un usuario cuya cc sea llave foranea
     * existente en otra tabla (como conductor).
     */
    public void deleteUsuario(int cc) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM usuario WHERE usu_cc=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, cc);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
}
