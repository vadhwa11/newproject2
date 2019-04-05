package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreTenderCommBidT;

public class StoreTenderCommBidT extends BaseStoreTenderCommBidT {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreTenderCommBidT() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreTenderCommBidT(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreTenderCommBidT(java.lang.Integer id,
			jkt.hms.masters.business.StoreTenderCommBidM commBid,
			jkt.hms.masters.business.MasStoreSupplier supplier,
			java.lang.Integer srNo, java.lang.String dispType,
			java.math.BigDecimal mdqValue, java.math.BigDecimal ratePerMdq,
			java.math.BigDecimal taxAmountMdq, java.math.BigDecimal totRateMdq,
			java.math.BigDecimal newRatePerMdq,
			java.math.BigDecimal newTaxAmtPerMdq,
			java.math.BigDecimal newTotRateMdq) {

		super(id, commBid, supplier, srNo, dispType, mdqValue, ratePerMdq,
				taxAmountMdq, totRateMdq, newRatePerMdq, newTaxAmtPerMdq,
				newTotRateMdq);
	}

	/* [CONSTRUCTOR MARKER END] */

}