package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.ICharla;
import model.TblCharla;

public class CharlaImp implements ICharla{

	@Override
	public void RegistrarCharla(TblCharla charla) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(charla);
		
		System.out.println("Charla registrada en la BD.");
		
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public void ActualizarCharla(TblCharla charla) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(charla);
		
		System.out.println("Charla actualizada en la BD.");
		
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public void EliminarCharla(TblCharla charla) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			charla = em.find(TblCharla.class, charla.getIdCharla());
			
			em.remove(charla);
			
			System.out.println("Charla eliminada de la BD.");
			
			em.getTransaction().commit();
			
		} catch (Exception e) {

			em.getTransaction().rollback();
			
			throw e;
			
		} finally {
			
			em.close();
			
		}
		
	}

	@Override
	public TblCharla BuscarCharla(TblCharla charla) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		TblCharla buscaCharla = em.find(TblCharla.class, charla.getIdCharla());
		
		em.getTransaction().commit();
		
		em.close();
		
		return buscaCharla;
	}

	@Override
	public List<TblCharla> ListarCharla() {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		List<TblCharla> listadoCharlas = em.createQuery("select c from TblCharla c", TblCharla.class).getResultList();
		
		em.getTransaction().commit();
		
		em.close();
		
		return listadoCharlas;
	}

}
