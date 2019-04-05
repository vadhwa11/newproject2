package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ANSWER_FAQ table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ANSWER_FAQ"
 */

public abstract class BaseAnswerFaq  implements Serializable {

	public static String REF = "AnswerFaq";
	public static String PROP_ANSWER = "Answer";
	public static String PROP_LAST_CHANGE_BY = "LastChangeBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGE_DATE = "LastChangeDate";
	public static String PROP_GROUP_ID = "GroupId";
	public static String PROP_LAST_CHANGE_TIME = "LastChangeTime";


	// constructors
	public BaseAnswerFaq () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAnswerFaq (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String answer;
	private java.lang.String lastChangeBy;
	private java.util.Date lastChangeDate;
	private java.lang.String lastChangeTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.QuestionFaq groupId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="Answer_ID"
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
	 * Return the value associated with the column: ANSWER
	 */
	public java.lang.String getAnswer () {
		return answer;
	}

	/**
	 * Set the value related to the column: ANSWER
	 * @param answer the ANSWER value
	 */
	public void setAnswer (java.lang.String answer) {
		this.answer = answer;
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



	/**
	 * Return the value associated with the column: Group_id
	 */
	public jkt.hms.masters.business.QuestionFaq getGroupId () {
		return groupId;
	}

	/**
	 * Set the value related to the column: Group_id
	 * @param groupId the Group_id value
	 */
	public void setGroupId (jkt.hms.masters.business.QuestionFaq groupId) {
		this.groupId = groupId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AnswerFaq)) return false;
		else {
			jkt.hms.masters.business.AnswerFaq answerFaq = (jkt.hms.masters.business.AnswerFaq) obj;
			if (null == this.getId() || null == answerFaq.getId()) return false;
			else return (this.getId().equals(answerFaq.getId()));
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