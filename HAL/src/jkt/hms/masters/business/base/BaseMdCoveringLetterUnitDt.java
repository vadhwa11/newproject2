package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * md_covering_letter_unit_dt table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="md_covering_letter_unit_dt"
 */

public abstract class BaseMdCoveringLetterUnitDt implements Serializable {

	public static String REF = "MdCoveringLetterUnitDt";
	public static String PROP_COVERING_HD = "CoveringHd";
	public static String PROP_DISPATCH = "Dispatch";
	public static String PROP_CONTINGENT_HD = "ContingentHd";
	public static String PROP_HIN = "Hin";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMdCoveringLetterUnitDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdCoveringLetterUnitDt(java.lang.Integer id) {
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
	private jkt.hms.masters.business.MdContigentMedicalBillHd contingentHd;
	private jkt.hms.masters.business.MdCoveringLetterUnitHd coveringHd;
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
	 * Return the value associated with the column: contingent_hd_id
	 */
	public jkt.hms.masters.business.MdContigentMedicalBillHd getContingentHd() {
		return contingentHd;
	}

	/**
	 * Set the value related to the column: contingent_hd_id
	 * 
	 * @param contingentHd
	 *            the contingent_hd_id value
	 */
	public void setContingentHd(
			jkt.hms.masters.business.MdContigentMedicalBillHd contingentHd) {
		this.contingentHd = contingentHd;
	}

	/**
	 * Return the value associated with the column: covering_hd_id
	 */
	public jkt.hms.masters.business.MdCoveringLetterUnitHd getCoveringHd() {
		return coveringHd;
	}

	/**
	 * Set the value related to the column: covering_hd_id
	 * 
	 * @param coveringHd
	 *            the covering_hd_id value
	 */
	public void setCoveringHd(
			jkt.hms.masters.business.MdCoveringLetterUnitHd coveringHd) {
		this.coveringHd = coveringHd;
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
		if (!(obj instanceof jkt.hms.masters.business.MdCoveringLetterUnitDt))
			return false;
		else {
			jkt.hms.masters.business.MdCoveringLetterUnitDt mdCoveringLetterUnitDt = (jkt.hms.masters.business.MdCoveringLetterUnitDt) obj;
			if (null == this.getId() || null == mdCoveringLetterUnitDt.getId())
				return false;
			else
				return (this.getId().equals(mdCoveringLetterUnitDt.getId()));
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