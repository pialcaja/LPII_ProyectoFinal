package listeners;

import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dao.CharlaImp;
import dao.DetalleCharlaImp;
import model.TblCharla;
import model.TblDetallecharla;

/**
 * Application Lifecycle Listener implementation class ReservaListener
 *
 */
public class ReservaListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ReservaListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 

    	System.out.println("ID...: " + se.getSession().getId());
        System.out.println("----------------------------------");
          
        // GENERAR LISTADO
        List<TblCharla> charlas = new CharlaImp().ListarCharla();
        List<TblDetallecharla> eventos = new DetalleCharlaImp().ListarDetalleCharla();
        
        // ENVIAR LAS VARIABLES A NIVEL DE SESION -> CREAR ATRIBUTOS
        se.getSession().setAttribute("charlas", charlas);
        System.out.println("Charlas size: " + charlas.size());
        se.getSession().setAttribute("eventos", eventos);
        System.out.println("Eventos size: " + eventos.size());

        
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 

    	System.out.println("Terminó una sesion");
    	System.out.println("ID...: " + se.getSession().getId());
        System.out.println("----------------------------------");
        
    }
}
