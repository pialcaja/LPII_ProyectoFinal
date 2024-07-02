package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_detallemensaje database table.
 * 
 */
@Entity
@Table(name="tbl_detallemensaje")
@NamedQuery(name="TblDetallemensaje.findAll", query="SELECT t FROM TblDetallemensaje t")
public class TblDetallemensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblDetallemensajePK id;

	//bi-directional many-to-one association to TblMensaje
	@ManyToOne
	@JoinColumn(name="id_msj", insertable=false, updatable=false)
	private TblMensaje tblMensaje;

	//bi-directional many-to-one association to TblUsuario
	@ManyToOne
	@JoinColumn(name="id_usu", insertable=false, updatable=false)
	private TblUsuario tblUsuario;

	public TblDetallemensaje() {
	}

	public TblDetallemensajePK getId() {
		return this.id;
	}

	public void setId(TblDetallemensajePK id) {
		this.id = id;
	}

	public TblMensaje getTblMensaje() {
		return this.tblMensaje;
	}

	public void setTblMensaje(TblMensaje tblMensaje) {
		this.tblMensaje = tblMensaje;
	}

	public TblUsuario getTblUsuario() {
		return this.tblUsuario;
	}

	public void setTblUsuario(TblUsuario tblUsuario) {
		this.tblUsuario = tblUsuario;
	}

}