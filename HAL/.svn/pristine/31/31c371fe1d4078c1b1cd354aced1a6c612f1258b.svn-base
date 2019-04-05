package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the pdc_details table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="pdc_details"
 */

public abstract class BasePdcDetails implements Serializable {

	public static String REF = "PdcDetails";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_PDC_REMARKS = "PdcRemarks";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_COMPLAINT_REG = "ComplaintReg";
	public static String PROP_COMMANDENT_REMARKS = "CommandentRemarks";
	public static String PROP_PDC_TIME = "PdcTime";
	public static String PROP_ID = "Id";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";
	public static String PROP_PDC_DATE = "PdcDate";

	// constructors
	public BasePdcDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePdcDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date pdcDate;
	private java.lang.String pdcTime;
	private java.lang.String pdcRemarks;
	private java.lang.String lstChangedBy;
	private java.util.Date lstChangedDate;
	private java.lang.String lstChangedTime;
	private java.lang.String status;
	private java.lang.String commandentRemarks;

	// many to one
	private jkt.hms.masters.business.MasComplaintRegister complaintReg;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="pdc_id"
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
	 * Return the value associated with the column: pdc_date
	 */
	public java.util.Date getPdcDate() {
		return pdcDate;
	}

	/**
	 * Set the value related to the column: pdc_date
	 * 
	 * @param pdcDate
	 *            the pdc_date value
	 */
	public void setPdcDate(java.util.Date pdcDate) {
		this.pdcDate = pdcDate;
	}

	/**
	 * Return the value associated with the column: pdc_time
	 */
	public java.lang.String getPdcTime() {
		return pdcTime;
	}

	/**
	 * Set the value related to the column: pdc_time
	 * 
	 * @param pdcTime
	 *            the pdc_time value
	 */
	public void setPdcTime(java.lang.String pdcTime) {
		this.pdcTime = pdcTime;
	}

	/**
	 * Return the value associated with the column: pdc_remarks
	 */
	public java.lang.String getPdcRemarks() {
		return pdcRemarks;
	}

	/**
	 * Set the value related to the column: pdc_remarks
	 * 
	 * @param pdcRemarks
	 *            the pdc_remarks value
	 */
	public void setPdcRemarks(java.lang.String pdcRemarks) {
		this.pdcRemarks = pdcRemarks;
	}

	/**
	 * Return the value associated with the column: lst_changed_by
	 */
	public java.lang.String getLstChangedBy() {
		return lstChangedBy;
	}

	/**
	 * Set the value related to the column: lst_changed_by
	 * 
	 * @param lstChangedBy
	 *            the lst_changed_by value
	 */
	public void setLstChangedBy(java.lang.String lstChangedBy) {
		this.lstChangedBy = lstChangedBy;
	}

	/**
	 * Return the value associated with the column: lst_changed_date
	 */
	public java.util.Date getLstChangedDate() {
		return lstChangedDate;
	}

	/**
	 * Set the value related to the column: lst_changed_date
	 * 
	 * @param lstChangedDate
	 *            the lst_changed_date value
	 */
	public void setLstChangedDate(java.util.Date lstChangedDate) {
		this.lstChangedDate = lstChangedDate;
	}

	/**
	 * Return the value associated with the column: lst_changed_time
	 */
	public java.lang.String getLstChangedTime() {
		return lstChangedTime;
	}

	/**
	 * Set the value related to the column: lst_changed_time
	 * 
	 * @param lstChangedTime
	 *            the lst_changed_time value
	 */
	public void setLstChangedTime(java.lang.String lstChangedTime) {
		this.lstChangedTime = lstChangedTime;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: commandent_remarks
	 */
	public java.lang.String getCommandentRemarks() {
		return commandentRemarks;
	}

	/**
	 * Set the value related to the column: commandent_remarks
	 * 
	 * @param commandentRemarks
	 *            the commandent_remarks value
	 */
	public void setCommandentRemarks(java.lang.String commandentRemarks) {
		this.commandentRemarks = commandentRemarks;
	}

	/**
	 * Return the value associated with the column: complaint_reg_id
	 */
	public jkt.hms.masters.business.MasComplaintRegister getComplaintReg() {
		return complaintReg;
	}

	/**
	 * Set the value related to the column: complaint_reg_id
	 * 
	 * @param complaintReg
	 *            the complaint_reg_id value
	 */
	public void setComplaintReg(
			jkt.hms.masters.business.MasComplaintRegister complaintReg) {
		this.complaintReg = complaintReg;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PdcDetails))
			return false;
		else {
			jkt.hms.masters.business.PdcDetails pdcDetails = (jkt.hms.masters.business.PdcDetails) obj;
			if (null == this.getId() || null == pdcDetails.getId())
				return false;
			else
				return (this.getId().equals(pdcDetails.getId()));
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