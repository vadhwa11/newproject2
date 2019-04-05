package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseFwcDeliveryDetails;



public class FwcDeliveryDetails extends BaseFwcDeliveryDetails {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FwcDeliveryDetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FwcDeliveryDetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FwcDeliveryDetails (
		java.lang.Integer id,
		java.lang.String timeDelivery,
		java.lang.String typeDelivery,
		java.lang.String placeDelivery) {

		super (
			id,
			timeDelivery,
			typeDelivery,
			placeDelivery);
	}

/*[CONSTRUCTOR MARKER END]*/


}