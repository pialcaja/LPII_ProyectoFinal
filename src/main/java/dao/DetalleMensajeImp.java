package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IDetalleMensaje;
import model.MensajeConUsuario;
import model.TblDetallemensaje;
import model.TblDetallemensajePK;

public class DetalleMensajeImp implements IDetalleMensaje{

	@Override
	public int RegistrarDetalleMensaje(TblDetallemensaje detalleMensaje) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		int contador = 0;
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(detalleMensaje);
			
			System.out.println("Detalle de mensaje registrado en la BD.");
			
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
	public void ActualizarDetalleMensaje(TblDetallemensaje detalleMensaje) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(detalleMensaje);
		
		System.out.println("Detalle de mensaje actualizado en la BD.");
		
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public int EliminarDetalleMensaje(TblDetallemensaje detalleMensaje) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		int contador = 0;
		
		try {
			
			em.getTransaction().begin();
			
			detalleMensaje = em.find(TblDetallemensaje.class, detalleMensaje);
			
			em.remove(detalleMensaje);
			
			System.out.println("Detalle de mensaje eliminado de la BD.");
			
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
	public TblDetallemensaje BuscarDetalleMensaje(TblDetallemensaje detalleMensaje) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		TblDetallemensaje buscaMensaje = em.find(TblDetallemensaje.class, detalleMensaje);
		
		em.getTransaction().commit();
		
		em.close();
		
		return buscaMensaje;
	}

	@Override
	public List<TblDetallemensaje> ListarDetalleMensaje() {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		List<TblDetallemensaje> listadoDetalleMensajes = em.createQuery("select dm from TblDetallemensaje dm", TblDetallemensaje.class).getResultList();
		
		em.getTransaction().commit();
		
		em.close();
		
		return listadoDetalleMensajes;
	}

	@Override
	public List<MensajeConUsuario> ListarMensajeConUsuario() {
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		List<MensajeConUsuario> mensajesConUsuario = new ArrayList<>();
		
		try {
			
			em.getTransaction().begin();
			
			List<TblDetallemensaje> query = em.createQuery("select d from TblDetallemensaje d", TblDetallemensaje.class).getResultList();
			
			for(TblDetallemensaje detalle:query) {
				
				MensajeConUsuario dto = new MensajeConUsuario();
				dto.setIdUsuario(detalle.getId().getIdUsu());
				dto.setIdMensaje(detalle.getTblMensaje().getIdMsj());
				dto.setNomUsuario(detalle.getTblUsuario().getNomUsu());
				dto.setDescMensaje(detalle.getTblMensaje().getDescMsj());
				dto.setFecRegistro(detalle.getTblMensaje().getFecReg());
				
				mensajesConUsuario.add(dto);
			}
			
			em.getTransaction().commit();
			
			System.out.println("Se encontraron registros");
			
			return mensajesConUsuario;
			
		} catch (Exception e) {

			em.getTransaction().rollback();

			System.out.println("No se encontraron registros");
			
			return null;
			
		} finally {
			
			em.close();
		}
	}

	@Override
	public TblDetallemensaje ObtenerDetalleMensaje(TblDetallemensajePK id) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			TblDetallemensaje getDetalleMensaje = em.find(TblDetallemensaje.class, id);
			
			em.getTransaction().commit();

			return getDetalleMensaje;
			
		} catch (Exception e) {

			em.getTransaction().rollback();
			
			return null;
			
		} finally {
			
			em.close();
			
		}
	}

}
