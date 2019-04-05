package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MEDICINENET table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MEDICINENET"
 */

public abstract class BaseMedicinenet  implements Serializable {

	public static String REF = "Medicinenet";
	public static String PROP_NAME = "Name";
	public static String PROP_TERM = "Term";
	public static String PROP_CAUSE = "Cause";
	public static String PROP_OTHERCAUSE = "Othercause";
	public static String PROP_EXAMPLE = "Example";


	// constructors
	public BaseMedicinenet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMedicinenet (java.lang.String sno) {
		this.setSno(sno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String sno;

	// fields
	private java.lang.String name;
	private java.lang.String term;
	private java.lang.String cause;
	private java.lang.String othercause;
	private java.lang.String example;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="SNO"
     */
	public java.lang.String getSno () {
		return sno;
	}

	/**
	 * Set the unique identifier of this class
	 * @param sno the new ID
	 */
	public void setSno (java.lang.String sno) {
		this.sno = sno;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: TERM
	 */
	public java.lang.String getTerm () {
		return term;
	}

	/**
	 * Set the value related to the column: TERM
	 * @param term the TERM value
	 */
	public void setTerm (java.lang.String term) {
		this.term = term;
	}



	/**
	 * Return the value associated with the column: CAUSE
	 */
	public java.lang.String getCause () {
		return cause;
	}

	/**
	 * Set the value related to the column: CAUSE
	 * @param cause the CAUSE value
	 */
	public void setCause (java.lang.String cause) {
		this.cause = cause;
	}



	/**
	 * Return the value associated with the column: OTHERCAUSE
	 */
	public java.lang.String getOthercause () {
		return othercause;
	}

	/**
	 * Set the value related to the column: OTHERCAUSE
	 * @param othercause the OTHERCAUSE value
	 */
	public void setOthercause (java.lang.String othercause) {
		this.othercause = othercause;
	}



	/**
	 * Return the value associated with the column: EXAMPLE
	 */
	public java.lang.String getExample () {
		return example;
	}

	/**
	 * Set the value related to the column: EXAMPLE
	 * @param example the EXAMPLE value
	 */
	public void setExample (java.lang.String example) {
		this.example = example;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Medicinenet)) return false;
		else {
			jkt.hms.masters.business.Medicinenet medicinenet = (jkt.hms.masters.business.Medicinenet) obj;
			if (null == this.getSno() || null == medicinenet.getSno()) return false;
			else return (this.getSno().equals(medicinenet.getSno()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSno()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSno().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}