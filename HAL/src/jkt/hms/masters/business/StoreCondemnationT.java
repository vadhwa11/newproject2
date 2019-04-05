package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreCondemnationT;

public class StoreCondemnationT extends BaseStoreCondemnationT {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreCondemnationT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreCondemnationT (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreCondemnationT (
		java.lang.Integer id,
		jkt.hms.masters.business.StoreCondemnationM condemM,
		jkt.hms.masters.business.MasStoreItem item,
		java.lang.Integer srNo,
		java.lang.String serialNo,
		java.lang.Integer qty,
		java.lang.String reasonForSentence,
		java.lang.String remarks) {

		super (
			id,
			condemM,
			item,
			srNo,
			serialNo,
			qty,
			reasonForSentence,
			remarks);
	}

	/* [CONSTRUCTOR MARKER END] */

}