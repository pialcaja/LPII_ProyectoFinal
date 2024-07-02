package etiquetas;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import dao.CharlaImp;
import model.TblCharla;

public class CboCharlaTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() throws JspException {	
		
		 JspWriter out = pageContext.getOut();
		 try {
			 // OBTENER UN LISTADO DE LAS CATEGORIAS
			 List<TblCharla> lstCharla = new CharlaImp().ListarCharla();			 
			 
			 // LLENAR LAS OPCIONES DEL COMBO
			 out.println("<option value=\"-1\" >Seleccione tema...</option>");
			 for(TblCharla c : lstCharla) {
				 out.println( String.format("<option value=\"%d\">%s</option>", c.getIdCharla(), c.getTema()));
			 }
		} catch (Exception e) {
			System.out.println("Error en MenuTag");
		}

		 return SKIP_BODY;

			}

	public int doEndTag() throws JspException {

		return EVAL_PAGE;

	}
}
