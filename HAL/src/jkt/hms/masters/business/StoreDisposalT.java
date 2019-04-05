package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreDisposalT;

public class StoreDisposalT extends BaseStoreDisposalT {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreDisposalT() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreDisposalT(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreDisposalT(java.lang.Integer id,
			jkt.hms.masters.business.StoreDisposalM disposalM,
			jkt.hms.masters.business.MasStoreItem item, java.lang.Integer srNo,
			java.math.BigDecimal qty, java.math.BigDecimal cost) {

		super(id, disposalM, item, srNo, qty, cost);
	}

	/* [CONSTRUCTOR MARKER END] */

}