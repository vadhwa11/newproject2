package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasImpanneledHospital;



public class MasImpanneledHospital extends BaseMasImpanneledHospital {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasImpanneledHospital () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasImpanneledHospital (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasImpanneledHospital (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}