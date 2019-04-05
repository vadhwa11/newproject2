package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the md_general_covering_dt
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="md_general_covering_dt"
 */

public abstract class BaseMdGeneralCoveringDt implements Serializable {

	public static String REF = "MdGeneralCoveringDt";
	public static String PROP_DISPATCH = "Dispatch";
	public static String PROP_GENERAL_HD = "GeneralHd";
	public static String PROP_CONINGENT_HD = "ConingentHd";
	public static String PROP_HIN = "Hin";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMdGeneralCoveringDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdGeneralCoveringDt(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dispatch;

	// many to one
	private jkt.hms.masters.business.MdContigentMedicalBillHd coningentHd;
	private jkt.hms.masters.business.MdGeneralCoveringHd generalHd;
	private jkt.hms.masters.business.Patient hin;

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
	 * Return the value associated with the column: dispatch
	 */
	public java.lang.String getDispatch() {
		return dispatch;
	}

	/**
	 * Set the value related to the column: dispatch
	 * 
	 * @param dispatch
	 *            the dispatch value
	 */
	public void setDispatch(java.lang.String dispatch) {
		this.dispatch = dispatch;
	}

	/**
	 * Return the value associated with the column: coningent_hd_id
	 */
	public jkt.hms.masters.business.MdContigentMedicalBillHd getConingentHd() {
		return coningentHd;
	}

	/**
	 * Set the value related to the column: coningent_hd_id
	 * 
	 * @param coningentHd
	 *            the coningent_hd_id value
	 */
	public void setConingentHd(
			jkt.hms.masters.business.MdContigentMedicalBillHd coningentHd) {
		this.coningentHd = coningentHd;
	}

	/**
	 * Return the value associated with the column: general_hd_id
	 */
	public jkt.hms.masters.business.MdGeneralCoveringHd getGeneralHd() {
		return generalHd;
	}

	/**
	 * Set the value related to the column: general_hd_id
	 * 
	 * @param generalHd
	 *            the general_hd_id value
	 */
	public void setGeneralHd(
			jkt.hms.masters.business.MdGeneralCoveringHd generalHd) {
		this.generalHd = generalHd;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MdGeneralCoveringDt))
			return false;
		else {
			jkt.hms.masters.business.MdGeneralCoveringDt mdGeneralCoveringDt = (jkt.hms.masters.business.MdGeneralCoveringDt) obj;
			if (null == this.getId() || null == mdGeneralCoveringDt.getId())
				return false;
			else
				return (this.getId().equals(mdGeneralCoveringDt.getId()));
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