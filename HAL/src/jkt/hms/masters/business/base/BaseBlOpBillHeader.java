package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_op_bill_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_op_bill_header"
 */

public abstract class BaseBlOpBillHeader  implements Serializable {

	public static String REF = "BlOpBillHeader";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ADVANCE_ADJUSTMENT = "AdvanceAdjustment";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_SCHEME_ID = "SchemeId";
	public static String PROP_RELATIVE_NAME = "RelativeName";
	public static String PROP_SEX = "Sex";
	public static String PROP_DISCOUNT_AMT = "DiscountAmt";
	public static String PROP_BILL_AMT = "BillAmt";
	public static String PROP_BILL_NO = "BillNo";
	public static String PROP_DISCOUNT_ON_BILL = "DiscountOnBill";
	public static String PROP_PACKAGE_BILL_ID = "PackageBillId";
	public static String PROP_NET_AMT = "NetAmt";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_AUTHORIZER = "Authorizer";
	public static String PROP_OUTSTANDING = "Outstanding";
	public static String PROP_CONSULTANT_NAME = "ConsultantName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_AGE = "Age";
	public static String PROP_STATUS = "Status";
	public static String PROP_PAYABLE_AMT = "PayableAmt";
	public static String PROP_CHARITY_RCVD = "CharityRcvd";
	public static String PROP_PAY_STATUS = "PayStatus";
	public static String PROP_SCHEME_AUTHORIZER = "SchemeAuthorizer";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_REG_TYPE = "RegType";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_BILL_DATE = "BillDate";
	public static String PROP_VISIT_ID = "VisitId";
	public static String PROP_HIN = "Hin";
	public static String PROP_ACTUAL_COLLECTED_AMT = "ActualCollectedAmt";
	public static String PROP_TOKEN_NO = "TokenNo";
	public static String PROP_BILL_TIME = "BillTime";
	public static String PROP_ROUND_OFF = "RoundOff";
	public static String PROP_CONSULTANT = "Consultant";
	public static String PROP_ID = "Id";
	public static String PROP_CHARITY = "Charity";
	public static String PROP_PATIENT_STATUS = "PatientStatus";


