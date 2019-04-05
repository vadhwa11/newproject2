package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseWorkNoDepartment;

public class WorkNoDepartment extends BaseWorkNoDepartment {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public WorkNoDepartment() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public WorkNoDepartment(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public WorkNoDepartment(java.lang.Integer id,
			jkt.hms.masters.business.MasDepartmentType department,
			jkt.hms.masters.business.MasMinorWorkDetail workNoType) {

		super(id, department, workNoType);
	}

	/* [CONSTRUCTOR MARKER END] */

}