package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * mas_medical_board_examination_detail table. Do not modify this class because
 * it will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="mas_medical_board_examination_detail"
 */

public abstract class BaseMasMedicalBoardExaminationDetail implements
		Serializable {

	public static String REF = "MasMedicalBoardExaminationDetail";
	public static String PROP_RELATION = "Relation";
	public static String PROP_AGE = "Age";
	public static String PROP_ID = "Id";
	public static String PROP_DIED = "Died";
	public static String PROP_HEALTH = "Health";
	public static String PROP_CAUSE_OF_DEATH = "CauseOfDeath";
	public static String PROP_MEDICAL_EXAMINATION = "MedicalExamination";
	public static String PROP_SR_NO = "SrNo";

	// constructors
	public BaseMasMedicalBoardExaminationDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMedicalBoardExaminationDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String age;
	private java.lang.String causeOfDeath;
	private java.lang.String died;
	private java.lang.String health;
	private java.lang.String relation;
	private java.lang.Integer srNo;
	private jkt.hms.masters.business.MasMedicalExaminationReportOnEntry medicalExamination;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="examination_detail_id"
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
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge() {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * 
	 * @param age
	 *            the age value
	 */
	public void setAge(java.lang.String age) {
		this.age = age;
	}

	/**
	 * Return the value associated with the column: cause_of_death
	 */
	public java.lang.String getCauseOfDeath() {
		return causeOfDeath;
	}

	/**
	 * Set the value related to the column: cause_of_death
	 * 
	 * @param causeOfDeath
	 *            the cause_of_death value
	 */
	public void setCauseOfDeath(java.lang.String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}

	/**
	 * Return the value associated with the column: died
	 */
	public java.lang.String getDied() {
		return died;
	}

	/**
	 * Set the value related to the column: died
	 * 
	 * @param died
	 *            the died value
	 */
	public void setDied(java.lang.String died) {
		this.died = died;
	}

	/**
	 * Return the value associated with the column: health
	 */
	public java.lang.String getHealth() {
		return health;
	}

	/**
	 * Set the value related to the column: health
	 * 
	 * @param health
	 *            the health value
	 */
	public void setHealth(java.lang.String health) {
		this.health = health;
	}

	/**
	 * Return the value associated with the column: relation
	 */
	public java.lang.String getRelation() {
		return relation;
	}

	/**
	 * Set the value related to the column: relation
	 * 
	 * @param relation
	 *            the relation value
	 */
	public void setRelation(java.lang.String relation) {
		this.relation = relation;
	}

	/**
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo() {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * 
	 * @param srNo
	 *            the sr_no value
	 */
	public void setSrNo(java.lang.Integer srNo) {
		this.srNo = srNo;
	}

	/**
	 * Return the value associated with the column: medical_examination_id
	 */
	public jkt.hms.masters.business.MasMedicalExaminationReportOnEntry getMedicalExamination() {
		return medicalExamination;
	}

	/**
	 * Set the value related to the column: medical_examination_id
	 * 
	 * @param medicalExamination
	 *            the medical_examination_id value
	 */
	public void setMedicalExamination(
			jkt.hms.masters.business.MasMedicalExaminationReportOnEntry medicalExamination) {
		this.medicalExamination = medicalExamination;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasMedicalBoardExaminationDetail))
			return false;
		else {
			jkt.hms.masters.business.MasMedicalBoardExaminationDetail masMedicalBoardExaminationDetail = (jkt.hms.masters.business.MasMedicalBoardExaminationDetail) obj;
			if (null == this.getId()
					|| null == masMedicalBoardExaminationDetail.getId())
				return false;
			else
				return (this.getId().equals(masMedicalBoardExaminationDetail
						.getId()));
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