package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasAircraftType;



public class MasAircraftType extends BaseMasAircraftType {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasAircraftType () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasAircraftType (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasAircraftType (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}