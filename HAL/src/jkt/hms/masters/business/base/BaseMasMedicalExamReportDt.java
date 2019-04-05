package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MAS_MEDICAL_EXAM_REPORT_DT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MAS_MEDICAL_EXAM_REPORT_DT"
 */

public abstract class BaseMasMedicalExamReportDt  implements Serializable {

	public static String REF = "MasMedicalExamReportDt";
	public static String PROP_GIVE_ON = "GiveOn";
	public static String PROP_DOSE = "Dose";
	public static String PROP_DOM = "DOM";
	public static String PROP_VACCINE = "Vaccine";
	public static String PROP_DOE = "DOE";
	public static String PROP_ID = "Id";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_ROUTE = "Route";
	public static String PROP_MAS_MEDICAL_EXAM_REPORT = "MasMedicalExamReport";


	// constructors
	public BaseMasMedicalExamReportDt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMedicalExamReportDt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String batchNo;
	private java.util.Date giveOn;
	private java.util.Date dOM;
	private java.util.Date dOE;
	private java.lang.String vaccine;
	private java.lang.String dose;
	private java.lang.String route;

	// many to one
	private jkt.hms.masters.business.MasMedicalExaminationReportOnEntry masMedicalExamReport;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo () {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * @param batchNo the batch_no value
	 */
	public void setBatchNo (java.lang.String batchNo) {
		this.batchNo = batchNo;
	}



	/**
	 * Return the value associated with the column: give_on
	 */
	public java.util.Date getGiveOn () {
		return giveOn;
	}

	/**
	 * Set the value related to the column: give_on
	 * @param giveOn the give_on value
	 */
	public void setGiveOn (java.util.Date giveOn) {
		this.giveOn = giveOn;
	}



	/**
	 * Return the value associated with the column: dom
	 */
	public java.util.Date getDOM () {
		return dOM;
	}

	/**
	 * Set the value related to the column: dom
	 * @param dOM the dom value
	 */
	public void setDOM (java.util.Date dOM) {
		this.dOM = dOM;
	}



	/**
	 * Return the value associated with the column: doe
	 */
	public java.util.Date getDOE () {
		return dOE;
	}

	/**
	 * Set the value related to the column: doe
	 * @param dOE the doe value
	 */
	public void setDOE (java.util.Date dOE) {
		this.dOE = dOE;
	}



	/**
	 * Return the value associated with the column: VACCINE
	 */
	public java.lang.String getVaccine () {
		return vaccine;
	}

	/**
	 * Set the value related to the column: VACCINE
	 * @param vaccine the VACCINE value
	 */
	public void setVaccine (java.lang.String vaccine) {
		this.vaccine = vaccine;
	}



	/**
	 * Return the value associated with the column: dose
	 */
	public java.lang.String getDose () {
		return dose;
	}

	/**
	 * Set the value related to the column: dose
	 * @param dose the dose value
	 */
	public void setDose (java.lang.String dose) {
		this.dose = dose;
	}



	/**
	 * Return the value associated with the column: route
	 */
	public java.lang.String getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: route
	 * @param route the route value
	 */
	public void setRoute (java.lang.String route) {
		this.route = route;
	}



	/**
	 * Return the value associated with the column: mas_medical_exam_report
	 */
	public jkt.hms.masters.business.MasMedicalExaminationReportOnEntry getMasMedicalExamReport () {
		return masMedicalExamReport;
	}

	/**
	 * Set the value related to the column: mas_medical_exam_report
	 * @param masMedicalExamReport the mas_medical_exam_report value
	 */
	public void setMasMedicalExamReport (jkt.hms.masters.business.MasMedicalExaminationReportOnEntry masMedicalExamReport) {
		this.masMedicalExamReport = masMedicalExamReport;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasMedicalExamReportDt)) return false;
		else {
			jkt.hms.masters.business.MasMedicalExamReportDt masMedicalExamReportDt = (jkt.hms.masters.business.MasMedicalExamReportDt) obj;
			if (null == this.getId() || null == masMedicalExamReportDt.getId()) return false;
			else return (this.getId().equals(masMedicalExamReportDt.getId()));
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