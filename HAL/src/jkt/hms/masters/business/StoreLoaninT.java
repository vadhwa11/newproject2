package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreLoaninT;

public class StoreLoaninT extends BaseStoreLoaninT {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreLoaninT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreLoaninT (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreLoaninT (
		java.lang.Integer id,
		jkt.hms.masters.business.StoreLoaninM loaninMaster,
		jkt.hms.masters.business.MasStoreItem item,
		java.math.BigDecimal receivedQty,
		java.math.BigDecimal rQty) {

		super (
			id,
			loaninMaster,
			item,
			receivedQty,
			rQty);
	}

	/* [CONSTRUCTOR MARKER END] */

}