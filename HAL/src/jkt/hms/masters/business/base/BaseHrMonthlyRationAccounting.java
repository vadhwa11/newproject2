package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_monthly_ration_accounting table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_monthly_ration_accounting"
 */

public abstract class BaseHrMonthlyRationAccounting  implements Serializable {

	public static String REF = "HrMonthlyRationAccounting";
	public static String PROP_NAME = "Name";
	public static String PROP_YEAR = "Year";
	public static String PROP_POR_NUMBER = "PorNumber";
	public static String PROP_OCCU_NUMBER = "OccuNumber";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_NO_OF_MONEY_DRAWN = "NoOfMoneyDrawn";
	public static String PROP_NO_OF_RATION_DRAWN = "NoOfRationDrawn";
	public static String PROP_ID = "Id";
	public static String PROP_RANK_NAME = "RankName";
	public static String PROP_MONTH = "Month";
	public static String PROP_EFF_OF_LEAVE_DAYS ="EffOfLeaveDays";
	public static String PROP_EFF_OF_INPATIENT_DAYS="EffOfInpatientDays";
	public static String PROP_EFF_OF_TD_DAYS = "EffOfTdDays";
	public static String PROP_EFF_OF_AWL_DAYS ="EffOfAwlDays";
	public static String PROP_RATION_MONEY_DRAWN ="RationMoneyDrawn" ;
	public static String PROP_DATE_OF_POSTING ="DateOfPosting" ;
	public static String PROP_DATE_OF_JOINING ="DateOfJoining" ;
	public static String PROP_EMPLOYEE_CODE = "EmployeeCode" ;

