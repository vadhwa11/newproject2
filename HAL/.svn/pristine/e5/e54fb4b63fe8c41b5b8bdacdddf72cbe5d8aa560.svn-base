package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_bed table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_bed"
 */

public abstract class BaseOtBed  implements Serializable {

	public static String REF = "OtBed";
	public static String PROP_OT = "Ot";
	public static String PROP_ID = "Id";
	public static String PROP_BED = "Bed";


	// constructors
	public BaseOtBed () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtBed (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasBed bed;
	private jkt.hms.masters.business.MasOt ot;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="ot_bed_id"
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
	 * Return the value associated with the column: bed_id
	 */
	public jkt.hms.masters.business.MasBed getBed () {
		return bed;
	}

	/**
	 * Set the value related to the column: bed_id
	 * @param bed the bed_id value
	 */
	public void setBed (jkt.hms.masters.business.MasBed bed) {
		this.bed = bed;
	}



	/**
	 * Return the value associated with the column: ot_id
	 */
	public jkt.hms.masters.business.MasOt getOt () {
		return ot;
	}

	/**
	 * Set the value related to the column: ot_id
	 * @param ot the ot_id value
	 */
	public void setOt (jkt.hms.masters.business.MasOt ot) {
		this.ot = ot;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtBed)) return false;
		else {
			jkt.hms.masters.business.OtBed otBed = (jkt.hms.masters.business.OtBed) obj;
			if (null == this.getId() || null == otBed.getId()) return false;
			else return (this.getId().equals(otBed.getId()));
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