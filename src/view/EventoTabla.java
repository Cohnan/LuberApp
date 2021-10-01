package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;

/**
 * Listener para eventos sobre la tabla de resultados en la GUI. En el 
 * momento, escucha eventos de mouse sobre la tabla, para intermediar entre la
 * tabla y el panel de Input de Usuario.
 * @author Sebastian Puerto & Katherine Casanova
 */
public class EventoTabla implements MouseListener{

    private Menu menu;
    
    public EventoTabla(Menu menu) {
        this.menu = menu;
    }
    
    @Override
    public void mouseClicked(MouseEvent evento) {
        // Ignorar evento
    }
    
    /**
     * Detecta la realizacion de un click sobre la tabla. En consecuencia, 
     * detecta la fila que corresponde a la posicion dada, y actualiza en la GUI
     * el panel de Input de Usuario.
     * @param evento 
     */
    @Override
    public void mousePressed(MouseEvent evento) {
       JTable tabla = menu.getTblResults();
        int fila = tabla.rowAtPoint(evento.getPoint());
        
        menu.gettxtUsuCedula().setText(tabla.getValueAt(fila, 0).toString());
        menu.gettxtUsuNombre().setText(tabla.getValueAt(fila, 1).toString());
        menu.gettxtUsuApellido().setText(tabla.getValueAt(fila, 2).toString());
        menu.gettxtUsuEmail().setText(tabla.getValueAt(fila, 3).toString());
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // Ignorar evento
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // Ignorar evento
    }

    @Override
    public void mouseExited(MouseEvent me) {
        // Ignorar evento
    }
    
}
