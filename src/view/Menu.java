package view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import controller.DatosIniciales;
import controller.EventoClick;
import controller.EventoMouse;

import model.UsuarioModel;

/**
  * JFrame creado con ayuda de la herramienta de Diseño de Jframes
  * que contiene toda la interfaz gráfica del programa.
  * @author Katherine Casanova & Sebastian Puerto
*/
public class Menu extends javax.swing.JFrame {
    
    // Declaracion de variables
    
    // Botones
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    
    // Labels
    private javax.swing.JLabel lblTitulo; // Titulo
    private javax.swing.JLabel lblTituloInput; // Titulo Panel input de Usuario
    private javax.swing.JLabel lblCedula; // Label para campo Cedula
    private javax.swing.JLabel lblNombre; // Label para campo Nombre
    private javax.swing.JLabel lblApellido; // Label para campo Apellido
    private javax.swing.JLabel lblEmail; // Label para campo Email
    private javax.swing.JLabel lblDevs; // Label con nombre de Devs
    
    // Panels
    private javax.swing.JPanel pnlResultados; // Panel de resultados
    private javax.swing.JPanel pnlCRUD; // Panel para botones de CRUD
    private javax.swing.JPanel pnlInputUsuario; // Panel para input de Usuario
    
    // En Resutaltados
    private javax.swing.JTable jTable1; // Tabla Query SELECT * FROM usuario
    private javax.swing.JScrollPane jScrollPane1; // Panel para hacer de la tabla deslizable
    
    // Para entradas de Usuario: campos que componen a un Usuario
    private javax.swing.JTextField txtUsuCedula;
    private javax.swing.JTextField txtUsuNombre;
    private javax.swing.JTextField txtUsuApellido;
    private javax.swing.JTextField txtUsuEmail;
    
    public Menu() {
        initComponents();
    }
    
    /**
     * Inicializa la interfaz grafica:
     *  - Dibuja
     *  - Determina los Listeners de botones y tablas
     *  - Carga Datos Iniciales a la tabla
     */
    @SuppressWarnings("unchecked")                        
    private void initComponents() {
        
        // Inicializando Panel de Resultados
        pnlResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){ // No permitir modificacion manual de Tabla
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        }; 
        
        // Inicializando Panel de CRUD (Create, Read, Update, Delete)
        pnlCRUD = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        
        // Inicializando Panel para Entradas del usuario
        pnlInputUsuario = new javax.swing.JPanel();
        lblTituloInput = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txtUsuCedula = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtUsuNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtUsuApellido = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtUsuEmail = new javax.swing.JTextField();

        // Inicializando Label con informacion de los desarrolladores
        lblDevs = new javax.swing.JLabel(); // label devs
        
        // Configuracion basica de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Luber APP");
        
        
        /*
         * Panel Resultados:
         */
        
        pnlResultados.setBackground(new java.awt.Color(204, 204, 204));
        
