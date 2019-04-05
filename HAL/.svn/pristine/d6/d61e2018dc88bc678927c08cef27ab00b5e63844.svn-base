package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_employee_pay_elements table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_employee_pay_elements"
 */

public abstract class BaseHrEmployeePayElements  implements Serializable {

	public static String REF = "HrEmployeePayElements";
	public static String PROP_STATUS = "Status";
	public static String PROP_PAY_ELEMENT = "PayElement";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_START_DATE = "StartDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PAY_AMOUNT = "PayAmount";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PAY_ELEMENT_TYPE = "PayElementType";


	// constructors
	public BaseHrEmployeePayElements () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeePayElements (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal payAmount;
	private java.util.Date startDate;
	private java.lang.String payElementType;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.HrMasPayElement payElement;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: pay_amount
	 */
	public java.math.BigDecimal getPayAmount () {
		return payAmount;
	}

	/**
	 * Set the value related to the column: pay_amount
	 * @param payAmount the pay_amount value
	 */
	public void setPayAmount (java.math.BigDecimal payAmount) {
		this.payAmount = payAmount;
	}



	/**
	 * Return the value associated with the column: start_date
	 */
	public java.util.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: start_date
	 * @param startDate the start_date value
	 */
	public void setStartDate (java.util.Date startDate) {
		this.startDate = startDate;
	}



	/**
	 * Return the value associated with the column: pay_element_type
	 */
	public java.lang.String getPayElementType () {
		return payElementType;
	}

	/**
	 * Set the value related to the column: pay_element_type
	 * @param payElementType the pay_element_type value
	 */
	public void setPayElementType (java.lang.String payElementType) {
		this.payElementType = payElementType;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
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
	 * Return the value associated with the column: pay_element_id
	 */
	public jkt.hms.masters.business.HrMasPayElement getPayElement () {
		return payElement;
	}

	/**
	 * Set the value related to the column: pay_element_id
	 * @param payElement the pay_element_id value
	 */
	public void setPayElement (jkt.hms.masters.business.HrMasPayElement payElement) {
		this.payElement = payElement;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeePayElements)) return false;
		else {
			jkt.hms.masters.business.HrEmployeePayElements hrEmployeePayElements = (jkt.hms.masters.business.HrEmployeePayElements) obj;
			if (null == this.getId() || null == hrEmployeePayElements.getId()) return false;
			else return (this.getId().equals(hrEmployeePayElements.getId()));
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