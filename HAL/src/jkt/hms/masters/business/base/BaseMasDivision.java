package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_division table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_division"
 */

public abstract class BaseMasDivision  implements Serializable {

	public static String REF = "MasDivision";
	public static String PROP_STATUS = "Status";
	public static String PROP_NOTE_SHEET_SIGNATURE_AUTHORITY = "NoteSheetSignatureAuthority";
	public static String PROP_DIVISION_NAME = "DivisionName";
	public static String PROP_DIVISION_CODE = "DivisionCode";
	public static String PROP_DIVISIONAL_LETTER_AUTHORITY = "DivisionalLetterAuthority";
	public static String PROP_DISPATCH_LETTER_HEADER = "DispatchLetterHeader";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COVERING_LETTER_AUTHORITY = "CoveringLetterAuthority";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DIET_LETTER_AUTHORITY = "DietLetterAuthority";
	public static String PROP_DISPATCH_LETTER_AUTHORITY = "DispatchLetterAuthority";


	// constructors
	public BaseMasDivision () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDivision (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String divisionCode;
	private java.lang.String divisionName;
	private java.lang.String dispatchLetterHeader;
	private java.lang.String coveringLetterAuthority;
	private java.lang.String dispatchLetterAuthority;
	private java.lang.String divisionalLetterAuthority;
	private java.lang.String dietLetterAuthority;
	private java.lang.String noteSheetSignatureAuthority;
	private java.lang.String status;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;
	private java.util.Set<jkt.hms.masters.business.MasDepartment> masDepartment;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="division_id"
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
	 * Return the value associated with the column: division_code
	 */
	public java.lang.String getDivisionCode () {
		return divisionCode;
	}

	/**
	 * Set the value related to the column: division_code
	 * @param divisionCode the division_code value
	 */
	public void setDivisionCode (java.lang.String divisionCode) {
		this.divisionCode = divisionCode;
	}



	/**
	 * Return the value associated with the column: division_name
	 */
	public java.lang.String getDivisionName () {
		return divisionName;
	}

	/**
	 * Set the value related to the column: division_name
	 * @param divisionName the division_name value
	 */
	public void setDivisionName (java.lang.String divisionName) {
		this.divisionName = divisionName;
	}



	/**
	 * Return the value associated with the column: dispatch_letter_header
	 */
	public java.lang.String getDispatchLetterHeader () {
		return dispatchLetterHeader;
	}

	/**
	 * Set the value related to the column: dispatch_letter_header
	 * @param dispatchLetterHeader the dispatch_letter_header value
	 */
	public void setDispatchLetterHeader (java.lang.String dispatchLetterHeader) {
		this.dispatchLetterHeader = dispatchLetterHeader;
	}



	/**
	 * Return the value associated with the column: covering_letter_authority
	 */
	public java.lang.String getCoveringLetterAuthority () {
		return coveringLetterAuthority;
	}

	/**
	 * Set the value related to the column: covering_letter_authority
	 * @param coveringLetterAuthority the covering_letter_authority value
	 */
	public void setCoveringLetterAuthority (java.lang.String coveringLetterAuthority) {
		this.coveringLetterAuthority = coveringLetterAuthority;
	}



	/**
	 * Return the value associated with the column: dispatch_letter_authority
	 */
	public java.lang.String getDispatchLetterAuthority () {
		return dispatchLetterAuthority;
	}

	/**
	 * Set the value related to the column: dispatch_letter_authority
	 * @param dispatchLetterAuthority the dispatch_letter_authority value
	 */
	public void setDispatchLetterAuthority (java.lang.String dispatchLetterAuthority) {
		this.dispatchLetterAuthority = dispatchLetterAuthority;
	}



	/**
	 * Return the value associated with the column: divisional_letter_authority
	 */
	public java.lang.String getDivisionalLetterAuthority () {
		return divisionalLetterAuthority;
	}

	/**
	 * Set the value related to the column: divisional_letter_authority
	 * @param divisionalLetterAuthority the divisional_letter_authority value
	 */
	public void setDivisionalLetterAuthority (java.lang.String divisionalLetterAuthority) {
		this.divisionalLetterAuthority = divisionalLetterAuthority;
	}



	/**
	 * Return the value associated with the column: diet_letter_authority
	 */
	public java.lang.String getDietLetterAuthority () {
		return dietLetterAuthority;
	}

	/**
	 * Set the value related to the column: diet_letter_authority
	 * @param dietLetterAuthority the diet_letter_authority value
	 */
	public void setDietLetterAuthority (java.lang.String dietLetterAuthority) {
		this.dietLetterAuthority = dietLetterAuthority;
	}



	/**
	 * Return the value associated with the column: note_sheet_signature_authority
	 */
	public java.lang.String getNoteSheetSignatureAuthority () {
		return noteSheetSignatureAuthority;
	}

	/**
	 * Set the value related to the column: note_sheet_signature_authority
	 * @param noteSheetSignatureAuthority the note_sheet_signature_authority value
	 */
	public void setNoteSheetSignatureAuthority (java.lang.String noteSheetSignatureAuthority) {
		this.noteSheetSignatureAuthority = noteSheetSignatureAuthority;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Integer lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: MasEmployees
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployee> getMasEmployees () {
		return masEmployees;
	}

	/**
	 * Set the value related to the column: MasEmployees
	 * @param masEmployees the MasEmployees value
	 */
	public void setMasEmployees (java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees) {
		this.masEmployees = masEmployees;
	}

	public void addToMasEmployees (jkt.hms.masters.business.MasEmployee masEmployee) {
		if (null == getMasEmployees()) setMasEmployees(new java.util.TreeSet<jkt.hms.masters.business.MasEmployee>());
		getMasEmployees().add(masEmployee);
	}



	/**
	 * Return the value associated with the column: MasDepartment
	 */
	public java.util.Set<jkt.hms.masters.business.MasDepartment> getMasDepartment () {
		return masDepartment;
	}

	/**
	 * Set the value related to the column: MasDepartment
	 * @param masDepartment the MasDepartment value
	 */
	public void setMasDepartment (java.util.Set<jkt.hms.masters.business.MasDepartment> masDepartment) {
		this.masDepartment = masDepartment;
	}

	public void addToMasDepartment (jkt.hms.masters.business.MasDepartment masDepartment) {
		if (null == getMasDepartment()) setMasDepartment(new java.util.TreeSet<jkt.hms.masters.business.MasDepartment>());
		getMasDepartment().add(masDepartment);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDivision)) return false;
		else {
			jkt.hms.masters.business.MasDivision masDivision = (jkt.hms.masters.business.MasDivision) obj;
			if (null == this.getId() || null == masDivision.getId()) return false;
			else return (this.getId().equals(masDivision.getId()));
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