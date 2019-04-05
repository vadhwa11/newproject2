package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * ot_surgey_pa_premedication_detail table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="ot_surgey_pa_premedication_detail"
 */

public abstract class BaseOtSurgeyPaPremedicationDetail implements Serializable {

	public static String REF = "OtSurgeyPaPremedicationDetail";
	public static String PROP_SURGEY_PA_PREMEDICATION_DETAIL_DOSA = "SurgeyPaPremedicationDetailDosa";
	public static String PROP_ITEM = "Item";
	public static String PROP_SURGEY_PA_PREMEDICATION_DETAIL_ROUTE = "SurgeyPaPremedicationDetailRoute";
	public static String PROP_SURGEY_PA_PREMEDICATION_DETAIL_TYPE = "SurgeyPaPremedicationDetailType";
	public static String PROP_OT_POST_ANAESTHESIA_PROCEDURE = "OtPostAnaesthesiaProcedure";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOtSurgeyPaPremedicationDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtSurgeyPaPremedicationDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String surgeyPaPremedicationDetailType;
	private java.lang.String surgeyPaPremedicationDetailDosa;
	private java.lang.String surgeyPaPremedicationDetailRoute;

	// many to one
	private jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="surgey_pa_premedication_detail_id"
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
	 * surgey_pa_premedication_detail_type
	 */
	public java.lang.String getSurgeyPaPremedicationDetailType() {
		return surgeyPaPremedicationDetailType;
	}

	/**
	 * Set the value related to the column: surgey_pa_premedication_detail_type
	 * 
	 * @param surgeyPaPremedicationDetailType
	 *            the surgey_pa_premedication_detail_type value
	 */
	public void setSurgeyPaPremedicationDetailType(
			java.lang.String surgeyPaPremedicationDetailType) {
		this.surgeyPaPremedicationDetailType = surgeyPaPremedicationDetailType;
	}

	/**
	 * Return the value associated with the column:
	 * surgey_pa_premedication_detail_dosa
	 */
	public java.lang.String getSurgeyPaPremedicationDetailDosa() {
		return surgeyPaPremedicationDetailDosa;
	}

	/**
	 * Set the value related to the column: surgey_pa_premedication_detail_dosa
	 * 
	 * @param surgeyPaPremedicationDetailDosa
	 *            the surgey_pa_premedication_detail_dosa value
	 */
	public void setSurgeyPaPremedicationDetailDosa(
			java.lang.String surgeyPaPremedicationDetailDosa) {
		this.surgeyPaPremedicationDetailDosa = surgeyPaPremedicationDetailDosa;
	}

	/**
	 * Return the value associated with the column:
	 * surgey_pa_premedication_detail_route
	 */
	public java.lang.String getSurgeyPaPremedicationDetailRoute() {
		return surgeyPaPremedicationDetailRoute;
	}

	/**
	 * Set the value related to the column: surgey_pa_premedication_detail_route
	 * 
	 * @param surgeyPaPremedicationDetailRoute
	 *            the surgey_pa_premedication_detail_route value
	 */
	public void setSurgeyPaPremedicationDetailRoute(
			java.lang.String surgeyPaPremedicationDetailRoute) {
		this.surgeyPaPremedicationDetailRoute = surgeyPaPremedicationDetailRoute;
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
		if (!(obj instanceof jkt.hms.masters.business.OtSurgeyPaPremedicationDetail))
			return false;
		else {
			jkt.hms.masters.business.OtSurgeyPaPremedicationDetail otSurgeyPaPremedicationDetail = (jkt.hms.masters.business.OtSurgeyPaPremedicationDetail) obj;
			if (null == this.getId()
					|| null == otSurgeyPaPremedicationDetail.getId())
				return false;
			else
				return (this.getId().equals(otSurgeyPaPremedicationDetail
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