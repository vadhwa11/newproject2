package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_proposed_m_p_r table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_proposed_m_p_r"
 */

public abstract class BaseMasProposedMPR  implements Serializable {

	public static String REF = "MasProposedMPR";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PROPOSED_M_P_R_NAME = "ProposedMPRName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PROPOSED_M_P_R_CODE = "ProposedMPRCode";


	// constructors
	public BaseMasProposedMPR () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasProposedMPR (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String proposedMPRCode;
	private java.lang.String proposedMPRName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="proposed_m_p_r_id"
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
	 * Return the value associated with the column: proposed_m_p_r_code
	 */
	public java.lang.String getProposedMPRCode () {
		return proposedMPRCode;
	}

	/**
	 * Set the value related to the column: proposed_m_p_r_code
	 * @param proposedMPRCode the proposed_m_p_r_code value
	 */
	public void setProposedMPRCode (java.lang.String proposedMPRCode) {
		this.proposedMPRCode = proposedMPRCode;
	}



	/**
	 * Return the value associated with the column: proposed_m_p_r_name
	 */
	public java.lang.String getProposedMPRName () {
		return proposedMPRName;
	}

	/**
	 * Set the value related to the column: proposed_m_p_r_name
	 * @param proposedMPRName the proposed_m_p_r_name value
	 */
	public void setProposedMPRName (java.lang.String proposedMPRName) {
		this.proposedMPRName = proposedMPRName;
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
		if (!(obj instanceof jkt.hms.masters.business.MasProposedMPR)) return false;
		else {
			jkt.hms.masters.business.MasProposedMPR masProposedMPR = (jkt.hms.masters.business.MasProposedMPR) obj;
			if (null == this.getId() || null == masProposedMPR.getId()) return false;
			else return (this.getId().equals(masProposedMPR.getId()));
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