package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasPorProgram;

public class MasPorProgram extends BaseMasPorProgram {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasPorProgram() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasPorProgram(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasPorProgram(java.lang.Integer id, java.util.Date fromDate,
			java.util.Date toDate, java.lang.String porNumber) {

		super(id, fromDate, toDate, porNumber);
	}

	/* [CONSTRUCTOR MARKER END] */

}