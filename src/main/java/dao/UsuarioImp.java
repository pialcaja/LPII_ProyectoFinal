package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.event.ListSelectionEvent;

import interfaces.IUsuario;
import model.TblDetallemensaje;
import model.TblTipousuario;
import model.TblUsuario;
import model.UsuarioConTipo;

public class UsuarioImp implements IUsuario{

	@Override
	public int RegistrarUsuario(TblUsuario usuario) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		int contador=0;
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(usuario);
			
			System.out.println("Usuario registrado en la BD.");
			
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
	public int ActualizarUsuario(TblUsuario usuario) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		int contador=0;
		
		try {
			
			em.getTransaction().begin();
			
			em.merge(usuario);
			
			System.out.println("Usuario actualizado en la BD.");
			
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
	public int EliminarUsuario(TblUsuario usuario) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		int contador=0;
		
		try {
			
			em.getTransaction().begin();
			
			usuario = em.find(TblUsuario.class, usuario.getIdUsu());
			
			em.remove(usuario);
			
			System.out.println("Usuario eliminado de la BD.");
			
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
	public TblUsuario BuscarUsuario(TblUsuario usuario) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		TblUsuario buscaUsuario = em.find(TblUsuario.class, usuario.getIdUsu());
		
		em.getTransaction().commit();
		
		em.close();
		
		return buscaUsuario;
	}

	@Override
	public List<TblUsuario> ListarUsuario() {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		em.getTransaction().begin();
		
		List<TblUsuario> listadoUsuarios = em.createQuery("select u from TblUsuario u", TblUsuario.class).getResultList();
		
		em.getTransaction().commit();
		
		em.close();
		
		return listadoUsuarios;
	}

	@Override
	public TblUsuario ValidarUsuario(String email, String password) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		TblUsuario usu = null;
		
		try {
			em.getTransaction().begin();
			
			TypedQuery<TblUsuario> buscaUsuario = em.createQuery("select u from TblUsuario u where u.emailUsu = :email and u.passwordUsu = :password", TblUsuario.class);
			buscaUsuario.setParameter("email", email);
			buscaUsuario.setParameter("password", password);
			
			
			List<TblUsuario> lista = buscaUsuario.getResultList();
			
			if (!lista.isEmpty()) {
				usu = lista.get(0);
			}
			
			em.getTransaction().commit();
			return usu;
		} catch (Exception e) {
			// EN CASO DE ERROR, SE HACE ROLLBACK DE LA TRANSACCION
			em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<UsuarioConTipo> ListarUsuarioConTipo() {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		List<UsuarioConTipo> usuariosConTipo = new ArrayList<>();
		
		try {
			
			em.getTransaction().begin();
			
			List<TblUsuario> query = em.createQuery("select u from TblUsuario u", TblUsuario.class).getResultList();
			
			for(TblUsuario usuario:query) {
				
				UsuarioConTipo dto = new UsuarioConTipo();
				dto.setIdUsu(usuario.getIdUsu());
				dto.setNomUsu(usuario.getNomUsu());
				dto.setApepaUsu(usuario.getApepaUsu());
				dto.setApemaUsu(usuario.getApemaUsu());
				dto.setFonoUsu(usuario.getFonoUsu());
				dto.setEmailUsu(usuario.getEmailUsu());
				dto.setPasswordUsu(usuario.getPasswordUsu());
				dto.setIdTipo(usuario.getTblTipousuario().getIdTipo());
				dto.setNomTipo(usuario.getTblTipousuario().getNomTipo());
				
				usuariosConTipo.add(dto);
				
			}
			
			em.getTransaction().commit();
			
			System.out.println("Se encontraron registros");
			
			return usuariosConTipo;
			
		} catch (Exception e) {
			
			em.getTransaction().rollback();
			
			System.out.println("No se encontraron registros");
			
			return null;
			
		} finally {
			
			em.close();
			
		}
		
	}

	@Override
	public int ActualizarTipoUsuario(int id) {

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("LPII_ProyectoFinal");
		
		EntityManager em = fac.createEntityManager();
		
		int contador = 0;
		
		try {
			
			em.getTransaction().begin();
			
			TblUsuario usuario = em.find(TblUsuario.class, id);
			
			if (usuario != null) {
				int tipo = usuario.getTblTipousuario().getIdTipo();
				
				System.out.println("Tipo de usuario encontrado: " + tipo);
				
				TblTipousuario nuevoTipo;
				
				if(tipo == 1) {
					
					nuevoTipo = em.find(TblTipousuario.class, 2);
					
				} else {
					
					nuevoTipo = em.find(TblTipousuario.class, 1);
					
				}
				
				if (nuevoTipo != null) {
					
					usuario.setTblTipousuario(nuevoTipo);
					
					em.merge(usuario);
					
					em.getTransaction().commit();
					
					System.out.println("Tipo de usuario actualizado");
					
					contador++;
					
				} else {
					
					System.out.println("Nuevo tipo de usuario no encontrado");
					em.getTransaction().rollback();
					
				}
			} else {
				
				System.out.println("Usuario no encontrado");
				em.getTransaction().rollback();
				
			}
			
			return contador;
			
		} catch (Exception e) {

			em.getTransaction().rollback();
			
			return contador;
			
		} finally {
			
			em.close();
			
		}
	}
}
