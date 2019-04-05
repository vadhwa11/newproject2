package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_qa_option_value table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_qa_option_value"
 */

public abstract class BaseMasQaOptionValue  implements Serializable {

	public static String REF = "MasQaOptionValue";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_QA_OPTION_VALUE_NAME = "QaOptionValueName";
	public static String PROP_OPTION_S_NO = "OptionSNo";
	public static String PROP_QA_OPTION_VALUE_CODE = "QaOptionValueCode";
	public static String PROP_QUESTION = "Question";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasQaOptionValue () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasQaOptionValue (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer optionSNo;
	private java.lang.String qaOptionValueCode;
	private java.lang.String qaOptionValueName;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.OpdQaMaster question;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdQaTransation> opdQaTransations;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="qa_option_value_id"
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
	 * Return the value associated with the column: option_s_no
	 */
	public java.lang.Integer getOptionSNo () {
		return optionSNo;
	}

	/**
	 * Set the value related to the column: option_s_no
	 * @param optionSNo the option_s_no value
	 */
	public void setOptionSNo (java.lang.Integer optionSNo) {
		this.optionSNo = optionSNo;
	}



	/**
	 * Return the value associated with the column: qa_option_value_code
	 */
	public java.lang.String getQaOptionValueCode () {
		return qaOptionValueCode;
	}

	/**
	 * Set the value related to the column: qa_option_value_code
	 * @param qaOptionValueCode the qa_option_value_code value
	 */
	public void setQaOptionValueCode (java.lang.String qaOptionValueCode) {
		this.qaOptionValueCode = qaOptionValueCode;
	}



	/**
	 * Return the value associated with the column: qa_option_value_name
	 */
	public java.lang.String getQaOptionValueName () {
		return qaOptionValueName;
	}

	/**
	 * Set the value related to the column: qa_option_value_name
	 * @param qaOptionValueName the qa_option_value_name value
	 */
	public void setQaOptionValueName (java.lang.String qaOptionValueName) {
		this.qaOptionValueName = qaOptionValueName;
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
	 * Return the value associated with the column: question_id
	 */
	public jkt.hms.masters.business.OpdQaMaster getQuestion () {
		return question;
	}

	/**
	 * Set the value related to the column: question_id
	 * @param question the question_id value
	 */
	public void setQuestion (jkt.hms.masters.business.OpdQaMaster question) {
		this.question = question;
	}



	/**
	 * Return the value associated with the column: OpdQaTransations
	 */
	public java.util.Set<jkt.hms.masters.business.OpdQaTransation> getOpdQaTransations () {
		return opdQaTransations;
	}

	/**
	 * Set the value related to the column: OpdQaTransations
	 * @param opdQaTransations the OpdQaTransations value
	 */
	public void setOpdQaTransations (java.util.Set<jkt.hms.masters.business.OpdQaTransation> opdQaTransations) {
		this.opdQaTransations = opdQaTransations;
	}

	public void addToOpdQaTransations (jkt.hms.masters.business.OpdQaTransation opdQaTransation) {
		if (null == getOpdQaTransations()) setOpdQaTransations(new java.util.TreeSet<jkt.hms.masters.business.OpdQaTransation>());
		getOpdQaTransations().add(opdQaTransation);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasQaOptionValue)) return false;
		else {
			jkt.hms.masters.business.MasQaOptionValue masQaOptionValue = (jkt.hms.masters.business.MasQaOptionValue) obj;
			if (null == this.getId() || null == masQaOptionValue.getId()) return false;
			else return (this.getId().equals(masQaOptionValue.getId()));
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