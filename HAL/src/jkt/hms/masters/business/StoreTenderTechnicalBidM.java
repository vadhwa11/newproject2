package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreTenderTechnicalBidM;

public class StoreTenderTechnicalBidM extends BaseStoreTenderTechnicalBidM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreTenderTechnicalBidM() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreTenderTechnicalBidM(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreTenderTechnicalBidM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.MasStoreSupplier supplier,
			jkt.hms.masters.business.StoreTenderM tender,
			jkt.hms.masters.business.MasStoreGroup group,
			java.lang.String goodManufLabPractice,
			java.lang.String noConvictionIssued,
			java.lang.String marketStandingCertificate,
			java.lang.String status, java.lang.String qualified,
			java.lang.String lastChgBy, java.lang.String lastChgTime) {

		super(id, hospital, department, supplier, tender, group,
				goodManufLabPractice, noConvictionIssued,
				marketStandingCertificate, status, qualified, lastChgBy,
				lastChgTime);
	}

	/* [CONSTRUCTOR MARKER END] */

}