package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.DetalleMensajeImp;
import dao.MensajeImp;
import dao.UsuarioImp;
import model.MensajeConUsuario;
import model.TblDetallemensaje;
import model.TblDetallemensajePK;
import model.TblMensaje;
import model.TblUsuario;

public class TestMensaje {

	public static void main(String[] args) {

//		// INSTANCIAS
//		TblMensaje mensaje = new TblMensaje();
//		MensajeImp crud1 = new MensajeImp();
//		TblUsuario usuario = new TblUsuario();
//		TblDetallemensaje detaMsj = new TblDetallemensaje();
//		DetalleMensajeImp crud2 = new DetalleMensajeImp();
//		TblDetallemensajePK detaMsjPk = new TblDetallemensajePK();
		
//		// TESTEO DEL REGISTRO DE MENSAJE Y DETALLE EN SIMULTANEO
//		usuario.setIdUsu(1);
//		mensaje.setDescMsj("Hola, quisiera recibir información sobre ciberseguridad");
//		mensaje.setFecReg(Calendar.getInstance().getTime());
//		
//		crud1.RegistrarMensaje(mensaje);
//		
//		detaMsjPk.setIdUsu(usuario.getIdUsu());
//		detaMsjPk.setIdMsj(mensaje.getIdMsj());
//		
//		detaMsj.setId(detaMsjPk);
//		detaMsj.setTblUsuario(usuario);
//		detaMsj.setTblMensaje(mensaje);
//		
//		crud2.RegistrarDetalleMensaje(detaMsj);
		
//		// TESTEO DEL METODO ACTUALIZAR
//		mensaje.setIdMsj(2);
//		SimpleDateFormat formFecha = new SimpleDateFormat("dd-MM-yyyy");
//		try {
//			
//			Date fechaEspecifica = formFecha.parse("20-06-2024");
//			mensaje.setFecReg(fechaEspecifica);
//			
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			
//		}
//		mensaje.setDescMsj("Cambio");
//
//		crud1.ActualizarMensaje(mensaje);
		
//		// TESTEO DEL METODO ELIMINAR
//		mensaje.setIdMsj(4);
//		
//		crud1.EliminarMensaje(mensaje);
		
//		// TESTEO DEL METODO BUSCAR
//		mensaje.setIdMsj(2);
//		
//		TblMensaje msj = crud1.BuscarMensaje(mensaje);
//		
//		System.out.println(	"Codigo: " + msj.getIdMsj() +
//							", Descripcion: " + msj.getDescMsj() +
//							", Fecha de registro: " + msj.getFecReg());

//		// TESTEO EL METODO LISTAR MENSAJE
//		List<TblMensaje> listado = crud1.ListarMensaje();
//		
//		for(TblMensaje lis:listado){
//			System.out.println(	"Codigo: " + lis.getIdMsj() +
//					", Descripcion: " + lis.getDescMsj() +
//					", Fecha de registro: " + lis.getFecReg());
//		}
		
//		// TESTEO EL METODO LISTAR MENSAJE
//		List<MensajeConUsuario> listado = crud2.ListarMensajeConUsuario();
//		
//		for(MensajeConUsuario lis:listado){
//			System.out.println(	"Codigo: " + lis.getIdUsuario() +
//					", Descripcion: " + lis.getDescMensaje() +
//					", Fecha de registro: " + lis.getFecRegistro());
//		}
		
	}
}
