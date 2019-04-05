package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_pre_anesthesia_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_pre_anesthesia_detail"
 */

public abstract class BaseOtPreAnesthesiaDetail  implements Serializable {

	public static String REF = "OtPreAnesthesiaDetail";
	public static String PROP_OPD_SURGERY_DETAIL = "OpdSurgeryDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_ANESTHESIA_HD = "AnesthesiaHd";
	public static String PROP_ID = "Id";


	// constructors
	public BaseOtPreAnesthesiaDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPreAnesthesiaDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.OpdSurgeryDetail opdSurgeryDetail;
	private jkt.hms.masters.business.OtPreAnesthesiaHd anesthesiaHd;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: opd_surgery_detail
	 */
	public jkt.hms.masters.business.OpdSurgeryDetail getOpdSurgeryDetail () {
		return opdSurgeryDetail;
	}

	/**
	 * Set the value related to the column: opd_surgery_detail
	 * @param opdSurgeryDetail the opd_surgery_detail value
	 */
	public void setOpdSurgeryDetail (jkt.hms.masters.business.OpdSurgeryDetail opdSurgeryDetail) {
		this.opdSurgeryDetail = opdSurgeryDetail;
	}



	/**
	 * Return the value associated with the column: anesthesia_hd_id
	 */
	public jkt.hms.masters.business.OtPreAnesthesiaHd getAnesthesiaHd () {
		return anesthesiaHd;
	}

	/**
	 * Set the value related to the column: anesthesia_hd_id
	 * @param anesthesiaHd the anesthesia_hd_id value
	 */
	public void setAnesthesiaHd (jkt.hms.masters.business.OtPreAnesthesiaHd anesthesiaHd) {
		this.anesthesiaHd = anesthesiaHd;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPreAnesthesiaDetail)) return false;
		else {
			jkt.hms.masters.business.OtPreAnesthesiaDetail otPreAnesthesiaDetail = (jkt.hms.masters.business.OtPreAnesthesiaDetail) obj;
			if (null == this.getId() || null == otPreAnesthesiaDetail.getId()) return false;
			else return (this.getId().equals(otPreAnesthesiaDetail.getId()));
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