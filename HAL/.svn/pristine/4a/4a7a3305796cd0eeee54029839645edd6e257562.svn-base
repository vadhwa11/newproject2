package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MONTHLY_DISCHARGE_DT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MONTHLY_DISCHARGE_DT"
 */

public abstract class BaseMonthlyDischargeDt  implements Serializable {

	public static String REF = "MonthlyDischargeDt";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_DISPOSED_OFF = "DisposedOff";
	public static String PROP_ID = "Id";
	public static String PROP_MONTHLY_DIS_HD = "MonthlyDisHd";
	public static String PROP_DATE_OF_DISCHARGE = "DateOfDischarge";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_DISCHARGE_SLIP = "DischargeSlip";


	// constructors
	public BaseMonthlyDischargeDt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMonthlyDischargeDt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String diagnosis;
	private java.util.Date dateOfDischarge;
	private java.lang.String disposedOff;
	private java.lang.String adNo;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MonthlyDischargeHd monthlyDisHd;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.PatientDischargeSlip dischargeSlip;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="MONTHLY_DIS_DT_ID"
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
	 * Return the value associated with the column: AD_NO
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: AD_NO
	 * @param adNo the AD_NO value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hin the HIN_ID value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: MONTHLY_DIS_HD_ID
	 */
	public jkt.hms.masters.business.MonthlyDischargeHd getMonthlyDisHd () {
		return monthlyDisHd;
	}

	/**
	 * Set the value related to the column: MONTHLY_DIS_HD_ID
	 * @param monthlyDisHd the MONTHLY_DIS_HD_ID value
	 */
	public void setMonthlyDisHd (jkt.hms.masters.business.MonthlyDischargeHd monthlyDisHd) {
		this.monthlyDisHd = monthlyDisHd;
	}



	/**
	 * Return the value associated with the column: INPATIENT_ID
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: INPATIENT_ID
	 * @param inpatient the INPATIENT_ID value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: DISCHARGE_SLIP_ID
	 */
	public jkt.hms.masters.business.PatientDischargeSlip getDischargeSlip () {
		return dischargeSlip;
	}

	/**
	 * Set the value related to the column: DISCHARGE_SLIP_ID
	 * @param dischargeSlip the DISCHARGE_SLIP_ID value
	 */
	public void setDischargeSlip (jkt.hms.masters.business.PatientDischargeSlip dischargeSlip) {
		this.dischargeSlip = dischargeSlip;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MonthlyDischargeDt)) return false;
		else {
			jkt.hms.masters.business.MonthlyDischargeDt monthlyDischargeDt = (jkt.hms.masters.business.MonthlyDischargeDt) obj;
			if (null == this.getId() || null == monthlyDischargeDt.getId()) return false;
			else return (this.getId().equals(monthlyDischargeDt.getId()));
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