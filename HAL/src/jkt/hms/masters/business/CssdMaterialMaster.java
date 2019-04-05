package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseCssdMaterialMaster;

public class CssdMaterialMaster extends BaseCssdMaterialMaster {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CssdMaterialMaster() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CssdMaterialMaster(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CssdMaterialMaster(java.lang.Integer id,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String materialCode, java.lang.String materialName,
			java.lang.String lastChgTime) {

		super(id, department, materialCode, materialName, lastChgTime);
	}

	/* [CONSTRUCTOR MARKER END] */

}