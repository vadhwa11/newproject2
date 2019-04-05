package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreDefectiveDrugM;

public class StoreDefectiveDrugM extends BaseStoreDefectiveDrugM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreDefectiveDrugM () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreDefectiveDrugM (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreDefectiveDrugM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasEmployee authorisedBy,
		jkt.hms.masters.business.MasEmployee enteredBy,
		java.util.Date entryDate,
		java.util.Date docDate,
		java.lang.String status,
		java.lang.String lastChgBy,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime,
		java.lang.String entryNo,
		java.lang.String reason,
		java.lang.String signalNo,
		java.lang.String disposalInstructions,
		java.lang.String remarks) {

		super (
			id,
			hospital,
			department,
			authorisedBy,
			enteredBy,
			entryDate,
			docDate,
			status,
			lastChgBy,
			lastChgDate,
			lastChgTime,
			entryNo,
			reason,
			signalNo,
			disposalInstructions,
			remarks);
	}

	/* [CONSTRUCTOR MARKER END] */

}