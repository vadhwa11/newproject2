package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_template_treatment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_template_treatment"
 */

public abstract class BaseOpdTemplateTreatment  implements Serializable {

	public static String REF = "OpdTemplateTreatment";
	public static String PROP_TEMPLATE = "Template";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_INSTRUCTION = "Instruction";
	public static String PROP_OPD_INSTRUCTION_TREATMENT = "OpdInstructionTreatment";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_DOSAGE = "Dosage";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_NOOFDAYS = "Noofdays";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_TOTAL = "Total";


	// constructors
	public BaseOpdTemplateTreatment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdTemplateTreatment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dosage;
	private java.lang.Integer noofdays;
	private java.lang.Integer total;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String instruction;

	// many to one
	private jkt.hms.masters.business.OpdInstructionTreatment opdInstructionTreatment;
	private jkt.hms.masters.business.OpdTemplate template;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasFrequency frequency;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="treatment_template_id"
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
	 * Return the value associated with the column: dosage
	 */
	public java.lang.String getDosage () {
		return dosage;
	}

	/**
	 * Set the value related to the column: dosage
	 * @param dosage the dosage value
	 */
	public void setDosage (java.lang.String dosage) {
		this.dosage = dosage;
	}



	/**
	 * Return the value associated with the column: noofdays
	 */
	public java.lang.Integer getNoofdays () {
		return noofdays;
	}

	/**
	 * Set the value related to the column: noofdays
	 * @param noofdays the noofdays value
	 */
	public void setNoofdays (java.lang.Integer noofdays) {
		this.noofdays = noofdays;
	}



	/**
	 * Return the value associated with the column: total
	 */
	public java.lang.Integer getTotal () {
		return total;
	}

	/**
	 * Set the value related to the column: total
	 * @param total the total value
	 */
	public void setTotal (java.lang.Integer total) {
		this.total = total;
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
	 * Return the value associated with the column: instruction
	 */
	public java.lang.String getInstruction () {
		return instruction;
	}

	/**
	 * Set the value related to the column: instruction
	 * @param instruction the instruction value
	 */
	public void setInstruction (java.lang.String instruction) {
		this.instruction = instruction;
	}



	/**
	 * Return the value associated with the column: opd_instruction_treatment_id
	 */
	public jkt.hms.masters.business.OpdInstructionTreatment getOpdInstructionTreatment () {
		return opdInstructionTreatment;
	}

	/**
	 * Set the value related to the column: opd_instruction_treatment_id
	 * @param opdInstructionTreatment the opd_instruction_treatment_id value
	 */
	public void setOpdInstructionTreatment (jkt.hms.masters.business.OpdInstructionTreatment opdInstructionTreatment) {
		this.opdInstructionTreatment = opdInstructionTreatment;
	}



	/**
	 * Return the value associated with the column: template_id
	 */
	public jkt.hms.masters.business.OpdTemplate getTemplate () {
		return template;
	}

	/**
	 * Set the value related to the column: template_id
	 * @param template the template_id value
	 */
	public void setTemplate (jkt.hms.masters.business.OpdTemplate template) {
		this.template = template;
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
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdTemplateTreatment)) return false;
		else {
			jkt.hms.masters.business.OpdTemplateTreatment opdTemplateTreatment = (jkt.hms.masters.business.OpdTemplateTreatment) obj;
			if (null == this.getId() || null == opdTemplateTreatment.getId()) return false;
			else return (this.getId().equals(opdTemplateTreatment.getId()));
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