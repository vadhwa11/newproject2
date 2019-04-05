package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseUserUsergroupApplication;

public class UserUsergroupApplication extends BaseUserUsergroupApplication {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public UserUsergroupApplication() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UserUsergroupApplication(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UserUsergroupApplication(java.lang.Integer id,
			jkt.hms.masters.business.Users user,
			jkt.hms.masters.business.UsergroupHospital groupHospital) {

		super(id, user, groupHospital);
	}

	/* [CONSTRUCTOR MARKER END] */

}