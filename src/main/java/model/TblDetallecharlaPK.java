package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbl_detallecharla database table.
 * 
 */
@Embeddable
public class TblDetallecharlaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_usu", insertable=false, updatable=false)
	private int idUsu;

	@Column(name="id_charla", insertable=false, updatable=false)
	private int idCharla;

	public TblDetallecharlaPK() {
	}
	public int getIdUsu() {
		return this.idUsu;
	}
	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}
	public int getIdCharla() {
		return this.idCharla;
	}
	public void setIdCharla(int idCharla) {
		this.idCharla = idCharla;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblDetallecharlaPK)) {
			return false;
		}
		TblDetallecharlaPK castOther = (TblDetallecharlaPK)other;
		return 
			(this.idUsu == castOther.idUsu)
			&& (this.idCharla == castOther.idCharla);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsu;
		hash = hash * prime + this.idCharla;
		
		return hash;
	}
}