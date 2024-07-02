package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_usuario database table.
 * 
 */
@Entity
@Table(name="tbl_usuario")
@NamedQuery(name="TblUsuario.findAll", query="SELECT t FROM TblUsuario t")
public class TblUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usu")
	private int idUsu;

	@Column(name="apema_usu")
	private String apemaUsu;

	@Column(name="apepa_usu")
	private String apepaUsu;

	@Column(name="email_usu")
	private String emailUsu;

	@Column(name="fono_usu")
	private String fonoUsu;

	@Column(name="nom_usu")
	private String nomUsu;

	@Column(name="password_usu")
	private String passwordUsu;

	//bi-directional many-to-one association to TblDetallecharla
	@OneToMany(mappedBy="tblUsuario")
	private List<TblDetallecharla> tblDetallecharlas;

	//bi-directional many-to-one association to TblDetallemensaje
	@OneToMany(mappedBy="tblUsuario")
	private List<TblDetallemensaje> tblDetallemensajes;

	//bi-directional many-to-many association to TblCharla
	@ManyToMany
	@JoinTable(
		name="tbl_detallecharla"
		, joinColumns={
			@JoinColumn(name="id_usu")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_charla")
			}
		)
	private List<TblCharla> tblCharlas;

	//bi-directional many-to-many association to TblMensaje
	@ManyToMany
	@JoinTable(
		name="tbl_detallemensaje"
		, joinColumns={
			@JoinColumn(name="id_usu")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_msj")
			}
		)
	private List<TblMensaje> tblMensajes;

	//bi-directional many-to-one association to TblTipousuario
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private TblTipousuario tblTipousuario;

	public TblUsuario() {
	}

	public int getIdUsu() {
		return this.idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}

	public String getApemaUsu() {
		return this.apemaUsu;
	}

	public void setApemaUsu(String apemaUsu) {
		this.apemaUsu = apemaUsu;
	}

	public String getApepaUsu() {
		return this.apepaUsu;
	}

	public void setApepaUsu(String apepaUsu) {
		this.apepaUsu = apepaUsu;
	}

	public String getEmailUsu() {
		return this.emailUsu;
	}

	public void setEmailUsu(String emailUsu) {
		this.emailUsu = emailUsu;
	}

	public String getFonoUsu() {
		return this.fonoUsu;
	}

	public void setFonoUsu(String fonoUsu) {
		this.fonoUsu = fonoUsu;
	}

	public String getNomUsu() {
		return this.nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getPasswordUsu() {
		return this.passwordUsu;
	}

	public void setPasswordUsu(String passwordUsu) {
		this.passwordUsu = passwordUsu;
	}

	public List<TblDetallecharla> getTblDetallecharlas() {
		return this.tblDetallecharlas;
	}

	public void setTblDetallecharlas(List<TblDetallecharla> tblDetallecharlas) {
		this.tblDetallecharlas = tblDetallecharlas;
	}

	public TblDetallecharla addTblDetallecharla(TblDetallecharla tblDetallecharla) {
		getTblDetallecharlas().add(tblDetallecharla);
		tblDetallecharla.setTblUsuario(this);

		return tblDetallecharla;
	}

	public TblDetallecharla removeTblDetallecharla(TblDetallecharla tblDetallecharla) {
		getTblDetallecharlas().remove(tblDetallecharla);
		tblDetallecharla.setTblUsuario(null);

		return tblDetallecharla;
	}

	public List<TblDetallemensaje> getTblDetallemensajes() {
		return this.tblDetallemensajes;
	}

	public void setTblDetallemensajes(List<TblDetallemensaje> tblDetallemensajes) {
		this.tblDetallemensajes = tblDetallemensajes;
	}

	public TblDetallemensaje addTblDetallemensaje(TblDetallemensaje tblDetallemensaje) {
		getTblDetallemensajes().add(tblDetallemensaje);
		tblDetallemensaje.setTblUsuario(this);

		return tblDetallemensaje;
	}

	public TblDetallemensaje removeTblDetallemensaje(TblDetallemensaje tblDetallemensaje) {
		getTblDetallemensajes().remove(tblDetallemensaje);
		tblDetallemensaje.setTblUsuario(null);

		return tblDetallemensaje;
	}

	public List<TblCharla> getTblCharlas() {
		return this.tblCharlas;
	}

	public void setTblCharlas(List<TblCharla> tblCharlas) {
		this.tblCharlas = tblCharlas;
	}

	public List<TblMensaje> getTblMensajes() {
		return this.tblMensajes;
	}

	public void setTblMensajes(List<TblMensaje> tblMensajes) {
		this.tblMensajes = tblMensajes;
	}

	public TblTipousuario getTblTipousuario() {
		return this.tblTipousuario;
	}

	public void setTblTipousuario(TblTipousuario tblTipousuario) {
		this.tblTipousuario = tblTipousuario;
	}

}