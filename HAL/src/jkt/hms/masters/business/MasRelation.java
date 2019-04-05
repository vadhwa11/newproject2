package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasRelation;

public class MasRelation extends BaseMasRelation {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasRelation () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasRelation (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasRelation (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

	/* [CONSTRUCTOR MARKER END] */

}