package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import interfaces.IDetalleCharla;
import model.CharlaConUsuario;
import model.TblCharla;
import model.TblDetallecharla;

public class DetalleCharlaImp implements IDetalleCharla{

	@Override
	public int RegistrarDetalleCharla(TblDetallecharla detaCharla) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		int contador=0;
		
		try {
			
			em.getTransaction().begin();
			
			// VERIFICAR SI EL USUARIO YA ESTÁ REGISTRADO EN LA CHARLA ELEGIDA
			TypedQuery<TblDetallecharla> query = em.createQuery("select d from TblDetallecharla d where d.id.idUsu = :idUsu and d.id.idCharla = :idCharla", TblDetallecharla.class);
			query.setParameter("idUsu", detaCharla.getTblUsuario().getIdUsu());
			query.setParameter("idCharla", detaCharla.getTblCharla().getIdCharla());
			
			List<TblDetallecharla> lista = query.getResultList();
			
			if (lista.isEmpty()) {
				
				// VERIFICAR SI HAY CUPOS DISPONIBLES
				TblCharla charla = em.find(TblCharla.class, detaCharla.getTblCharla().getIdCharla());
				if (charla.getCupos() > 0) {
					
					// REGISTRA
					em.persist(detaCharla);
					
					// ACTUALIZA LOS CUPOS
					charla.setCupos(charla.getCupos() - 1);
					em.merge(charla);
					
					em.getTransaction().commit();
					System.out.println("Se registro el evento y se actualizaron los cupos");
					contador++;
					
					return contador;
					
				} else {
					
					em.getTransaction().rollback();
					System.out.println("No hay cupos en esa charla");
					contador = contador + 3;
					
					return contador; // NO HAY CUPOS PARA ESA CHARLA
				}
			} else {
				
				em.getTransaction().rollback();
				System.out.println("El usuario ya está registrado en esa charla");
				contador = contador + 2;
				
				return contador; // YA ESTA REGISTRADO EN ESA CHARLA
			}
			
		} catch (Exception e) {

			if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                
                return contador;
            }
            throw e;
            
		} finally {
			
			em.close();
			
		}
	}

	@Override
	public void ActualizarDetalleCharla(TblDetallecharla detaCharla) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(detaCharla);
		
		System.out.println("Detalle de charla actualizado en la BD.");
		
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public int EliminarDetalleCharla(TblDetallecharla detaCharla) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		int contador=0;
		
		try {
			
	        em.getTransaction().begin();
	        	
	        em.remove(detaCharla);
	        
	        System.out.println("Detalle de charla eliminado de la BD.");

	        em.getTransaction().commit();
	        
	        contador ++;
	        
	        return contador;
	        
	    } catch (Exception e) {
	    	
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	            
	            return contador;
	        }
	        
	        throw e;
	        
	    } finally {
	    	
	        em.close();
	        fac.close();
	        
	    }
	}

	@Override
	public TblDetallecharla BuscarDetalleCharla(TblDetallecharla detaCharla) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		TblDetallecharla buscaDetalleCharla = em.find(TblDetallecharla.class, detaCharla.getId());
		
		em.getTransaction().commit();
		
		em.close();
		
		return buscaDetalleCharla;
	}

	@Override
	public List<TblDetallecharla> ListarDetalleCharla() {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		List<TblDetallecharla> listadoDetalleCharla = em.createQuery("select d from TblDetallecharla d", TblDetallecharla.class).getResultList();
		
		em.getTransaction().commit();
		
		em.close();
	
		return listadoDetalleCharla;
	}

	@Override
	public List<CharlaConUsuario> ListarUsuarioSegunCharla(int id) {
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		List<CharlaConUsuario> charlasConUsuario = new ArrayList<>();
		
		try {
			
			em.getTransaction().begin();
			
			TypedQuery<TblDetallecharla> query = em.createQuery("select d from TblDetallecharla d where d.id.idCharla = :idCharla", TblDetallecharla.class);
			query.setParameter("idCharla", id);
			
			List<TblDetallecharla> charlas = query.getResultList();
			
			for(TblDetallecharla detalle:charlas) {
				
				CharlaConUsuario dto = new CharlaConUsuario();
				dto.setIdCharla(detalle.getTblCharla().getIdCharla());
				dto.setTema(detalle.getTblCharla().getTema());
				dto.setCupos(detalle.getTblCharla().getCupos());
				dto.setFec_reg(detalle.getFecReg());
				dto.setIdUsu(detalle.getTblUsuario().getIdUsu());
				dto.setNomUsu(detalle.getTblUsuario().getNomUsu());
				dto.setApepaUsu(detalle.getTblUsuario().getApepaUsu());
				dto.setApemaUsu(detalle.getTblUsuario().getApemaUsu());
				dto.setFonoUsu(detalle.getTblUsuario().getFonoUsu());
				dto.setEmailUsu(detalle.getTblUsuario().getEmailUsu());
				
				charlasConUsuario.add(dto);
			}
			
			em.getTransaction().commit();
			
			System.out.println("Se encontraron registros");
			
			return charlasConUsuario;
			
		} catch (Exception e) {

			em.getTransaction().rollback();
			
			System.out.println("No se encontraron registros");

			return null;
			
		} finally {
			
			em.close();
			
		}
	}

}
