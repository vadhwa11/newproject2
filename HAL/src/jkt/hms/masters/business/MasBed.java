package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasBed;

public class MasBed extends BaseMasBed {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasBed () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasBed (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasBed (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

	/* [CONSTRUCTOR MARKER END] */

}