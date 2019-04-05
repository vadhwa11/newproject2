package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * store_tender_comm_hod_recom table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_tender_comm_hod_recom"
 */

public abstract class BaseStoreTenderCommHodRecom implements Serializable {

	public static String REF = "StoreTenderCommHodRecom";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_SPECIALIST = "Specialist";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_ID = "Id";
	public static String PROP_REMARKS = "Remarks";

	// constructors
	public BaseStoreTenderCommHodRecom() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderCommHodRecom(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreTenderCommHodRecom(java.lang.Integer id,
			jkt.hms.masters.business.MasEmployee specialist,
			jkt.hms.masters.business.MasStoreSupplier supplier,
			java.lang.Integer srNo) {

		this.setId(id);
		this.setSpecialist(specialist);
		this.setSupplier(supplier);
		this.setSrNo(srNo);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasEmployee specialist;
	private jkt.hms.masters.business.MasStoreSupplier supplier;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo() {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * 
	 * @param srNo
	 *            the sr_no value
	 */
	public void setSrNo(java.lang.Integer srNo) {
		this.srNo = srNo;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: specialist_id
	 */
	public jkt.hms.masters.business.MasEmployee getSpecialist() {
		return specialist;
	}

	/**
	 * Set the value related to the column: specialist_id
	 * 
	 * @param specialist
	 *            the specialist_id value
	 */
	public void setSpecialist(jkt.hms.masters.business.MasEmployee specialist) {
		this.specialist = specialist;
	}

	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier() {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * 
	 * @param supplier
	 *            the supplier_id value
	 */
	public void setSupplier(jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderCommHodRecom))
			return false;
		else {
			jkt.hms.masters.business.StoreTenderCommHodRecom storeTenderCommHodRecom = (jkt.hms.masters.business.StoreTenderCommHodRecom) obj;
			if (null == this.getId() || null == storeTenderCommHodRecom.getId())
				return false;
			else
				return (this.getId().equals(storeTenderCommHodRecom.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}