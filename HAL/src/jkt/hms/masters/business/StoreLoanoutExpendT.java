package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreLoanoutExpendT;



public class StoreLoanoutExpendT extends BaseStoreLoanoutExpendT {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public StoreLoanoutExpendT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreLoanoutExpendT (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreLoanoutExpendT (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item,
		jkt.hms.masters.business.StoreLoanoutExpendM issueM) {

		super (
			id,
			item,
			issueM);
	}

/*[CONSTRUCTOR MARKER END]*/


}