package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_tipousuario database table.
 * 
 */
@Entity
@Table(name="tbl_tipousuario")
@NamedQuery(name="TblTipousuario.findAll", query="SELECT t FROM TblTipousuario t")
public class TblTipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo")
	private int idTipo;

	@Column(name="nom_tipo")
	private String nomTipo;

	//bi-directional many-to-one association to TblUsuario
	@OneToMany(mappedBy="tblTipousuario")
	private List<TblUsuario> tblUsuarios;

	public TblTipousuario() {
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNomTipo() {
		return this.nomTipo;
	}

	public void setNomTipo(String nomTipo) {
		this.nomTipo = nomTipo;
	}

	public List<TblUsuario> getTblUsuarios() {
		return this.tblUsuarios;
	}

	public void setTblUsuarios(List<TblUsuario> tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

	public TblUsuario addTblUsuario(TblUsuario tblUsuario) {
		getTblUsuarios().add(tblUsuario);
		tblUsuario.setTblTipousuario(this);

		return tblUsuario;
	}

	public TblUsuario removeTblUsuario(TblUsuario tblUsuario) {
		getTblUsuarios().remove(tblUsuario);
		tblUsuario.setTblTipousuario(null);

		return tblUsuario;
	}

}