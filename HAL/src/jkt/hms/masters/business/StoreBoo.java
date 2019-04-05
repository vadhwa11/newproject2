package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreBoo;

public class StoreBoo extends BaseStoreBoo {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreBoo() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreBoo(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreBoo(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasRank commandRank,
			jkt.hms.masters.business.MasEmployee command,
			java.lang.String booNo, java.util.Date booDate,
			java.lang.String grnNo, java.lang.String hroSlNo,
			java.util.Date hroDate, java.lang.String status,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime) {

		super(id, hospital, commandRank, command, booNo, booDate, grnNo,
				hroSlNo, hroDate, status, lastChgBy, lastChgDate, lastChgTime);
	}

	/* [CONSTRUCTOR MARKER END] */

}