package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_detallecharla database table.
 * 
 */
@Entity
@Table(name="tbl_detallecharla")
@NamedQuery(name="TblDetallecharla.findAll", query="SELECT t FROM TblDetallecharla t")
public class TblDetallecharla implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblDetallecharlaPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_reg")
	private Date fecReg;

	//bi-directional many-to-one association to TblCharla
	@ManyToOne
	@JoinColumn(name="id_charla", insertable=false, updatable=false)
	private TblCharla tblCharla;

	//bi-directional many-to-one association to TblUsuario
	@ManyToOne
	@JoinColumn(name="id_usu", insertable=false, updatable=false)
	private TblUsuario tblUsuario;

	public TblDetallecharla() {
	}

	public TblDetallecharlaPK getId() {
		return this.id;
	}

	public void setId(TblDetallecharlaPK id) {
		this.id = id;
	}

	public Date getFecReg() {
		return this.fecReg;
	}

	public void setFecReg(Date fecReg) {
		this.fecReg = fecReg;
	}

	public TblCharla getTblCharla() {
		return this.tblCharla;
	}

	public void setTblCharla(TblCharla tblCharla) {
		this.tblCharla = tblCharla;
	}

	public TblUsuario getTblUsuario() {
		return this.tblUsuario;
	}

	public void setTblUsuario(TblUsuario tblUsuario) {
		this.tblUsuario = tblUsuario;
	}

}