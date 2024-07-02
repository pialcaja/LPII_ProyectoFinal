package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IMensaje;
import model.TblMensaje;

public class MensajeImp implements IMensaje{

	@Override
	public int RegistrarMensaje(TblMensaje mensaje) {
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		int contador = 0;
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(mensaje);
			
			System.out.println("Mensaje registrado en la BD.");
			
			em.getTransaction().commit();
			
			contador++;
			
			return contador;
			
		} catch (Exception e) {

			em.getTransaction().rollback();
			
			return contador;
			
		} finally {
			
			em.close();
			
		}
	}

	@Override
	public void ActualizarMensaje(TblMensaje mensaje) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(mensaje);
		
		System.out.println("Mensaje actualizado en la BD.");
		
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public int EliminarMensaje(int idMensaje) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
        EntityManager em = fac.createEntityManager();
        
        int contador = 0;

        try {
        	
            em.getTransaction().begin();
            
            // ELIMINAR LOS REGISTROS EN tbl_detallemensaje QUE REFERENCIAN AL MENSAJE
            Query deleteDetalles = em.createQuery("DELETE FROM TblDetallemensaje d WHERE d.tblMensaje.idMsj = :idMensaje");
            deleteDetalles.setParameter("idMensaje", idMensaje);
            deleteDetalles.executeUpdate();
            
            // AHORA ELIMINAR EL MENSAJE EN tbl_mensaje
            TblMensaje mensaje = em.find(TblMensaje.class, idMensaje);
            if (mensaje != null) {
            	
                em.remove(mensaje);
                
            }
            
            em.getTransaction().commit();
            
            System.out.println("Mensaje y sus detalles eliminados con éxito");
            
            contador++;
            
            return contador;
            
        } catch (Exception e) {
        	
            em.getTransaction().rollback();
            e.printStackTrace();
            
            return contador;
            
        } finally {
        	
            em.close();
            
        }
	}

	@Override
	public TblMensaje BuscarMensaje(int id) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		TblMensaje buscaMensaje = em.find(TblMensaje.class, id);
		
		em.getTransaction().commit();
		
		em.close();
		
		return buscaMensaje;
	}

	@Override
	public List<TblMensaje> ListarMensaje() {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		List<TblMensaje> listadoMensajes = em.createQuery("select m from TblMensaje m", TblMensaje.class).getResultList();
		
		em.getTransaction().commit();
		
		em.close();
		
		return listadoMensajes;
	}
}
