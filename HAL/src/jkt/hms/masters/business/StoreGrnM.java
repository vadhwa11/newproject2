package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreGrnM;

public class StoreGrnM extends BaseStoreGrnM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreGrnM () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreGrnM (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreGrnM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasHospital hospital,
		java.lang.String receiveType,
		java.util.Date grnDate,
		java.lang.String status,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		super (
			id,
			department,
			hospital,
			receiveType,
			grnDate,
			status,
			lastChgDate,
			lastChgTime);
	}

	/* [CONSTRUCTOR MARKER END] */

}