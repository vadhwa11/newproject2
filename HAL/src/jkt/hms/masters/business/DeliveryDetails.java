package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseDeliveryDetails;



public class DeliveryDetails extends BaseDeliveryDetails {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public DeliveryDetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DeliveryDetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DeliveryDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.Patient hin) {

		super (
			id,
			hospital,
			hin);
	}

/*[CONSTRUCTOR MARKER END]*/


}