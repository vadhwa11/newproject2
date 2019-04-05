package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseCssdMaterialStockM;

public class CssdMaterialStockM extends BaseCssdMaterialStockM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CssdMaterialStockM() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CssdMaterialStockM(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CssdMaterialStockM(java.lang.Integer id,
			jkt.hms.masters.business.MasEmployee approvedBy,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String entryNo) {

		super(id, approvedBy, department, entryNo);
	}

	/* [CONSTRUCTOR MARKER END] */

}