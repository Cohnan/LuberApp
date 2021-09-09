package model;

/**
 * Modelo interno de un elemento de la relacion Usuario de la base de datos de Luber.
 * @author Sebastian Puerto & Katherine Casanova
 */
public class UsuarioModel {
    // Atributos: campos de la tabla Usuario
    private int     usu_cc; 
    private String  usu_nombre;
    private String  usu_apellido;
    private String  usu_email;
    
    /**
     * Constructor: campos para creacion de Usuario.
     * @param usu_cc
     * @param usu_nombre
     * @param usu_apellido
     * @param usu_email 
     */
    public UsuarioModel(int usu_cc, String usu_nombre, String usu_apellido, String usu_email) {
        this.usu_cc = usu_cc;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.usu_email = usu_email;
    }
    
    /**
     * @return the usu_cc
     */
    public int getUsu_cc() {
        return usu_cc;
    }

    /**
     * @param usu_cc the usu_cc to set
     */
    public void setUsu_cc(int usu_cc) {
        this.usu_cc = usu_cc;
    }

    /**
     * @return the usu_nombre
     */
    public String getUsu_nombre() {
        return usu_nombre;
    }

    /**
     * @param usu_nombre the usu_nombre to set
     */
    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    /**
     * @return the usu_apellido
     */
    public String getUsu_apellido() {
        return usu_apellido;
    }

    /**
     * @param usu_apellido the usu_apellido to set
     */
    public void setUsu_apellido(String usu_apellido) {
        this.usu_apellido = usu_apellido;
    }

    /**
     * @return the usu_email
     */
    public String getUsu_email() {
        return usu_email;
    }

    /**
     * @param usu_email the usu_email to set
     */
    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }
    
    /**
     * Metodo para devolver la informacion encapsulada por cada instancia de
     * UsuarioModel como un arreglo, en el orden en que se deben mostrar.
     */
    public Object[] toArray( ) {
        Object[] arreglo = {usu_cc, usu_nombre, usu_apellido, usu_email};
        return arreglo;
    }
}
