package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_question_heading table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_question_heading"
 */

public abstract class BaseMasQuestionHeading  implements Serializable {

	public static String REF = "MasQuestionHeading";
	public static String PROP_STATUS = "Status";
	public static String PROP_QUESTION_HEADING_NAME = "QuestionHeadingName";
	public static String PROP_QUESTION_HEADING_CODE = "QuestionHeadingCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasQuestionHeading () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasQuestionHeading (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String questionHeadingCode;
	private java.lang.String questionHeadingName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="question_heading_id"
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
	 * Return the value associated with the column: question_heading_code
	 */
	public java.lang.String getQuestionHeadingCode () {
		return questionHeadingCode;
	}

	/**
	 * Set the value related to the column: question_heading_code
	 * @param questionHeadingCode the question_heading_code value
	 */
	public void setQuestionHeadingCode (java.lang.String questionHeadingCode) {
		this.questionHeadingCode = questionHeadingCode;
	}



	/**
	 * Return the value associated with the column: question_heading_name
	 */
	public java.lang.String getQuestionHeadingName () {
		return questionHeadingName;
	}

	/**
	 * Set the value related to the column: question_heading_name
	 * @param questionHeadingName the question_heading_name value
	 */
	public void setQuestionHeadingName (java.lang.String questionHeadingName) {
		this.questionHeadingName = questionHeadingName;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasQuestionHeading)) return false;
		else {
			jkt.hms.masters.business.MasQuestionHeading masQuestionHeading = (jkt.hms.masters.business.MasQuestionHeading) obj;
			if (null == this.getId() || null == masQuestionHeading.getId()) return false;
			else return (this.getId().equals(masQuestionHeading.getId()));
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