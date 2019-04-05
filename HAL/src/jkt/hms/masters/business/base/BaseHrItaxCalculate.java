package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_itax_calculate table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_itax_calculate"
 */

public abstract class BaseHrItaxCalculate  implements Serializable {

	public static String REF = "HrItaxCalculate";
	public static String PROP_TOTAL_EARNING = "TotalEarning";
	public static String PROP_FIN_YEAR = "FinYear";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_TOTAL_TAX = "TotalTax";
	public static String PROP_ID = "Id";
	public static String PROP_TOTAL_DEDUCTION = "TotalDeduction";
	public static String PROP_MONTHLY_ITAX = "MonthlyItax";


	// constructors
	public BaseHrItaxCalculate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrItaxCalculate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrItaxCalculate (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreFinancial finYear,
		jkt.hms.masters.business.MasEmployee employee,
		java.math.BigDecimal totalEarning,
		java.math.BigDecimal totalDeduction) {

		this.setId(id);
		this.setFinYear(finYear);
		this.setEmployee(employee);
		this.setTotalEarning(totalEarning);
		this.setTotalDeduction(totalDeduction);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal totalEarning;
	private java.math.BigDecimal totalDeduction;
	private java.math.BigDecimal monthlyItax;
	private java.math.BigDecimal totalTax;

	// many to one
	private jkt.hms.masters.business.MasStoreFinancial finYear;
	private jkt.hms.masters.business.MasEmployee employee;



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
	 * Return the value associated with the column: total_earning
	 */
	public java.math.BigDecimal getTotalEarning () {
		return totalEarning;
	}

	/**
	 * Set the value related to the column: total_earning
	 * @param totalEarning the total_earning value
	 */
	public void setTotalEarning (java.math.BigDecimal totalEarning) {
		this.totalEarning = totalEarning;
	}



	/**
	 * Return the value associated with the column: total_deduction
	 */
	public java.math.BigDecimal getTotalDeduction () {
		return totalDeduction;
	}

	/**
	 * Set the value related to the column: total_deduction
	 * @param totalDeduction the total_deduction value
	 */
	public void setTotalDeduction (java.math.BigDecimal totalDeduction) {
		this.totalDeduction = totalDeduction;
	}



	/**
	 * Return the value associated with the column: monthly_itax
	 */
	public java.math.BigDecimal getMonthlyItax () {
		return monthlyItax;
	}

	/**
	 * Set the value related to the column: monthly_itax
	 * @param monthlyItax the monthly_itax value
	 */
	public void setMonthlyItax (java.math.BigDecimal monthlyItax) {
		this.monthlyItax = monthlyItax;
	}



	/**
	 * Return the value associated with the column: total_tax
	 */
	public java.math.BigDecimal getTotalTax () {
		return totalTax;
	}

	/**
	 * Set the value related to the column: total_tax
	 * @param totalTax the total_tax value
	 */
	public void setTotalTax (java.math.BigDecimal totalTax) {
		this.totalTax = totalTax;
	}



	/**
	 * Return the value associated with the column: fin_year_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFinYear () {
		return finYear;
	}

	/**
	 * Set the value related to the column: fin_year_id
	 * @param finYear the fin_year_id value
	 */
	public void setFinYear (jkt.hms.masters.business.MasStoreFinancial finYear) {
		this.finYear = finYear;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrItaxCalculate)) return false;
		else {
			jkt.hms.masters.business.HrItaxCalculate hrItaxCalculate = (jkt.hms.masters.business.HrItaxCalculate) obj;
			if (null == this.getId() || null == hrItaxCalculate.getId()) return false;
			else return (this.getId().equals(hrItaxCalculate.getId()));
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