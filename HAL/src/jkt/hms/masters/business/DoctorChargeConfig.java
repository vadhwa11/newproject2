package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseDoctorChargeConfig;

public class DoctorChargeConfig extends BaseDoctorChargeConfig {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public DoctorChargeConfig() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DoctorChargeConfig(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DoctorChargeConfig(java.lang.Integer id, java.lang.Integer doctorId) {

		super(id, doctorId);
	}

	/* [CONSTRUCTOR MARKER END] */

}