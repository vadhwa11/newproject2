package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreTenderCommBidM;

public class StoreTenderCommBidM extends BaseStoreTenderCommBidM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreTenderCommBidM() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreTenderCommBidM(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreTenderCommBidM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.StoreTenderM tender,
			jkt.hms.masters.business.MasStoreItem item,
			jkt.hms.masters.business.MasStoreGroup group,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime, java.lang.String status) {

		super(id, hospital, department, tender, item, group, lastChgBy,
				lastChgDate, lastChgTime, status);
	}

	/* [CONSTRUCTOR MARKER END] */

}