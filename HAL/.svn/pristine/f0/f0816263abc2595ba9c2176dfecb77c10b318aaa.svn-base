package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the emp_afmsf_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="emp_afmsf_det"
 */

public abstract class BaseEmpAfmsfDet  implements Serializable {

	public static String REF = "EmpAfmsfDet";
	public static String PROP_TRADE = "Trade";
	public static String PROP_RANK = "Rank";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DIS_DATE = "disDate";
	public static String PROP_REC_DATE = "recDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_UNIT = "Unit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DIAGNOSIS = "diagnosis";
	public static String PROP_EMP_LAST_NAME = "EmpLastName";
	public static String PROP_EMP_NAME = "EmpName";
	public static String PROP_NEXT_REVIEW = "NextReview";
	public static String PROP_AUTH_POST_OUT = "authPostOut";
	public static String PROP_LETTER_NO = "LetterNo";
	public static String PROP_FMSF_DATE = "FmsfDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DIS_REMARKS = "DisRemarks";
	public static String PROP_DOC_STATUS = "DocStatus";
	public static String PROP_POSTED_TO = "PostedTo";
	public static String PROP_AMA_CLEAR = "AmaClear";
	public static String PROP_POST_IN_DATE = "postInDate";
	public static String PROP_AUTH_POSTING = "AuthPosting";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_MEDICAL_CATEGORY = "MedicalCategory";
	public static String PROP_SUFFIX = "suffix";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_DIS_LETTER_NO = "disLetterNo";
	public static String PROP_AMA_ARRIVAL = "AmaArrival";
	public static String PROP_POST_OUT_DATE = "postOutDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_AFMSF_TYPE = "AfmsfType";
	public static String PROP_DOCUMENT_RECEIVED = "DocumentReceived";
	public static String PROP_VIDE_WITH_DATE = "VideWithDate";
	public static String PROP_ID = "Id";
	public static String PROP_POSTED_FROM = "PostedFrom";


	// constructors
	public BaseEmpAfmsfDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmpAfmsfDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.util.Date fmsfDate;
	private java.lang.String docStatus;
	private java.util.Date videWithDate;
	private java.lang.String afmsfType;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.lang.String disRemarks;
	private java.lang.String suffix;
	private java.util.Date nextReview;
	private java.lang.String empName;
	private java.lang.String empLastName;
	private java.lang.String letterNo;
	private java.lang.String status;
	private java.lang.String authPosting;
	private java.util.Date recDate;
	private java.util.Date disDate;
	private java.util.Date postInDate;
	private java.util.Date postOutDate;
	private java.lang.String authPostOut;
	private java.lang.String disLetterNo;
	private java.lang.String diagnosis;
	private java.lang.String documentReceived;
	private java.lang.String amaArrival;
	private java.lang.String amaClear;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasUnit postedTo;
	private jkt.hms.masters.business.MasTrade trade;
	private jkt.hms.masters.business.MasUnit postedFrom;
	private jkt.hms.masters.business.MasMedicalCategory medicalCategory;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="empafmsfdet_id"
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
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: fmsf_date
	 */
	public java.util.Date getFmsfDate () {
		return fmsfDate;
	}

	/**
	 * Set the value related to the column: fmsf_date
	 * @param fmsfDate the fmsf_date value
	 */
	public void setFmsfDate (java.util.Date fmsfDate) {
		this.fmsfDate = fmsfDate;
	}



	/**
	 * Return the value associated with the column: doc_status
	 */
	public java.lang.String getDocStatus () {
		return docStatus;
	}

	/**
	 * Set the value related to the column: doc_status
	 * @param docStatus the doc_status value
	 */
	public void setDocStatus (java.lang.String docStatus) {
		this.docStatus = docStatus;
	}



	/**
	 * Return the value associated with the column: vide_with_date
	 */
	public java.util.Date getVideWithDate () {
		return videWithDate;
	}

	/**
	 * Set the value related to the column: vide_with_date
	 * @param videWithDate the vide_with_date value
	 */
	public void setVideWithDate (java.util.Date videWithDate) {
		this.videWithDate = videWithDate;
	}



