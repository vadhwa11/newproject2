package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasTemplate;

public class MasTemplate extends BaseMasTemplate {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasTemplate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasTemplate (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasTemplate (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment dept,
		java.lang.String templateCode,
		java.lang.String templateName,
		java.lang.String lastChgBy,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		super (
			id,
			hospital,
			dept,
			templateCode,
			templateName,
			lastChgBy,
			lastChgDate,
			lastChgTime);
	}

	/* [CONSTRUCTOR MARKER END] */

}