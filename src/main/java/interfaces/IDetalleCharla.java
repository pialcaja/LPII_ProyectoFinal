package interfaces;

import java.util.List;

import model.CharlaConUsuario;
import model.TblDetallecharla;

public interface IDetalleCharla {

	public int RegistrarDetalleCharla(TblDetallecharla detaCharla);
	public void ActualizarDetalleCharla(TblDetallecharla detaCharla);
	public int EliminarDetalleCharla(TblDetallecharla detaCharla);
	public TblDetallecharla BuscarDetalleCharla(TblDetallecharla detaCharla);
	List<TblDetallecharla> ListarDetalleCharla();
	List<CharlaConUsuario> ListarUsuarioSegunCharla(int id);
	
}
