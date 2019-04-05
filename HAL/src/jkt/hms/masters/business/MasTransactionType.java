package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasTransactionType;

public class MasTransactionType extends BaseMasTransactionType {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasTransactionType() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasTransactionType(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasTransactionType(java.lang.Integer id, java.lang.String status) {

		super(id, status);
	}

	/* [CONSTRUCTOR MARKER END] */

}