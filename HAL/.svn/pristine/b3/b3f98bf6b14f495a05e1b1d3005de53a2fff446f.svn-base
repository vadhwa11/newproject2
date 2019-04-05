package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the INJECTION_REGISTER_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="INJECTION_REGISTER_DETAILS"
 */

public abstract class BaseInjectionRegisterDetails  implements Serializable {

	public static String REF = "InjectionRegisterDetails";
	public static String PROP_DOSE = "Dose";
	public static String PROP_ITEM = "Item";
	public static String PROP_ALLERGIC_TESTING = "AllergicTesting";
	public static String PROP_INJECTION_REGISTER = "InjectionRegister";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_ADVERSE_REACTION = "AdverseReaction";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_ROUTE = "Route";


	// constructors
	public BaseInjectionRegisterDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInjectionRegisterDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dose;
	private java.lang.String route;
	private java.lang.Integer noOfDays;
	private java.lang.String allergicTesting;
	private java.lang.String adverseReaction;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasFrequency frequency;
	private jkt.hms.masters.business.InjectionRegister injectionRegister;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="INJECTION_REGISTER_DETAILS_ID"
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
	 * Return the value associated with the column: DOSE
	 */
	public java.lang.String getDose () {
		return dose;
	}

	/**
	 * Set the value related to the column: DOSE
	 * @param dose the DOSE value
	 */
	public void setDose (java.lang.String dose) {
		this.dose = dose;
	}



	/**
	 * Return the value associated with the column: ROUTE
	 */
	public java.lang.String getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: ROUTE
	 * @param route the ROUTE value
	 */
	public void setRoute (java.lang.String route) {
		this.route = route;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: ALLERGIC_TESTING
	 */
	public java.lang.String getAllergicTesting () {
		return allergicTesting;
	}

	/**
	 * Set the value related to the column: ALLERGIC_TESTING
	 * @param allergicTesting the ALLERGIC_TESTING value
	 */
	public void setAllergicTesting (java.lang.String allergicTesting) {
		this.allergicTesting = allergicTesting;
	}



	/**
	 * Return the value associated with the column: ADVERSE_REACTION
	 */
	public java.lang.String getAdverseReaction () {
		return adverseReaction;
	}

	/**
	 * Set the value related to the column: ADVERSE_REACTION
	 * @param adverseReaction the ADVERSE_REACTION value
	 */
	public void setAdverseReaction (java.lang.String adverseReaction) {
		this.adverseReaction = adverseReaction;
	}



	/**
	 * Return the value associated with the column: ITEM_ID
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: ITEM_ID
	 * @param item the ITEM_ID value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: FREQUENCY_ID
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: FREQUENCY_ID
	 * @param frequency the FREQUENCY_ID value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: INJECTION_REGISTER_ID
	 */
	public jkt.hms.masters.business.InjectionRegister getInjectionRegister () {
		return injectionRegister;
	}

	/**
	 * Set the value related to the column: INJECTION_REGISTER_ID
	 * @param injectionRegister the INJECTION_REGISTER_ID value
	 */
	public void setInjectionRegister (jkt.hms.masters.business.InjectionRegister injectionRegister) {
		this.injectionRegister = injectionRegister;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.InjectionRegisterDetails)) return false;
		else {
			jkt.hms.masters.business.InjectionRegisterDetails injectionRegisterDetails = (jkt.hms.masters.business.InjectionRegisterDetails) obj;
			if (null == this.getId() || null == injectionRegisterDetails.getId()) return false;
			else return (this.getId().equals(injectionRegisterDetails.getId()));
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