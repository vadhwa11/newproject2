package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DIFFERENTIAL_DIAGNOSIS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DIFFERENTIAL_DIAGNOSIS"
 */

public abstract class BaseDifferentialDiagnosis  implements Serializable {

	public static String REF = "DifferentialDiagnosis";
	public static String PROP_GROUPID = "Groupid";
	public static String PROP_INTENSITYID = "Intensityid";
	public static String PROP_CONDITION_CODE = "ConditionCode";
	public static String PROP_PARENTID = "Parentid";
	public static String PROP_PROCESS2SORTORDER = "Process2sortorder";
	public static String PROP_FREQUENCYID = "Frequencyid";
	public static String PROP_CONDITION_TERM = "ConditionTerm";
	public static String PROP_ATTRIB_CODE = "AttribCode";
	public static String PROP_DISEASETYPESORTORDER = "Diseasetypesortorder";
	public static String PROP_GROUPSORTORDER = "Groupsortorder";
	public static String PROP_LABELS_TERM = "LabelsTerm";
	public static String PROP_PROCESSSORTORDER = "Processsortorder";
	public static String PROP_LEVELID = "Levelid";
	public static String PROP_PROCESS1SORTORDER = "Process1sortorder";
	public static String PROP_PROCESS2ID = "Process2id";
	public static String PROP_CONDITION_CONDITIONID = "ConditionConditionid";
	public static String PROP_BODYPARTID = "Bodypartid";
	public static String PROP_PROCESSID = "Processid";
	public static String PROP_BODYPARTSORTORDER = "Bodypartsortorder";
	public static String PROP_ATTRIB_TERM = "AttribTerm";
	public static String PROP_ATTRIB_ATTRIBID = "AttribAttribid";
	public static String PROP_ID = "Id";
	public static String PROP_TERMID = "Termid";
	public static String PROP_PROCESS1ID = "Process1id";


