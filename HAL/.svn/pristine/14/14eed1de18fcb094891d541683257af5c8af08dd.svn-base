package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_surgery_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_surgery_detail"
 */

public abstract class BaseOpdSurgeryDetail  implements Serializable {

	public static String REF = "OpdSurgeryDetail";
	public static String PROP_ANESTHEISA_PAC = "AnestheisaPac";
	public static String PROP_STATUS = "Status";
	public static String PROP_OT_BOOKING_DT = "OtBookingDt";
	public static String PROP_OPD_SURGERY = "OpdSurgery";
	public static String PROP_SURGEON = "Surgeon";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_TENTATIVE_DATE = "TentativeDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ANESTHEISA_PAC_STATUS = "AnestheisaPacStatus";
	public static String PROP_SURGERY_STATUS = "SurgeryStatus";


	// constructors
	public BaseOpdSurgeryDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdSurgeryDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date tentativeDate;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String anestheisaPacStatus;
	private java.lang.String surgeryStatus;

	// many to one
	private jkt.hms.masters.business.MasEmployee surgeon;
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.OtPreAnesthesiaDetail anestheisaPac;
	private jkt.hms.masters.business.OpdSurgeryHeader opdSurgery;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.OtBookingDt otBookingDt;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: tentative_date
	 */
	public java.util.Date getTentativeDate () {
		return tentativeDate;
	}

	/**
	 * Set the value related to the column: tentative_date
	 * @param tentativeDate the tentative_date value
	 */
	public void setTentativeDate (java.util.Date tentativeDate) {
		this.tentativeDate = tentativeDate;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: anestheisa_pac_status
	 */
	public java.lang.String getAnestheisaPacStatus () {
		return anestheisaPacStatus;
	}

	/**
	 * Set the value related to the column: anestheisa_pac_status
	 * @param anestheisaPacStatus the anestheisa_pac_status value
	 */
	public void setAnestheisaPacStatus (java.lang.String anestheisaPacStatus) {
		this.anestheisaPacStatus = anestheisaPacStatus;
	}



	/**
	 * Return the value associated with the column: surgery_status
	 */
	public java.lang.String getSurgeryStatus () {
		return surgeryStatus;
	}

	/**
	 * Set the value related to the column: surgery_status
	 * @param surgeryStatus the surgery_status value
	 */
	public void setSurgeryStatus (java.lang.String surgeryStatus) {
		this.surgeryStatus = surgeryStatus;
	}



	/**
	 * Return the value associated with the column: surgeon_id
	 */
	public jkt.hms.masters.business.MasEmployee getSurgeon () {
		return surgeon;
	}

	/**
	 * Set the value related to the column: surgeon_id
	 * @param surgeon the surgeon_id value
	 */
	public void setSurgeon (jkt.hms.masters.business.MasEmployee surgeon) {
		this.surgeon = surgeon;
	}



	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}



	/**
	 * Return the value associated with the column: anestheisa_pac_id
	 */
	public jkt.hms.masters.business.OtPreAnesthesiaDetail getAnestheisaPac () {
		return anestheisaPac;
	}

	/**
	 * Set the value related to the column: anestheisa_pac_id
	 * @param anestheisaPac the anestheisa_pac_id value
	 */
	public void setAnestheisaPac (jkt.hms.masters.business.OtPreAnesthesiaDetail anestheisaPac) {
		this.anestheisaPac = anestheisaPac;
	}



	/**
	 * Return the value associated with the column: opd_surgery_id
	 */
	public jkt.hms.masters.business.OpdSurgeryHeader getOpdSurgery () {
		return opdSurgery;
	}

	/**
	 * Set the value related to the column: opd_surgery_id
	 * @param opdSurgery the opd_surgery_id value
	 */
	public void setOpdSurgery (jkt.hms.masters.business.OpdSurgeryHeader opdSurgery) {
		this.opdSurgery = opdSurgery;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: ot_booking_dt
	 */
	public jkt.hms.masters.business.OtBookingDt getOtBookingDt () {
		return otBookingDt;
	}

	/**
	 * Set the value related to the column: ot_booking_dt
	 * @param otBookingDt the ot_booking_dt value
	 */
	public void setOtBookingDt (jkt.hms.masters.business.OtBookingDt otBookingDt) {
		this.otBookingDt = otBookingDt;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdSurgeryDetail)) return false;
		else {
			jkt.hms.masters.business.OpdSurgeryDetail opdSurgeryDetail = (jkt.hms.masters.business.OpdSurgeryDetail) obj;
			if (null == this.getId() || null == opdSurgeryDetail.getId()) return false;
			else return (this.getId().equals(opdSurgeryDetail.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}