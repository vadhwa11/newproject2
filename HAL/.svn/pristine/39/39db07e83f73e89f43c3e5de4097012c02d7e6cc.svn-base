package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * ot_surgey_pa_iv_fluids_detail table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="ot_surgey_pa_iv_fluids_detail"
 */

public abstract class BaseOtSurgeyPaIvFluidsDetail implements Serializable {

	public static String REF = "OtSurgeyPaIvFluidsDetail";
	public static String PROP_SURGEY_PA_IV_FLUIDS_DETAIL_FLUIDS_NAME = "SurgeyPaIvFluidsDetailFluidsName";
	public static String PROP_ITEM = "Item";
	public static String PROP_OT_POST_ANAESTHESIA_PROCEDURE = "OtPostAnaesthesiaProcedure";
	public static String PROP_SURGEY_PA_IV_FLUIDS_DETAIL_VOLUME = "SurgeyPaIvFluidsDetailVolume";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOtSurgeyPaIvFluidsDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtSurgeyPaIvFluidsDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer surgeyPaIvFluidsDetailVolume;
	private java.lang.String surgeyPaIvFluidsDetailFluidsName;

	// many to one
	private jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="surgey_pa_iv_fluids_detail_id"
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
	 * surgey_pa_iv_fluids_detail_volume
	 */
	public java.lang.Integer getSurgeyPaIvFluidsDetailVolume() {
		return surgeyPaIvFluidsDetailVolume;
	}

	/**
	 * Set the value related to the column: surgey_pa_iv_fluids_detail_volume
	 * 
	 * @param surgeyPaIvFluidsDetailVolume
	 *            the surgey_pa_iv_fluids_detail_volume value
	 */
	public void setSurgeyPaIvFluidsDetailVolume(
			java.lang.Integer surgeyPaIvFluidsDetailVolume) {
		this.surgeyPaIvFluidsDetailVolume = surgeyPaIvFluidsDetailVolume;
	}

	/**
	 * Return the value associated with the column:
	 * surgey_pa_iv_fluids_detail_fluids_name
	 */
	public java.lang.String getSurgeyPaIvFluidsDetailFluidsName() {
		return surgeyPaIvFluidsDetailFluidsName;
	}

	/**
	 * Set the value related to the column:
	 * surgey_pa_iv_fluids_detail_fluids_name
	 * 
	 * @param surgeyPaIvFluidsDetailFluidsName
	 *            the surgey_pa_iv_fluids_detail_fluids_name value
	 */
	public void setSurgeyPaIvFluidsDetailFluidsName(
			java.lang.String surgeyPaIvFluidsDetailFluidsName) {
		this.surgeyPaIvFluidsDetailFluidsName = surgeyPaIvFluidsDetailFluidsName;
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
		if (!(obj instanceof jkt.hms.masters.business.OtSurgeyPaIvFluidsDetail))
			return false;
		else {
			jkt.hms.masters.business.OtSurgeyPaIvFluidsDetail otSurgeyPaIvFluidsDetail = (jkt.hms.masters.business.OtSurgeyPaIvFluidsDetail) obj;
			if (null == this.getId()
					|| null == otSurgeyPaIvFluidsDetail.getId())
				return false;
			else
				return (this.getId().equals(otSurgeyPaIvFluidsDetail.getId()));
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