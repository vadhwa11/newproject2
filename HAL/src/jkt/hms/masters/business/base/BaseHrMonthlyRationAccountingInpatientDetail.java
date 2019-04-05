package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_monthly_ration_accounting_inpatient_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_monthly_ration_accounting_inpatient_detail"
 */

public abstract class BaseHrMonthlyRationAccountingInpatientDetail  implements Serializable {

	public static String REF = "HrMonthlyRationAccountingInpatientDetail";
    public static String PROP_EFF_TOTAL_DAYS ="EffTotalDays";
	public static String PROP_HOSP_TO_DATE = "HospToDate";
	public static String PROP_YEAR = "Year";
	public static String PROP_HOSP_TOTAL_DAYS = "HospTotalDays";
	public static String PROP_ID = "Id";
	public static String PROP_MONTH = "Month";
	public static String PROP_HOSP_FROM_DATE = "HospFromDate";
	


	// constructors
	public BaseHrMonthlyRationAccountingInpatientDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMonthlyRationAccountingInpatientDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer year;
	private java.lang.Integer month;
	private java.util.Date hospFromDate;
	private java.util.Date hospToDate;
	private java.lang.Integer hospTotalDays;
	private java.lang.Integer effTotalDays ;   
	//many-to-one 
	
	private jkt.hms.masters.business.MasEmployee employeeId ;
	private jkt.hms.masters.business.HrMonthlyRationAccounting rationId ;
	private jkt.hms.masters.business.Inpatient inpatientId;
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="inpatient_detail_id"
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
	 * Return the value associated with the column: year
	 */
	public java.lang.Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.lang.Integer year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: month
	 */
	public java.lang.Integer getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: month
	 * @param month the month value
	 */
	public void setMonth (java.lang.Integer month) {
		this.month = month;
	}



	/**
	 * Return the value associated with the column: hosp_from_date
	 */
	public java.util.Date getHospFromDate () {
		return hospFromDate;
	}

	/**
	 * Set the value related to the column: hosp_from_date
	 * @param hospFromDate the hosp_from_date value
	 */
	public void setHospFromDate (java.util.Date hospFromDate) {
		this.hospFromDate = hospFromDate;
	}



	/**
	 * Return the value associated with the column: hosp_to_date
	 */
	public java.util.Date getHospToDate () {
		return hospToDate;
	}

	/**
	 * Set the value related to the column: hosp_to_date
	 * @param hospToDate the hosp_to_date value
	 */
	public void setHospToDate (java.util.Date hospToDate) {
		this.hospToDate = hospToDate;
	}



	/**
	 * Return the value associated with the column: hosp_total_days
	 */
	public java.lang.Integer getHospTotalDays () {
		return hospTotalDays;
	}

	/**
	 * Set the value related to the column: eff_total_days
	 * @param hospTotalDays the hosp_total_days value
	 */
	public void setEffTotalDays (java.lang.Integer effTotalDays) {
		this.effTotalDays = effTotalDays;
	}
	/**
	 * Return the value associated with the column: effTotalDays
	 */
	public java.lang.Integer getEffTotalDays () {
		return effTotalDays;
	}

	/**
	 * Set the value related to the column: hosp_total_days
	 * @param hospTotalDays the hosp_total_days value
	 */
	public void setHospTotalDays (java.lang.Integer hospTotalDays) {
		this.hospTotalDays = hospTotalDays;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatientId () {
		return inpatientId;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatientId the inpatient_id value
	 */
	public void setInpatientId (jkt.hms.masters.business.Inpatient inpatientId) {
		this.inpatientId = inpatientId;
	}
	
	/**
	 * Return the value associated with the column: ration_id
	 */
	public jkt.hms.masters.business.HrMonthlyRationAccounting getRationId () {
		return rationId;
	}

	/**
	 * Set the value related to the column: ration_id
	 * @param rationId the ration_id value
	 */
	public void setRationId (jkt.hms.masters.business.HrMonthlyRationAccounting rationId) {
		this.rationId = rationId;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (jkt.hms.masters.business.MasEmployee employeeId) {
		this.employeeId = employeeId;
	}







	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMonthlyRationAccountingInpatientDetail)) return false;
		else {
			jkt.hms.masters.business.HrMonthlyRationAccountingInpatientDetail hrMonthlyRationAccountingInpatientDetail = (jkt.hms.masters.business.HrMonthlyRationAccountingInpatientDetail) obj;
			if (null == this.getId() || null == hrMonthlyRationAccountingInpatientDetail.getId()) return false;
			else return (this.getId().equals(hrMonthlyRationAccountingInpatientDetail.getId()));
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