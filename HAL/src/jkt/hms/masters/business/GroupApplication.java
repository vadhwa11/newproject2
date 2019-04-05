package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseGroupApplication;

public class GroupApplication extends BaseGroupApplication {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public GroupApplication() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public GroupApplication(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public GroupApplication(java.lang.Integer id,
			jkt.hms.masters.business.MasApplication app,
			jkt.hms.masters.business.UserGroups group) {

		super(id, app, group);
	}

	/* [CONSTRUCTOR MARKER END] */

}