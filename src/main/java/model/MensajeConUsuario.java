package model;

import java.util.Date;

public class MensajeConUsuario {

	private int idUsuario;
	private int idMensaje;
	private String nomUsuario;
	private String descMensaje;
	private Date fecRegistro;
	
	public MensajeConUsuario() {
	}

	public MensajeConUsuario(int idUsuario, int idMensaje, String nomUsuario, String descMensaje, Date fecRegistro) {
		this.idUsuario = idUsuario;
		this.idMensaje = idMensaje;
		this.nomUsuario = nomUsuario;
		this.descMensaje = descMensaje;
		this.fecRegistro = fecRegistro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getDescMensaje() {
		return descMensaje;
	}

	public void setDescMensaje(String descMensaje) {
		this.descMensaje = descMensaje;
	}

	public Date getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}
}
