package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseDiagnosticsOrderHeader;

public class DiagnosticsOrderHeader extends BaseDiagnosticsOrderHeader {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public DiagnosticsOrderHeader() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DiagnosticsOrderHeader(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DiagnosticsOrderHeader(java.lang.Integer id,
			jkt.hms.masters.business.Patient hin, java.lang.Integer hospitalId,
			java.lang.Integer addEditById) {

		super(id, hin, hospitalId, addEditById);
	}

	/* [CONSTRUCTOR MARKER END] */

}