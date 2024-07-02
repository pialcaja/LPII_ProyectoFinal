package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_mensaje database table.
 * 
 */
@Entity
@Table(name="tbl_mensaje")
@NamedQuery(name="TblMensaje.findAll", query="SELECT t FROM TblMensaje t")
public class TblMensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_msj")
	private int idMsj;

	@Column(name="desc_msj")
	private String descMsj;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_reg")
	private Date fecReg;

	//bi-directional many-to-one association to TblDetallemensaje
	@OneToMany(mappedBy="tblMensaje")
	private List<TblDetallemensaje> tblDetallemensajes;

	//bi-directional many-to-many association to TblUsuario
	@ManyToMany(mappedBy="tblMensajes")
	private List<TblUsuario> tblUsuarios;

	public TblMensaje() {
	}

	public int getIdMsj() {
		return this.idMsj;
	}

	public void setIdMsj(int idMsj) {
		this.idMsj = idMsj;
	}

	public String getDescMsj() {
		return this.descMsj;
	}

	public void setDescMsj(String descMsj) {
		this.descMsj = descMsj;
	}

	public Date getFecReg() {
		return this.fecReg;
	}

	public void setFecReg(Date fecReg) {
		this.fecReg = fecReg;
	}

	public List<TblDetallemensaje> getTblDetallemensajes() {
		return this.tblDetallemensajes;
	}

	public void setTblDetallemensajes(List<TblDetallemensaje> tblDetallemensajes) {
		this.tblDetallemensajes = tblDetallemensajes;
	}

	public TblDetallemensaje addTblDetallemensaje(TblDetallemensaje tblDetallemensaje) {
		getTblDetallemensajes().add(tblDetallemensaje);
		tblDetallemensaje.setTblMensaje(this);

		return tblDetallemensaje;
	}

	public TblDetallemensaje removeTblDetallemensaje(TblDetallemensaje tblDetallemensaje) {
		getTblDetallemensajes().remove(tblDetallemensaje);
		tblDetallemensaje.setTblMensaje(null);

		return tblDetallemensaje;
	}

	public List<TblUsuario> getTblUsuarios() {
		return this.tblUsuarios;
	}

	public void setTblUsuarios(List<TblUsuario> tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

}