	// constructors
	public BaseHrMonthlyRationAccounting () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMonthlyRationAccounting (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	
	private java.lang.Integer year;
	private java.lang.Integer month;
	private java.lang.String serviceNo;
	private java.lang.String rankName;
	private java.lang.String name;
	private java.lang.Integer noOfRationDrawn;
	private java.lang.Integer noOfMoneyDrawn;
	private java.lang.String porNumber;
	private java.lang.String occuNumber;
	private java.lang.Integer effOfLeaveDays ;
	private java.lang.Integer effOfInpatientDays ;
	private java.lang.Integer effOfTdDays ;
	private java.lang.Integer effOfAwlDays ;
	private java.lang.Integer rationMoneyDrawn  ;
	private java.util.Date dateOfJoining ;
	private java.util.Date dateOfPosting ;
    private java.lang.String employeeCode ;	
	
	//many-to-one
	private jkt.hms.masters.business.MasEmployee employeeId ;
	private jkt.hms.masters.business.MasRank rankId ;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ration_id"
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
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (jkt.hms.masters.business.MasEmployee employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasRank getRankId () {
		return rankId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setRankId (jkt.hms.masters.business.MasRank rankId) {
		this.rankId =rankId;
	}


	/**
	 * Return the value associated with the column: year
	 */
	public java.lang.Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.lang.Integer year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: month
	 */
	public java.lang.Integer getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: month
	 * @param month the month value
	 */
	public void setMonth (java.lang.Integer month) {
		this.month = month;
	}



	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: rank_name
	 */
	public java.lang.String getRankName () {
		return rankName;
	}

	/**
	 * Set the value related to the column: rank_name
	 * @param rankName the rank_name value
	 */
	public void setRankName (java.lang.String rankName) {
		this.rankName = rankName;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: no_of_ration_drawn
	 */
	public java.lang.Integer getNoOfRationDrawn () {
		return noOfRationDrawn;
	}

	/**
	 * Set the value related to the column: no_of_ration_drawn
	 * @param noOfRationDrawn the no_of_ration_drawn value
	 */
	public void setNoOfRationDrawn (java.lang.Integer noOfRationDrawn) {
		this.noOfRationDrawn = noOfRationDrawn;
	}



	/**
	 * Return the value associated with the column: no_of_money_drawn
	 */
	public java.lang.Integer getNoOfMoneyDrawn () {
		return noOfMoneyDrawn;
	}

	/**
	 * Set the value related to the column: no_of_money_drawn
	 * @param noOfMoneyDrawn the no_of_money_drawn value
	 */
	public void setNoOfMoneyDrawn (java.lang.Integer noOfMoneyDrawn) {
		this.noOfMoneyDrawn = noOfMoneyDrawn;
	}
	
	/**
	 * Return the value associated with the column: rationMoneyDrawn
	 */
	public java.lang.Integer getRationMoneyDrawn () {
		return rationMoneyDrawn;
	}

	/**
	 * Set the value related to the column: no_of_ration_drawn
	 * @param noOfRationDrawn the no_of_ration_drawn value
	 */
	public void setRationMoneyDrawn (java.lang.Integer rationMoneyDrawn) {
		this.rationMoneyDrawn = rationMoneyDrawn;
	}





	/**
	 * Return the value associated with the column: por_number
	 */
	public java.lang.String getPorNumber () {
		return porNumber;
	}

	/**
	 * Set the value related to the column: por_number
	 * @param porNumber the por_number value
	 */
	public void setPorNumber (java.lang.String porNumber) {
		this.porNumber = porNumber;
	}



	/**
	 * Return the value associated with the column: occu_number
	 */
	public java.lang.String getOccuNumber () {
		return occuNumber;
	}

	/**
	 * Set the value related to the column: occu_number
	 * @param occuNumber the occu_number value
	 */
	public void setOccuNumber (java.lang.String occuNumber) {
		this.occuNumber = occuNumber;
	}
	
	/**
	 * Return the value associated with the column: effOfLeaveDays
	 */
	public java.lang.Integer getEffOfLeaveDays () {
		return effOfLeaveDays;
	}

	/**
	 * Set the value related to the column: effOfLeaveDays
	 * @param year the year value
	 */
	public void setEffOfLeaveDays (java.lang.Integer effOfLeaveDays) {
		this.effOfLeaveDays = effOfLeaveDays;
	}

	/**
	 * Return the value associated with the column: effOfInpatientDays
	 */
	public java.lang.Integer getEffOfInpatientDays () {
		return effOfInpatientDays;
	}

	/**
	 * Set the value related to the column: effOfInpatientDays
	 * @param year the year value
	 */
	public void setEffOfInpatientDays (java.lang.Integer effOfInpatientDays) {
		this.effOfInpatientDays = effOfInpatientDays;
	}

	/**
	 * Return the value associated with the column: effOfTdDays
	 */
	public java.lang.Integer getEffOfTdDays () {
		return effOfTdDays;
	}

	/**
	 * Set the value related to the column: effOfTdDays
	 * @param year the year value
	 */
	public void setEffOfTdDays (java.lang.Integer effOfTdDays) {
		this.effOfTdDays = effOfTdDays;
	}

	/**
	 * Return the value associated with the column: effOfAwlDays
	 */
	public java.lang.Integer getEffOfAwlDays () {
		return effOfAwlDays;
	}

	/**
	 * Set the value related to the column: effOfAwlDays
	 * @param year the year value
	 */
	public void setEffOfAwlDays (java.lang.Integer effOfAwlDays) {
		this.effOfAwlDays = effOfAwlDays;
	}
    
	/**
	 * Return the value associated with the column: dateOfJoining
	 */
	public java.util.Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * Set the value related to the column: dateOfJoining
	 * @param year the year value
	 */
	public void setDateOfJoining(java.util.Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
    
	/**
	 * Return the value associated with the column: dateOfPosting
	 */
	public java.util.Date getDateOfPosting() {
		return dateOfPosting;
	}

	/**
	 * Set the value related to the column: dateOfPosting
	 * @param year the year value
	 */
	public void setDateOfPosting(java.util.Date dateOfPosting) {
		this.dateOfPosting = dateOfPosting;
	}
	
	/**
	 * Set the value related to the column: EmployeeCode
	 * @param year the year value
	 */
	public void setEmployeeCode (java.lang.String employeeCode) {
		this.employeeCode = employeeCode;
	}

	/**
	 * Return the value associated with the column: employeeCode
	 */
	public java.lang.String getEmployeeCode () {
		return employeeCode;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMonthlyRationAccounting)) return false;
		else {
			jkt.hms.masters.business.HrMonthlyRationAccounting hrMonthlyRationAccounting = (jkt.hms.masters.business.HrMonthlyRationAccounting) obj;
			if (null == this.getId() || null == hrMonthlyRationAccounting.getId()) return false;
			else return (this.getId().equals(hrMonthlyRationAccounting.getId()));
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