package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreSupplyOrderEntry;

public class StoreSupplyOrderEntry extends BaseStoreSupplyOrderEntry {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreSupplyOrderEntry() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreSupplyOrderEntry(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreSupplyOrderEntry(java.lang.Integer id,
			java.lang.String indentType) {

		super(id, indentType);
	}

	/* [CONSTRUCTOR MARKER END] */

}