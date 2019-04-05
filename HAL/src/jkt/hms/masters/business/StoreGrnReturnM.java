package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreGrnReturnM;

public class StoreGrnReturnM extends BaseStoreGrnReturnM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreGrnReturnM() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreGrnReturnM(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreGrnReturnM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital) {

		super(id, hospital);
	}

	/* [CONSTRUCTOR MARKER END] */

}