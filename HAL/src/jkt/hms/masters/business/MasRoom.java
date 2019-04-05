package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasRoom;

public class MasRoom extends BaseMasRoom {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasRoom () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasRoom (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasRoom (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

	/* [CONSTRUCTOR MARKER END] */

}