	// constructors
	public BaseDifferentialDiagnosis () {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDifferentialDiagnosis (
		java.lang.Integer id) {

		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.Integer id;
	private java.lang.Integer termid;
	private java.lang.String labelsTerm;
	private java.lang.Integer attribAttribid;
	private java.lang.String attribTerm;
	private java.lang.Integer conditionConditionid;
	private java.lang.String conditionTerm;
	private java.lang.String attribCode;
	private java.lang.Integer groupid;
	private java.lang.Integer processid;
	private java.lang.Integer process1id;
	private java.lang.Integer process2id;
	private java.lang.Integer bodypartid;
	private java.lang.Integer groupsortorder;
	private java.lang.Integer processsortorder;
	private java.lang.Integer process1sortorder;
	private java.lang.Integer process2sortorder;
	private java.lang.Integer bodypartsortorder;
	private java.lang.Integer parentid;
	private java.lang.Integer intensityid;
	private java.lang.Integer levelid;
	private java.lang.Integer frequencyid;
	private java.lang.String conditionCode;
	private java.lang.Integer diseasetypesortorder;






	/**
	 * Return the value associated with the column: ID
	 */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the value related to the column: ID
	 * @param id the ID value
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: TERMID
	 */
	public java.lang.Integer getTermid () {
		return termid;
	}

	/**
	 * Set the value related to the column: TERMID
	 * @param termid the TERMID value
	 */
	public void setTermid (java.lang.Integer termid) {
		this.termid = termid;
	}



	/**
	 * Return the value associated with the column: LABELS_TERM
	 */
	public java.lang.String getLabelsTerm () {
		return labelsTerm;
	}

	/**
	 * Set the value related to the column: LABELS_TERM
	 * @param labelsTerm the LABELS_TERM value
	 */
	public void setLabelsTerm (java.lang.String labelsTerm) {
		this.labelsTerm = labelsTerm;
	}



	/**
	 * Return the value associated with the column: ATTRIB_ATTRIBID
	 */
	public java.lang.Integer getAttribAttribid () {
		return attribAttribid;
	}

	/**
	 * Set the value related to the column: ATTRIB_ATTRIBID
	 * @param attribAttribid the ATTRIB_ATTRIBID value
	 */
	public void setAttribAttribid (java.lang.Integer attribAttribid) {
		this.attribAttribid = attribAttribid;
	}



	/**
	 * Return the value associated with the column: ATTRIB_TERM
	 */
	public java.lang.String getAttribTerm () {
		return attribTerm;
	}

	/**
	 * Set the value related to the column: ATTRIB_TERM
	 * @param attribTerm the ATTRIB_TERM value
	 */
	public void setAttribTerm (java.lang.String attribTerm) {
		this.attribTerm = attribTerm;
	}



	/**
	 * Return the value associated with the column: CONDITION_CONDITIONID
	 */
	public java.lang.Integer getConditionConditionid () {
		return conditionConditionid;
	}

	/**
	 * Set the value related to the column: CONDITION_CONDITIONID
	 * @param conditionConditionid the CONDITION_CONDITIONID value
	 */
	public void setConditionConditionid (java.lang.Integer conditionConditionid) {
		this.conditionConditionid = conditionConditionid;
	}



	/**
	 * Return the value associated with the column: CONDITION_TERM
	 */
	public java.lang.String getConditionTerm () {
		return conditionTerm;
	}

	/**
	 * Set the value related to the column: CONDITION_TERM
	 * @param conditionTerm the CONDITION_TERM value
	 */
	public void setConditionTerm (java.lang.String conditionTerm) {
		this.conditionTerm = conditionTerm;
	}



	/**
	 * Return the value associated with the column: ATTRIB_CODE
	 */
	public java.lang.String getAttribCode () {
		return attribCode;
	}

	/**
	 * Set the value related to the column: ATTRIB_CODE
	 * @param attribCode the ATTRIB_CODE value
	 */
	public void setAttribCode (java.lang.String attribCode) {
		this.attribCode = attribCode;
	}



	/**
	 * Return the value associated with the column: GROUPID
	 */
	public java.lang.Integer getGroupid () {
		return groupid;
	}

	/**
	 * Set the value related to the column: GROUPID
	 * @param groupid the GROUPID value
	 */
	public void setGroupid (java.lang.Integer groupid) {
		this.groupid = groupid;
	}



	/**
	 * Return the value associated with the column: PROCESSID
	 */
	public java.lang.Integer getProcessid () {
		return processid;
	}

	/**
	 * Set the value related to the column: PROCESSID
	 * @param processid the PROCESSID value
	 */
	public void setProcessid (java.lang.Integer processid) {
		this.processid = processid;
	}



	/**
	 * Return the value associated with the column: PROCESS1ID
	 */
	public java.lang.Integer getProcess1id () {
		return process1id;
	}

	/**
	 * Set the value related to the column: PROCESS1ID
	 * @param process1id the PROCESS1ID value
	 */
	public void setProcess1id (java.lang.Integer process1id) {
		this.process1id = process1id;
	}



	/**
	 * Return the value associated with the column: PROCESS2ID
	 */
	public java.lang.Integer getProcess2id () {
		return process2id;
	}

	/**
	 * Set the value related to the column: PROCESS2ID
	 * @param process2id the PROCESS2ID value
	 */
	public void setProcess2id (java.lang.Integer process2id) {
		this.process2id = process2id;
	}



	/**
	 * Return the value associated with the column: BODYPARTID
	 */
	public java.lang.Integer getBodypartid () {
		return bodypartid;
	}

	/**
	 * Set the value related to the column: BODYPARTID
	 * @param bodypartid the BODYPARTID value
	 */
	public void setBodypartid (java.lang.Integer bodypartid) {
		this.bodypartid = bodypartid;
	}



	/**
	 * Return the value associated with the column: GROUPSORTORDER
	 */
	public java.lang.Integer getGroupsortorder () {
		return groupsortorder;
	}

	/**
	 * Set the value related to the column: GROUPSORTORDER
	 * @param groupsortorder the GROUPSORTORDER value
	 */
	public void setGroupsortorder (java.lang.Integer groupsortorder) {
		this.groupsortorder = groupsortorder;
	}



	/**
	 * Return the value associated with the column: PROCESSSORTORDER
	 */
	public java.lang.Integer getProcesssortorder () {
		return processsortorder;
	}

	/**
	 * Set the value related to the column: PROCESSSORTORDER
	 * @param processsortorder the PROCESSSORTORDER value
	 */
	public void setProcesssortorder (java.lang.Integer processsortorder) {
		this.processsortorder = processsortorder;
	}



	/**
	 * Return the value associated with the column: PROCESS1SORTORDER
	 */
	public java.lang.Integer getProcess1sortorder () {
		return process1sortorder;
	}

	/**
	 * Set the value related to the column: PROCESS1SORTORDER
	 * @param process1sortorder the PROCESS1SORTORDER value
	 */
	public void setProcess1sortorder (java.lang.Integer process1sortorder) {
		this.process1sortorder = process1sortorder;
	}



	/**
	 * Return the value associated with the column: PROCESS2SORTORDER
	 */
	public java.lang.Integer getProcess2sortorder () {
		return process2sortorder;
	}

	/**
	 * Set the value related to the column: PROCESS2SORTORDER
	 * @param process2sortorder the PROCESS2SORTORDER value
	 */
	public void setProcess2sortorder (java.lang.Integer process2sortorder) {
		this.process2sortorder = process2sortorder;
	}



	/**
	 * Return the value associated with the column: BODYPARTSORTORDER
	 */
	public java.lang.Integer getBodypartsortorder () {
		return bodypartsortorder;
	}

	/**
	 * Set the value related to the column: BODYPARTSORTORDER
	 * @param bodypartsortorder the BODYPARTSORTORDER value
	 */
	public void setBodypartsortorder (java.lang.Integer bodypartsortorder) {
		this.bodypartsortorder = bodypartsortorder;
	}



	/**
	 * Return the value associated with the column: PARENTID
	 */
	public java.lang.Integer getParentid () {
		return parentid;
	}

	/**
	 * Set the value related to the column: PARENTID
	 * @param parentid the PARENTID value
	 */
	public void setParentid (java.lang.Integer parentid) {
		this.parentid = parentid;
	}



	/**
	 * Return the value associated with the column: INTENSITYID
	 */
	public java.lang.Integer getIntensityid () {
		return intensityid;
	}

	/**
	 * Set the value related to the column: INTENSITYID
	 * @param intensityid the INTENSITYID value
	 */
	public void setIntensityid (java.lang.Integer intensityid) {
		this.intensityid = intensityid;
	}



	/**
	 * Return the value associated with the column: LEVELID
	 */
	public java.lang.Integer getLevelid () {
		return levelid;
	}

	/**
	 * Set the value related to the column: LEVELID
	 * @param levelid the LEVELID value
	 */
	public void setLevelid (java.lang.Integer levelid) {
		this.levelid = levelid;
	}



	/**
	 * Return the value associated with the column: FREQUENCYID
	 */
	public java.lang.Integer getFrequencyid () {
		return frequencyid;
	}

	/**
	 * Set the value related to the column: FREQUENCYID
	 * @param frequencyid the FREQUENCYID value
	 */
	public void setFrequencyid (java.lang.Integer frequencyid) {
		this.frequencyid = frequencyid;
	}



	/**
	 * Return the value associated with the column: CONDITION_CODE
	 */
	public java.lang.String getConditionCode () {
		return conditionCode;
	}

	/**
	 * Set the value related to the column: CONDITION_CODE
	 * @param conditionCode the CONDITION_CODE value
	 */
	public void setConditionCode (java.lang.String conditionCode) {
		this.conditionCode = conditionCode;
	}



	/**
	 * Return the value associated with the column: DISEASETYPESORTORDER
	 */
	public java.lang.Integer getDiseasetypesortorder () {
		return diseasetypesortorder;
	}

	/**
	 * Set the value related to the column: DISEASETYPESORTORDER
	 * @param diseasetypesortorder the DISEASETYPESORTORDER value
	 */
	public void setDiseasetypesortorder (java.lang.Integer diseasetypesortorder) {
		this.diseasetypesortorder = diseasetypesortorder;
	}







	public String toString () {
		return super.toString();
	}


}