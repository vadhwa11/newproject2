package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasComplaint;

public class MasComplaint extends BaseMasComplaint {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasComplaint() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasComplaint(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasComplaint(java.lang.Integer id, java.lang.String status) {

		super(id, status);
	}

	/* [CONSTRUCTOR MARKER END] */

}