package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMisFrw;

public class MisFrw extends BaseMisFrw {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MisFrw () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MisFrw (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MisFrw (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDisposedTo disposedTo,
		jkt.hms.masters.business.Patient hin,
		jkt.hms.masters.business.MasUnit toUnit) {

		super (
			id,
			disposedTo,
			hin,
			toUnit);
	}

	/* [CONSTRUCTOR MARKER END] */

}