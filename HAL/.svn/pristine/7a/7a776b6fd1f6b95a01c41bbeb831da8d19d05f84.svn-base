package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_itax_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_itax_header"
 */

public abstract class BaseHrItaxHeader  implements Serializable {

	public static String REF = "HrItaxHeader";
	public static String PROP_ITAX = "Itax";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_EARNING = "Earning";
	public static String PROP_DEDUCTION = "Deduction";
	public static String PROP_NET_INCOME = "NetIncome";
	public static String PROP_F_YEAR = "FYear";
	public static String PROP_ID = "Id";
	public static String PROP_F_MONTH = "FMonth";


	// constructors
	public BaseHrItaxHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrItaxHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrItaxHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreFinancial fYear,
		jkt.hms.masters.business.MasEmployee employee,
		java.lang.Integer fMonth) {

		this.setId(id);
		this.setFYear(fYear);
		this.setEmployee(employee);
		this.setFMonth(fMonth);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer fMonth;
	private java.math.BigDecimal earning;
	private java.math.BigDecimal deduction;
	private java.math.BigDecimal netIncome;
	private java.math.BigDecimal itax;

	// many to one
	private jkt.hms.masters.business.MasStoreFinancial fYear;
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrItaxDetails> iTaxDetailsSet;



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
	 * Return the value associated with the column: f_month
	 */
	public java.lang.Integer getFMonth () {
		return fMonth;
	}

	/**
	 * Set the value related to the column: f_month
	 * @param fMonth the f_month value
	 */
	public void setFMonth (java.lang.Integer fMonth) {
		this.fMonth = fMonth;
	}



	/**
	 * Return the value associated with the column: earning
	 */
	public java.math.BigDecimal getEarning () {
		return earning;
	}

	/**
	 * Set the value related to the column: earning
	 * @param earning the earning value
	 */
	public void setEarning (java.math.BigDecimal earning) {
		this.earning = earning;
	}



	/**
	 * Return the value associated with the column: deduction
	 */
	public java.math.BigDecimal getDeduction () {
		return deduction;
	}

	/**
	 * Set the value related to the column: deduction
	 * @param deduction the deduction value
	 */
	public void setDeduction (java.math.BigDecimal deduction) {
		this.deduction = deduction;
	}



	/**
	 * Return the value associated with the column: net_income
	 */
	public java.math.BigDecimal getNetIncome () {
		return netIncome;
	}

	/**
	 * Set the value related to the column: net_income
	 * @param netIncome the net_income value
	 */
	public void setNetIncome (java.math.BigDecimal netIncome) {
		this.netIncome = netIncome;
	}



	/**
	 * Return the value associated with the column: itax
	 */
	public java.math.BigDecimal getItax () {
		return itax;
	}

	/**
	 * Set the value related to the column: itax
	 * @param itax the itax value
	 */
	public void setItax (java.math.BigDecimal itax) {
		this.itax = itax;
	}



	/**
	 * Return the value associated with the column: f_year
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFYear () {
		return fYear;
	}

	/**
	 * Set the value related to the column: f_year
	 * @param fYear the f_year value
	 */
	public void setFYear (jkt.hms.masters.business.MasStoreFinancial fYear) {
		this.fYear = fYear;
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
	 * Return the value associated with the column: ITaxDetailsSet
	 */
	public java.util.Set<jkt.hms.masters.business.HrItaxDetails> getITaxDetailsSet () {
		return iTaxDetailsSet;
	}

	/**
	 * Set the value related to the column: ITaxDetailsSet
	 * @param iTaxDetailsSet the ITaxDetailsSet value
	 */
	public void setITaxDetailsSet (java.util.Set<jkt.hms.masters.business.HrItaxDetails> iTaxDetailsSet) {
		this.iTaxDetailsSet = iTaxDetailsSet;
	}

	public void addToITaxDetailsSet (jkt.hms.masters.business.HrItaxDetails hrItaxDetails) {
		if (null == getITaxDetailsSet()) setITaxDetailsSet(new java.util.TreeSet<jkt.hms.masters.business.HrItaxDetails>());
		getITaxDetailsSet().add(hrItaxDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrItaxHeader)) return false;
		else {
			jkt.hms.masters.business.HrItaxHeader hrItaxHeader = (jkt.hms.masters.business.HrItaxHeader) obj;
			if (null == this.getId() || null == hrItaxHeader.getId()) return false;
			else return (this.getId().equals(hrItaxHeader.getId()));
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