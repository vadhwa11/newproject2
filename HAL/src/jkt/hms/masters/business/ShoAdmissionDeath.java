package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseShoAdmissionDeath;



public class ShoAdmissionDeath extends BaseShoAdmissionDeath {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ShoAdmissionDeath () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ShoAdmissionDeath (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ShoAdmissionDeath (
		java.lang.Integer id,
		java.lang.String category,
		java.lang.String noOfAd,
		java.lang.String noOfD,
		java.lang.String avg,
		java.lang.String rate) {

		super (
			id,
			category,
			noOfAd,
			noOfD,
			avg,
			rate);
	}

/*[CONSTRUCTOR MARKER END]*/


}