package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreTenderCommHodRecom;

public class StoreTenderCommHodRecom extends BaseStoreTenderCommHodRecom {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreTenderCommHodRecom() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreTenderCommHodRecom(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreTenderCommHodRecom(java.lang.Integer id,
			jkt.hms.masters.business.MasEmployee specialist,
			jkt.hms.masters.business.MasStoreSupplier supplier,
			java.lang.Integer srNo) {

		super(id, specialist, supplier, srNo);
	}

	/* [CONSTRUCTOR MARKER END] */

}