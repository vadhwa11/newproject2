package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasMajorCategoryCode;

public class MasMajorCategoryCode extends BaseMasMajorCategoryCode {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasMajorCategoryCode() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasMajorCategoryCode(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasMajorCategoryCode(java.lang.Integer id, java.lang.String status) {

		super(id, status);
	}

	/* [CONSTRUCTOR MARKER END] */

}