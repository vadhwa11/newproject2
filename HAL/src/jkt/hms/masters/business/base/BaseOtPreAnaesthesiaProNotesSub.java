package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * ot_pre_anaesthesia_pro_notes_sub table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="ot_pre_anaesthesia_pro_notes_sub"
 */

public abstract class BaseOtPreAnaesthesiaProNotesSub implements Serializable {

	public static String REF = "OtPreAnaesthesiaProNotesSub";
	public static String PROP_STORE_ITEM = "StoreItem";
	public static String PROP_DOSE = "Dose";
	public static String PROP_ROUTE = "Route";
	public static String PROP_PRE_ANAESTHESIA_MAIN = "PreAnaesthesiaMain";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOtPreAnaesthesiaProNotesSub() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPreAnaesthesiaProNotesSub(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dose;
	private java.lang.String route;

	// many to one
	private jkt.hms.masters.business.MasStoreItem storeItem;
	private jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain preAnaesthesiaMain;

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
	 * Return the value associated with the column: dose
	 */
	public java.lang.String getDose() {
		return dose;
	}

	/**
	 * Set the value related to the column: dose
	 * 
	 * @param dose
	 *            the dose value
	 */
	public void setDose(java.lang.String dose) {
		this.dose = dose;
	}

	/**
	 * Return the value associated with the column: route
	 */
	public java.lang.String getRoute() {
		return route;
	}

	/**
	 * Set the value related to the column: route
	 * 
	 * @param route
	 *            the route value
	 */
	public void setRoute(java.lang.String route) {
		this.route = route;
	}

	/**
	 * Return the value associated with the column: store_item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getStoreItem() {
		return storeItem;
	}

	/**
	 * Set the value related to the column: store_item_id
	 * 
	 * @param storeItem
	 *            the store_item_id value
	 */
	public void setStoreItem(jkt.hms.masters.business.MasStoreItem storeItem) {
		this.storeItem = storeItem;
	}

	/**
	 * Return the value associated with the column: pre_anaesthesia_main_id
	 */
	public jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain getPreAnaesthesiaMain() {
		return preAnaesthesiaMain;
	}

	/**
	 * Set the value related to the column: pre_anaesthesia_main_id
	 * 
	 * @param preAnaesthesiaMain
	 *            the pre_anaesthesia_main_id value
	 */
	public void setPreAnaesthesiaMain(
			jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain preAnaesthesiaMain) {
		this.preAnaesthesiaMain = preAnaesthesiaMain;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub))
			return false;
		else {
			jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub otPreAnaesthesiaProNotesSub = (jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub) obj;
			if (null == this.getId()
					|| null == otPreAnaesthesiaProNotesSub.getId())
				return false;
			else
				return (this.getId()
						.equals(otPreAnaesthesiaProNotesSub.getId()));
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