package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasChargeCode;

public class MasChargeCode extends BaseMasChargeCode {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasChargeCode() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasChargeCode(java.lang.Integer id) {
		super(id);
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return super.compareTo((MasChargeCode)arg0);
	}

	/* [CONSTRUCTOR MARKER END] */

}