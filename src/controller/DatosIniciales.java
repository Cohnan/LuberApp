package controller;

import java.util.ArrayList;

import model.UsuarioModel;

import access.UsuarioDAO;

/**
 * Interactua con los DAOs para extraer la informacion de la base de datos
 * al momento de ejecutar la aplicacion, y establece metodos para extraer esta
 * informacion desde la GUI.
 * @author Sebastian Puerto & Katherine Casanova
 */
public class DatosIniciales {
    private ArrayList<UsuarioModel> listaUsuarios = null;
    private final UsuarioDAO usuarioDAO;
    
    /**
     * Establece conexion con la DB a traves de los DAOs y guarda un modelo del 
     * estado actual de la base de datos.
     */
    public DatosIniciales(){
        this.usuarioDAO = new UsuarioDAO();
        this.listaUsuarios = usuarioDAO.getAllUsers();
    }

    /**
     * Retorna la informacion inicial de la tabla, previamente extraida.
     * @return los usuarios
     */
    public ArrayList<UsuarioModel> getUsers() {
        return listaUsuarios;
    }

}