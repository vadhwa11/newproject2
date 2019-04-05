package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseBlOpBillHeader;



public class BlOpBillHeader extends BaseBlOpBillHeader {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BlOpBillHeader () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BlOpBillHeader (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BlOpBillHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.Patient hin,
		jkt.hms.masters.business.MasHospital hospital,
		java.util.Date billDate,
		java.lang.String billTime) {

		super (
			id,
			hin,
			hospital,
			billDate,
			billTime);
	}

/*[CONSTRUCTOR MARKER END]*/


}