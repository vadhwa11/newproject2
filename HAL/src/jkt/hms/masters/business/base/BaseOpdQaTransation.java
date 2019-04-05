package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_qa_transation table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_qa_transation"
 */

public abstract class BaseOpdQaTransation  implements Serializable {

	public static String REF = "OpdQaTransation";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_QUESTION = "Question";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ANSWER_OPTION = "AnswerOption";


	// constructors
	public BaseOpdQaTransation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdQaTransation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasQaOptionValue answerOption;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.OpdQaMaster question;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;



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
	 * Return the value associated with the column: answer_option_id
	 */
	public jkt.hms.masters.business.MasQaOptionValue getAnswerOption () {
		return answerOption;
	}

	/**
	 * Set the value related to the column: answer_option_id
	 * @param answerOption the answer_option_id value
	 */
	public void setAnswerOption (jkt.hms.masters.business.MasQaOptionValue answerOption) {
		this.answerOption = answerOption;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdQaTransation)) return false;
		else {
			jkt.hms.masters.business.OpdQaTransation opdQaTransation = (jkt.hms.masters.business.OpdQaTransation) obj;
			if (null == this.getId() || null == opdQaTransation.getId()) return false;
			else return (this.getId().equals(opdQaTransation.getId()));
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