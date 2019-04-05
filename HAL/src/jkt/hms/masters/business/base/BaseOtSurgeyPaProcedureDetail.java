package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * ot_surgey_pa_procedure_detail table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="ot_surgey_pa_procedure_detail"
 */

public abstract class BaseOtSurgeyPaProcedureDetail implements Serializable {

	public static String REF = "OtSurgeyPaProcedureDetail";
	public static String PROP_ITEM = "Item";
	public static String PROP_SURGEY_PA_PROCEDURE_DETAIL_LEVEL = "SurgeyPaProcedureDetailLevel";
	public static String PROP_SURGEY_PA_PROCEDURE_DETAIL_CATHETER = "SurgeyPaProcedureDetailCatheter";
	public static String PROP_SURGEY_PA_PROCEDURE_DETAIL_DOSA = "SurgeyPaProcedureDetailDosa";
	public static String PROP_OT_POST_ANAESTHESIA_PROCEDURE = "OtPostAnaesthesiaProcedure";
	public static String PROP_ID = "Id";
	public static String PROP_SURGEY_PA_PROCEDURE_DETAIL_ANESTHESIA = "SurgeyPaProcedureDetailAnesthesia";

	// constructors
	public BaseOtSurgeyPaProcedureDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtSurgeyPaProcedureDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String surgeyPaProcedureDetailLevel;
	private java.lang.String surgeyPaProcedureDetailAnesthesia;
	private java.lang.String surgeyPaProcedureDetailDosa;
	private java.lang.String surgeyPaProcedureDetailCatheter;

	// many to one
	private jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="surgey_pa_procedure_detail_id"
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
	 * Return the value associated with the column:
	 * surgey_pa_procedure_detail_level
	 */
	public java.lang.String getSurgeyPaProcedureDetailLevel() {
		return surgeyPaProcedureDetailLevel;
	}

	/**
	 * Set the value related to the column: surgey_pa_procedure_detail_level
	 * 
	 * @param surgeyPaProcedureDetailLevel
	 *            the surgey_pa_procedure_detail_level value
	 */
	public void setSurgeyPaProcedureDetailLevel(
			java.lang.String surgeyPaProcedureDetailLevel) {
		this.surgeyPaProcedureDetailLevel = surgeyPaProcedureDetailLevel;
	}

	/**
	 * Return the value associated with the column:
	 * surgey_pa_procedure_detail_anesthesia
	 */
	public java.lang.String getSurgeyPaProcedureDetailAnesthesia() {
		return surgeyPaProcedureDetailAnesthesia;
	}

	/**
	 * Set the value related to the column:
	 * surgey_pa_procedure_detail_anesthesia
	 * 
	 * @param surgeyPaProcedureDetailAnesthesia
	 *            the surgey_pa_procedure_detail_anesthesia value
	 */
	public void setSurgeyPaProcedureDetailAnesthesia(
			java.lang.String surgeyPaProcedureDetailAnesthesia) {
		this.surgeyPaProcedureDetailAnesthesia = surgeyPaProcedureDetailAnesthesia;
	}

	/**
	 * Return the value associated with the column:
	 * surgey_pa_procedure_detail_dosa
	 */
	public java.lang.String getSurgeyPaProcedureDetailDosa() {
		return surgeyPaProcedureDetailDosa;
	}

	/**
	 * Set the value related to the column: surgey_pa_procedure_detail_dosa
	 * 
	 * @param surgeyPaProcedureDetailDosa
	 *            the surgey_pa_procedure_detail_dosa value
	 */
	public void setSurgeyPaProcedureDetailDosa(
			java.lang.String surgeyPaProcedureDetailDosa) {
		this.surgeyPaProcedureDetailDosa = surgeyPaProcedureDetailDosa;
	}

	/**
	 * Return the value associated with the column:
	 * surgey_pa_procedure_detail_catheter
	 */
	public java.lang.String getSurgeyPaProcedureDetailCatheter() {
		return surgeyPaProcedureDetailCatheter;
	}

	/**
	 * Set the value related to the column: surgey_pa_procedure_detail_catheter
	 * 
	 * @param surgeyPaProcedureDetailCatheter
	 *            the surgey_pa_procedure_detail_catheter value
	 */
	public void setSurgeyPaProcedureDetailCatheter(
			java.lang.String surgeyPaProcedureDetailCatheter) {
		this.surgeyPaProcedureDetailCatheter = surgeyPaProcedureDetailCatheter;
	}

	/**
	 * Return the value associated with the column:
	 * ot_post_anaesthesia_procedure_id
	 */
	public jkt.hms.masters.business.OtPostAnaesthesiaProcedure getOtPostAnaesthesiaProcedure() {
		return otPostAnaesthesiaProcedure;
	}

	/**
	 * Set the value related to the column: ot_post_anaesthesia_procedure_id
	 * 
	 * @param otPostAnaesthesiaProcedure
	 *            the ot_post_anaesthesia_procedure_id value
	 */
	public void setOtPostAnaesthesiaProcedure(
			jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure) {
		this.otPostAnaesthesiaProcedure = otPostAnaesthesiaProcedure;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OtSurgeyPaProcedureDetail))
			return false;
		else {
			jkt.hms.masters.business.OtSurgeyPaProcedureDetail otSurgeyPaProcedureDetail = (jkt.hms.masters.business.OtSurgeyPaProcedureDetail) obj;
			if (null == this.getId()
					|| null == otSurgeyPaProcedureDetail.getId())
				return false;
			else
				return (this.getId().equals(otSurgeyPaProcedureDetail.getId()));
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