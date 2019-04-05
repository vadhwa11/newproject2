package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the complaint_register table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="complaint_register"
 */

public abstract class BaseComplaintRegister implements Serializable {

	public static String REF = "ComplaintRegister";
	public static String PROP_OLD_COMPLAINT_DATE = "OldComplaintDate";
	public static String PROP_COMPLAINT = "Complaint";
	public static String PROP_OLD_COMPLAINT_NO = "OldComplaintNo";
	public static String PROP_ID = "Id";

	// constructors
	public BaseComplaintRegister() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseComplaintRegister(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String oldComplaintNo;
	private java.util.Date oldComplaintDate;

	// many to one
	private jkt.hms.masters.business.MasComplaintRegister complaint;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="complaint_reg_id"
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
	 * Return the value associated with the column: old_complaint_no
	 */
	public java.lang.String getOldComplaintNo() {
		return oldComplaintNo;
	}

	/**
	 * Set the value related to the column: old_complaint_no
	 * 
	 * @param oldComplaintNo
	 *            the old_complaint_no value
	 */
	public void setOldComplaintNo(java.lang.String oldComplaintNo) {
		this.oldComplaintNo = oldComplaintNo;
	}

	/**
	 * Return the value associated with the column: old_complaint_date
	 */
	public java.util.Date getOldComplaintDate() {
		return oldComplaintDate;
	}

	/**
	 * Set the value related to the column: old_complaint_date
	 * 
	 * @param oldComplaintDate
	 *            the old_complaint_date value
	 */
	public void setOldComplaintDate(java.util.Date oldComplaintDate) {
		this.oldComplaintDate = oldComplaintDate;
	}

	/**
	 * Return the value associated with the column: complaint_id
	 */
	public jkt.hms.masters.business.MasComplaintRegister getComplaint() {
		return complaint;
	}

	/**
	 * Set the value related to the column: complaint_id
	 * 
	 * @param complaint
	 *            the complaint_id value
	 */
	public void setComplaint(
			jkt.hms.masters.business.MasComplaintRegister complaint) {
		this.complaint = complaint;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.ComplaintRegister))
			return false;
		else {
			jkt.hms.masters.business.ComplaintRegister complaintRegister = (jkt.hms.masters.business.ComplaintRegister) obj;
			if (null == this.getId() || null == complaintRegister.getId())
				return false;
			else
				return (this.getId().equals(complaintRegister.getId()));
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