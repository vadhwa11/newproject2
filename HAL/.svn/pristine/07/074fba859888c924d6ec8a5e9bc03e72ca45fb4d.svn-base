package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_referral_doctor table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_referral_doctor"
 */

public abstract class BaseMasReferralDoctor  implements Serializable {

	public static String REF = "MasReferralDoctor";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DOCTOR_NAME = "DoctorName";
	public static String PROP_REFERRAL_TYPE = "ReferralType";
	public static String PROP_PHONE_NO = "PhoneNo";
	public static String PROP_MOBILE_NO = "MobileNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ADDRESS2 = "Address2";
	public static String PROP_ADDRESS1 = "Address1";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseMasReferralDoctor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasReferralDoctor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasReferralDoctor (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDepartment department) {

		this.setId(id);
		this.setDepartment(department);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String doctorName;
	private java.lang.String address1;
	private java.lang.String address2;
	private java.lang.String phoneNo;
	private java.lang.String mobileNo;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer referralType;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="referral_doctor_id"
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
	 * Return the value associated with the column: doctor_name
	 */
	public java.lang.String getDoctorName () {
		return doctorName;
	}

	/**
	 * Set the value related to the column: doctor_name
	 * @param doctorName the doctor_name value
	 */
	public void setDoctorName (java.lang.String doctorName) {
		this.doctorName = doctorName;
	}



	/**
	 * Return the value associated with the column: address1
	 */
	public java.lang.String getAddress1 () {
		return address1;
	}

	/**
	 * Set the value related to the column: address1
	 * @param address1 the address1 value
	 */
	public void setAddress1 (java.lang.String address1) {
		this.address1 = address1;
	}



	/**
	 * Return the value associated with the column: address2
	 */
	public java.lang.String getAddress2 () {
		return address2;
	}

	/**
	 * Set the value related to the column: address2
	 * @param address2 the address2 value
	 */
	public void setAddress2 (java.lang.String address2) {
		this.address2 = address2;
	}



	/**
	 * Return the value associated with the column: phone_no
	 */
	public java.lang.String getPhoneNo () {
		return phoneNo;
	}

	/**
	 * Set the value related to the column: phone_no
	 * @param phoneNo the phone_no value
	 */
	public void setPhoneNo (java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}



	/**
	 * Return the value associated with the column: mobile_no
	 */
	public java.lang.String getMobileNo () {
		return mobileNo;
	}

	/**
	 * Set the value related to the column: mobile_no
	 * @param mobileNo the mobile_no value
	 */
	public void setMobileNo (java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: referral_type
	 */
	public java.lang.Integer getReferralType () {
		return referralType;
	}

	/**
	 * Set the value related to the column: referral_type
	 * @param referralType the referral_type value
	 */
	public void setReferralType (java.lang.Integer referralType) {
		this.referralType = referralType;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasReferralDoctor)) return false;
		else {
			jkt.hms.masters.business.MasReferralDoctor masReferralDoctor = (jkt.hms.masters.business.MasReferralDoctor) obj;
			if (null == this.getId() || null == masReferralDoctor.getId()) return false;
			else return (this.getId().equals(masReferralDoctor.getId()));
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