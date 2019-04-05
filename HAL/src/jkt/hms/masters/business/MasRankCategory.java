package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasRankCategory;

public class MasRankCategory extends BaseMasRankCategory {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasRankCategory() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasRankCategory(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasRankCategory(java.lang.Integer id, java.lang.String status) {

		super(id, status);
	}

	/* [CONSTRUCTOR MARKER END] */

}