package interfaces;

import java.util.List;

import model.TblCharla;

public interface ICharla {

	public void RegistrarCharla(TblCharla charla);
	public void ActualizarCharla(TblCharla charla);
	public void EliminarCharla(TblCharla charla);
	public TblCharla BuscarCharla(TblCharla charla);
	List<TblCharla> ListarCharla();
	
}