	// constructors
	public BaseBlOpBillHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlOpBillHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBlOpBillHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.Patient hin,
		jkt.hms.masters.business.MasHospital hospital,
		java.util.Date billDate,
		java.lang.String billTime) {

		this.setId(id);
		this.setHin(hin);
		this.setHospital(hospital);
		this.setBillDate(billDate);
		this.setBillTime(billTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal actualCollectedAmt;
	private java.math.BigDecimal advanceAdjustment;
	private java.lang.String age;
	private java.math.BigDecimal billAmt;
	private java.util.Date billDate;
	private java.lang.String billNo;
	private java.lang.String billTime;
	private java.math.BigDecimal charity;
	private java.math.BigDecimal charityRcvd;
	private java.lang.String consultantName;
	private java.math.BigDecimal discount;
	private java.math.BigDecimal discountAmt;
	private java.math.BigDecimal discountOnBill;
	private java.lang.String hinNo;
	private java.math.BigDecimal netAmt;
	private java.math.BigDecimal outstanding;
	private java.lang.Integer packageBillId;
	private java.lang.String patientName;
	private java.lang.String patientStatus;
	private java.lang.String payStatus;
	private java.math.BigDecimal payableAmt;
	private java.lang.String regType;
	private java.lang.String relativeName;
	private java.lang.String remarks;
	private java.math.BigDecimal roundOff;
	private java.lang.Integer schemeId;
	private java.lang.String status;
	private java.lang.Integer tokenNo;
	private java.lang.Integer visitId;

	// many to one
	private jkt.hms.masters.business.MasAuthorizer authorizer;
	private jkt.hms.masters.business.Users changedBy;
	private jkt.hms.masters.business.MasCompany company;
	private jkt.hms.masters.business.MasEmployee consultant;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasPatientType patientType;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasAuthorizer schemeAuthorizer;
	private jkt.hms.masters.business.MasAdministrativeSex sex;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlOpBillDetails> blOpBillDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="op_bill_header_id"
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
	 * Return the value associated with the column: actual_collected_amt
	 */
	public java.math.BigDecimal getActualCollectedAmt () {
		return actualCollectedAmt;
	}

	/**
	 * Set the value related to the column: actual_collected_amt
	 * @param actualCollectedAmt the actual_collected_amt value
	 */
	public void setActualCollectedAmt (java.math.BigDecimal actualCollectedAmt) {
		this.actualCollectedAmt = actualCollectedAmt;
	}



	/**
	 * Return the value associated with the column: advance_adjustment
	 */
	public java.math.BigDecimal getAdvanceAdjustment () {
		return advanceAdjustment;
	}

	/**
	 * Set the value related to the column: advance_adjustment
	 * @param advanceAdjustment the advance_adjustment value
	 */
	public void setAdvanceAdjustment (java.math.BigDecimal advanceAdjustment) {
		this.advanceAdjustment = advanceAdjustment;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: bill_amt
	 */
	public java.math.BigDecimal getBillAmt () {
		return billAmt;
	}

	/**
	 * Set the value related to the column: bill_amt
	 * @param billAmt the bill_amt value
	 */
	public void setBillAmt (java.math.BigDecimal billAmt) {
		this.billAmt = billAmt;
	}



	/**
	 * Return the value associated with the column: bill_date
	 */
	public java.util.Date getBillDate () {
		return billDate;
	}

	/**
	 * Set the value related to the column: bill_date
	 * @param billDate the bill_date value
	 */
	public void setBillDate (java.util.Date billDate) {
		this.billDate = billDate;
	}



	/**
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.String getBillNo () {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * @param billNo the bill_no value
	 */
	public void setBillNo (java.lang.String billNo) {
		this.billNo = billNo;
	}



	/**
	 * Return the value associated with the column: bill_time
	 */
	public java.lang.String getBillTime () {
		return billTime;
	}

	/**
	 * Set the value related to the column: bill_time
	 * @param billTime the bill_time value
	 */
	public void setBillTime (java.lang.String billTime) {
		this.billTime = billTime;
	}



	/**
	 * Return the value associated with the column: charity
	 */
	public java.math.BigDecimal getCharity () {
		return charity;
	}

	/**
	 * Set the value related to the column: charity
	 * @param charity the charity value
	 */
	public void setCharity (java.math.BigDecimal charity) {
		this.charity = charity;
	}



	/**
	 * Return the value associated with the column: charity_rcvd
	 */
	public java.math.BigDecimal getCharityRcvd () {
		return charityRcvd;
	}

	/**
	 * Set the value related to the column: charity_rcvd
	 * @param charityRcvd the charity_rcvd value
	 */
	public void setCharityRcvd (java.math.BigDecimal charityRcvd) {
		this.charityRcvd = charityRcvd;
	}



	/**
	 * Return the value associated with the column: consultant_name
	 */
	public java.lang.String getConsultantName () {
		return consultantName;
	}

	/**
	 * Set the value related to the column: consultant_name
	 * @param consultantName the consultant_name value
	 */
	public void setConsultantName (java.lang.String consultantName) {
		this.consultantName = consultantName;
	}



	/**
	 * Return the value associated with the column: discount
	 */
	public java.math.BigDecimal getDiscount () {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * @param discount the discount value
	 */
	public void setDiscount (java.math.BigDecimal discount) {
		this.discount = discount;
	}



	/**
	 * Return the value associated with the column: discount_amt
	 */
	public java.math.BigDecimal getDiscountAmt () {
		return discountAmt;
	}

	/**
	 * Set the value related to the column: discount_amt
	 * @param discountAmt the discount_amt value
	 */
	public void setDiscountAmt (java.math.BigDecimal discountAmt) {
		this.discountAmt = discountAmt;
	}



	/**
	 * Return the value associated with the column: discount_on_bill
	 */
	public java.math.BigDecimal getDiscountOnBill () {
		return discountOnBill;
	}

	/**
	 * Set the value related to the column: discount_on_bill
	 * @param discountOnBill the discount_on_bill value
	 */
	public void setDiscountOnBill (java.math.BigDecimal discountOnBill) {
		this.discountOnBill = discountOnBill;
	}



	/**
	 * Return the value associated with the column: hin_no
	 */
	public java.lang.String getHinNo () {
		return hinNo;
	}

	/**
	 * Set the value related to the column: hin_no
	 * @param hinNo the hin_no value
	 */
	public void setHinNo (java.lang.String hinNo) {
		this.hinNo = hinNo;
	}



	/**
	 * Return the value associated with the column: net_amt
	 */
	public java.math.BigDecimal getNetAmt () {
		return netAmt;
	}

	/**
	 * Set the value related to the column: net_amt
	 * @param netAmt the net_amt value
	 */
	public void setNetAmt (java.math.BigDecimal netAmt) {
		this.netAmt = netAmt;
	}



	/**
	 * Return the value associated with the column: outstanding
	 */
	public java.math.BigDecimal getOutstanding () {
		return outstanding;
	}

	/**
	 * Set the value related to the column: outstanding
	 * @param outstanding the outstanding value
	 */
	public void setOutstanding (java.math.BigDecimal outstanding) {
		this.outstanding = outstanding;
	}



	/**
	 * Return the value associated with the column: package_bill_id
	 */
	public java.lang.Integer getPackageBillId () {
		return packageBillId;
	}

	/**
	 * Set the value related to the column: package_bill_id
	 * @param packageBillId the package_bill_id value
	 */
	public void setPackageBillId (java.lang.Integer packageBillId) {
		this.packageBillId = packageBillId;
	}



	/**
	 * Return the value associated with the column: patient_name
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: patient_name
	 * @param patientName the patient_name value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
	}



	/**
	 * Return the value associated with the column: patient_status
	 */
	public java.lang.String getPatientStatus () {
		return patientStatus;
	}

	/**
	 * Set the value related to the column: patient_status
	 * @param patientStatus the patient_status value
	 */
	public void setPatientStatus (java.lang.String patientStatus) {
		this.patientStatus = patientStatus;
	}



	/**
	 * Return the value associated with the column: pay_status
	 */
	public java.lang.String getPayStatus () {
		return payStatus;
	}

	/**
	 * Set the value related to the column: pay_status
	 * @param payStatus the pay_status value
	 */
	public void setPayStatus (java.lang.String payStatus) {
		this.payStatus = payStatus;
	}



	/**
	 * Return the value associated with the column: payable_amt
	 */
	public java.math.BigDecimal getPayableAmt () {
		return payableAmt;
	}

	/**
	 * Set the value related to the column: payable_amt
	 * @param payableAmt the payable_amt value
	 */
	public void setPayableAmt (java.math.BigDecimal payableAmt) {
		this.payableAmt = payableAmt;
	}



	/**
	 * Return the value associated with the column: reg_type
	 */
	public java.lang.String getRegType () {
		return regType;
	}

	/**
	 * Set the value related to the column: reg_type
	 * @param regType the reg_type value
	 */
	public void setRegType (java.lang.String regType) {
		this.regType = regType;
	}



	/**
	 * Return the value associated with the column: relative_name
	 */
	public java.lang.String getRelativeName () {
		return relativeName;
	}

	/**
	 * Set the value related to the column: relative_name
	 * @param relativeName the relative_name value
	 */
	public void setRelativeName (java.lang.String relativeName) {
		this.relativeName = relativeName;
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
	 * Return the value associated with the column: round_off
	 */
	public java.math.BigDecimal getRoundOff () {
		return roundOff;
	}

	/**
	 * Set the value related to the column: round_off
	 * @param roundOff the round_off value
	 */
	public void setRoundOff (java.math.BigDecimal roundOff) {
		this.roundOff = roundOff;
	}



	/**
	 * Return the value associated with the column: scheme_id
	 */
	public java.lang.Integer getSchemeId () {
		return schemeId;
	}

	/**
	 * Set the value related to the column: scheme_id
	 * @param schemeId the scheme_id value
	 */
	public void setSchemeId (java.lang.Integer schemeId) {
		this.schemeId = schemeId;
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
	 * Return the value associated with the column: token_no
	 */
	public java.lang.Integer getTokenNo () {
		return tokenNo;
	}

	/**
	 * Set the value related to the column: token_no
	 * @param tokenNo the token_no value
	 */
	public void setTokenNo (java.lang.Integer tokenNo) {
		this.tokenNo = tokenNo;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public java.lang.Integer getVisitId () {
		return visitId;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visitId the visit_id value
	 */
	public void setVisitId (java.lang.Integer visitId) {
		this.visitId = visitId;
	}



	/**
	 * Return the value associated with the column: authorizer_id
	 */
	public jkt.hms.masters.business.MasAuthorizer getAuthorizer () {
		return authorizer;
	}

	/**
	 * Set the value related to the column: authorizer_id
	 * @param authorizer the authorizer_id value
	 */
	public void setAuthorizer (jkt.hms.masters.business.MasAuthorizer authorizer) {
		this.authorizer = authorizer;
	}



	/**
	 * Return the value associated with the column: changed_by
	 */
	public jkt.hms.masters.business.Users getChangedBy () {
		return changedBy;
	}

	/**
	 * Set the value related to the column: changed_by
	 * @param changedBy the changed_by value
	 */
	public void setChangedBy (jkt.hms.masters.business.Users changedBy) {
		this.changedBy = changedBy;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasCompany getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasCompany company) {
		this.company = company;
	}



	/**
	 * Return the value associated with the column: consultant_id
	 */
	public jkt.hms.masters.business.MasEmployee getConsultant () {
		return consultant;
	}

	/**
	 * Set the value related to the column: consultant_id
	 * @param consultant the consultant_id value
	 */
	public void setConsultant (jkt.hms.masters.business.MasEmployee consultant) {
		this.consultant = consultant;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
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



	/**
	 * Return the value associated with the column: patient_type_id
	 */
	public jkt.hms.masters.business.MasPatientType getPatientType () {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type_id
	 * @param patientType the patient_type_id value
	 */
	public void setPatientType (jkt.hms.masters.business.MasPatientType patientType) {
		this.patientType = patientType;
	}



	/**
	 * Return the value associated with the column: scheme_authorizer_id
	 */
	public jkt.hms.masters.business.MasAuthorizer getSchemeAuthorizer () {
		return schemeAuthorizer;
	}

	/**
	 * Set the value related to the column: scheme_authorizer_id
	 * @param schemeAuthorizer the scheme_authorizer_id value
	 */
	public void setSchemeAuthorizer (jkt.hms.masters.business.MasAuthorizer schemeAuthorizer) {
		this.schemeAuthorizer = schemeAuthorizer;
	}



	/**
	 * Return the value associated with the column: sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex_id
	 * @param sex the sex_id value
	 */
	public void setSex (jkt.hms.masters.business.MasAdministrativeSex sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: BlOpBillDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlOpBillDetails> getBlOpBillDetails () {
		return blOpBillDetails;
	}

	/**
	 * Set the value related to the column: BlOpBillDetails
	 * @param blOpBillDetails the BlOpBillDetails value
	 */
	public void setBlOpBillDetails (java.util.Set<jkt.hms.masters.business.BlOpBillDetails> blOpBillDetails) {
		this.blOpBillDetails = blOpBillDetails;
	}

	public void addToBlOpBillDetails (jkt.hms.masters.business.BlOpBillDetails blOpBillDetails) {
		if (null == getBlOpBillDetails()) setBlOpBillDetails(new java.util.TreeSet<jkt.hms.masters.business.BlOpBillDetails>());
		getBlOpBillDetails().add(blOpBillDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlOpBillHeader)) return false;
		else {
			jkt.hms.masters.business.BlOpBillHeader blOpBillHeader = (jkt.hms.masters.business.BlOpBillHeader) obj;
			if (null == this.getId() || null == blOpBillHeader.getId()) return false;
			else return (this.getId().equals(blOpBillHeader.getId()));
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

	public jkt.hms.masters.business.Visit getVisit() {
		return visit;
	}

	public void setVisit(jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}


}