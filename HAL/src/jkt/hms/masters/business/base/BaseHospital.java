package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hospital table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="hospital"
 */

public abstract class BaseHospital implements Serializable {

	public static String REF = "Hospital";
	public static String PROP_ALLOW_REFUND = "AllowRefund";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_E_MAIL = "EMail";
	public static String PROP_REGISTRATION_NUMBER = "RegistrationNumber";
	public static String PROP_MARQUEE_TEXT = "MarqueeText";
	public static String PROP_OP_ON_ACCT = "OpOnAcct";
	public static String PROP_BILL_PRINT_TYPE = "BillPrintType";
	public static String PROP_CST_NUMBER = "CstNumber";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_URL = "Url";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_FAX_NUMBER = "FaxNumber";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_GRAMOPHONE_NUMBER = "GramophoneNumber";
	public static String PROP_STD_CODE = "StdCode";
	public static String PROP_MOBILE_NUMBER = "MobileNumber";
	public static String PROP_OP_PAY_TYPE = "OpPayType";
	public static String PROP_REGISTRATION_VALIDITY_POLICY = "RegistrationValidityPolicy";
	public static String PROP_PROV_DIAG_MUST = "ProvDiagMust";
	public static String PROP_CUURRENT_UNIT = "CuurrentUnit";
	public static String PROP_PHONE_NUMBER = "PhoneNumber";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_IP_PAY_TYPE = "IpPayType";
	public static String PROP_CITY = "City";
	public static String PROP_REG_POLICY_PERIOD = "RegPolicyPeriod";
	public static String PROP_HOSPITAL_NAME = "HospitalName";
	public static String PROP_STATE = "State";
	public static String PROP_REGISTRATION_DATE = "RegistrationDate";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_LST_NUMBER = "LstNumber";
	public static String PROP_ID = "Id";
	public static String PROP_INCLUDE_ST = "IncludeSt";
	public static String PROP_ALLOW_REG_FEE = "AllowRegFee";

