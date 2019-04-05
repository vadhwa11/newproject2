package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreDisposalM;

public class StoreDisposalM extends BaseStoreDisposalM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreDisposalM() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreDisposalM(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreDisposalM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.StoreBosM bos,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String disposalNo, java.util.Date date,
			java.lang.String type, java.lang.String status,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime) {

		super(id, hospital, bos, department, disposalNo, date, type, status,
				lastChgBy, lastChgDate, lastChgTime);
	}

	/* [CONSTRUCTOR MARKER END] */

}