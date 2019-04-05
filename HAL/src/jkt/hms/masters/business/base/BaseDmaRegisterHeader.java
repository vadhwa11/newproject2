package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DMA_REGISTER_HEADER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DMA_REGISTER_HEADER"
 */

public abstract class BaseDmaRegisterHeader  implements Serializable {

	public static String REF = "DmaRegisterHeader";
	public static String PROP_WORKING_DIAGNOSIS = "WorkingDiagnosis";
	public static String PROP_DMO_CALLED = "DmoCalled";
	public static String PROP_TIME_ATTENDED = "TimeAttended";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DMO = "DMO";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_DMO_ARRIVED_TIME = "DmoArrivedTime";
	public static String PROP_COMPLAINTS = "Complaints";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_DMA = "DMA";
	public static String PROP_TPT_AMB_SENT_TIME = "TptAmbSentTime";
	public static String PROP_CALL_TIME = "CallTime";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_REPORTED_TIME = "ReportedTime";
	public static String PROP_DMO_TRANS_AMBU = "DmoTransAmbu";
	public static String PROP_DMA_REGISTER_DATE = "DmaRegisterDate";


	// constructors
	public BaseDmaRegisterHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDmaRegisterHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String complaints;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date dmaRegisterDate;
	private java.lang.String workingDiagnosis;
	private java.lang.String dmoCalled;
	private java.lang.String callTime;
	private java.lang.String timeAttended;
	private java.lang.String remarks;
	private java.lang.String reportedTime;
	private java.lang.String dmoTransAmbu;
	private java.lang.String tptAmbSentTime;
	private java.lang.String dmoArrivedTime;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users dMA;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee dMO;
	private jkt.hms.masters.business.MasDisposal disposal;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="DMA_REGISTER_HEADER_ID"
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
	 * Return the value associated with the column: COMPLAINTS
	 */
	public java.lang.String getComplaints () {
		return complaints;
	}

	/**
	 * Set the value related to the column: COMPLAINTS
	 * @param complaints the COMPLAINTS value
	 */
	public void setComplaints (java.lang.String complaints) {
		this.complaints = complaints;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: DMA_REGISTER_DATE
	 */
	public java.util.Date getDmaRegisterDate () {
		return dmaRegisterDate;
	}

	/**
	 * Set the value related to the column: DMA_REGISTER_DATE
	 * @param dmaRegisterDate the DMA_REGISTER_DATE value
	 */
	public void setDmaRegisterDate (java.util.Date dmaRegisterDate) {
		this.dmaRegisterDate = dmaRegisterDate;
	}



	/**
	 * Return the value associated with the column: WORKING_DIAGNOSIS
	 */
	public java.lang.String getWorkingDiagnosis () {
		return workingDiagnosis;
	}

	/**
	 * Set the value related to the column: WORKING_DIAGNOSIS
	 * @param workingDiagnosis the WORKING_DIAGNOSIS value
	 */
	public void setWorkingDiagnosis (java.lang.String workingDiagnosis) {
		this.workingDiagnosis = workingDiagnosis;
	}



	/**
	 * Return the value associated with the column: DMO_CALLED
	 */
	public java.lang.String getDmoCalled () {
		return dmoCalled;
	}

	/**
	 * Set the value related to the column: DMO_CALLED
	 * @param dmoCalled the DMO_CALLED value
	 */
	public void setDmoCalled (java.lang.String dmoCalled) {
		this.dmoCalled = dmoCalled;
	}



	/**
	 * Return the value associated with the column: CALL_TIME
	 */
	public java.lang.String getCallTime () {
		return callTime;
	}

	/**
	 * Set the value related to the column: CALL_TIME
	 * @param callTime the CALL_TIME value
	 */
	public void setCallTime (java.lang.String callTime) {
		this.callTime = callTime;
	}



	/**
	 * Return the value associated with the column: TIME_ATTENDED
	 */
	public java.lang.String getTimeAttended () {
		return timeAttended;
	}

	/**
	 * Set the value related to the column: TIME_ATTENDED
	 * @param timeAttended the TIME_ATTENDED value
	 */
	public void setTimeAttended (java.lang.String timeAttended) {
		this.timeAttended = timeAttended;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: REPORTED_TIME
	 */
	public java.lang.String getReportedTime () {
		return reportedTime;
	}

	/**
	 * Set the value related to the column: REPORTED_TIME
	 * @param reportedTime the REPORTED_TIME value
	 */
	public void setReportedTime (java.lang.String reportedTime) {
		this.reportedTime = reportedTime;
	}



	/**
	 * Return the value associated with the column: dmo_trans_ambu
	 */
	public java.lang.String getDmoTransAmbu () {
		return dmoTransAmbu;
	}

	/**
	 * Set the value related to the column: dmo_trans_ambu
	 * @param dmoTransAmbu the dmo_trans_ambu value
	 */
	public void setDmoTransAmbu (java.lang.String dmoTransAmbu) {
		this.dmoTransAmbu = dmoTransAmbu;
	}



	/**
	 * Return the value associated with the column: tpt_amb_sent_time
	 */
	public java.lang.String getTptAmbSentTime () {
		return tptAmbSentTime;
	}

	/**
	 * Set the value related to the column: tpt_amb_sent_time
	 * @param tptAmbSentTime the tpt_amb_sent_time value
	 */
	public void setTptAmbSentTime (java.lang.String tptAmbSentTime) {
		this.tptAmbSentTime = tptAmbSentTime;
	}



	/**
	 * Return the value associated with the column: dmo_arrived_time
	 */
	public java.lang.String getDmoArrivedTime () {
		return dmoArrivedTime;
	}

	/**
	 * Set the value related to the column: dmo_arrived_time
	 * @param dmoArrivedTime the dmo_arrived_time value
	 */
	public void setDmoArrivedTime (java.lang.String dmoArrivedTime) {
		this.dmoArrivedTime = dmoArrivedTime;
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
	 * Return the value associated with the column: DMA_ID
	 */
	public jkt.hms.masters.business.Users getDMA () {
		return dMA;
	}

	/**
	 * Set the value related to the column: DMA_ID
	 * @param dMA the DMA_ID value
	 */
	public void setDMA (jkt.hms.masters.business.Users dMA) {
		this.dMA = dMA;
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
	 * Return the value associated with the column: DMO_ID
	 */
	public jkt.hms.masters.business.MasEmployee getDMO () {
		return dMO;
	}

	/**
	 * Set the value related to the column: DMO_ID
	 * @param dMO the DMO_ID value
	 */
	public void setDMO (jkt.hms.masters.business.MasEmployee dMO) {
		this.dMO = dMO;
	}



	/**
	 * Return the value associated with the column: DISPOSAL_ID
	 */
	public jkt.hms.masters.business.MasDisposal getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: DISPOSAL_ID
	 * @param disposal the DISPOSAL_ID value
	 */
	public void setDisposal (jkt.hms.masters.business.MasDisposal disposal) {
		this.disposal = disposal;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DmaRegisterHeader)) return false;
		else {
			jkt.hms.masters.business.DmaRegisterHeader dmaRegisterHeader = (jkt.hms.masters.business.DmaRegisterHeader) obj;
			if (null == this.getId() || null == dmaRegisterHeader.getId()) return false;
			else return (this.getId().equals(dmaRegisterHeader.getId()));
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