package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * mb_result_of_appeal_medicalboard_unfit_expl table. Do not modify this class
 * because it will be overwritten if the configuration file related to this
 * class is modified.
 * 
 * @hibernate.class table="mb_result_of_appeal_medicalboard_unfit_expl"
 */

public abstract class BaseMbResultOfAppealMedicalboardUnfitExpl implements
		Serializable {

	public static String REF = "MbResultOfAppealMedicalboardUnfitExpl";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RESULT_OF_APPEAL_MEDICALBOARD_UNFIT_EXPL = "ResultOfAppealMedicalboardUnfitExpl";
	public static String PROP_UNFIT_EXPLANATION = "UnfitExplanation";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SR_NO = "SrNo";

	// constructors
	public BaseMbResultOfAppealMedicalboardUnfitExpl() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMbResultOfAppealMedicalboardUnfitExpl(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String unfitExplanation;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster resultOfAppealMedicalboardUnfitExpl;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="result_of_appeal_medicalboard_unfit_expl_id"
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
	 * Return the value associated with the column: unfit_explanation
	 */
	public java.lang.String getUnfitExplanation() {
		return unfitExplanation;
	}

	/**
	 * Set the value related to the column: unfit_explanation
	 * 
	 * @param unfitExplanation
	 *            the unfit_explanation value
	 */
	public void setUnfitExplanation(java.lang.String unfitExplanation) {
		this.unfitExplanation = unfitExplanation;
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

	/**
	 * Return the value associated with the column:
	 * result_of_appeal_medicalboard_unfit_expl
	 */
	public jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster getResultOfAppealMedicalboardUnfitExpl() {
		return resultOfAppealMedicalboardUnfitExpl;
	}

	/**
	 * Set the value related to the column:
	 * result_of_appeal_medicalboard_unfit_expl
	 * 
	 * @param resultOfAppealMedicalboardUnfitExpl
	 *            the result_of_appeal_medicalboard_unfit_expl value
	 */
	public void setResultOfAppealMedicalboardUnfitExpl(
			jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster resultOfAppealMedicalboardUnfitExpl) {
		this.resultOfAppealMedicalboardUnfitExpl = resultOfAppealMedicalboardUnfitExpl;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl))
			return false;
		else {
			jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl mbResultOfAppealMedicalboardUnfitExpl = (jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl) obj;
			if (null == this.getId()
					|| null == mbResultOfAppealMedicalboardUnfitExpl.getId())
				return false;
			else
				return (this.getId()
						.equals(mbResultOfAppealMedicalboardUnfitExpl.getId()));
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