package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreBosM;

public class StoreBosM extends BaseStoreBosM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreBosM () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreBosM (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreBosM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment department,
		java.lang.String bosNo,
		java.util.Date bosDate,
		java.lang.String status,
		java.lang.String lastChgBy,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		super (
			id,
			hospital,
			department,
			bosNo,
			bosDate,
			status,
			lastChgBy,
			lastChgDate,
			lastChgTime);
	}

	/* [CONSTRUCTOR MARKER END] */

}