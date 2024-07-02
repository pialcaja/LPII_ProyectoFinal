package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbl_detallemensaje database table.
 * 
 */
@Embeddable
public class TblDetallemensajePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_usu", insertable=false, updatable=false)
	private int idUsu;

	@Column(name="id_msj", insertable=false, updatable=false)
	private int idMsj;

	public TblDetallemensajePK() {
	}
	public int getIdUsu() {
		return this.idUsu;
	}
	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}
	public int getIdMsj() {
		return this.idMsj;
	}
	public void setIdMsj(int idMsj) {
		this.idMsj = idMsj;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblDetallemensajePK)) {
			return false;
		}
		TblDetallemensajePK castOther = (TblDetallemensajePK)other;
		return 
			(this.idUsu == castOther.idUsu)
			&& (this.idMsj == castOther.idMsj);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsu;
		hash = hash * prime + this.idMsj;
		
		return hash;
	}
}