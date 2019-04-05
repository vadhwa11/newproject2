package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseAviAircrewMedicalLectures;



public class AviAircrewMedicalLectures extends BaseAviAircrewMedicalLectures {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AviAircrewMedicalLectures () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AviAircrewMedicalLectures (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public AviAircrewMedicalLectures (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}