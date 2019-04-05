package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * ot_procedure_notes_entry_detail table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="ot_procedure_notes_entry_detail"
 */

public abstract class BaseOtProcedureNotesEntryDetail implements Serializable {

	public static String REF = "OtProcedureNotesEntryDetail";
	public static String PROP_ID = "Id";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_OT_PROCEDURE_HEADER = "OtProcedureHeader";

	// constructors
	public BaseOtProcedureNotesEntryDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtProcedureNotesEntryDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.OtProcedureNotesEntryHeader otProcedureHeader;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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

	/**
	 * Return the value associated with the column: ot_procedure_header_id
	 */
	public jkt.hms.masters.business.OtProcedureNotesEntryHeader getOtProcedureHeader() {
		return otProcedureHeader;
	}

	/**
	 * Set the value related to the column: ot_procedure_header_id
	 * 
	 * @param otProcedureHeader
	 *            the ot_procedure_header_id value
	 */
	public void setOtProcedureHeader(
			jkt.hms.masters.business.OtProcedureNotesEntryHeader otProcedureHeader) {
		this.otProcedureHeader = otProcedureHeader;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OtProcedureNotesEntryDetail))
			return false;
		else {
			jkt.hms.masters.business.OtProcedureNotesEntryDetail otProcedureNotesEntryDetail = (jkt.hms.masters.business.OtProcedureNotesEntryDetail) obj;
			if (null == this.getId()
					|| null == otProcedureNotesEntryDetail.getId())
				return false;
			else
				return (this.getId()
						.equals(otProcedureNotesEntryDetail.getId()));
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