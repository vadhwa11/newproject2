package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasAnesthesia;

public class MasAnesthesia extends BaseMasAnesthesia {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasAnesthesia() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasAnesthesia(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasAnesthesia(java.lang.Integer id, java.lang.String status) {

		super(id, status);
	}

	/* [CONSTRUCTOR MARKER END] */

}