package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_BREAK_DOWN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_BREAK_DOWN"
 */

public abstract class BaseShoBreakDown  implements Serializable {

	public static String REF = "ShoBreakDown";
	public static String PROP_CHILDREN_TOTAL = "ChildrenTotal";
	public static String PROP_WIVES_CIVILIAN = "WivesCivilian";
	public static String PROP_WIVES_TOTAL = "WivesTotal";
	public static String PROP_WIVES_NCS = "WivesNcs";
	public static String PROP_TOTAL_ARMY = "TotalArmy";
	public static String PROP_WIVES_OFFICER = "WivesOfficer";
	public static String PROP_PERSONNEL_TOTAL = "PersonnelTotal";
	public static String PROP_CURRENT_DATE = "CurrentDate";
	public static String PROP_CHILDREN_ARMY = "ChildrenArmy";
	public static String PROP_WIVES_ARMY = "WivesArmy";
	public static String PROP_TOTAL_OFFICER = "TotalOfficer";
	public static String PROP_CHILDREN_NCS = "ChildrenNcs";
	public static String PROP_CHILDREN_AIRMEN = "ChildrenAirmen";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PERSONNEL_OFFICER = "PersonnelOfficer";
	public static String PROP_LAST_UPDATED_DATE = "LastUpdatedDate";
	public static String PROP_PERSONNEL_ARMY = "PersonnelArmy";
	public static String PROP_TOTAL_CIVILIAN = "TotalCivilian";
	public static String PROP_PERSONNEL_CIVILIAN = "PersonnelCivilian";
	public static String PROP_WIVES_AIRMEN = "WivesAirmen";
	public static String PROP_TOTAL_AIRMEN = "TotalAirmen";
	public static String PROP_CHILDREN_OFFICER = "ChildrenOfficer";
	public static String PROP_TOTAL_NCS = "TotalNcs";
	public static String PROP_ID = "Id";
	public static String PROP_TOTAL_TOTAL = "TotalTotal";
	public static String PROP_CHILDREN_CIVILIAN = "ChildrenCivilian";
	public static String PROP_PERSONNEL_NCS = "PersonnelNcs";
	public static String PROP_PERSONNEL_AIRMEN = "PersonnelAirmen";


