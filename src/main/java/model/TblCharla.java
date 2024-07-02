package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_charla database table.
 * 
 */
@Entity
@Table(name="tbl_charla")
@NamedQuery(name="TblCharla.findAll", query="SELECT t FROM TblCharla t")
public class TblCharla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_charla")
	private int idCharla;

	private int cupos;

	private String tema;

	//bi-directional many-to-one association to TblDetallecharla
	@OneToMany(mappedBy="tblCharla")
	private List<TblDetallecharla> tblDetallecharlas;

	//bi-directional many-to-many association to TblUsuario
	@ManyToMany(mappedBy="tblCharlas")
	private List<TblUsuario> tblUsuarios;

	public TblCharla() {
	}

	public int getIdCharla() {
		return this.idCharla;
	}

	public void setIdCharla(int idCharla) {
		this.idCharla = idCharla;
	}

	public int getCupos() {
		return this.cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<TblDetallecharla> getTblDetallecharlas() {
		return this.tblDetallecharlas;
	}

	public void setTblDetallecharlas(List<TblDetallecharla> tblDetallecharlas) {
		this.tblDetallecharlas = tblDetallecharlas;
	}

	public TblDetallecharla addTblDetallecharla(TblDetallecharla tblDetallecharla) {
		getTblDetallecharlas().add(tblDetallecharla);
		tblDetallecharla.setTblCharla(this);

		return tblDetallecharla;
	}

	public TblDetallecharla removeTblDetallecharla(TblDetallecharla tblDetallecharla) {
		getTblDetallecharlas().remove(tblDetallecharla);
		tblDetallecharla.setTblCharla(null);

		return tblDetallecharla;
	}

	public List<TblUsuario> getTblUsuarios() {
		return this.tblUsuarios;
	}

	public void setTblUsuarios(List<TblUsuario> tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

}