package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreIndentM;

public class StoreIndentM extends BaseStoreIndentM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreIndentM () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreIndentM (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreIndentM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment department,
		java.lang.String indentNo,
		java.util.Date indentDate,
		java.lang.String indentType,
		java.lang.String status,
		java.lang.String imported) {

		super (
			id,
			hospital,
			department,
			indentNo,
			indentDate,
			indentType,
			status,
			imported);
	}

	/* [CONSTRUCTOR MARKER END] */

}