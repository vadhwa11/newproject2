package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreLoanoutExpendM;



public class StoreLoanoutExpendM extends BaseStoreLoanoutExpendM {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public StoreLoanoutExpendM () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreLoanoutExpendM (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreLoanoutExpendM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasHospital hospital,
		java.lang.String issueType,
		java.lang.String issueNo,
		java.util.Date issueDate) {

		super (
			id,
			department,
			hospital,
			issueType,
			issueNo,
			issueDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}