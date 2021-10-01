package controller;

import access.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.UsuarioModel;
import view.Menu;

/**
 * Controlador para botones del CRUD de la base de datos. En el momento, escucha
 * su activacion en la GUI y realiza la consecuente ejecucion de los queries 
 * correspondientes haciendo uso del DAO. I.e. CONECTA VISTA CON capa de DATOS.
 * @author Sebastian Puerto & Katherine Casanova
 */
public class EventoBotonCRUD  implements ActionListener {
    
    // Objeto en donde se encuentran los objetos que estan escuchando las acciones
    private final Menu framePrincipal; 
    // Objeto para acceso a la tabla de Usuario en la base de datos.
    // Basta con unico DAO de Usuario para todos los eventos, de todos los botones,
    // que establezca una unica conexion con la base de datos.
    private final UsuarioDAO usuarioDAO;
    
    public EventoBotonCRUD (Menu framePrincipal) {
        this.framePrincipal = framePrincipal;
        usuarioDAO = new UsuarioDAO();
    }
    
    /**
     * Recepcion de los eventos escuchados, para la ejecucion de las acciones
     * correspondientes dependiente del boton fuente del evento.
     * @param evento 
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        // En caso de que la fuente sea el boton Agregar:
        if(evento.getSource() == this.framePrincipal.getbtnAgregar()) {
            
            // Extraer datos de los campos de texto en la interfaz
            int cc = Integer.parseInt(this.framePrincipal.gettxtUsuCedula().getText());
            String nombre = this.framePrincipal.gettxtUsuNombre().getText();
            String apellido = this.framePrincipal.gettxtUsuApellido().getText();
            String email = this.framePrincipal.gettxtUsuEmail().getText();
            
            // Usar el UsuarioDAO para agregar un nuevo usuario con 
            // los datos extraidos: Query INSERT...
            usuarioDAO.insertUsuario(new UsuarioModel(cc, nombre, apellido, email));
            
        // En caso de que la fuente sea el boton Listar:
        } else if(evento.getSource() == this.framePrincipal.getbtnListar()) {
            
            // Ejecutar query SELECT * FROM usuario;
            ArrayList<UsuarioModel> listaUsuarios = usuarioDAO.getAllUsers();
            
            // Actualizar Tabla de resultados en la GUI
            this.framePrincipal.setTblResults(listaUsuarios);
            
        // En caso de que la fuente sea el boton Eliminar:
        } else if(evento.getSource() == this.framePrincipal.getbtnEliminar()) {
            
            // Determinar usuario a eliminar a partir de su cedula
            int cc = Integer.parseInt( this.framePrincipal.gettxtUsuCedula().getText() ); 
            
            // Ejecutar Query de eliminacion de fila DELETE... 
            usuarioDAO.deleteUsuario(cc);
           
        // En caso de que la fuente sea el boton Actualizar:
        } else if(evento.getSource() == this.framePrincipal.getbtnActualizar()) {
            
            // Extraer datos de la GUI
            int cc = Integer.parseInt( this.framePrincipal.gettxtUsuCedula().getText() ); 
            String nombre = this.framePrincipal.gettxtUsuNombre().getText();
            String apellido = this.framePrincipal.gettxtUsuApellido().getText();
            String email = this.framePrincipal.gettxtUsuEmail().getText();
            
            // Ejecutar QUERY UPDATE...
            // OJO: si la cedula presente en el campo de texto de 'Cedula' no 
            // existe previamente, no se llevara a cabo ninguna actualizacion.
            // En otras palabras, no es posible actualizar la Cedula de un usuario
            // haciendo uso solo de este boton.
            usuarioDAO.updateUsuario(new UsuarioModel(cc, nombre, apellido, email));
    }
  }
}