        // Estructura basica de la Tabla
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 20)); 
        jTable1.setRowHeight(jTable1.getRowHeight() + 20);
        jTable1.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.ITALIC, 20));
        jScrollPane1.setViewportView(jTable1);
        
        // Cargar datos iniciales de la DB a la tabla
        DatosIniciales datosI = new DatosIniciales();
        this.setTblResults(datosI.getUsers());
        
        // Hacer que la tabla escuche a los eventos del mouse para seleccionar filas
        EventoMouse eventoMouseTabla = new EventoMouse(this);
        jTable1.addMouseListener(eventoMouseTabla);
        
        // Label Devs
        lblDevs.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        lblDevs.setText("Katherine Casanova & Sebastian Puerto Devs.");
        
        // Incorporacion y Dibujo de la tabla y el label de autores al Panel 1
        javax.swing.GroupLayout pnlResultadosLayout = new javax.swing.GroupLayout(pnlResultados);
        pnlResultados.setLayout(pnlResultadosLayout);
        pnlResultadosLayout.setHorizontalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResultadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDevs)
                .addContainerGap())
        );
        pnlResultadosLayout.setVerticalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDevs)
                .addContainerGap())
        );
        
        /*
         * Panel CRUD:
         */
        pnlCRUD.setBackground(new java.awt.Color(204, 204, 255));
        
        // Label Titulo
        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 36));
        lblTitulo.setText("Luber APP ");
        
        // Botones:
        
        // Listener para los botones: basta uno solo para todos los botones
        // pues no es necesario establecer multiples conexiones a la base de datos
        EventoClick eventoClickBotones = new EventoClick(this);
        
        btnListar.setText("Listar");
        btnListar.setName("btnListar");
        // Agregar Listener (definido en controller) al boton 'Listar'
        btnListar.addActionListener(eventoClickBotones);
        
        btnAgregar.setText("Agregar");
        btnAgregar.setName("btnAgregar"); 
        btnAgregar.addActionListener(eventoClickBotones);

        btnActualizar.setText("Actualizar");
        btnActualizar.setName("btnActualizar"); 
        btnActualizar.addActionListener(eventoClickBotones);

        btnEliminar.setText("Eliminar");
        btnEliminar.setName("btnEliminar"); 
        btnEliminar.addActionListener(eventoClickBotones);

        
        /*
         * Panel Input Usuarios
        */
        
        // Titulo
        lblTituloInput.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        lblTituloInput.setText("USUARIOS");
        
        // Parejas: Label - Campo Texto
        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        lblCedula.setText("Cédula: ");
        txtUsuCedula.setName("txtUsuCedula");
        //txtUsuCedula.setEditable(false); // No permitir que la cedula se modifique

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        lblNombre.setText("Nombre:");
        txtUsuNombre.setName("txtUsuNombre"); 

        lblApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        lblApellido.setText("Apellido:");
        txtUsuApellido.setName("txtUsuApellido"); 

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        lblEmail.setText("Email:");
        txtUsuEmail.setName("txtUsuEmail"); 
        
        /*
         * Dibujo de Panel CRUD y Panel Input Usuario
        */
        javax.swing.GroupLayout pnlInputUsuarioLayout = new javax.swing.GroupLayout(pnlInputUsuario);
        pnlInputUsuario.setLayout(pnlInputUsuarioLayout);
        pnlInputUsuarioLayout.setHorizontalGroup(
            pnlInputUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloInput)
                    .addGroup(pnlInputUsuarioLayout.createSequentialGroup()
                        .addComponent(lblCedula)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInputUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInputUsuarioLayout.createSequentialGroup()
                            .addComponent(lblNombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtUsuNombre))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInputUsuarioLayout.createSequentialGroup()
                            .addGroup(pnlInputUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblApellido)
                                .addComponent(lblEmail))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pnlInputUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUsuEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUsuApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlInputUsuarioLayout.setVerticalGroup(
            pnlInputUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputUsuarioLayout.createSequentialGroup()
                .addComponent(lblTituloInput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtUsuCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtUsuNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellido)
                    .addComponent(txtUsuApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtUsuEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCRUDLayout = new javax.swing.GroupLayout(pnlCRUD);
        pnlCRUD.setLayout(pnlCRUDLayout);
        pnlCRUDLayout.setHorizontalGroup(
            pnlCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCRUDLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlInputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlCRUDLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCRUDLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(pnlCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCRUDLayout.setVerticalGroup(
            pnlCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCRUDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(27, 27, 27)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlInputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        // Panel de agregacion y actualizacion invisible... futuro
        //pnlInputUsuario.setVisible(false);
        
        // Panel la tabla invisible
        //pnlResultados.setVisible(false);
        
        
        
        pack();
    }                        

    
    
    /**
     * Encapsulamiento de la tabla de reultados, para permitir la lectura de su
     * contenido desde el controlador.
     * @return the tblResults
     */
    public javax.swing.JTable getTblResults() {
        return jTable1;
    }

    
    /**
     * Actualizar contenidos de la tabla de resultados para contener 
     * la lista de UsuarioModelos de entrada.
     * Usado tanto en la inicializacion, como por el controlador para la actualizacion.
     * @param listoUsuarios
     */
    public void setTblResults(ArrayList<UsuarioModel> listaUsuarios) {
        System.out.println("Entro a modificar tabla");
        
        String[] headers = {"CC", "Nombre", "Apellido", "e-mail"};
        
        this.jTable1.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.jTable1.setModel(tableModel);
        
        for(int i=0; i < listaUsuarios.size(); i++){
            tableModel.addRow(listaUsuarios.get(i).toArray() );
        }
    }

    // Metodos de encapsulamiento:
    /**
     * Getter para el boton Listar, que permite determinar la fuente de los eventos
     * en el controlador
     * @return the btnListar
     */
    public javax.swing.JButton getbtnListar() {
        return btnListar;
    }

    /**
     * Getter para el boton Agregar, que permite determinar la fuente de los eventos
     * en el controlador
     * @return the btnAgregar
     */
    public javax.swing.JButton getbtnAgregar() {
        return btnAgregar;
    }

    /**
     * Getter para el boton Actualizar, que permite determinar la fuente de los eventos
     * en el controlador
     * @return the btnActualizar
     */
    public javax.swing.JButton getbtnActualizar() {
        return btnActualizar;
    }

    /**
     * Getter para el boton Eliminar, que permite determinar la fuente de los eventos
     * en el controlador
     * @return the btnEliminar
     */
    public javax.swing.JButton getbtnEliminar() {
        return btnEliminar;
    }

    /**
     * Getter para el campo de Cedula que permite extraer su informacion en el
     * controlador.
     * @return the txtUsuCedula
     */
    public javax.swing.JTextField gettxtUsuCedula() {
        return txtUsuCedula;
    }

    /**
     * Getter para el campo de Nombre que permite extraer su informacion en el
     * controlador.
     * @return the txtUsuNombre
     */
    public javax.swing.JTextField gettxtUsuNombre() {
        return txtUsuNombre;
    }

    /**
     * Getter para el campo de Apellido que permite extraer su informacion en el
     * controlador.
     * @return the txtUsuApellido
     */
    public javax.swing.JTextField gettxtUsuApellido() {
        return txtUsuApellido;
    }
    /**
     * Getter para el campo de Email que permite extraer su informacion en el
     * controlador.
     * @return the txtUsuEmail
     */
    public javax.swing.JTextField gettxtUsuEmail() {
        return txtUsuEmail;
    }
    
    /**
     * Getter del panel de input del usuario, que permitiria afectar el panel 
     * (e.g. visibilidad) de acuerdo a los eventos registrados.
     * @return el panel de adicion y actualizacion de usuarios
     */
    public javax.swing.JPanel getpnlInputUsuario() {
        return pnlInputUsuario;
    }

    /**
     * Main: mostrar ventanas con el look and feel indicados
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }       
    
}