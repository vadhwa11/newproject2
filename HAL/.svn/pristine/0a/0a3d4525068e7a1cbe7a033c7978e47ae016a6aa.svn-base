package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_diagnosis_conclusion
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_diagnosis_conclusion"
 */

public abstract class BaseMasDiagnosisConclusion implements Serializable {

	public static String REF = "MasDiagnosisConclusion";
	public static String PROP_STATUS = "Status";
	public static String PROP_DIAGNOSIS_CONCLUSION_CODE = "DiagnosisConclusionCode";
	public static String PROP_LAST_CHGBY = "LastChgby";
	public static String PROP_LASTCHGDATE = "Lastchgdate";
	public static String PROP_DIAGNOSIS_CONCLUSION_NAME = "DiagnosisConclusionName";
	public static String PROP_LASTCHGTIME = "Lastchgtime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasDiagnosisConclusion() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDiagnosisConclusion(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String diagnosisConclusionCode;
	private java.lang.String diagnosisConclusionName;
	private java.lang.String status;
	private java.lang.String lastChgby;
	private java.util.Date lastchgdate;
	private java.lang.String lastchgtime;

	// collections
	private java.util.Set<jkt.hms.masters.business.Visit> visits;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="diagnosis_conclusion_id"
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
	 * Return the value associated with the column: diagnosis_conclusion_code
	 */
	public java.lang.String getDiagnosisConclusionCode() {
		return diagnosisConclusionCode;
	}

	/**
	 * Set the value related to the column: diagnosis_conclusion_code
	 * 
	 * @param diagnosisConclusionCode
	 *            the diagnosis_conclusion_code value
	 */
	public void setDiagnosisConclusionCode(
			java.lang.String diagnosisConclusionCode) {
		this.diagnosisConclusionCode = diagnosisConclusionCode;
	}

	/**
	 * Return the value associated with the column: diagnosis_conclusion_name
	 */
	public java.lang.String getDiagnosisConclusionName() {
		return diagnosisConclusionName;
	}

	/**
	 * Set the value related to the column: diagnosis_conclusion_name
	 * 
	 * @param diagnosisConclusionName
	 *            the diagnosis_conclusion_name value
	 */
	public void setDiagnosisConclusionName(
			java.lang.String diagnosisConclusionName) {
		this.diagnosisConclusionName = diagnosisConclusionName;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: last_chgby
	 */
	public java.lang.String getLastChgby() {
		return lastChgby;
	}

	/**
	 * Set the value related to the column: last_chgby
	 * 
	 * @param lastChgby
	 *            the last_chgby value
	 */
	public void setLastChgby(java.lang.String lastChgby) {
		this.lastChgby = lastChgby;
	}

	/**
	 * Return the value associated with the column: lastchgdate
	 */
	public java.util.Date getLastchgdate() {
		return lastchgdate;
	}

	/**
	 * Set the value related to the column: lastchgdate
	 * 
	 * @param lastchgdate
	 *            the lastchgdate value
	 */
	public void setLastchgdate(java.util.Date lastchgdate) {
		this.lastchgdate = lastchgdate;
	}

	/**
	 * Return the value associated with the column: lastchgtime
	 */
	public java.lang.String getLastchgtime() {
		return lastchgtime;
	}

	/**
	 * Set the value related to the column: lastchgtime
	 * 
	 * @param lastchgtime
	 *            the lastchgtime value
	 */
	public void setLastchgtime(java.lang.String lastchgtime) {
		this.lastchgtime = lastchgtime;
	}

	/**
	 * Return the value associated with the column: Visits
	 */
	public java.util.Set<jkt.hms.masters.business.Visit> getVisits() {
		return visits;
	}

	/**
	 * Set the value related to the column: Visits
	 * 
	 * @param visits
	 *            the Visits value
	 */
	public void setVisits(java.util.Set<jkt.hms.masters.business.Visit> visits) {
		this.visits = visits;
	}

	public void addToVisits(jkt.hms.masters.business.Visit visit) {
		if (null == getVisits())
			setVisits(new java.util.TreeSet<jkt.hms.masters.business.Visit>());
		getVisits().add(visit);
	}

	/**
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients() {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * 
	 * @param inpatients
	 *            the Inpatients value
	 */
	public void setInpatients(
			java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients(jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients())
			setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
	}

	/**
	 * Return the value associated with the column: Discharges
	 */
	public java.util.Set<jkt.hms.masters.business.Discharge> getDischarges() {
		return discharges;
	}

	/**
	 * Set the value related to the column: Discharges
	 * 
	 * @param discharges
	 *            the Discharges value
	 */
	public void setDischarges(
			java.util.Set<jkt.hms.masters.business.Discharge> discharges) {
		this.discharges = discharges;
	}

	public void addToDischarges(jkt.hms.masters.business.Discharge discharge) {
		if (null == getDischarges())
			setDischarges(new java.util.TreeSet<jkt.hms.masters.business.Discharge>());
		getDischarges().add(discharge);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDiagnosisConclusion))
			return false;
		else {
			jkt.hms.masters.business.MasDiagnosisConclusion masDiagnosisConclusion = (jkt.hms.masters.business.MasDiagnosisConclusion) obj;
			if (null == this.getId() || null == masDiagnosisConclusion.getId())
				return false;
			else
				return (this.getId().equals(masDiagnosisConclusion.getId()));
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