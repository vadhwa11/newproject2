package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseBlReceiptDetails;



public class BlReceiptDetails extends BaseBlReceiptDetails {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BlReceiptDetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BlReceiptDetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BlReceiptDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.BlReceiptHeader receiptHeader) {

		super (
			id,
			receiptHeader);
	}

/*[CONSTRUCTOR MARKER END]*/


}