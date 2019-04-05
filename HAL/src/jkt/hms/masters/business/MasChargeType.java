package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasChargeType;

public class MasChargeType extends BaseMasChargeType {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasChargeType() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasChargeType(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasChargeType(java.lang.Integer id, java.lang.String status) {

		super(id, status);
	}

	/* [CONSTRUCTOR MARKER END] */

}