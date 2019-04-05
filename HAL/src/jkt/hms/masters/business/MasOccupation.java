package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasOccupation;

public class MasOccupation extends BaseMasOccupation {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasOccupation () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasOccupation (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasOccupation (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

	/* [CONSTRUCTOR MARKER END] */

}