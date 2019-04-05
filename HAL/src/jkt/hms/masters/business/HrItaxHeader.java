package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseHrItaxHeader;



public class HrItaxHeader extends BaseHrItaxHeader {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HrItaxHeader () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HrItaxHeader (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HrItaxHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreFinancial fYear,
		jkt.hms.masters.business.MasEmployee employee,
		java.lang.Integer fMonth) {

		super (
			id,
			fYear,
			employee,
			fMonth);
	}

/*[CONSTRUCTOR MARKER END]*/


}