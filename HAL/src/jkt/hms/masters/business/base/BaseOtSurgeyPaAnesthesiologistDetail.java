package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * ot_surgey_pa_anesthesiologist_detail table. Do not modify this class because
 * it will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="ot_surgey_pa_anesthesiologist_detail"
 */

public abstract class BaseOtSurgeyPaAnesthesiologistDetail implements
		Serializable {

	public static String REF = "OtSurgeyPaAnesthesiologistDetail";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_OT_POST_ANAESTHESIA_PROCEDURE = "OtPostAnaesthesiaProcedure";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOtSurgeyPaAnesthesiologistDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtSurgeyPaAnesthesiologistDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure;
	private jkt.hms.masters.business.MasEmployee employee;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="surgey_pa_anesthesiologist_detail_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column:
	 * ot_post_anaesthesia_procedure_id
	 */
	public jkt.hms.masters.business.OtPostAnaesthesiaProcedure getOtPostAnaesthesiaProcedure() {
		return otPostAnaesthesiaProcedure;
	}

	/**
	 * Set the value related to the column: ot_post_anaesthesia_procedure_id
	 * 
	 * @param otPostAnaesthesiaProcedure
	 *            the ot_post_anaesthesia_procedure_id value
	 */
	public void setOtPostAnaesthesiaProcedure(
			jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure) {
		this.otPostAnaesthesiaProcedure = otPostAnaesthesiaProcedure;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OtSurgeyPaAnesthesiologistDetail))
			return false;
		else {
			jkt.hms.masters.business.OtSurgeyPaAnesthesiologistDetail otSurgeyPaAnesthesiologistDetail = (jkt.hms.masters.business.OtSurgeyPaAnesthesiologistDetail) obj;
			if (null == this.getId()
					|| null == otSurgeyPaAnesthesiologistDetail.getId())
				return false;
			else
				return (this.getId().equals(otSurgeyPaAnesthesiologistDetail
						.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}