package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the transaction_sequence table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="transaction_sequence"
 */

public abstract class BaseTransactionSequence  implements Serializable {

	public static String REF = "TransactionSequence";
	public static String PROP_FINANCIAL = "Financial";
	public static String PROP_TABLENAME = "Tablename";
	public static String PROP_CREATEDBY = "Createdby";
	public static String PROP_TRANSACTION_SEQUENCE_NAME = "TransactionSequenceName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_TRANSACTION_SEQUENCE_NUMBER = "TransactionSequenceNumber";
	public static String PROP_TRANSACTION_POSTFIX = "TransactionPostfix";
	public static String PROP_MONTH = "Month";
	public static String PROP_TRANSACTION_PREFIX = "TransactionPrefix";
	public static String PROP_STATUS = "Status";
	public static String PROP_DIVISION = "Division";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseTransactionSequence () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTransactionSequence (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer transactionSequenceNumber;
	private java.lang.String transactionSequenceName;
	private java.lang.String transactionPrefix;
	private java.lang.String transactionPostfix;
	private java.lang.String tablename;
	private java.lang.String createdby;
	private java.lang.String status;
	private java.lang.Integer month;

	// many to one
	private jkt.hms.masters.business.MasServiceType serviceType;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreFinancial financial;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDivision division;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="transaction_sequence_id"
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
	 * Return the value associated with the column: transaction_sequence_number
	 */
	public java.lang.Integer getTransactionSequenceNumber () {
		return transactionSequenceNumber;
	}

	/**
	 * Set the value related to the column: transaction_sequence_number
	 * @param transactionSequenceNumber the transaction_sequence_number value
	 */
	public void setTransactionSequenceNumber (java.lang.Integer transactionSequenceNumber) {
		this.transactionSequenceNumber = transactionSequenceNumber;
	}



	/**
	 * Return the value associated with the column: transaction_sequence_name
	 */
	public java.lang.String getTransactionSequenceName () {
		return transactionSequenceName;
	}

	/**
	 * Set the value related to the column: transaction_sequence_name
	 * @param transactionSequenceName the transaction_sequence_name value
	 */
	public void setTransactionSequenceName (java.lang.String transactionSequenceName) {
		this.transactionSequenceName = transactionSequenceName;
	}



	/**
	 * Return the value associated with the column: transaction_prefix
	 */
	public java.lang.String getTransactionPrefix () {
		return transactionPrefix;
	}

	/**
	 * Set the value related to the column: transaction_prefix
	 * @param transactionPrefix the transaction_prefix value
	 */
	public void setTransactionPrefix (java.lang.String transactionPrefix) {
		this.transactionPrefix = transactionPrefix;
	}



	/**
	 * Return the value associated with the column: transaction_postfix
	 */
	public java.lang.String getTransactionPostfix () {
		return transactionPostfix;
	}

	/**
	 * Set the value related to the column: transaction_postfix
	 * @param transactionPostfix the transaction_postfix value
	 */
	public void setTransactionPostfix (java.lang.String transactionPostfix) {
		this.transactionPostfix = transactionPostfix;
	}



	/**
	 * Return the value associated with the column: tablename
	 */
	public java.lang.String getTablename () {
		return tablename;
	}

	/**
	 * Set the value related to the column: tablename
	 * @param tablename the tablename value
	 */
	public void setTablename (java.lang.String tablename) {
		this.tablename = tablename;
	}



	/**
	 * Return the value associated with the column: createdby
	 */
	public java.lang.String getCreatedby () {
		return createdby;
	}

	/**
	 * Set the value related to the column: createdby
	 * @param createdby the createdby value
	 */
	public void setCreatedby (java.lang.String createdby) {
		this.createdby = createdby;
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
	 * Return the value associated with the column: service_type_id
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType () {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * @param serviceType the service_type_id value
	 */
	public void setServiceType (jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
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
	 * Return the value associated with the column: financial_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFinancial () {
		return financial;
	}

	/**
	 * Set the value related to the column: financial_id
	 * @param financial the financial_id value
	 */
	public void setFinancial (jkt.hms.masters.business.MasStoreFinancial financial) {
		this.financial = financial;
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
	 * Return the value associated with the column: division_id
	 */
	public jkt.hms.masters.business.MasDivision getDivision () {
		return division;
	}

	/**
	 * Set the value related to the column: division_id
	 * @param division the division_id value
	 */
	public void setDivision (jkt.hms.masters.business.MasDivision division) {
		this.division = division;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.TransactionSequence)) return false;
		else {
			jkt.hms.masters.business.TransactionSequence transactionSequence = (jkt.hms.masters.business.TransactionSequence) obj;
			if (null == this.getId() || null == transactionSequence.getId()) return false;
			else return (this.getId().equals(transactionSequence.getId()));
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