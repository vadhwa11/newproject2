package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_employee_personel_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_employee_personel_details"
 */

public abstract class BaseHrEmployeePersonelDetails  implements Serializable {

	public static String REF = "HrEmployeePersonelDetails";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_PASSPORT_ISSUE_PLACE = "PassportIssuePlace";
	public static String PROP_PASSPORT_ISSUE_DATE = "PassportIssueDate";
	public static String PROP_VEHICLE_TYPE = "VehicleType";
	public static String PROP_REGISTRATION_NO = "RegistrationNo";
	public static String PROP_MAKE = "Make";
	public static String PROP_PAN_NO = "PanNo";
	public static String PROP_GENDER = "Gender";
	public static String PROP_PASSPORT_EXPIRY_DATE = "PassportExpiryDate";
	public static String PROP_MARITAL_STATUS = "MaritalStatus";
	public static String PROP_VISA_DETAILS = "VisaDetails";
	public static String PROP_MAS_EMPLOYEE = "MasEmployee";
	public static String PROP_PASSPORT_NO = "PassportNo";
	public static String PROP_MARRIAGE_DATE = "MarriageDate";
	public static String PROP_DRIVING_LICENCE = "DrivingLicence";
	public static String PROP_MODEL = "Model";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHrEmployeePersonelDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeePersonelDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateOfBirth;
	private java.lang.String passportNo;
	private java.util.Date passportIssueDate;
	private java.util.Date passportExpiryDate;
	private java.lang.String passportIssuePlace;
	private java.lang.String visaDetails;
	private java.lang.String panNo;
	private java.lang.String drivingLicence;
	private java.util.Date marriageDate;
	private java.lang.String registrationNo;
	private java.lang.String vehicleType;
	private java.lang.String make;
	private java.lang.String model;

	// one to one
	private jkt.hms.masters.business.MasEmployee masEmployee;

	// many to one
	private jkt.hms.masters.business.MasMaritalStatus maritalStatus;
	private jkt.hms.masters.business.MasAdministrativeSex gender;



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
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth () {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * @param dateOfBirth the date_of_birth value
	 */
	public void setDateOfBirth (java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	/**
	 * Return the value associated with the column: passport_no
	 */
	public java.lang.String getPassportNo () {
		return passportNo;
	}

	/**
	 * Set the value related to the column: passport_no
	 * @param passportNo the passport_no value
	 */
	public void setPassportNo (java.lang.String passportNo) {
		this.passportNo = passportNo;
	}



	/**
	 * Return the value associated with the column: passport_issue_date
	 */
	public java.util.Date getPassportIssueDate () {
		return passportIssueDate;
	}

	/**
	 * Set the value related to the column: passport_issue_date
	 * @param passportIssueDate the passport_issue_date value
	 */
	public void setPassportIssueDate (java.util.Date passportIssueDate) {
		this.passportIssueDate = passportIssueDate;
	}



	/**
	 * Return the value associated with the column: passport_expiry_date
	 */
	public java.util.Date getPassportExpiryDate () {
		return passportExpiryDate;
	}

	/**
	 * Set the value related to the column: passport_expiry_date
	 * @param passportExpiryDate the passport_expiry_date value
	 */
	public void setPassportExpiryDate (java.util.Date passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}



	/**
	 * Return the value associated with the column: passport_issue_place
	 */
	public java.lang.String getPassportIssuePlace () {
		return passportIssuePlace;
	}

	/**
	 * Set the value related to the column: passport_issue_place
	 * @param passportIssuePlace the passport_issue_place value
	 */
	public void setPassportIssuePlace (java.lang.String passportIssuePlace) {
		this.passportIssuePlace = passportIssuePlace;
	}



	/**
	 * Return the value associated with the column: visa_details
	 */
	public java.lang.String getVisaDetails () {
		return visaDetails;
	}

	/**
	 * Set the value related to the column: visa_details
	 * @param visaDetails the visa_details value
	 */
	public void setVisaDetails (java.lang.String visaDetails) {
		this.visaDetails = visaDetails;
	}



	/**
	 * Return the value associated with the column: pan_no
	 */
	public java.lang.String getPanNo () {
		return panNo;
	}

	/**
	 * Set the value related to the column: pan_no
	 * @param panNo the pan_no value
	 */
	public void setPanNo (java.lang.String panNo) {
		this.panNo = panNo;
	}



	/**
	 * Return the value associated with the column: driving_licence
	 */
	public java.lang.String getDrivingLicence () {
		return drivingLicence;
	}

	/**
	 * Set the value related to the column: driving_licence
	 * @param drivingLicence the driving_licence value
	 */
	public void setDrivingLicence (java.lang.String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}



	/**
	 * Return the value associated with the column: marriage_date
	 */
	public java.util.Date getMarriageDate () {
		return marriageDate;
	}

	/**
	 * Set the value related to the column: marriage_date
	 * @param marriageDate the marriage_date value
	 */
	public void setMarriageDate (java.util.Date marriageDate) {
		this.marriageDate = marriageDate;
	}



	/**
	 * Return the value associated with the column: registration_no
	 */
	public java.lang.String getRegistrationNo () {
		return registrationNo;
	}

	/**
	 * Set the value related to the column: registration_no
	 * @param registrationNo the registration_no value
	 */
	public void setRegistrationNo (java.lang.String registrationNo) {
		this.registrationNo = registrationNo;
	}



	/**
	 * Return the value associated with the column: vehicle_type
	 */
	public java.lang.String getVehicleType () {
		return vehicleType;
	}

	/**
	 * Set the value related to the column: vehicle_type
	 * @param vehicleType the vehicle_type value
	 */
	public void setVehicleType (java.lang.String vehicleType) {
		this.vehicleType = vehicleType;
	}



	/**
	 * Return the value associated with the column: make
	 */
	public java.lang.String getMake () {
		return make;
	}

	/**
	 * Set the value related to the column: make
	 * @param make the make value
	 */
	public void setMake (java.lang.String make) {
		this.make = make;
	}



	/**
	 * Return the value associated with the column: model
	 */
	public java.lang.String getModel () {
		return model;
	}

	/**
	 * Set the value related to the column: model
	 * @param model the model value
	 */
	public void setModel (java.lang.String model) {
		this.model = model;
	}



	/**
	 * Return the value associated with the column: MasEmployee
	 */
	public jkt.hms.masters.business.MasEmployee getMasEmployee () {
		return masEmployee;
	}

	/**
	 * Set the value related to the column: MasEmployee
	 * @param masEmployee the MasEmployee value
	 */
	public void setMasEmployee (jkt.hms.masters.business.MasEmployee masEmployee) {
		this.masEmployee = masEmployee;
	}



	/**
	 * Return the value associated with the column: marital_status_id
	 */
	public jkt.hms.masters.business.MasMaritalStatus getMaritalStatus () {
		return maritalStatus;
	}

	/**
	 * Set the value related to the column: marital_status_id
	 * @param maritalStatus the marital_status_id value
	 */
	public void setMaritalStatus (jkt.hms.masters.business.MasMaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}



	/**
	 * Return the value associated with the column: gender_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender_id
	 * @param gender the gender_id value
	 */
	public void setGender (jkt.hms.masters.business.MasAdministrativeSex gender) {
		this.gender = gender;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeePersonelDetails)) return false;
		else {
			jkt.hms.masters.business.HrEmployeePersonelDetails hrEmployeePersonelDetails = (jkt.hms.masters.business.HrEmployeePersonelDetails) obj;
			if (null == this.getId() || null == hrEmployeePersonelDetails.getId()) return false;
			else return (this.getId().equals(hrEmployeePersonelDetails.getId()));
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