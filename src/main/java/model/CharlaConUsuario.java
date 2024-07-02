package model;

import java.util.Date;

public class CharlaConUsuario {
	
	private int idCharla;
	private String tema;
	private int cupos;
	private int idUsu;
	private Date fec_reg;
	private String nomUsu;
	private String apepaUsu;
	private String apemaUsu;
	private String fonoUsu;
	private String emailUsu;
	
	public CharlaConUsuario() {
	}

	public CharlaConUsuario(int idCharla, String tema, int cupos, int idUsu, Date fec_reg, String nomUsu,
			String apepaUsu, String apemaUsu, String fonoUsu, String emailUsu) {
		this.idCharla = idCharla;
		this.tema = tema;
		this.cupos = cupos;
		this.idUsu = idUsu;
		this.fec_reg = fec_reg;
		this.nomUsu = nomUsu;
		this.apepaUsu = apepaUsu;
		this.apemaUsu = apemaUsu;
		this.fonoUsu = fonoUsu;
		this.emailUsu = emailUsu;
	}

	public int getIdCharla() {
		return idCharla;
	}

	public void setIdCharla(int idCharla) {
		this.idCharla = idCharla;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public int getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}

	public Date getFec_reg() {
		return fec_reg;
	}

	public void setFec_reg(Date fec_reg) {
		this.fec_reg = fec_reg;
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getApepaUsu() {
		return apepaUsu;
	}

	public void setApepaUsu(String apepaUsu) {
		this.apepaUsu = apepaUsu;
	}

	public String getApemaUsu() {
		return apemaUsu;
	}

	public void setApemaUsu(String apemaUsu) {
		this.apemaUsu = apemaUsu;
	}

	public String getFonoUsu() {
		return fonoUsu;
	}

	public void setFonoUsu(String fonoUsu) {
		this.fonoUsu = fonoUsu;
	}

	public String getEmailUsu() {
		return emailUsu;
	}

	public void setEmailUsu(String emailUsu) {
		this.emailUsu = emailUsu;
	}
}
