package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * blood_transfussion_reaction_dt table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="blood_transfussion_reaction_dt"
 */

public abstract class BaseBloodTransfussionReactionDt implements Serializable {

	public static String REF = "BloodTransfussionReactionDt";
	public static String PROP_RESULT = "Result";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_ID = "Id";
	public static String PROP_TRANSFUSION_HD = "TransfusionHd";

	// constructors
	public BaseBloodTransfussionReactionDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodTransfussionReactionDt(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String result;

	// many to one
	private jkt.hms.masters.business.BloodTransfussionReactionHd transfusionHd;
	private jkt.hms.masters.business.DgMasInvestigation investigation;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: result
	 */
	public java.lang.String getResult() {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * 
	 * @param result
	 *            the result value
	 */
	public void setResult(java.lang.String result) {
		this.result = result;
	}

	/**
	 * Return the value associated with the column: transfusion_hd_id
	 */
	public jkt.hms.masters.business.BloodTransfussionReactionHd getTransfusionHd() {
		return transfusionHd;
	}

	/**
	 * Set the value related to the column: transfusion_hd_id
	 * 
	 * @param transfusionHd
	 *            the transfusion_hd_id value
	 */
	public void setTransfusionHd(
			jkt.hms.masters.business.BloodTransfussionReactionHd transfusionHd) {
		this.transfusionHd = transfusionHd;
	}

	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation() {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * 
	 * @param investigation
	 *            the investigation_id value
	 */
	public void setInvestigation(
			jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodTransfussionReactionDt))
			return false;
		else {
			jkt.hms.masters.business.BloodTransfussionReactionDt bloodTransfussionReactionDt = (jkt.hms.masters.business.BloodTransfussionReactionDt) obj;
			if (null == this.getId()
					|| null == bloodTransfussionReactionDt.getId())
				return false;
			else
				return (this.getId()
						.equals(bloodTransfussionReactionDt.getId()));
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