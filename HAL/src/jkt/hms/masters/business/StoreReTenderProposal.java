package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreReTenderProposal;

public class StoreReTenderProposal extends BaseStoreReTenderProposal {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreReTenderProposal() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreReTenderProposal(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreReTenderProposal(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.MasStoreItem item) {

		super(id, hospital, department, item);
	}

	/* [CONSTRUCTOR MARKER END] */

}