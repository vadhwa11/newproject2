package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseUsergroupApplications;

public class UsergroupApplications extends BaseUsergroupApplications {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public UsergroupApplications() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UsergroupApplications(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UsergroupApplications(java.lang.Integer id,
			jkt.hms.masters.business.MasApplication app,
			jkt.hms.masters.business.UsergroupHospital groupHospital) {

		super(id, app, groupHospital);
	}

	/* [CONSTRUCTOR MARKER END] */

}