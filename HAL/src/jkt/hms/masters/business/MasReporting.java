package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasReporting;



public class MasReporting extends BaseMasReporting {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasReporting () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasReporting (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasReporting (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}