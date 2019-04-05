package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasItemType;

public class MasItemType extends BaseMasItemType {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasItemType () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasItemType (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasItemType (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

	/* [CONSTRUCTOR MARKER END] */

}