package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseCssdAutoclaveRequestM;

public class CssdAutoclaveRequestM extends BaseCssdAutoclaveRequestM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CssdAutoclaveRequestM() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CssdAutoclaveRequestM(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CssdAutoclaveRequestM(java.lang.Integer id,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.MasEmployee orderBy,
			java.lang.String orderNo, java.util.Date orderDate,
			java.lang.String orderTime) {

		super(id, department, orderBy, orderNo, orderDate, orderTime);
	}

	/* [CONSTRUCTOR MARKER END] */

}