package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseOtMasDeptDistribution;



public class OtMasDeptDistribution extends BaseOtMasDeptDistribution {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OtMasDeptDistribution () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OtMasDeptDistribution (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public OtMasDeptDistribution (
		java.lang.Integer id,
		java.lang.String status,
		java.lang.String dayName) {

		super (
			id,
			status,
			dayName);
	}

/*[CONSTRUCTOR MARKER END]*/


}