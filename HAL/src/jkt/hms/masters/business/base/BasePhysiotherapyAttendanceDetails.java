package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * physiotherapy_attendance_details table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="physiotherapy_attendance_details"
 */

public abstract class BasePhysiotherapyAttendanceDetails implements
		Serializable {

	public static String REF = "PhysiotherapyAttendanceDetails";
	public static String PROP_PHYSIOTHERAPY_VISIT = "PhysiotherapyVisit";
	public static String PROP_ATTENDANCE_DATE = "AttendanceDate";
	public static String PROP_ID = "Id";
	public static String PROP_ATTENDANCE_STATUS = "AttendanceStatus";

	// constructors
	public BasePhysiotherapyAttendanceDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysiotherapyAttendanceDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String attendanceStatus;
	private java.util.Date attendanceDate;

	// many to one
	private jkt.hms.masters.business.PhysiotherapyVisitDetails physiotherapyVisit;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment"
	 *               column="physiotherapy_attendance_id"
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
	 * Return the value associated with the column: attendance_status
	 */
	public java.lang.String getAttendanceStatus() {
		return attendanceStatus;
	}

	/**
	 * Set the value related to the column: attendance_status
	 * 
	 * @param attendanceStatus
	 *            the attendance_status value
	 */
	public void setAttendanceStatus(java.lang.String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	/**
	 * Return the value associated with the column: attendance_date
	 */
	public java.util.Date getAttendanceDate() {
		return attendanceDate;
	}

	/**
	 * Set the value related to the column: attendance_date
	 * 
	 * @param attendanceDate
	 *            the attendance_date value
	 */
	public void setAttendanceDate(java.util.Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	/**
	 * Return the value associated with the column: physiotherapy_visit_id
	 */
	public jkt.hms.masters.business.PhysiotherapyVisitDetails getPhysiotherapyVisit() {
		return physiotherapyVisit;
	}

	/**
	 * Set the value related to the column: physiotherapy_visit_id
	 * 
	 * @param physiotherapyVisit
	 *            the physiotherapy_visit_id value
	 */
	public void setPhysiotherapyVisit(
			jkt.hms.masters.business.PhysiotherapyVisitDetails physiotherapyVisit) {
		this.physiotherapyVisit = physiotherapyVisit;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PhysiotherapyAttendanceDetails))
			return false;
		else {
			jkt.hms.masters.business.PhysiotherapyAttendanceDetails physiotherapyAttendanceDetails = (jkt.hms.masters.business.PhysiotherapyAttendanceDetails) obj;
			if (null == this.getId()
					|| null == physiotherapyAttendanceDetails.getId())
				return false;
			else
				return (this.getId().equals(physiotherapyAttendanceDetails
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