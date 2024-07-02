package model;

public class UsuarioConTipo {
	
	private int idUsu;
	private String nomUsu;
	private String apepaUsu;
	private String apemaUsu;
	private String fonoUsu;
	private String emailUsu;
	private String passwordUsu;
	private int idTipo;
	private String nomTipo;
	
	public UsuarioConTipo() {
	}

	public UsuarioConTipo(int idUsu, String nomUsu, String apepaUsu, String apemaUsu, String fonoUsu, String emailUsu,
			String passwordUsu, int idTipo, String nomTipo) {
		this.idUsu = idUsu;
		this.nomUsu = nomUsu;
		this.apepaUsu = apepaUsu;
		this.apemaUsu = apemaUsu;
		this.fonoUsu = fonoUsu;
		this.emailUsu = emailUsu;
		this.passwordUsu = passwordUsu;
		this.idTipo = idTipo;
		this.nomTipo = nomTipo;
	}

	public int getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
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

	public String getPasswordUsu() {
		return passwordUsu;
	}

	public void setPasswordUsu(String passwordUsu) {
		this.passwordUsu = passwordUsu;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNomTipo() {
		return nomTipo;
	}

	public void setNomTipo(String nomTipo) {
		this.nomTipo = nomTipo;
	}
}
