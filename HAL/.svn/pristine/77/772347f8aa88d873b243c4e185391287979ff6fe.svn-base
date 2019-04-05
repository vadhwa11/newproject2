package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the annual_medical_examination table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="annual_medical_examination"
 */

public abstract class BaseAnnualMediacalExamination  implements Serializable {

	public static String REF = "AnnualMediacalExamination";
	public static String PROP_PERIOD = "Period";
	public static String PROP_LAST_BOARD = "LastBoard";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_AFMSF_DET = "AfmsfDet";
	public static String PROP_STATUS = "Status";
	public static String PROP_CONDIATION_STATUS = "CondiationStatus";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_NEXT_REVIEW = "NextReview";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_LAST_BOARD_AT = "LastBoardAt";


	// constructors
	public BaseAnnualMediacalExamination () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAnnualMediacalExamination (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date nextReview;
	private java.util.Date lastBoard;
	private java.lang.String status;
	private java.lang.String condiationStatus;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String period;
	private java.lang.String duration;

	// many to one
	private jkt.hms.masters.business.EmpAfmsfDet afmsfDet;
	private jkt.hms.masters.business.MasMedicalCategory category;
	private jkt.hms.masters.business.MasUnit lastBoardAt;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ame_id"
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
	 * Return the value associated with the column: next_review
	 */
	public java.util.Date getNextReview () {
		return nextReview;
	}

	/**
	 * Set the value related to the column: next_review
	 * @param nextReview the next_review value
	 */
	public void setNextReview (java.util.Date nextReview) {
		this.nextReview = nextReview;
	}



	/**
	 * Return the value associated with the column: last_board
	 */
	public java.util.Date getLastBoard () {
		return lastBoard;
	}

	/**
	 * Set the value related to the column: last_board
	 * @param lastBoard the last_board value
	 */
	public void setLastBoard (java.util.Date lastBoard) {
		this.lastBoard = lastBoard;
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
	 * Return the value associated with the column: condition_status
	 */
	public java.lang.String getCondiationStatus () {
		return condiationStatus;
	}

	/**
	 * Set the value related to the column: condition_status
	 * @param condiationStatus the condition_status value
	 */
	public void setCondiationStatus (java.lang.String condiationStatus) {
		this.condiationStatus = condiationStatus;
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
	 * Return the value associated with the column: period
	 */
	public java.lang.String getPeriod () {
		return period;
	}

	/**
	 * Set the value related to the column: period
	 * @param period the period value
	 */
	public void setPeriod (java.lang.String period) {
		this.period = period;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: emp_afmsf_det_id
	 */
	public jkt.hms.masters.business.EmpAfmsfDet getAfmsfDet () {
		return afmsfDet;
	}

	/**
	 * Set the value related to the column: emp_afmsf_det_id
	 * @param afmsfDet the emp_afmsf_det_id value
	 */
	public void setAfmsfDet (jkt.hms.masters.business.EmpAfmsfDet afmsfDet) {
		this.afmsfDet = afmsfDet;
	}



	/**
	 * Return the value associated with the column: category
	 */
	public jkt.hms.masters.business.MasMedicalCategory getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category
	 * @param category the category value
	 */
	public void setCategory (jkt.hms.masters.business.MasMedicalCategory category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: last_board_at
	 */
	public jkt.hms.masters.business.MasUnit getLastBoardAt () {
		return lastBoardAt;
	}

	/**
	 * Set the value related to the column: last_board_at
	 * @param lastBoardAt the last_board_at value
	 */
	public void setLastBoardAt (jkt.hms.masters.business.MasUnit lastBoardAt) {
		this.lastBoardAt = lastBoardAt;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AnnualMediacalExamination)) return false;
		else {
			jkt.hms.masters.business.AnnualMediacalExamination annualMediacalExamination = (jkt.hms.masters.business.AnnualMediacalExamination) obj;
			if (null == this.getId() || null == annualMediacalExamination.getId()) return false;
			else return (this.getId().equals(annualMediacalExamination.getId()));
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