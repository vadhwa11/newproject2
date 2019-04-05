package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_payroll_process_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_payroll_process_header"
 */

public abstract class BaseHrPayrollProcessHeader  implements Serializable {

	public static String REF = "HrPayrollProcessHeader";
	public static String PROP_BONUS_AMOUNT = "BonusAmount";
	public static String PROP_ARREAR_SALARY_AMT = "ArrearSalaryAmt";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ADVANCE_INSTALLMENT = "AdvanceInstallment";
	public static String PROP_LOAN_INSTALLMENT = "LoanInstallment";
	public static String PROP_TOTAL_EARNING = "TotalEarning";
	public static String PROP_ARREAR_DAYS = "ArrearDays";
	public static String PROP_MONTH = "Month";
	public static String PROP_YEAR = "Year";
	public static String PROP_LWP_DAYS = "LwpDays";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TOTAL_DEDUCTION = "TotalDeduction";
	public static String PROP_ARREAR_PAYELEMENT_AMT = "ArrearPayelementAmt";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SAL_DAYS = "SalDays";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_FLAG = "Flag";
	public static String PROP_I_TAX = "ITax";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_NET_SALARY = "NetSalary";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_BASIC = "Basic";
	public static String PROP_TOTAL_MONTH_DAYS = "TotalMonthDays";
	public static String PROP_TOTAL_DAYS = "TotalDays";
	public static String PROP_TOTAL_REIMB = "TotalReimb";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHrPayrollProcessHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrPayrollProcessHeader (java.lang.Integer id) {
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
	private java.lang.Integer totalDays;
	private java.lang.Integer lwpDays;
	private java.lang.Integer salDays;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.math.BigDecimal loanInstallment;
	private java.math.BigDecimal advanceInstallment;
	private java.math.BigDecimal bonusAmount;
	private java.math.BigDecimal basic;
	private java.math.BigDecimal arrearPayelementAmt;
	private java.lang.Float arrearDays;
	private java.math.BigDecimal arrearSalaryAmt;
	private java.lang.Integer totalMonthDays;
	private java.lang.String flag;
	private java.math.BigDecimal netSalary;
	private java.math.BigDecimal totalEarning;
	private java.math.BigDecimal totalDeduction;
	private java.math.BigDecimal totalReimb;
	private java.math.BigDecimal iTax;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrPayrollProcessDetail> hrPayrollProcessDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="payroll_process_header_id"
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
	 * Return the value associated with the column: total_days
	 */
	public java.lang.Integer getTotalDays () {
		return totalDays;
	}

	/**
	 * Set the value related to the column: total_days
	 * @param totalDays the total_days value
	 */
	public void setTotalDays (java.lang.Integer totalDays) {
		this.totalDays = totalDays;
	}



	/**
	 * Return the value associated with the column: lwp_days
	 */
	public java.lang.Integer getLwpDays () {
		return lwpDays;
	}

	/**
	 * Set the value related to the column: lwp_days
	 * @param lwpDays the lwp_days value
	 */
	public void setLwpDays (java.lang.Integer lwpDays) {
		this.lwpDays = lwpDays;
	}



	/**
	 * Return the value associated with the column: sal_days
	 */
	public java.lang.Integer getSalDays () {
		return salDays;
	}

	/**
	 * Set the value related to the column: sal_days
	 * @param salDays the sal_days value
	 */
	public void setSalDays (java.lang.Integer salDays) {
		this.salDays = salDays;
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
	 * Return the value associated with the column: loan_installment
	 */
	public java.math.BigDecimal getLoanInstallment () {
		return loanInstallment;
	}

	/**
	 * Set the value related to the column: loan_installment
	 * @param loanInstallment the loan_installment value
	 */
	public void setLoanInstallment (java.math.BigDecimal loanInstallment) {
		this.loanInstallment = loanInstallment;
	}



	/**
	 * Return the value associated with the column: advance_installment
	 */
	public java.math.BigDecimal getAdvanceInstallment () {
		return advanceInstallment;
	}

	/**
	 * Set the value related to the column: advance_installment
	 * @param advanceInstallment the advance_installment value
	 */
	public void setAdvanceInstallment (java.math.BigDecimal advanceInstallment) {
		this.advanceInstallment = advanceInstallment;
	}



	/**
	 * Return the value associated with the column: bonus_amount
	 */
	public java.math.BigDecimal getBonusAmount () {
		return bonusAmount;
	}

	/**
	 * Set the value related to the column: bonus_amount
	 * @param bonusAmount the bonus_amount value
	 */
	public void setBonusAmount (java.math.BigDecimal bonusAmount) {
		this.bonusAmount = bonusAmount;
	}



	/**
	 * Return the value associated with the column: basic
	 */
	public java.math.BigDecimal getBasic () {
		return basic;
	}

	/**
	 * Set the value related to the column: basic
	 * @param basic the basic value
	 */
	public void setBasic (java.math.BigDecimal basic) {
		this.basic = basic;
	}



	/**
	 * Return the value associated with the column: arrear_payelement_amt
	 */
	public java.math.BigDecimal getArrearPayelementAmt () {
		return arrearPayelementAmt;
	}

	/**
	 * Set the value related to the column: arrear_payelement_amt
	 * @param arrearPayelementAmt the arrear_payelement_amt value
	 */
	public void setArrearPayelementAmt (java.math.BigDecimal arrearPayelementAmt) {
		this.arrearPayelementAmt = arrearPayelementAmt;
	}



	/**
	 * Return the value associated with the column: arrear_days
	 */
	public java.lang.Float getArrearDays () {
		return arrearDays;
	}

	/**
	 * Set the value related to the column: arrear_days
	 * @param arrearDays the arrear_days value
	 */
	public void setArrearDays (java.lang.Float arrearDays) {
		this.arrearDays = arrearDays;
	}



	/**
	 * Return the value associated with the column: arrear_salary_amt
	 */
	public java.math.BigDecimal getArrearSalaryAmt () {
		return arrearSalaryAmt;
	}

	/**
	 * Set the value related to the column: arrear_salary_amt
	 * @param arrearSalaryAmt the arrear_salary_amt value
	 */
	public void setArrearSalaryAmt (java.math.BigDecimal arrearSalaryAmt) {
		this.arrearSalaryAmt = arrearSalaryAmt;
	}



	/**
	 * Return the value associated with the column: total_month_days
	 */
	public java.lang.Integer getTotalMonthDays () {
		return totalMonthDays;
	}

	/**
	 * Set the value related to the column: total_month_days
	 * @param totalMonthDays the total_month_days value
	 */
	public void setTotalMonthDays (java.lang.Integer totalMonthDays) {
		this.totalMonthDays = totalMonthDays;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: net_salary
	 */
	public java.math.BigDecimal getNetSalary () {
		return netSalary;
	}

	/**
	 * Set the value related to the column: net_salary
	 * @param netSalary the net_salary value
	 */
	public void setNetSalary (java.math.BigDecimal netSalary) {
		this.netSalary = netSalary;
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
	 * Return the value associated with the column: total_reimb
	 */
	public java.math.BigDecimal getTotalReimb () {
		return totalReimb;
	}

	/**
	 * Set the value related to the column: total_reimb
	 * @param totalReimb the total_reimb value
	 */
	public void setTotalReimb (java.math.BigDecimal totalReimb) {
		this.totalReimb = totalReimb;
	}



	/**
	 * Return the value associated with the column: itax
	 */
	public java.math.BigDecimal getITax () {
		return iTax;
	}

	/**
	 * Set the value related to the column: itax
	 * @param iTax the itax value
	 */
	public void setITax (java.math.BigDecimal iTax) {
		this.iTax = iTax;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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
	 * Return the value associated with the column: HrPayrollProcessDetails
	 */
	public java.util.Set<jkt.hms.masters.business.HrPayrollProcessDetail> getHrPayrollProcessDetails () {
		return hrPayrollProcessDetails;
	}

	/**
	 * Set the value related to the column: HrPayrollProcessDetails
	 * @param hrPayrollProcessDetails the HrPayrollProcessDetails value
	 */
	public void setHrPayrollProcessDetails (java.util.Set<jkt.hms.masters.business.HrPayrollProcessDetail> hrPayrollProcessDetails) {
		this.hrPayrollProcessDetails = hrPayrollProcessDetails;
	}

	public void addToHrPayrollProcessDetails (jkt.hms.masters.business.HrPayrollProcessDetail hrPayrollProcessDetail) {
		if (null == getHrPayrollProcessDetails()) setHrPayrollProcessDetails(new java.util.TreeSet<jkt.hms.masters.business.HrPayrollProcessDetail>());
		getHrPayrollProcessDetails().add(hrPayrollProcessDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrPayrollProcessHeader)) return false;
		else {
			jkt.hms.masters.business.HrPayrollProcessHeader hrPayrollProcessHeader = (jkt.hms.masters.business.HrPayrollProcessHeader) obj;
			if (null == this.getId() || null == hrPayrollProcessHeader.getId()) return false;
			else return (this.getId().equals(hrPayrollProcessHeader.getId()));
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