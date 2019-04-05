package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasNursingCare;

public class MasNursingCare extends BaseMasNursingCare {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasNursingCare () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasNursingCare (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasNursingCare (
		java.lang.Integer id,
		java.lang.String defaultStatus,
		java.lang.String status,
		java.lang.String nursingType) {

		super (
			id,
			defaultStatus,
			status,
			nursingType);
	}

	/* [CONSTRUCTOR MARKER END] */

}