package interfaces;

import java.util.List;

import model.MensajeConUsuario;
import model.TblDetallemensaje;
import model.TblDetallemensajePK;

public interface IDetalleMensaje {

	public int RegistrarDetalleMensaje(TblDetallemensaje detalleMensaje);
	public void ActualizarDetalleMensaje(TblDetallemensaje detalleMensaje);
	public int EliminarDetalleMensaje(TblDetallemensaje detalleMensaje);
	public TblDetallemensaje BuscarDetalleMensaje(TblDetallemensaje detalleMensaje);
	public TblDetallemensaje ObtenerDetalleMensaje(TblDetallemensajePK id);
	List<TblDetallemensaje> ListarDetalleMensaje();
	List<MensajeConUsuario> ListarMensajeConUsuario();
	
}
