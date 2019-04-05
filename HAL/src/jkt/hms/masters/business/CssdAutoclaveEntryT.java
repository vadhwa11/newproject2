package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseCssdAutoclaveEntryT;

public class CssdAutoclaveEntryT extends BaseCssdAutoclaveEntryT {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CssdAutoclaveEntryT() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CssdAutoclaveEntryT(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CssdAutoclaveEntryT(java.lang.Integer id,
			jkt.hms.masters.business.CssdAutoclaveRequestM request,
			jkt.hms.masters.business.CssdInstrumentMaster instrument,
			jkt.hms.masters.business.CssdAutoclaveEntryM entryM,
			jkt.hms.masters.business.CssdMaterialMaster material,
			java.lang.Integer qty, java.lang.String receiptStatus) {

		super(id, request, instrument, entryM, material, qty, receiptStatus);
	}

	/* [CONSTRUCTOR MARKER END] */

}