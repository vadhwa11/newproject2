package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_payroll_process_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_payroll_process_detail"
 */

public abstract class BaseHrPayrollProcessDetail  implements Serializable {

	public static String REF = "HrPayrollProcessDetail";
	public static String PROP_EMP_PAY_ELEMENT = "EmpPayElement";
	public static String PROP_PAYROLL_PROCESS_HEADER = "PayrollProcessHeader";
	public static String PROP_ELEMENT_TYPE = "ElementType";
	public static String PROP_ID = "Id";
	public static String PROP_PAYELEMENT_AMOUNT = "PayelementAmount";


	// constructors
	public BaseHrPayrollProcessDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrPayrollProcessDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String elementType;
	private java.math.BigDecimal payelementAmount;

	// many to one
	private jkt.hms.masters.business.HrPayrollProcessHeader payrollProcessHeader;
	private jkt.hms.masters.business.HrEmployeePayElements empPayElement;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="payroll_process_detail_id"
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
	 * Return the value associated with the column: element_type
	 */
	public java.lang.String getElementType () {
		return elementType;
	}

	/**
	 * Set the value related to the column: element_type
	 * @param elementType the element_type value
	 */
	public void setElementType (java.lang.String elementType) {
		this.elementType = elementType;
	}



	/**
	 * Return the value associated with the column: payelement_amount
	 */
	public java.math.BigDecimal getPayelementAmount () {
		return payelementAmount;
	}

	/**
	 * Set the value related to the column: payelement_amount
	 * @param payelementAmount the payelement_amount value
	 */
	public void setPayelementAmount (java.math.BigDecimal payelementAmount) {
		this.payelementAmount = payelementAmount;
	}



	/**
	 * Return the value associated with the column: payroll_process_header_id
	 */
	public jkt.hms.masters.business.HrPayrollProcessHeader getPayrollProcessHeader () {
		return payrollProcessHeader;
	}

	/**
	 * Set the value related to the column: payroll_process_header_id
	 * @param payrollProcessHeader the payroll_process_header_id value
	 */
	public void setPayrollProcessHeader (jkt.hms.masters.business.HrPayrollProcessHeader payrollProcessHeader) {
		this.payrollProcessHeader = payrollProcessHeader;
	}



	/**
	 * Return the value associated with the column: emp_pay_element_id
	 */
	public jkt.hms.masters.business.HrEmployeePayElements getEmpPayElement () {
		return empPayElement;
	}

	/**
	 * Set the value related to the column: emp_pay_element_id
	 * @param empPayElement the emp_pay_element_id value
	 */
	public void setEmpPayElement (jkt.hms.masters.business.HrEmployeePayElements empPayElement) {
		this.empPayElement = empPayElement;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrPayrollProcessDetail)) return false;
		else {
			jkt.hms.masters.business.HrPayrollProcessDetail hrPayrollProcessDetail = (jkt.hms.masters.business.HrPayrollProcessDetail) obj;
			if (null == this.getId() || null == hrPayrollProcessDetail.getId()) return false;
			else return (this.getId().equals(hrPayrollProcessDetail.getId()));
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