package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_monthly_ration_accounting_movement_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_monthly_ration_accounting_movement_detail"
 */

public abstract class BaseHrMonthlyRationAccountingMovementDetail  implements Serializable {

	public static String REF = "HrMonthlyRationAccountingMovementDetail";
	public static String PROP_YEAR = "Year";
	public static String PROP_MOVEMENT_FROM_DATE = "MovementFromDate";
	public static String PROP_MOVEMENT_TO_DATE = "MovementToDate";
	public static String PROP_MOVEMENT_TYPE = "MovementType";
	public static String PROP_ID = "Id";
	public static String PROP_MOVEMENT_TOTAL_DAYS = "MovementTotalDays";
	public static String PROP_MONTH = "Month";
	public static String PROP_EFF_TOTAL_DAYS ="EffTotalDays";


	// constructors
	public BaseHrMonthlyRationAccountingMovementDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMonthlyRationAccountingMovementDetail (java.lang.Integer id) {
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
	private java.util.Date movementFromDate;
	private java.util.Date movementToDate;
	private java.lang.Integer movementTotalDays;
	private java.lang.String movementType;
	private java.lang.Integer effTotalDays ;
	
	//many-to-one
	private jkt.hms.masters.business.MasEmployee employeeId ;
	private jkt.hms.masters.business.HrMonthlyRationAccounting rationId ;
	private jkt.hms.masters.business.MovementOutEntry movementOutId;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="movement_detail_id"
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
	 * Return the value associated with the column: movement_from_date
	 */
	public java.util.Date getMovementFromDate () {
		return movementFromDate;
	}

	/**
	 * Set the value related to the column: movement_from_date
	 * @param movementFromDate the movement_from_date value
	 */
	public void setMovementFromDate (java.util.Date movementFromDate) {
		this.movementFromDate = movementFromDate;
	}



	/**
	 * Return the value associated with the column: movement_to_date
	 */
	public java.util.Date getMovementToDate () {
		return movementToDate;
	}

	/**
	 * Set the value related to the column: movement_to_date
	 * @param movementToDate the movement_to_date value
	 */
	public void setMovementToDate (java.util.Date movementToDate) {
		this.movementToDate = movementToDate;
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
	 * Return the value associated with the column: movement_total_days
	 */
	public java.lang.Integer getMovementTotalDays () {
		return movementTotalDays;
	}

	/**
	 * Set the value related to the column: movement_total_days
	 * @param movementTotalDays the movement_total_days value
	 */
	public void setMovementTotalDays (java.lang.Integer movementTotalDays) {
		this.movementTotalDays = movementTotalDays;
	}



	/**
	 * Return the value associated with the column: movement_out_id
	 */
	public jkt.hms.masters.business.MovementOutEntry getMovementOutId () {
		return movementOutId;
	}

	/**
	 * Set the value related to the column: movement_out_id
	 * @param movementOutId the movement_out_id value
	 */
	public void setMovementOutId (jkt.hms.masters.business.MovementOutEntry movementOutId) {
		this.movementOutId = movementOutId;
	}



	/**
	 * Return the value associated with the column: movement_type
	 */
	public java.lang.String getMovementType () {
		return movementType;
	}

	/**
	 * Set the value related to the column: movement_type
	 * @param movementType the movement_type value
	 */
	public void setMovementType (java.lang.String movementType) {
		this.movementType = movementType;
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
		if (!(obj instanceof jkt.hms.masters.business.HrMonthlyRationAccountingMovementDetail)) return false;
		else {
			jkt.hms.masters.business.HrMonthlyRationAccountingMovementDetail hrMonthlyRationAccountingMovementDetail = (jkt.hms.masters.business.HrMonthlyRationAccountingMovementDetail) obj;
			if (null == this.getId() || null == hrMonthlyRationAccountingMovementDetail.getId()) return false;
			else return (this.getId().equals(hrMonthlyRationAccountingMovementDetail.getId()));
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