	// constructors
	public BaseShoBreakDown () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoBreakDown (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date currentDate;
	private java.util.Date lastUpdatedDate;
	private java.lang.String personnelOfficer;
	private java.lang.String personnelAirmen;
	private java.lang.String personnelNcs;
	private java.lang.String personnelArmy;
	private java.lang.String personnelCivilian;
	private java.lang.String personnelTotal;
	private java.lang.String wivesOfficer;
	private java.lang.String wivesAirmen;
	private java.lang.String wivesNcs;
	private java.lang.String wivesArmy;
	private java.lang.String wivesCivilian;
	private java.lang.String wivesTotal;
	private java.lang.String childrenOfficer;
	private java.lang.String childrenAirmen;
	private java.lang.String childrenNcs;
	private java.lang.String childrenArmy;
	private java.lang.String childrenCivilian;
	private java.lang.String childrenTotal;
	private java.lang.String totalOfficer;
	private java.lang.String totalAirmen;
	private java.lang.String totalNcs;
	private java.lang.String totalArmy;
	private java.lang.String totalCivilian;
	private java.lang.String totalTotal;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="BREAK_DOWN_ID"
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
	 * Return the value associated with the column: CURRENT_DATE
	 */
	public java.util.Date getCurrentDate () {
		return currentDate;
	}

	/**
	 * Set the value related to the column: CURRENT_DATE
	 * @param currentDate the CURRENT_DATE value
	 */
	public void setCurrentDate (java.util.Date currentDate) {
		this.currentDate = currentDate;
	}



	/**
	 * Return the value associated with the column: LAST_UPDATED_DATE
	 */
	public java.util.Date getLastUpdatedDate () {
		return lastUpdatedDate;
	}

	/**
	 * Set the value related to the column: LAST_UPDATED_DATE
	 * @param lastUpdatedDate the LAST_UPDATED_DATE value
	 */
	public void setLastUpdatedDate (java.util.Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}



	/**
	 * Return the value associated with the column: PERSONNEL_OFFICER
	 */
	public java.lang.String getPersonnelOfficer () {
		return personnelOfficer;
	}

	/**
	 * Set the value related to the column: PERSONNEL_OFFICER
	 * @param personnelOfficer the PERSONNEL_OFFICER value
	 */
	public void setPersonnelOfficer (java.lang.String personnelOfficer) {
		this.personnelOfficer = personnelOfficer;
	}



	/**
	 * Return the value associated with the column: PERSONNEL_AIRMEN
	 */
	public java.lang.String getPersonnelAirmen () {
		return personnelAirmen;
	}

	/**
	 * Set the value related to the column: PERSONNEL_AIRMEN
	 * @param personnelAirmen the PERSONNEL_AIRMEN value
	 */
	public void setPersonnelAirmen (java.lang.String personnelAirmen) {
		this.personnelAirmen = personnelAirmen;
	}



	/**
	 * Return the value associated with the column: PERSONNEL_NCS
	 */
	public java.lang.String getPersonnelNcs () {
		return personnelNcs;
	}

	/**
	 * Set the value related to the column: PERSONNEL_NCS
	 * @param personnelNcs the PERSONNEL_NCS value
	 */
	public void setPersonnelNcs (java.lang.String personnelNcs) {
		this.personnelNcs = personnelNcs;
	}



	/**
	 * Return the value associated with the column: PERSONNEL_ARMY
	 */
	public java.lang.String getPersonnelArmy () {
		return personnelArmy;
	}

	/**
	 * Set the value related to the column: PERSONNEL_ARMY
	 * @param personnelArmy the PERSONNEL_ARMY value
	 */
	public void setPersonnelArmy (java.lang.String personnelArmy) {
		this.personnelArmy = personnelArmy;
	}



	/**
	 * Return the value associated with the column: PERSONNEL_CIVILIAN
	 */
	public java.lang.String getPersonnelCivilian () {
		return personnelCivilian;
	}

	/**
	 * Set the value related to the column: PERSONNEL_CIVILIAN
	 * @param personnelCivilian the PERSONNEL_CIVILIAN value
	 */
	public void setPersonnelCivilian (java.lang.String personnelCivilian) {
		this.personnelCivilian = personnelCivilian;
	}



	/**
	 * Return the value associated with the column: PERSONNEL_TOTAL
	 */
	public java.lang.String getPersonnelTotal () {
		return personnelTotal;
	}

	/**
	 * Set the value related to the column: PERSONNEL_TOTAL
	 * @param personnelTotal the PERSONNEL_TOTAL value
	 */
	public void setPersonnelTotal (java.lang.String personnelTotal) {
		this.personnelTotal = personnelTotal;
	}



	/**
	 * Return the value associated with the column: WIVES_OFFICER
	 */
	public java.lang.String getWivesOfficer () {
		return wivesOfficer;
	}

	/**
	 * Set the value related to the column: WIVES_OFFICER
	 * @param wivesOfficer the WIVES_OFFICER value
	 */
	public void setWivesOfficer (java.lang.String wivesOfficer) {
		this.wivesOfficer = wivesOfficer;
	}



	/**
	 * Return the value associated with the column: WIVES_AIRMEN
	 */
	public java.lang.String getWivesAirmen () {
		return wivesAirmen;
	}

	/**
	 * Set the value related to the column: WIVES_AIRMEN
	 * @param wivesAirmen the WIVES_AIRMEN value
	 */
	public void setWivesAirmen (java.lang.String wivesAirmen) {
		this.wivesAirmen = wivesAirmen;
	}



	/**
	 * Return the value associated with the column: WIVES_NCS
	 */
	public java.lang.String getWivesNcs () {
		return wivesNcs;
	}

	/**
	 * Set the value related to the column: WIVES_NCS
	 * @param wivesNcs the WIVES_NCS value
	 */
	public void setWivesNcs (java.lang.String wivesNcs) {
		this.wivesNcs = wivesNcs;
	}



	/**
	 * Return the value associated with the column: WIVES_ARMY
	 */
	public java.lang.String getWivesArmy () {
		return wivesArmy;
	}

	/**
	 * Set the value related to the column: WIVES_ARMY
	 * @param wivesArmy the WIVES_ARMY value
	 */
	public void setWivesArmy (java.lang.String wivesArmy) {
		this.wivesArmy = wivesArmy;
	}



	/**
	 * Return the value associated with the column: WIVES_CIVILIAN
	 */
	public java.lang.String getWivesCivilian () {
		return wivesCivilian;
	}

	/**
	 * Set the value related to the column: WIVES_CIVILIAN
	 * @param wivesCivilian the WIVES_CIVILIAN value
	 */
	public void setWivesCivilian (java.lang.String wivesCivilian) {
		this.wivesCivilian = wivesCivilian;
	}



	/**
	 * Return the value associated with the column: WIVES_TOTAL
	 */
	public java.lang.String getWivesTotal () {
		return wivesTotal;
	}

	/**
	 * Set the value related to the column: WIVES_TOTAL
	 * @param wivesTotal the WIVES_TOTAL value
	 */
	public void setWivesTotal (java.lang.String wivesTotal) {
		this.wivesTotal = wivesTotal;
	}



	/**
	 * Return the value associated with the column: CHILDREN_OFFICER
	 */
	public java.lang.String getChildrenOfficer () {
		return childrenOfficer;
	}

	/**
	 * Set the value related to the column: CHILDREN_OFFICER
	 * @param childrenOfficer the CHILDREN_OFFICER value
	 */
	public void setChildrenOfficer (java.lang.String childrenOfficer) {
		this.childrenOfficer = childrenOfficer;
	}



	/**
	 * Return the value associated with the column: CHILDREN_AIRMEN
	 */
	public java.lang.String getChildrenAirmen () {
		return childrenAirmen;
	}

	/**
	 * Set the value related to the column: CHILDREN_AIRMEN
	 * @param childrenAirmen the CHILDREN_AIRMEN value
	 */
	public void setChildrenAirmen (java.lang.String childrenAirmen) {
		this.childrenAirmen = childrenAirmen;
	}



	/**
	 * Return the value associated with the column: CHILDREN_NCS
	 */
	public java.lang.String getChildrenNcs () {
		return childrenNcs;
	}

	/**
	 * Set the value related to the column: CHILDREN_NCS
	 * @param childrenNcs the CHILDREN_NCS value
	 */
	public void setChildrenNcs (java.lang.String childrenNcs) {
		this.childrenNcs = childrenNcs;
	}



	/**
	 * Return the value associated with the column: CHILDREN_ARMY
	 */
	public java.lang.String getChildrenArmy () {
		return childrenArmy;
	}

	/**
	 * Set the value related to the column: CHILDREN_ARMY
	 * @param childrenArmy the CHILDREN_ARMY value
	 */
	public void setChildrenArmy (java.lang.String childrenArmy) {
		this.childrenArmy = childrenArmy;
	}



	/**
	 * Return the value associated with the column: CHILDREN_CIVILIAN
	 */
	public java.lang.String getChildrenCivilian () {
		return childrenCivilian;
	}

	/**
	 * Set the value related to the column: CHILDREN_CIVILIAN
	 * @param childrenCivilian the CHILDREN_CIVILIAN value
	 */
	public void setChildrenCivilian (java.lang.String childrenCivilian) {
		this.childrenCivilian = childrenCivilian;
	}



	/**
	 * Return the value associated with the column: CHILDREN_TOTAL
	 */
	public java.lang.String getChildrenTotal () {
		return childrenTotal;
	}

	/**
	 * Set the value related to the column: CHILDREN_TOTAL
	 * @param childrenTotal the CHILDREN_TOTAL value
	 */
	public void setChildrenTotal (java.lang.String childrenTotal) {
		this.childrenTotal = childrenTotal;
	}



	/**
	 * Return the value associated with the column: TOTAL_OFFICER
	 */
	public java.lang.String getTotalOfficer () {
		return totalOfficer;
	}

	/**
	 * Set the value related to the column: TOTAL_OFFICER
	 * @param totalOfficer the TOTAL_OFFICER value
	 */
	public void setTotalOfficer (java.lang.String totalOfficer) {
		this.totalOfficer = totalOfficer;
	}



	/**
	 * Return the value associated with the column: TOTAL_AIRMEN
	 */
	public java.lang.String getTotalAirmen () {
		return totalAirmen;
	}

	/**
	 * Set the value related to the column: TOTAL_AIRMEN
	 * @param totalAirmen the TOTAL_AIRMEN value
	 */
	public void setTotalAirmen (java.lang.String totalAirmen) {
		this.totalAirmen = totalAirmen;
	}



	/**
	 * Return the value associated with the column: TOTAL_NCS
	 */
	public java.lang.String getTotalNcs () {
		return totalNcs;
	}

	/**
	 * Set the value related to the column: TOTAL_NCS
	 * @param totalNcs the TOTAL_NCS value
	 */
	public void setTotalNcs (java.lang.String totalNcs) {
		this.totalNcs = totalNcs;
	}



	/**
	 * Return the value associated with the column: TOTAL_ARMY
	 */
	public java.lang.String getTotalArmy () {
		return totalArmy;
	}

	/**
	 * Set the value related to the column: TOTAL_ARMY
	 * @param totalArmy the TOTAL_ARMY value
	 */
	public void setTotalArmy (java.lang.String totalArmy) {
		this.totalArmy = totalArmy;
	}



	/**
	 * Return the value associated with the column: TOTAL_CIVILIAN
	 */
	public java.lang.String getTotalCivilian () {
		return totalCivilian;
	}

	/**
	 * Set the value related to the column: TOTAL_CIVILIAN
	 * @param totalCivilian the TOTAL_CIVILIAN value
	 */
	public void setTotalCivilian (java.lang.String totalCivilian) {
		this.totalCivilian = totalCivilian;
	}



	/**
	 * Return the value associated with the column: TOTAL_TOTAL
	 */
	public java.lang.String getTotalTotal () {
		return totalTotal;
	}

	/**
	 * Set the value related to the column: TOTAL_TOTAL
	 * @param totalTotal the TOTAL_TOTAL value
	 */
	public void setTotalTotal (java.lang.String totalTotal) {
		this.totalTotal = totalTotal;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoBreakDown)) return false;
		else {
			jkt.hms.masters.business.ShoBreakDown shoBreakDown = (jkt.hms.masters.business.ShoBreakDown) obj;
			if (null == this.getId() || null == shoBreakDown.getId()) return false;
			else return (this.getId().equals(shoBreakDown.getId()));
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