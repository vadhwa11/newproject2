package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseHesEquipmentMaster;



public class HesEquipmentMaster extends BaseHesEquipmentMaster {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HesEquipmentMaster () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HesEquipmentMaster (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HesEquipmentMaster (
		java.lang.Integer id,
		java.math.BigDecimal replacementValue) {

		super (
			id,
			replacementValue);
	}

/*[CONSTRUCTOR MARKER END]*/


}