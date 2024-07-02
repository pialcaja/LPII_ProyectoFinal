package interfaces;

import java.util.List;

import model.TblUsuario;
import model.UsuarioConTipo;

public interface IUsuario {

	public int RegistrarUsuario(TblUsuario usuario);
	public int ActualizarUsuario(TblUsuario usuario);
	public int EliminarUsuario(TblUsuario usuario);
	public TblUsuario BuscarUsuario(TblUsuario usuario);
	public List<TblUsuario> ListarUsuario();
	public TblUsuario ValidarUsuario(String email, String password);
	List<UsuarioConTipo> ListarUsuarioConTipo();
	public int ActualizarTipoUsuario(int id);
	
}
