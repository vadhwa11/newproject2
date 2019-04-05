package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_transaction_type
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_transaction_type"
 */

public abstract class BaseMasTransactionType implements Serializable {

	public static String REF = "MasTransactionType";
	public static String PROP_STATUS = "Status";
	public static String PROP_TRANSACTION_TYPE_CODE = "TransactionTypeCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TRANSACTION_TYPE_NAME = "TransactionTypeName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasTransactionType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasTransactionType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasTransactionType(java.lang.Integer id, java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String transactionTypeCode;
	private java.lang.String transactionTypeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="transaction_type_id"
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
	 * Return the value associated with the column: transaction_type_code
	 */
	public java.lang.String getTransactionTypeCode() {
		return transactionTypeCode;
	}

	/**
	 * Set the value related to the column: transaction_type_code
	 * 
	 * @param transactionTypeCode
	 *            the transaction_type_code value
	 */
	public void setTransactionTypeCode(java.lang.String transactionTypeCode) {
		this.transactionTypeCode = transactionTypeCode;
	}

	/**
	 * Return the value associated with the column: transaction_type_name
	 */
	public java.lang.String getTransactionTypeName() {
		return transactionTypeName;
	}

	/**
	 * Set the value related to the column: transaction_type_name
	 * 
	 * @param transactionTypeName
	 *            the transaction_type_name value
	 */
	public void setTransactionTypeName(java.lang.String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasTransactionType))
			return false;
		else {
			jkt.hms.masters.business.MasTransactionType masTransactionType = (jkt.hms.masters.business.MasTransactionType) obj;
			if (null == this.getId() || null == masTransactionType.getId())
				return false;
			else
				return (this.getId().equals(masTransactionType.getId()));
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