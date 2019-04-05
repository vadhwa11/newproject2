package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_medical_board_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_medical_board_details"
 */

public abstract class BaseMasMedicalBoardDetails  implements Serializable {

	public static String REF = "MasMedicalBoardDetails";
	public static String PROP_PREVIOUS_MEDICAL_CATEGORISATION_DATE = "PreviousMedicalCategorisationDate";
	public static String PROP_PLACE_OF_ORIGIN = "PlaceOfOrigin";
	public static String PROP_BOARD_PROCEEDINGS = "BoardProceedings";
	public static String PROP_NEXT_MEDICAL_CATEGORISATION_DUE = "NextMedicalCategorisationDue";
	public static String PROP_DISABILITIES = "Disabilities";
	public static String PROP_DATE_OF_ORIGIN = "DateOfOrigin";
	public static String PROP_ID = "Id";
	public static String PROP_PREVIOUS_MEDICAL_CATEGORISATRION = "PreviousMedicalCategorisatrion";
	public static String PROP_SR_NO = "SrNo";


	// constructors
	public BaseMasMedicalBoardDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMedicalBoardDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String disabilities;
	private java.util.Date dateOfOrigin;
	private java.lang.String placeOfOrigin;
	private java.lang.String previousMedicalCategorisatrion;
	private java.util.Date previousMedicalCategorisationDate;
	private java.util.Date nextMedicalCategorisationDue;

	// many to one
	private jkt.hms.masters.business.MasMedicalBoardProceedings boardProceedings;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="board_details_id"
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
	 * Return the value associated with the column: SrNo
	 */
	public java.lang.Integer getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: SrNo
	 * @param srNo the SrNo value
	 */
	public void setSrNo (java.lang.Integer srNo) {
		this.srNo = srNo;
	}



	/**
	 * Return the value associated with the column: disabilities
	 */
	public java.lang.String getDisabilities () {
		return disabilities;
	}

	/**
	 * Set the value related to the column: disabilities
	 * @param disabilities the disabilities value
	 */
	public void setDisabilities (java.lang.String disabilities) {
		this.disabilities = disabilities;
	}



	/**
	 * Return the value associated with the column: date_of_origin
	 */
	public java.util.Date getDateOfOrigin () {
		return dateOfOrigin;
	}

	/**
	 * Set the value related to the column: date_of_origin
	 * @param dateOfOrigin the date_of_origin value
	 */
	public void setDateOfOrigin (java.util.Date dateOfOrigin) {
		this.dateOfOrigin = dateOfOrigin;
	}



	/**
	 * Return the value associated with the column: place_of_origin
	 */
	public java.lang.String getPlaceOfOrigin () {
		return placeOfOrigin;
	}

	/**
	 * Set the value related to the column: place_of_origin
	 * @param placeOfOrigin the place_of_origin value
	 */
	public void setPlaceOfOrigin (java.lang.String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}



	/**
	 * Return the value associated with the column: previous_medical_categorisatrion
	 */
	public java.lang.String getPreviousMedicalCategorisatrion () {
		return previousMedicalCategorisatrion;
	}

	/**
	 * Set the value related to the column: previous_medical_categorisatrion
	 * @param previousMedicalCategorisatrion the previous_medical_categorisatrion value
	 */
	public void setPreviousMedicalCategorisatrion (java.lang.String previousMedicalCategorisatrion) {
		this.previousMedicalCategorisatrion = previousMedicalCategorisatrion;
	}



	/**
	 * Return the value associated with the column: previous_medical_categorisation_date
	 */
	public java.util.Date getPreviousMedicalCategorisationDate () {
		return previousMedicalCategorisationDate;
	}

	/**
	 * Set the value related to the column: previous_medical_categorisation_date
	 * @param previousMedicalCategorisationDate the previous_medical_categorisation_date value
	 */
	public void setPreviousMedicalCategorisationDate (java.util.Date previousMedicalCategorisationDate) {
		this.previousMedicalCategorisationDate = previousMedicalCategorisationDate;
	}



	/**
	 * Return the value associated with the column: next_medical_categorisation_due
	 */
	public java.util.Date getNextMedicalCategorisationDue () {
		return nextMedicalCategorisationDue;
	}

	/**
	 * Set the value related to the column: next_medical_categorisation_due
	 * @param nextMedicalCategorisationDue the next_medical_categorisation_due value
	 */
	public void setNextMedicalCategorisationDue (java.util.Date nextMedicalCategorisationDue) {
		this.nextMedicalCategorisationDue = nextMedicalCategorisationDue;
	}



	/**
	 * Return the value associated with the column: board_proceedings_id
	 */
	public jkt.hms.masters.business.MasMedicalBoardProceedings getBoardProceedings () {
		return boardProceedings;
	}

	/**
	 * Set the value related to the column: board_proceedings_id
	 * @param boardProceedings the board_proceedings_id value
	 */
	public void setBoardProceedings (jkt.hms.masters.business.MasMedicalBoardProceedings boardProceedings) {
		this.boardProceedings = boardProceedings;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasMedicalBoardDetails)) return false;
		else {
			jkt.hms.masters.business.MasMedicalBoardDetails masMedicalBoardDetails = (jkt.hms.masters.business.MasMedicalBoardDetails) obj;
			if (null == this.getId() || null == masMedicalBoardDetails.getId()) return false;
			else return (this.getId().equals(masMedicalBoardDetails.getId()));
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