	/**
	 * Return the value associated with the column: afmsf_type
	 */
	public java.lang.String getAfmsfType () {
		return afmsfType;
	}

	/**
	 * Set the value related to the column: afmsf_type
	 * @param afmsfType the afmsf_type value
	 */
	public void setAfmsfType (java.lang.String afmsfType) {
		this.afmsfType = afmsfType;
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
	 * Return the value associated with the column: dis_remarks
	 */
	public java.lang.String getDisRemarks () {
		return disRemarks;
	}

	/**
	 * Set the value related to the column: dis_remarks
	 * @param disRemarks the dis_remarks value
	 */
	public void setDisRemarks (java.lang.String disRemarks) {
		this.disRemarks = disRemarks;
	}



	/**
	 * Return the value associated with the column: suffix
	 */
	public java.lang.String getSuffix () {
		return suffix;
	}

	/**
	 * Set the value related to the column: suffix
	 * @param suffix the suffix value
	 */
	public void setSuffix (java.lang.String suffix) {
		this.suffix = suffix;
	}



	/**
	 * Return the value associated with the column: next_review
	 */
	public java.util.Date getNextReview () {
		return nextReview;
	}

	/**
	 * Set the value related to the column: next_review
	 * @param nextReview the next_review value
	 */
	public void setNextReview (java.util.Date nextReview) {
		this.nextReview = nextReview;
	}



	/**
	 * Return the value associated with the column: emp_name
	 */
	public java.lang.String getEmpName () {
		return empName;
	}

	/**
	 * Set the value related to the column: emp_name
	 * @param empName the emp_name value
	 */
	public void setEmpName (java.lang.String empName) {
		this.empName = empName;
	}



	/**
	 * Return the value associated with the column: emp_lname
	 */
	public java.lang.String getEmpLastName () {
		return empLastName;
	}

	/**
	 * Set the value related to the column: emp_lname
	 * @param empLastName the emp_lname value
	 */
	public void setEmpLastName (java.lang.String empLastName) {
		this.empLastName = empLastName;
	}



	/**
	 * Return the value associated with the column: letter_no
	 */
	public java.lang.String getLetterNo () {
		return letterNo;
	}

	/**
	 * Set the value related to the column: letter_no
	 * @param letterNo the letter_no value
	 */
	public void setLetterNo (java.lang.String letterNo) {
		this.letterNo = letterNo;
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
	 * Return the value associated with the column: auth_posting
	 */
	public java.lang.String getAuthPosting () {
		return authPosting;
	}

	/**
	 * Set the value related to the column: auth_posting
	 * @param authPosting the auth_posting value
	 */
	public void setAuthPosting (java.lang.String authPosting) {
		this.authPosting = authPosting;
	}



	/**
	 * Return the value associated with the column: rec_date 
	 */
	public java.util.Date getRecDate () {
		return recDate;
	}

	/**
	 * Set the value related to the column: rec_date 
	 * @param recDate the rec_date  value
	 */
	public void setRecDate (java.util.Date recDate) {
		this.recDate = recDate;
	}



	/**
	 * Return the value associated with the column: dis_date 
	 */
	public java.util.Date getDisDate () {
		return disDate;
	}

	/**
	 * Set the value related to the column: dis_date 
	 * @param disDate the dis_date  value
	 */
	public void setDisDate (java.util.Date disDate) {
		this.disDate = disDate;
	}



	/**
	 * Return the value associated with the column: post_in_date 
	 */
	public java.util.Date getPostInDate () {
		return postInDate;
	}

	/**
	 * Set the value related to the column: post_in_date 
	 * @param postInDate the post_in_date  value
	 */
	public void setPostInDate (java.util.Date postInDate) {
		this.postInDate = postInDate;
	}



	/**
	 * Return the value associated with the column: post_out_date 
	 */
	public java.util.Date getPostOutDate () {
		return postOutDate;
	}

	/**
	 * Set the value related to the column: post_out_date 
	 * @param postOutDate the post_out_date  value
	 */
	public void setPostOutDate (java.util.Date postOutDate) {
		this.postOutDate = postOutDate;
	}



	/**
	 * Return the value associated with the column: auth_post_out
	 */
	public java.lang.String getAuthPostOut () {
		return authPostOut;
	}

	/**
	 * Set the value related to the column: auth_post_out
	 * @param authPostOut the auth_post_out value
	 */
	public void setAuthPostOut (java.lang.String authPostOut) {
		this.authPostOut = authPostOut;
	}



	/**
	 * Return the value associated with the column: dis_letter_no
	 */
	public java.lang.String getDisLetterNo () {
		return disLetterNo;
	}

	/**
	 * Set the value related to the column: dis_letter_no
	 * @param disLetterNo the dis_letter_no value
	 */
	public void setDisLetterNo (java.lang.String disLetterNo) {
		this.disLetterNo = disLetterNo;
	}



	/**
	 * Return the value associated with the column: diagnosis
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis
	 * @param diagnosis the diagnosis value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: document_received
	 */
	public java.lang.String getDocumentReceived () {
		return documentReceived;
	}

	/**
	 * Set the value related to the column: document_received
	 * @param documentReceived the document_received value
	 */
	public void setDocumentReceived (java.lang.String documentReceived) {
		this.documentReceived = documentReceived;
	}



	/**
	 * Return the value associated with the column: ama_arrival
	 */
	public java.lang.String getAmaArrival () {
		return amaArrival;
	}

	/**
	 * Set the value related to the column: ama_arrival
	 * @param amaArrival the ama_arrival value
	 */
	public void setAmaArrival (java.lang.String amaArrival) {
		this.amaArrival = amaArrival;
	}



	/**
	 * Return the value associated with the column: ama_clear
	 */
	public java.lang.String getAmaClear () {
		return amaClear;
	}

	/**
	 * Set the value related to the column: ama_clear
	 * @param amaClear the ama_clear value
	 */
	public void setAmaClear (java.lang.String amaClear) {
		this.amaClear = amaClear;
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
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unit the unit_id value
	 */
	public void setUnit (jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}



	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: posted_to
	 */
	public jkt.hms.masters.business.MasUnit getPostedTo () {
		return postedTo;
	}

	/**
	 * Set the value related to the column: posted_to
	 * @param postedTo the posted_to value
	 */
	public void setPostedTo (jkt.hms.masters.business.MasUnit postedTo) {
		this.postedTo = postedTo;
	}



	/**
	 * Return the value associated with the column: trade_id
	 */
	public jkt.hms.masters.business.MasTrade getTrade () {
		return trade;
	}

	/**
	 * Set the value related to the column: trade_id
	 * @param trade the trade_id value
	 */
	public void setTrade (jkt.hms.masters.business.MasTrade trade) {
		this.trade = trade;
	}



	/**
	 * Return the value associated with the column: posted_from
	 */
	public jkt.hms.masters.business.MasUnit getPostedFrom () {
		return postedFrom;
	}

	/**
	 * Set the value related to the column: posted_from
	 * @param postedFrom the posted_from value
	 */
	public void setPostedFrom (jkt.hms.masters.business.MasUnit postedFrom) {
		this.postedFrom = postedFrom;
	}



	/**
	 * Return the value associated with the column: medical_category_id
	 */
	public jkt.hms.masters.business.MasMedicalCategory getMedicalCategory () {
		return medicalCategory;
	}

	/**
	 * Set the value related to the column: medical_category_id
	 * @param medicalCategory the medical_category_id value
	 */
	public void setMedicalCategory (jkt.hms.masters.business.MasMedicalCategory medicalCategory) {
		this.medicalCategory = medicalCategory;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.EmpAfmsfDet)) return false;
		else {
			jkt.hms.masters.business.EmpAfmsfDet empAfmsfDet = (jkt.hms.masters.business.EmpAfmsfDet) obj;
			if (null == this.getId() || null == empAfmsfDet.getId()) return false;
			else return (this.getId().equals(empAfmsfDet.getId()));
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