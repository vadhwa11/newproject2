package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreLoanOutT;



public class StoreLoanOutT extends BaseStoreLoanOutT {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public StoreLoanOutT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreLoanOutT (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreLoanOutT (
		java.lang.Integer id,
		jkt.hms.masters.business.StoreLoanOutM issueM,
		jkt.hms.masters.business.MasStoreItem item) {

		super (
			id,
			issueM,
			item);
	}

/*[CONSTRUCTOR MARKER END]*/


}