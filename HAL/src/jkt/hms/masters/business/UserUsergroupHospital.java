package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseUserUsergroupHospital;

public class UserUsergroupHospital extends BaseUserUsergroupHospital {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public UserUsergroupHospital () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UserUsergroupHospital (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UserUsergroupHospital (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

	/* [CONSTRUCTOR MARKER END] */

}