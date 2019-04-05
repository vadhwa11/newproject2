package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseAccomRegistration;

public class AccomRegistration extends BaseAccomRegistration {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public AccomRegistration() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AccomRegistration(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public AccomRegistration(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasPool pool,
			jkt.hms.masters.business.MasUnit previousUnit,
			jkt.hms.masters.business.MasRank rank,
			java.lang.String registrationNo, java.util.Date registrationDate,
			java.lang.String registrationTime, java.lang.String serviceNo,
			java.lang.String servicePersonName, java.lang.String previousSmq,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime, java.lang.String sfx,
			java.lang.String regType) {

		super(id, hospital, pool, previousUnit, rank, registrationNo,
				registrationDate, registrationTime, serviceNo,
				servicePersonName, previousSmq, lastChgBy, lastChgDate,
				lastChgTime, sfx, regType);
	}

	/* [CONSTRUCTOR MARKER END] */

}