package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasSalesType;

public class MasSalesType extends BaseMasSalesType {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasSalesType() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasSalesType(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasSalesType(java.lang.Integer id, java.lang.String status) {

		super(id, status);
	}

	/* [CONSTRUCTOR MARKER END] */

}