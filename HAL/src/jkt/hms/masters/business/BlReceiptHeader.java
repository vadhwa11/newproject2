package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseBlReceiptHeader;



public class BlReceiptHeader extends BaseBlReceiptHeader {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BlReceiptHeader () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BlReceiptHeader (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BlReceiptHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.Users changedBy,
		jkt.hms.masters.business.MasHospital hospital,
		java.lang.String receiptNo,
		java.util.Date receiptDate) {

		super (
			id,
			changedBy,
			hospital,
			receiptNo,
			receiptDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}