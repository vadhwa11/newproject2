package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseCssdAutoclaveReceiptT;

public class CssdAutoclaveReceiptT extends BaseCssdAutoclaveReceiptT {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CssdAutoclaveReceiptT() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CssdAutoclaveReceiptT(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CssdAutoclaveReceiptT(java.lang.Integer id,
			jkt.hms.masters.business.CssdInstrumentMaster instrument,
			jkt.hms.masters.business.CssdAutoclaveEntryM entryM,
			jkt.hms.masters.business.CssdMaterialMaster material,
			java.lang.Integer qty, java.lang.String integrator,
			java.lang.String recallStatus) {

		super(id, instrument, entryM, material, qty, integrator, recallStatus);
	}

	/* [CONSTRUCTOR MARKER END] */

}