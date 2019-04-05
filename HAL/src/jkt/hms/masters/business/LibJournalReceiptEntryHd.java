package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseLibJournalReceiptEntryHd;

public class LibJournalReceiptEntryHd extends BaseLibJournalReceiptEntryHd {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public LibJournalReceiptEntryHd() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LibJournalReceiptEntryHd(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public LibJournalReceiptEntryHd(java.lang.Integer id,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime) {

		super(id, lastChgBy, lastChgDate, lastChgTime);
	}

	/* [CONSTRUCTOR MARKER END] */

}