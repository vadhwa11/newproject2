package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hro_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hro_entry"
 */

public abstract class BaseHroEntry  implements Serializable {

	public static String REF = "HroEntry";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_NAME_OF_COMMANDANT = "NameOfCommandant";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_NAME_OF_ADJUDANT = "NameOfAdjudant";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_ID = "Id";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";
	public static String PROP_TEXT_CONTENT = "TextContent";
	public static String PROP_DESIGNATION = "Designation";
	public static String PROP_HRO_DATE = "HroDate";


	// constructors
	public BaseHroEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHroEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date hroDate;
	private java.lang.String serialNo;
	private java.lang.String textContent;
	private java.lang.String lstChangedBy;
	private java.util.Date lstChangedDate;
	private java.lang.String lstChangedTime;
	private java.lang.String status;
	private java.lang.String entryNo;
	private java.lang.String designation;

	// many to one
	private jkt.hms.masters.business.MasEmployee nameOfCommandant;
	private jkt.hms.masters.business.MasEmployee nameOfAdjudant;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="hro_entry_id"
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
	 * Return the value associated with the column: hro_date
	 */
	public java.util.Date getHroDate () {
		return hroDate;
	}

	/**
	 * Set the value related to the column: hro_date
	 * @param hroDate the hro_date value
	 */
	public void setHroDate (java.util.Date hroDate) {
		this.hroDate = hroDate;
	}



	/**
	 * Return the value associated with the column: Serial_No
	 */
	public java.lang.String getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: Serial_No
	 * @param serialNo the Serial_No value
	 */
	public void setSerialNo (java.lang.String serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: text_content
	 */
	public java.lang.String getTextContent () {
		return textContent;
	}

	/**
	 * Set the value related to the column: text_content
	 * @param textContent the text_content value
	 */
	public void setTextContent (java.lang.String textContent) {
		this.textContent = textContent;
	}



	/**
	 * Return the value associated with the column: lst_changed_by
	 */
	public java.lang.String getLstChangedBy () {
		return lstChangedBy;
	}

	/**
	 * Set the value related to the column: lst_changed_by
	 * @param lstChangedBy the lst_changed_by value
	 */
	public void setLstChangedBy (java.lang.String lstChangedBy) {
		this.lstChangedBy = lstChangedBy;
	}



	/**
	 * Return the value associated with the column: lst_changed_date
	 */
	public java.util.Date getLstChangedDate () {
		return lstChangedDate;
	}

	/**
	 * Set the value related to the column: lst_changed_date
	 * @param lstChangedDate the lst_changed_date value
	 */
	public void setLstChangedDate (java.util.Date lstChangedDate) {
		this.lstChangedDate = lstChangedDate;
	}



	/**
	 * Return the value associated with the column: lst_changed_time
	 */
	public java.lang.String getLstChangedTime () {
		return lstChangedTime;
	}

	/**
	 * Set the value related to the column: lst_changed_time
	 * @param lstChangedTime the lst_changed_time value
	 */
	public void setLstChangedTime (java.lang.String lstChangedTime) {
		this.lstChangedTime = lstChangedTime;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: entry_No
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_No
	 * @param entryNo the entry_No value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
	}



	/**
	 * Return the value associated with the column: designation
	 */
	public java.lang.String getDesignation () {
		return designation;
	}

	/**
	 * Set the value related to the column: designation
	 * @param designation the designation value
	 */
	public void setDesignation (java.lang.String designation) {
		this.designation = designation;
	}



	/**
	 * Return the value associated with the column: name_of_commandant
	 */
	public jkt.hms.masters.business.MasEmployee getNameOfCommandant () {
		return nameOfCommandant;
	}

	/**
	 * Set the value related to the column: name_of_commandant
	 * @param nameOfCommandant the name_of_commandant value
	 */
	public void setNameOfCommandant (jkt.hms.masters.business.MasEmployee nameOfCommandant) {
		this.nameOfCommandant = nameOfCommandant;
	}



	/**
	 * Return the value associated with the column: name_of_adjudant
	 */
	public jkt.hms.masters.business.MasEmployee getNameOfAdjudant () {
		return nameOfAdjudant;
	}

	/**
	 * Set the value related to the column: name_of_adjudant
	 * @param nameOfAdjudant the name_of_adjudant value
	 */
	public void setNameOfAdjudant (jkt.hms.masters.business.MasEmployee nameOfAdjudant) {
		this.nameOfAdjudant = nameOfAdjudant;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HroEntry)) return false;
		else {
			jkt.hms.masters.business.HroEntry hroEntry = (jkt.hms.masters.business.HroEntry) obj;
			if (null == this.getId() || null == hroEntry.getId()) return false;
			else return (this.getId().equals(hroEntry.getId()));
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