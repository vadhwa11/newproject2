package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseLeaveRestrictionEntry;

public class LeaveRestrictionEntry extends BaseLeaveRestrictionEntry {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public LeaveRestrictionEntry() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LeaveRestrictionEntry(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public LeaveRestrictionEntry(java.lang.Integer id,
			java.util.Date entryDate, java.util.Date fromPeriod,
			java.util.Date toPeriod, java.lang.Integer maxLeaveDays,
			java.lang.String lastChangedBy, java.util.Date lastChangedDate,
			java.lang.String status, java.lang.String entryNo) {

		super(id, entryDate, fromPeriod, toPeriod, maxLeaveDays, lastChangedBy,
				lastChangedDate, status, entryNo);
	}

	/* [CONSTRUCTOR MARKER END] */

}