package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasDepartmentType;

public class MasDepartmentType extends BaseMasDepartmentType {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasDepartmentType() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasDepartmentType(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasDepartmentType(java.lang.Integer id, java.lang.String status) {

		super(id, status);
	}

	/* [CONSTRUCTOR MARKER END] */

}