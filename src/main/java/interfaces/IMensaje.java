package interfaces;

import java.util.List;

import model.TblMensaje;

public interface IMensaje {

	public int RegistrarMensaje(TblMensaje mensaje);
	public void ActualizarMensaje(TblMensaje mensaje);
	public int EliminarMensaje(int idMensaje);
	public TblMensaje BuscarMensaje(int id);
	List<TblMensaje> ListarMensaje();
	
}
