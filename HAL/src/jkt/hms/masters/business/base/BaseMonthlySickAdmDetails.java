package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MONTHLY_SICK_ADM_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MONTHLY_SICK_ADM_DETAILS"
 */

public abstract class BaseMonthlySickAdmDetails  implements Serializable {

	public static String REF = "MonthlySickAdmDetails";
	public static String PROP_MONTHLY_SICK_ADM_HEADER = "MonthlySickAdmHeader";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_DATE_OF_ADMISSION = "DateOfAdmission";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_DISPOSED_OFF = "DisposedOff";
	public static String PROP_ID = "Id";
	public static String PROP_DATE_OF_DISCHARGE = "DateOfDischarge";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_NO_OF_DAYS = "NoOfDays";


	// constructors
	public BaseMonthlySickAdmDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMonthlySickAdmDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String diagnosis;
	private java.util.Date dateOfAdmission;
	private java.util.Date dateOfDischarge;
	private java.lang.String disposedOff;
	private java.lang.Integer noOfDays;
	private java.lang.String adNo;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MonthlySickAdmHeader monthlySickAdmHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="MONTHLY_ADM_DETAILS_ID"
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
	 * Return the value associated with the column: DIAGNOSIS
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: DIAGNOSIS
	 * @param diagnosis the DIAGNOSIS value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: DATE_OF_ADMISSION
	 */
	public java.util.Date getDateOfAdmission () {
		return dateOfAdmission;
	}

	/**
	 * Set the value related to the column: DATE_OF_ADMISSION
	 * @param dateOfAdmission the DATE_OF_ADMISSION value
	 */
	public void setDateOfAdmission (java.util.Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}



	/**
	 * Return the value associated with the column: DATE_OF_DISCHARGE
	 */
	public java.util.Date getDateOfDischarge () {
		return dateOfDischarge;
	}

	/**
	 * Set the value related to the column: DATE_OF_DISCHARGE
	 * @param dateOfDischarge the DATE_OF_DISCHARGE value
	 */
	public void setDateOfDischarge (java.util.Date dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}



	/**
	 * Return the value associated with the column: DISPOSED_OFF
	 */
	public java.lang.String getDisposedOff () {
		return disposedOff;
	}

	/**
	 * Set the value related to the column: DISPOSED_OFF
	 * @param disposedOff the DISPOSED_OFF value
	 */
	public void setDisposedOff (java.lang.String disposedOff) {
		this.disposedOff = disposedOff;
	}



	/**
	 * Return the value associated with the column: NO_OF_DAYS
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: NO_OF_DAYS
	 * @param noOfDays the NO_OF_DAYS value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: MONTHLY_ADM_HEADER_ID
	 */
	public jkt.hms.masters.business.MonthlySickAdmHeader getMonthlySickAdmHeader () {
		return monthlySickAdmHeader;
	}

	/**
	 * Set the value related to the column: MONTHLY_ADM_HEADER_ID
	 * @param monthlySickAdmHeader the MONTHLY_ADM_HEADER_ID value
	 */
	public void setMonthlySickAdmHeader (jkt.hms.masters.business.MonthlySickAdmHeader monthlySickAdmHeader) {
		this.monthlySickAdmHeader = monthlySickAdmHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MonthlySickAdmDetails)) return false;
		else {
			jkt.hms.masters.business.MonthlySickAdmDetails monthlySickAdmDetails = (jkt.hms.masters.business.MonthlySickAdmDetails) obj;
			if (null == this.getId() || null == monthlySickAdmDetails.getId()) return false;
			else return (this.getId().equals(monthlySickAdmDetails.getId()));
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