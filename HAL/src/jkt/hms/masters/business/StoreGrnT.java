package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreGrnT;

public class StoreGrnT extends BaseStoreGrnT {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreGrnT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreGrnT (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreGrnT (
		java.lang.Integer id,
		jkt.hms.masters.business.StoreGrnM grnMaster,
		jkt.hms.masters.business.MasStoreItem item,
		java.math.BigDecimal receivedQty,
		java.math.BigDecimal unitRate) {

		super (
			id,
			grnMaster,
			item,
			receivedQty,
			unitRate);
	}

	/* [CONSTRUCTOR MARKER END] */

}