package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FWC_DELIVERY_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FWC_DELIVERY_DETAILS"
 */

public abstract class BaseFwcDeliveryDetails  implements Serializable {

	public static String REF = "FwcDeliveryDetails";
	public static String PROP_TIME_DELIVERY = "TimeDelivery";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PLACE_DELIVERY = "PlaceDelivery";
	public static String PROP_ID = "Id";
	public static String PROP_DATE_DELIVERY = "DateDelivery";
	public static String PROP_SL_NO = "SlNo";
	public static String PROP_VISIT = "Visit";
	public static String PROP_HIN = "Hin";
	public static String PROP_TYPE_DELIVERY = "TypeDelivery";


	// constructors
	public BaseFwcDeliveryDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFwcDeliveryDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFwcDeliveryDetails (
		java.lang.Integer id,
		java.lang.String timeDelivery,
		java.lang.String typeDelivery,
		java.lang.String placeDelivery) {

		this.setId(id);
		this.setTimeDelivery(timeDelivery);
		this.setTypeDelivery(typeDelivery);
		this.setPlaceDelivery(placeDelivery);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer slNo;
	private java.util.Date dateDelivery;
	private java.lang.String timeDelivery;
	private java.lang.String typeDelivery;
	private java.lang.String placeDelivery;

	// many to one
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="DELIVERY_DETAILS_ID"
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
	 * Return the value associated with the column: SL_NO
	 */
	public java.lang.Integer getSlNo () {
		return slNo;
	}

	/**
	 * Set the value related to the column: SL_NO
	 * @param slNo the SL_NO value
	 */
	public void setSlNo (java.lang.Integer slNo) {
		this.slNo = slNo;
	}



	/**
	 * Return the value associated with the column: DATE_DELIVERY
	 */
	public java.util.Date getDateDelivery () {
		return dateDelivery;
	}

	/**
	 * Set the value related to the column: DATE_DELIVERY
	 * @param dateDelivery the DATE_DELIVERY value
	 */
	public void setDateDelivery (java.util.Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}



	/**
	 * Return the value associated with the column: TIME_DELIVERY
	 */
	public java.lang.String getTimeDelivery () {
		return timeDelivery;
	}

	/**
	 * Set the value related to the column: TIME_DELIVERY
	 * @param timeDelivery the TIME_DELIVERY value
	 */
	public void setTimeDelivery (java.lang.String timeDelivery) {
		this.timeDelivery = timeDelivery;
	}



	/**
	 * Return the value associated with the column: TYPE_DELIVERY
	 */
	public java.lang.String getTypeDelivery () {
		return typeDelivery;
	}

	/**
	 * Set the value related to the column: TYPE_DELIVERY
	 * @param typeDelivery the TYPE_DELIVERY value
	 */
	public void setTypeDelivery (java.lang.String typeDelivery) {
		this.typeDelivery = typeDelivery;
	}



	/**
	 * Return the value associated with the column: PLACE_DELIVERY
	 */
	public java.lang.String getPlaceDelivery () {
		return placeDelivery;
	}

	/**
	 * Set the value related to the column: PLACE_DELIVERY
	 * @param placeDelivery the PLACE_DELIVERY value
	 */
	public void setPlaceDelivery (java.lang.String placeDelivery) {
		this.placeDelivery = placeDelivery;
	}



	/**
	 * Return the value associated with the column: VISIT_ID
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: VISIT_ID
	 * @param visit the VISIT_ID value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hin the HIN_ID value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FwcDeliveryDetails)) return false;
		else {
			jkt.hms.masters.business.FwcDeliveryDetails fwcDeliveryDetails = (jkt.hms.masters.business.FwcDeliveryDetails) obj;
			if (null == this.getId() || null == fwcDeliveryDetails.getId()) return false;
			else return (this.getId().equals(fwcDeliveryDetails.getId()));
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