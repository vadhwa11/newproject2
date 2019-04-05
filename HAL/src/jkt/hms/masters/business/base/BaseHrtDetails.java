package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HRT_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HRT_DETAILS"
 */

public abstract class BaseHrtDetails  implements Serializable {

	public static String REF = "HrtDetails";
	public static String PROP_HORMONE = "Hormone";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_INDEX_CANCER = "IndexCancer";
	public static String PROP_ROUTE = "Route";


	// constructors
	public BaseHrtDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrtDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String hormone;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.String route;
	private java.lang.String indexCancer;
	private java.lang.String hinNo;

	// many to one
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="HRT_DETAILS_ID"
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
	 * Return the value associated with the column: HORMONE
	 */
	public java.lang.String getHormone () {
		return hormone;
	}

	/**
	 * Set the value related to the column: HORMONE
	 * @param hormone the HORMONE value
	 */
	public void setHormone (java.lang.String hormone) {
		this.hormone = hormone;
	}



	/**
	 * Return the value associated with the column: FROM_DATE
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: FROM_DATE
	 * @param fromDate the FROM_DATE value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: TO_DATE
	 */
	public java.util.Date getToDate () {
		return toDate;
	}

	/**
	 * Set the value related to the column: TO_DATE
	 * @param toDate the TO_DATE value
	 */
	public void setToDate (java.util.Date toDate) {
		this.toDate = toDate;
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
	 * Return the value associated with the column: INDEX_CANCER
	 */
	public java.lang.String getIndexCancer () {
		return indexCancer;
	}

	/**
	 * Set the value related to the column: INDEX_CANCER
	 * @param indexCancer the INDEX_CANCER value
	 */
	public void setIndexCancer (java.lang.String indexCancer) {
		this.indexCancer = indexCancer;
	}



	/**
	 * Return the value associated with the column: HIN_NO
	 */
	public java.lang.String getHinNo () {
		return hinNo;
	}

	/**
	 * Set the value related to the column: HIN_NO
	 * @param hinNo the HIN_NO value
	 */
	public void setHinNo (java.lang.String hinNo) {
		this.hinNo = hinNo;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrtDetails)) return false;
		else {
			jkt.hms.masters.business.HrtDetails hrtDetails = (jkt.hms.masters.business.HrtDetails) obj;
			if (null == this.getId() || null == hrtDetails.getId()) return false;
			else return (this.getId().equals(hrtDetails.getId()));
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