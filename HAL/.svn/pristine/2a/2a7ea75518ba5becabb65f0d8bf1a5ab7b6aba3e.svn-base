package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_mas_narration table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_mas_narration"
 */

public abstract class BaseFaMasNarration  implements Serializable {

	public static String REF = "FaMasNarration";
	public static String PROP_NARRATION_DESC = "NarrationDesc";
	public static String PROP_ID = "Id";
	public static String PROP_FLAG = "Flag";


	// constructors
	public BaseFaMasNarration () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaMasNarration (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String narrationDesc;
	private java.lang.String flag;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="narration_id"
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
	 * Return the value associated with the column: narration_desc
	 */
	public java.lang.String getNarrationDesc () {
		return narrationDesc;
	}

	/**
	 * Set the value related to the column: narration_desc
	 * @param narrationDesc the narration_desc value
	 */
	public void setNarrationDesc (java.lang.String narrationDesc) {
		this.narrationDesc = narrationDesc;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaMasNarration)) return false;
		else {
			jkt.hms.masters.business.FaMasNarration faMasNarration = (jkt.hms.masters.business.FaMasNarration) obj;
			if (null == this.getId() || null == faMasNarration.getId()) return false;
			else return (this.getId().equals(faMasNarration.getId()));
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