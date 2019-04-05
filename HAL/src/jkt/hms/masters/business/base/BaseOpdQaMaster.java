package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_qa_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_qa_master"
 */

public abstract class BaseOpdQaMaster  implements Serializable {

	public static String REF = "OpdQaMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OPTION_VALUE = "OptionValue";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_QUESTION = "Question";
	public static String PROP_ID = "Id";
	public static String PROP_QUESTION_HEADING = "QuestionHeading";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseOpdQaMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdQaMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String question;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Integer optionValue;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasQuestionHeading questionHeading;



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
	 * Return the value associated with the column: question
	 */
	public java.lang.String getQuestion () {
		return question;
	}

	/**
	 * Set the value related to the column: question
	 * @param question the question value
	 */
	public void setQuestion (java.lang.String question) {
		this.question = question;
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
	 * Return the value associated with the column: option_value
	 */
	public java.lang.Integer getOptionValue () {
		return optionValue;
	}

	/**
	 * Set the value related to the column: option_value
	 * @param optionValue the option_value value
	 */
	public void setOptionValue (java.lang.Integer optionValue) {
		this.optionValue = optionValue;
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
	 * Return the value associated with the column: question_heading_id
	 */
	public jkt.hms.masters.business.MasQuestionHeading getQuestionHeading () {
		return questionHeading;
	}

	/**
	 * Set the value related to the column: question_heading_id
	 * @param questionHeading the question_heading_id value
	 */
	public void setQuestionHeading (jkt.hms.masters.business.MasQuestionHeading questionHeading) {
		this.questionHeading = questionHeading;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdQaMaster)) return false;
		else {
			jkt.hms.masters.business.OpdQaMaster opdQaMaster = (jkt.hms.masters.business.OpdQaMaster) obj;
			if (null == this.getId() || null == opdQaMaster.getId()) return false;
			else return (this.getId().equals(opdQaMaster.getId()));
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