	// constructors
	public BaseHospital() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHospital(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String hospitalName;
	private java.lang.String eMail;
	private java.lang.String url;
	private java.lang.String cuurrentUnit;
	private java.lang.String cstNumber;
	private java.lang.String lstNumber;
	private java.lang.String registrationNumber;
	private java.util.Date registrationDate;
	private java.lang.String address;
	private java.lang.String city;
	private java.lang.String state;
	private java.lang.String country;
	private java.lang.String pinCode;
	private java.lang.String stdCode;
	private java.lang.String phoneNumber;
	private java.lang.String faxNumber;
	private java.lang.String mobileNumber;
	private java.lang.String gramophoneNumber;
	private java.lang.Integer opOnAcct;
	private java.lang.Integer ipPayType;
	private java.lang.Integer opPayType;
	private java.lang.Integer includeSt;
	private java.lang.Integer provDiagMust;
	private java.lang.Integer billPrintType;
	private java.lang.Integer allowRegFee;
	private java.lang.Integer allowRefund;
	private java.lang.String marqueeText;
	private java.lang.String lastChangedBy;
	private java.util.Date lastChangedDate;
	private java.util.Date lastChangedTime;
	private java.lang.Integer registrationValidityPolicy;
	private java.lang.Integer regPolicyPeriod;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="hospital_id"
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
	 * Return the value associated with the column: hospital_name
	 */
	public java.lang.String getHospitalName() {
		return hospitalName;
	}

	/**
	 * Set the value related to the column: hospital_name
	 * 
	 * @param hospitalName
	 *            the hospital_name value
	 */
	public void setHospitalName(java.lang.String hospitalName) {
		this.hospitalName = hospitalName;
	}

	/**
	 * Return the value associated with the column: e_mail
	 */
	public java.lang.String getEMail() {
		return eMail;
	}

	/**
	 * Set the value related to the column: e_mail
	 * 
	 * @param eMail
	 *            the e_mail value
	 */
	public void setEMail(java.lang.String eMail) {
		this.eMail = eMail;
	}

	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl() {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * 
	 * @param url
	 *            the url value
	 */
	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	/**
	 * Return the value associated with the column: cuurrent_unit
	 */
	public java.lang.String getCuurrentUnit() {
		return cuurrentUnit;
	}

	/**
	 * Set the value related to the column: cuurrent_unit
	 * 
	 * @param cuurrentUnit
	 *            the cuurrent_unit value
	 */
	public void setCuurrentUnit(java.lang.String cuurrentUnit) {
		this.cuurrentUnit = cuurrentUnit;
	}

	/**
	 * Return the value associated with the column: cst_number
	 */
	public java.lang.String getCstNumber() {
		return cstNumber;
	}

	/**
	 * Set the value related to the column: cst_number
	 * 
	 * @param cstNumber
	 *            the cst_number value
	 */
	public void setCstNumber(java.lang.String cstNumber) {
		this.cstNumber = cstNumber;
	}

	/**
	 * Return the value associated with the column: lst_number
	 */
	public java.lang.String getLstNumber() {
		return lstNumber;
	}

	/**
	 * Set the value related to the column: lst_number
	 * 
	 * @param lstNumber
	 *            the lst_number value
	 */
	public void setLstNumber(java.lang.String lstNumber) {
		this.lstNumber = lstNumber;
	}

	/**
	 * Return the value associated with the column: registration_number
	 */
	public java.lang.String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * Set the value related to the column: registration_number
	 * 
	 * @param registrationNumber
	 *            the registration_number value
	 */
	public void setRegistrationNumber(java.lang.String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * Return the value associated with the column: registration_date
	 */
	public java.util.Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Set the value related to the column: registration_date
	 * 
	 * @param registrationDate
	 *            the registration_date value
	 */
	public void setRegistrationDate(java.util.Date registrationDate) {
		this.registrationDate = registrationDate;
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
	 * Return the value associated with the column: state
	 */
	public java.lang.String getState() {
		return state;
	}

	/**
	 * Set the value related to the column: state
	 * 
	 * @param state
	 *            the state value
	 */
	public void setState(java.lang.String state) {
		this.state = state;
	}

	/**
	 * Return the value associated with the column: country
	 */
	public java.lang.String getCountry() {
		return country;
	}

	/**
	 * Set the value related to the column: country
	 * 
	 * @param country
	 *            the country value
	 */
	public void setCountry(java.lang.String country) {
		this.country = country;
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
	 * Return the value associated with the column: std_code
	 */
	public java.lang.String getStdCode() {
		return stdCode;
	}

	/**
	 * Set the value related to the column: std_code
	 * 
	 * @param stdCode
	 *            the std_code value
	 */
	public void setStdCode(java.lang.String stdCode) {
		this.stdCode = stdCode;
	}

	/**
	 * Return the value associated with the column: phone_number
	 */
	public java.lang.String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set the value related to the column: phone_number
	 * 
	 * @param phoneNumber
	 *            the phone_number value
	 */
	public void setPhoneNumber(java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Return the value associated with the column: fax_number
	 */
	public java.lang.String getFaxNumber() {
		return faxNumber;
	}

	/**
	 * Set the value related to the column: fax_number
	 * 
	 * @param faxNumber
	 *            the fax_number value
	 */
	public void setFaxNumber(java.lang.String faxNumber) {
		this.faxNumber = faxNumber;
	}

	/**
	 * Return the value associated with the column: mobile_number
	 */
	public java.lang.String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Set the value related to the column: mobile_number
	 * 
	 * @param mobileNumber
	 *            the mobile_number value
	 */
	public void setMobileNumber(java.lang.String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Return the value associated with the column: gramophone_number
	 */
	public java.lang.String getGramophoneNumber() {
		return gramophoneNumber;
	}

	/**
	 * Set the value related to the column: gramophone_number
	 * 
	 * @param gramophoneNumber
	 *            the gramophone_number value
	 */
	public void setGramophoneNumber(java.lang.String gramophoneNumber) {
		this.gramophoneNumber = gramophoneNumber;
	}

	/**
	 * Return the value associated with the column: op_on_acct
	 */
	public java.lang.Integer getOpOnAcct() {
		return opOnAcct;
	}

	/**
	 * Set the value related to the column: op_on_acct
	 * 
	 * @param opOnAcct
	 *            the op_on_acct value
	 */
	public void setOpOnAcct(java.lang.Integer opOnAcct) {
		this.opOnAcct = opOnAcct;
	}

	/**
	 * Return the value associated with the column: ip_pay_type
	 */
	public java.lang.Integer getIpPayType() {
		return ipPayType;
	}

	/**
	 * Set the value related to the column: ip_pay_type
	 * 
	 * @param ipPayType
	 *            the ip_pay_type value
	 */
	public void setIpPayType(java.lang.Integer ipPayType) {
		this.ipPayType = ipPayType;
	}

	/**
	 * Return the value associated with the column: op_pay_type
	 */
	public java.lang.Integer getOpPayType() {
		return opPayType;
	}

	/**
	 * Set the value related to the column: op_pay_type
	 * 
	 * @param opPayType
	 *            the op_pay_type value
	 */
	public void setOpPayType(java.lang.Integer opPayType) {
		this.opPayType = opPayType;
	}

	/**
	 * Return the value associated with the column: include_st
	 */
	public java.lang.Integer getIncludeSt() {
		return includeSt;
	}

	/**
	 * Set the value related to the column: include_st
	 * 
	 * @param includeSt
	 *            the include_st value
	 */
	public void setIncludeSt(java.lang.Integer includeSt) {
		this.includeSt = includeSt;
	}

	/**
	 * Return the value associated with the column: prov_diag_must
	 */
	public java.lang.Integer getProvDiagMust() {
		return provDiagMust;
	}

	/**
	 * Set the value related to the column: prov_diag_must
	 * 
	 * @param provDiagMust
	 *            the prov_diag_must value
	 */
	public void setProvDiagMust(java.lang.Integer provDiagMust) {
		this.provDiagMust = provDiagMust;
	}

	/**
	 * Return the value associated with the column: bill_print_type
	 */
	public java.lang.Integer getBillPrintType() {
		return billPrintType;
	}

	/**
	 * Set the value related to the column: bill_print_type
	 * 
	 * @param billPrintType
	 *            the bill_print_type value
	 */
	public void setBillPrintType(java.lang.Integer billPrintType) {
		this.billPrintType = billPrintType;
	}

	/**
	 * Return the value associated with the column: allow_reg_fee
	 */
	public java.lang.Integer getAllowRegFee() {
		return allowRegFee;
	}

	/**
	 * Set the value related to the column: allow_reg_fee
	 * 
	 * @param allowRegFee
	 *            the allow_reg_fee value
	 */
	public void setAllowRegFee(java.lang.Integer allowRegFee) {
		this.allowRegFee = allowRegFee;
	}

	/**
	 * Return the value associated with the column: allow_refund
	 */
	public java.lang.Integer getAllowRefund() {
		return allowRefund;
	}

	/**
	 * Set the value related to the column: allow_refund
	 * 
	 * @param allowRefund
	 *            the allow_refund value
	 */
	public void setAllowRefund(java.lang.Integer allowRefund) {
		this.allowRefund = allowRefund;
	}

	/**
	 * Return the value associated with the column: marquee_text
	 */
	public java.lang.String getMarqueeText() {
		return marqueeText;
	}

	/**
	 * Set the value related to the column: marquee_text
	 * 
	 * @param marqueeText
	 *            the marquee_text value
	 */
	public void setMarqueeText(java.lang.String marqueeText) {
		this.marqueeText = marqueeText;
	}

	/**
	 * Return the value associated with the column: last_changed_by
	 */
	public java.lang.String getLastChangedBy() {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * 
	 * @param lastChangedBy
	 *            the last_changed_by value
	 */
	public void setLastChangedBy(java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	/**
	 * Return the value associated with the column: last_changed_date
	 */
	public java.util.Date getLastChangedDate() {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_changed_date
	 * 
	 * @param lastChangedDate
	 *            the last_changed_date value
	 */
	public void setLastChangedDate(java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}

	/**
	 * Return the value associated with the column: last_changed_time
	 */
	public java.util.Date getLastChangedTime() {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_changed_time
	 * 
	 * @param lastChangedTime
	 *            the last_changed_time value
	 */
	public void setLastChangedTime(java.util.Date lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
	}

	/**
	 * Return the value associated with the column: registration_validity_policy
	 */
	public java.lang.Integer getRegistrationValidityPolicy() {
		return registrationValidityPolicy;
	}

	/**
	 * Set the value related to the column: registration_validity_policy
	 * 
	 * @param registrationValidityPolicy
	 *            the registration_validity_policy value
	 */
	public void setRegistrationValidityPolicy(
			java.lang.Integer registrationValidityPolicy) {
		this.registrationValidityPolicy = registrationValidityPolicy;
	}

	/**
	 * Return the value associated with the column: reg_policy_period
	 */
	public java.lang.Integer getRegPolicyPeriod() {
		return regPolicyPeriod;
	}

	/**
	 * Set the value related to the column: reg_policy_period
	 * 
	 * @param regPolicyPeriod
	 *            the reg_policy_period value
	 */
	public void setRegPolicyPeriod(java.lang.Integer regPolicyPeriod) {
		this.regPolicyPeriod = regPolicyPeriod;
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
		if (!(obj instanceof jkt.hms.masters.business.Hospital))
			return false;
		else {
			jkt.hms.masters.business.Hospital hospital = (jkt.hms.masters.business.Hospital) obj;
			if (null == this.getId() || null == hospital.getId())
				return false;
			else
				return (this.getId().equals(hospital.getId()));
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