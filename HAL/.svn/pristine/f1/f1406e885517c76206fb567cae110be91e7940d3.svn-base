package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the QUESTION_FAQ table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="QUESTION_FAQ"
 */

public abstract class BaseQuestionFaq  implements Serializable {

	public static String REF = "QuestionFaq";
	public static String PROP_QUESTION_NAME = "QuestionName";
	public static String PROP_LAST_CHANGE_BY = "LastChangeBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_QUESTION = "Question";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGE_DATE = "LastChangeDate";
	public static String PROP_MODULE_NAME = "ModuleName";
	public static String PROP_LAST_CHANGE_TIME = "LastChangeTime";


	// constructors
	public BaseQuestionFaq () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseQuestionFaq (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String questionName;
	private java.lang.String moduleName;
	private java.lang.String question;
	private java.lang.String lastChangeBy;
	private java.util.Date lastChangeDate;
	private java.lang.String lastChangeTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="Group_ID"
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
	 * Return the value associated with the column: Question_Name
	 */
	public java.lang.String getQuestionName () {
		return questionName;
	}

	/**
	 * Set the value related to the column: Question_Name
	 * @param questionName the Question_Name value
	 */
	public void setQuestionName (java.lang.String questionName) {
		this.questionName = questionName;
	}



	/**
	 * Return the value associated with the column: Module_Name
	 */
	public java.lang.String getModuleName () {
		return moduleName;
	}

	/**
	 * Set the value related to the column: Module_Name
	 * @param moduleName the Module_Name value
	 */
	public void setModuleName (java.lang.String moduleName) {
		this.moduleName = moduleName;
	}



	/**
	 * Return the value associated with the column: Question
	 */
	public java.lang.String getQuestion () {
		return question;
	}

	/**
	 * Set the value related to the column: Question
	 * @param question the Question value
	 */
	public void setQuestion (java.lang.String question) {
		this.question = question;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_BY
	 */
	public java.lang.String getLastChangeBy () {
		return lastChangeBy;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_BY
	 * @param lastChangeBy the LAST_CHANGE_BY value
	 */
	public void setLastChangeBy (java.lang.String lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_DATE
	 */
	public java.util.Date getLastChangeDate () {
		return lastChangeDate;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_DATE
	 * @param lastChangeDate the LAST_CHANGE_DATE value
	 */
	public void setLastChangeDate (java.util.Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_TIME
	 */
	public java.lang.String getLastChangeTime () {
		return lastChangeTime;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_TIME
	 * @param lastChangeTime the LAST_CHANGE_TIME value
	 */
	public void setLastChangeTime (java.lang.String lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.QuestionFaq)) return false;
		else {
			jkt.hms.masters.business.QuestionFaq questionFaq = (jkt.hms.masters.business.QuestionFaq) obj;
			if (null == this.getId() || null == questionFaq.getId()) return false;
			else return (this.getId().equals(questionFaq.getId()));
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