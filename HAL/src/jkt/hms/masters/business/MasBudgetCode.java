package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasBudgetCode;



public class MasBudgetCode extends BaseMasBudgetCode {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasBudgetCode () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasBudgetCode (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasBudgetCode (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}