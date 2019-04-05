package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the patient_address table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="patient_address"
 */

public abstract class BasePatientAddress implements Serializable {

	public static String REF = "PatientAddress";
	public static String PROP_BLOCK = "Block";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_STATE_ID = "StateId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_DISTRICT = "District";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_HIN_ID = "HinId";
	public static String PROP_CITY = "City";
	public static String PROP_POST_OFFICE = "PostOffice";
	public static String PROP_NATIONALITY_ID = "NationalityId";
	public static String PROP_POLICE_STATION = "PoliceStation";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_ID = "Id";

	// constructors
	public BasePatientAddress() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientAddress(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer hinId;
	private java.lang.Integer hospitalId;
	private java.lang.String address;
	private java.lang.String village;
	private java.lang.String block;
	private java.lang.String district;
	private java.lang.Integer stateId;
	private java.lang.Integer nationalityId;
	private java.lang.String city;
	private java.lang.String policeStation;
	private java.lang.String postOffice;
	private java.lang.String pinCode;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="patient_address_id"
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
	 * Return the value associated with the column: hin_id
	 */
	public java.lang.Integer getHinId() {
		return hinId;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hinId
	 *            the hin_id value
	 */
	public void setHinId(java.lang.Integer hinId) {
		this.hinId = hinId;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospitalId
	 *            the hospital_id value
	 */
	public void setHospitalId(java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * 
	 * @param address
	 *            the address value
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * Return the value associated with the column: village
	 */
	public java.lang.String getVillage() {
		return village;
	}

	/**
	 * Set the value related to the column: village
	 * 
	 * @param village
	 *            the village value
	 */
	public void setVillage(java.lang.String village) {
		this.village = village;
	}

	/**
	 * Return the value associated with the column: block
	 */
	public java.lang.String getBlock() {
		return block;
	}

	/**
	 * Set the value related to the column: block
	 * 
	 * @param block
	 *            the block value
	 */
	public void setBlock(java.lang.String block) {
		this.block = block;
	}

	/**
	 * Return the value associated with the column: district
	 */
	public java.lang.String getDistrict() {
		return district;
	}

	/**
	 * Set the value related to the column: district
	 * 
	 * @param district
	 *            the district value
	 */
	public void setDistrict(java.lang.String district) {
		this.district = district;
	}

	/**
	 * Return the value associated with the column: state_id
	 */
	public java.lang.Integer getStateId() {
		return stateId;
	}

	/**
	 * Set the value related to the column: state_id
	 * 
	 * @param stateId
	 *            the state_id value
	 */
	public void setStateId(java.lang.Integer stateId) {
		this.stateId = stateId;
	}

	/**
	 * Return the value associated with the column: nationality_id
	 */
	public java.lang.Integer getNationalityId() {
		return nationalityId;
	}

	/**
	 * Set the value related to the column: nationality_id
	 * 
	 * @param nationalityId
	 *            the nationality_id value
	 */
	public void setNationalityId(java.lang.Integer nationalityId) {
		this.nationalityId = nationalityId;
	}

	/**
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity() {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * 
	 * @param city
	 *            the city value
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * Return the value associated with the column: police_station
	 */
	public java.lang.String getPoliceStation() {
		return policeStation;
	}

	/**
	 * Set the value related to the column: police_station
	 * 
	 * @param policeStation
	 *            the police_station value
	 */
	public void setPoliceStation(java.lang.String policeStation) {
		this.policeStation = policeStation;
	}

	/**
	 * Return the value associated with the column: post_office
	 */
	public java.lang.String getPostOffice() {
		return postOffice;
	}

	/**
	 * Set the value related to the column: post_office
	 * 
	 * @param postOffice
	 *            the post_office value
	 */
	public void setPostOffice(java.lang.String postOffice) {
		this.postOffice = postOffice;
	}

	/**
	 * Return the value associated with the column: pin_code
	 */
	public java.lang.String getPinCode() {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code
	 * 
	 * @param pinCode
	 *            the pin_code value
	 */
	public void setPinCode(java.lang.String pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public java.lang.Integer getAddEditById() {
		return addEditById;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * 
	 * @param addEditById
	 *            the add_edit_by_id value
	 */
	public void setAddEditById(java.lang.Integer addEditById) {
		this.addEditById = addEditById;
	}

	/**
	 * Return the value associated with the column: add_edit_date_time
	 */
	public java.util.Date getAddEditDateTime() {
		return addEditDateTime;
	}

	/**
	 * Set the value related to the column: add_edit_date_time
	 * 
	 * @param addEditDateTime
	 *            the add_edit_date_time value
	 */
	public void setAddEditDateTime(java.util.Date addEditDateTime) {
		this.addEditDateTime = addEditDateTime;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientAddress))
			return false;
		else {
			jkt.hms.masters.business.PatientAddress patientAddress = (jkt.hms.masters.business.PatientAddress) obj;
			if (null == this.getId() || null == patientAddress.getId())
				return false;
			else
				return (this.getId().equals(patientAddress.getId()));
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