package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the discharge_view table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="discharge_view"
 */

public abstract class BaseDischargeView implements Serializable {

	public static String REF = "DischargeView";
	public static String PROP_TOT_DISCHARGE = "TotDischarge";
	public static String PROP_DATE_OF_DISCHARGE = "DateOfDischarge";
	public static String PROP_RANK_CATEGORY_NAME = "RankCategoryName";
	public static String PROP_SERVICE_TYPE_NAME = "ServiceTypeName";

	// constructors
	public BaseDischargeView() {
		initialize();
	}

	protected void initialize() {
	}

	// fields
	private java.util.Date dateOfDischarge;
	private java.lang.String rankCategoryName;
	private java.lang.String serviceTypeName;
	private java.lang.Long totDischarge;

	/**
	 * Return the value associated with the column: date_of_discharge
	 */
	public java.util.Date getDateOfDischarge() {
		return dateOfDischarge;
	}

	/**
	 * Set the value related to the column: date_of_discharge
	 * 
	 * @param dateOfDischarge
	 *            the date_of_discharge value
	 */
	public void setDateOfDischarge(java.util.Date dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	/**
	 * Return the value associated with the column: rank_category_name
	 */
	public java.lang.String getRankCategoryName() {
		return rankCategoryName;
	}

	/**
	 * Set the value related to the column: rank_category_name
	 * 
	 * @param rankCategoryName
	 *            the rank_category_name value
	 */
	public void setRankCategoryName(java.lang.String rankCategoryName) {
		this.rankCategoryName = rankCategoryName;
	}

	/**
	 * Return the value associated with the column: service_type_name
	 */
	public java.lang.String getServiceTypeName() {
		return serviceTypeName;
	}

	/**
	 * Set the value related to the column: service_type_name
	 * 
	 * @param serviceTypeName
	 *            the service_type_name value
	 */
	public void setServiceTypeName(java.lang.String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}

	/**
	 * Return the value associated with the column: tot_discharge
	 */
	public java.lang.Long getTotDischarge() {
		return totDischarge;
	}

	/**
	 * Set the value related to the column: tot_discharge
	 * 
	 * @param totDischarge
	 *            the tot_discharge value
	 */
	public void setTotDischarge(java.lang.Long totDischarge) {
		this.totDischarge = totDischarge;
	}

	public String toString() {
		return super.toString();
	}

}