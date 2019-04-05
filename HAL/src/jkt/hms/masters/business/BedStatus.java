package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseBedStatus;

public class BedStatus extends BaseBedStatus {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public BedStatus() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BedStatus(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BedStatus(java.lang.Integer id, java.lang.Integer remd,
			java.lang.Integer adm) {

		super(id, remd, adm);
	}

	/* [CONSTRUCTOR MARKER END] */

}