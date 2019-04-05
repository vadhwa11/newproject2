package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PHYSIO_REQUISITION_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PHYSIO_REQUISITION_DETAIL"
 */

public abstract class BasePhysioRequisitionDetail  implements Serializable {

	public static String REF = "PhysioRequisitionDetail";
	public static String PROP_PHYSIO_REQUISITION_HEADER = "PhysioRequisitionHeader";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_REMARK = "Remark";
	public static String PROP_THARAPHY = "Tharaphy";
	public static String PROP_NO_OF_DAYS = "NoOfDays";


	// constructors
	public BasePhysioRequisitionDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysioRequisitionDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer noOfDays;
	private java.lang.String duration;
	private java.lang.String remark;

	// many to one
	private jkt.hms.masters.business.MasTherapyType tharaphy;
	private jkt.hms.masters.business.PhysioRequisitionHeader physioRequisitionHeader;
	private jkt.hms.masters.business.MasFrequency frequency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="PHYSIO_REQUISITION_DETAIL_ID"
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
	 * Return the value associated with the column: NO_OF_DAYS
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: NO_OF_DAYS
	 * @param noOfDays the NO_OF_DAYS value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: DURATION
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: DURATION
	 * @param duration the DURATION value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * @param remark the REMARK value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: tharaphy_id
	 */
	public jkt.hms.masters.business.MasTherapyType getTharaphy () {
		return tharaphy;
	}

	/**
	 * Set the value related to the column: tharaphy_id
	 * @param tharaphy the tharaphy_id value
	 */
	public void setTharaphy (jkt.hms.masters.business.MasTherapyType tharaphy) {
		this.tharaphy = tharaphy;
	}



	/**
	 * Return the value associated with the column: physio_requisition_header_id
	 */
	public jkt.hms.masters.business.PhysioRequisitionHeader getPhysioRequisitionHeader () {
		return physioRequisitionHeader;
	}

	/**
	 * Set the value related to the column: physio_requisition_header_id
	 * @param physioRequisitionHeader the physio_requisition_header_id value
	 */
	public void setPhysioRequisitionHeader (jkt.hms.masters.business.PhysioRequisitionHeader physioRequisitionHeader) {
		this.physioRequisitionHeader = physioRequisitionHeader;
	}



	/**
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhysioRequisitionDetail)) return false;
		else {
			jkt.hms.masters.business.PhysioRequisitionDetail physioRequisitionDetail = (jkt.hms.masters.business.PhysioRequisitionDetail) obj;
			if (null == this.getId() || null == physioRequisitionDetail.getId()) return false;
			else return (this.getId().equals(physioRequisitionDetail.getId()));
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