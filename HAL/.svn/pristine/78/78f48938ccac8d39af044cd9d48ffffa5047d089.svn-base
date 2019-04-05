package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the doctor_master table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="doctor_master"
 */

public abstract class BaseDoctorMaster implements Serializable {

	public static String REF = "DoctorMaster";
	public static String PROP_EMPLOYEE_SEQUENCE_ID = "EmployeeSequenceId";
	public static String PROP_VISIT_CHARGES = "VisitCharges";
	public static String PROP_REVISIT_CHARGES = "RevisitCharges";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDoctorMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDoctorMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer employeeSequenceId;
	private java.lang.Float visitCharges;
	private java.lang.Float revisitCharges;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="doctor_id"
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
	 * Return the value associated with the column: employee_sequence_id
	 */
	public java.lang.Integer getEmployeeSequenceId() {
		return employeeSequenceId;
	}

	/**
	 * Set the value related to the column: employee_sequence_id
	 * 
	 * @param employeeSequenceId
	 *            the employee_sequence_id value
	 */
	public void setEmployeeSequenceId(java.lang.Integer employeeSequenceId) {
		this.employeeSequenceId = employeeSequenceId;
	}

	/**
	 * Return the value associated with the column: visit_charges
	 */
	public java.lang.Float getVisitCharges() {
		return visitCharges;
	}

	/**
	 * Set the value related to the column: visit_charges
	 * 
	 * @param visitCharges
	 *            the visit_charges value
	 */
	public void setVisitCharges(java.lang.Float visitCharges) {
		this.visitCharges = visitCharges;
	}

	/**
	 * Return the value associated with the column: revisit_charges
	 */
	public java.lang.Float getRevisitCharges() {
		return revisitCharges;
	}

	/**
	 * Set the value related to the column: revisit_charges
	 * 
	 * @param revisitCharges
	 *            the revisit_charges value
	 */
	public void setRevisitCharges(java.lang.Float revisitCharges) {
		this.revisitCharges = revisitCharges;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DoctorMaster))
			return false;
		else {
			jkt.hms.masters.business.DoctorMaster doctorMaster = (jkt.hms.masters.business.DoctorMaster) obj;
			if (null == this.getId() || null == doctorMaster.getId())
				return false;
			else
				return (this.getId().equals(doctorMaster.getId()));
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