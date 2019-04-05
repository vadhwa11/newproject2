package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreBosT;

public class StoreBosT extends BaseStoreBosT {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreBosT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreBosT (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreBosT (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item,
		jkt.hms.masters.business.StoreBosM bosM,
		java.lang.Integer srNo,
		java.lang.String serialNo,
		java.lang.Integer qty) {

		super (
			id,
			item,
			bosM,
			srNo,
			serialNo,
			qty);
	}

	/* [CONSTRUCTOR MARKER END] */

}