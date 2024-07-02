package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.CharlaImp;
import dao.DetalleCharlaImp;
import model.TblCharla;
import model.TblDetallecharla;
import model.TblDetallecharlaPK;
import model.TblUsuario;

public class TestDetalleCharla {

	public static void main(String[] args) {

//		// INSTANCIAS
//		TblUsuario usuario = new TblUsuario();
//		TblCharla charla = new TblCharla();
//		CharlaImp crud1 = new CharlaImp();
//		TblDetallecharla detaChar = new TblDetallecharla();
//		DetalleCharlaImp crud = new DetalleCharlaImp();
//		TblDetallecharlaPK detaChl = new TblDetallecharlaPK();
		
//		// TESTEO DEL METODO REGISTRAR Y ACTUALIZAR CANTIDAD DE CUPOS
//		usuario.setIdUsu(7);
//		charla.setIdCharla(3);
//		
//		detaChl.setIdUsu(usuario.getIdUsu());
//		detaChl.setIdCharla(charla.getIdCharla());
//		
//		detaChar.setId(detaChl);
//		detaChar.setTblUsuario(usuario);
//		detaChar.setTblCharla(charla);
//		detaChar.setFecReg(Calendar.getInstance().getTime());
//		
//		crud.RegistrarDetalleCharla(detaChar);
		
//		// TESTEO DEL METODO ACTUALIZAR
//		usuario.setIdUsu(4);
//		charla.setIdCharla(2);
//		
//		detaChl.setIdUsu(usuario.getIdUsu());
//		detaChl.setIdCharla(charla.getIdCharla());
//		
//		detaChar.setId(detaChl);
//		detaChar.setTblUsuario(usuario);
//		detaChar.setTblCharla(charla);
//		SimpleDateFormat formFecha = new SimpleDateFormat("dd-MM-yyyy");
//		try {
//			
//			Date fechaEspecifica = formFecha.parse("20-06-2024");
//			detaChar.setFecReg(fechaEspecifica);
//			
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			
//		}
//		
//		crud.ActualizarDetalleCharla(detaChar);
		
//		// TESTEO DEL METODO ELIMINAR
//		usuario.setIdUsu(4);
//		charla.setIdCharla(2);	
//		
//		detaChl.setIdUsu(usuario.getIdUsu());
//		detaChl.setIdCharla(charla.getIdCharla());
//		
//		detaChar.setId(detaChl);
//		detaChar.setTblUsuario(usuario);
//		detaChar.setTblCharla(charla);
//		
//		crud.EliminarDetalleCharla(detaChar);
		
//		// TESTEO DEL METODO BUSCAR
//		usuario.setIdUsu(4);
//		charla.setIdCharla(2);	
//		
//		detaChl.setIdUsu(usuario.getIdUsu());
//		detaChl.setIdCharla(charla.getIdCharla());
//		
//		detaChar.setId(detaChl);
//		detaChar.setTblUsuario(usuario);
//		detaChar.setTblCharla(charla);
//		
//		TblDetallecharla chl = crud.BuscarDetalleCharla(detaChar);
//		System.out.println(	"Codigo de usuario: " + chl.getTblUsuario().getIdUsu() +
//							", Codigo de charla: " + chl.getTblCharla().getIdCharla() +
//							", Fecha de registro: " + chl.getFecReg());
		
//		// TESTEO DE LISTADO DETALLE CHARLA
//		List<TblDetallecharla> listado = crud.ListarDetalleCharla();
//		for(TblDetallecharla lis:listado) {
//			System.out.println(	"Codigo de usuario: " + lis.getTblUsuario().getIdUsu() +
//								", Codigo de charla: " + lis.getTblCharla().getIdCharla() +
//								", Fecha de registro: " + lis.getFecReg());
//		}

	}

}
