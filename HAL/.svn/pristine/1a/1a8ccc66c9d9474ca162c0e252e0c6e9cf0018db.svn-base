package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_setup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_setup"
 */

public abstract class BaseStoreSetup  implements Serializable {

	public static String REF = "StoreSetup";
	public static String PROP_MMF_TENDER_MONTH = "MmfTenderMonth";
	public static String PROP_A_CLASS = "AClass";
	public static String PROP_UNUSED_MMF_DAYS = "UnusedMmfDays";
	public static String PROP_STORE_DISPENSARY = "StoreDispensary";
	public static String PROP_SLOW_MOVING = "SlowMoving";
	public static String PROP_FAST_MOVING = "FastMoving";
	public static String PROP_STORE_ECHS_DISPENSARY = "StoreEchsDispensary";
	public static String PROP_STORE_ECHS = "StoreEchs";
	public static String PROP_ID = "Id";
	public static String PROP_STORE_EXPENDABLE = "StoreExpendable";
	public static String PROP_B_CLASS = "BClass";
	public static String PROP_NON_MOVING = "NonMoving";


	// constructors
	public BaseStoreSetup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreSetup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Short fastMoving;
	private java.lang.Short slowMoving;
	private java.lang.Short nonMoving;
	private java.lang.Integer aClass;
	private java.lang.Integer bClass;
	private java.lang.Short unusedMmfDays;
	private java.lang.Integer mmfTenderMonth;

	// many to one
	private jkt.hms.masters.business.MasDepartment storeDispensary;
	private jkt.hms.masters.business.MasDepartment storeEchs;
	private jkt.hms.masters.business.MasDepartment storeExpendable;
	private jkt.hms.masters.business.MasDepartment storeEchsDispensary;



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
	 * Return the value associated with the column: fast_moving
	 */
	public java.lang.Short getFastMoving () {
		return fastMoving;
	}

	/**
	 * Set the value related to the column: fast_moving
	 * @param fastMoving the fast_moving value
	 */
	public void setFastMoving (java.lang.Short fastMoving) {
		this.fastMoving = fastMoving;
	}



	/**
	 * Return the value associated with the column: slow_moving
	 */
	public java.lang.Short getSlowMoving () {
		return slowMoving;
	}

	/**
	 * Set the value related to the column: slow_moving
	 * @param slowMoving the slow_moving value
	 */
	public void setSlowMoving (java.lang.Short slowMoving) {
		this.slowMoving = slowMoving;
	}



	/**
	 * Return the value associated with the column: non_moving
	 */
	public java.lang.Short getNonMoving () {
		return nonMoving;
	}

	/**
	 * Set the value related to the column: non_moving
	 * @param nonMoving the non_moving value
	 */
	public void setNonMoving (java.lang.Short nonMoving) {
		this.nonMoving = nonMoving;
	}



	/**
	 * Return the value associated with the column: a_class
	 */
	public java.lang.Integer getAClass () {
		return aClass;
	}

	/**
	 * Set the value related to the column: a_class
	 * @param aClass the a_class value
	 */
	public void setAClass (java.lang.Integer aClass) {
		this.aClass = aClass;
	}



	/**
	 * Return the value associated with the column: b_class
	 */
	public java.lang.Integer getBClass () {
		return bClass;
	}

	/**
	 * Set the value related to the column: b_class
	 * @param bClass the b_class value
	 */
	public void setBClass (java.lang.Integer bClass) {
		this.bClass = bClass;
	}



	/**
	 * Return the value associated with the column: unused_mmf_days
	 */
	public java.lang.Short getUnusedMmfDays () {
		return unusedMmfDays;
	}

	/**
	 * Set the value related to the column: unused_mmf_days
	 * @param unusedMmfDays the unused_mmf_days value
	 */
	public void setUnusedMmfDays (java.lang.Short unusedMmfDays) {
		this.unusedMmfDays = unusedMmfDays;
	}



	/**
	 * Return the value associated with the column: mmf_tender_month
	 */
	public java.lang.Integer getMmfTenderMonth () {
		return mmfTenderMonth;
	}

	/**
	 * Set the value related to the column: mmf_tender_month
	 * @param mmfTenderMonth the mmf_tender_month value
	 */
	public void setMmfTenderMonth (java.lang.Integer mmfTenderMonth) {
		this.mmfTenderMonth = mmfTenderMonth;
	}



	/**
	 * Return the value associated with the column: store_dispensary_id
	 */
	public jkt.hms.masters.business.MasDepartment getStoreDispensary () {
		return storeDispensary;
	}

	/**
	 * Set the value related to the column: store_dispensary_id
	 * @param storeDispensary the store_dispensary_id value
	 */
	public void setStoreDispensary (jkt.hms.masters.business.MasDepartment storeDispensary) {
		this.storeDispensary = storeDispensary;
	}



	/**
	 * Return the value associated with the column: store_echs
	 */
	public jkt.hms.masters.business.MasDepartment getStoreEchs () {
		return storeEchs;
	}

	/**
	 * Set the value related to the column: store_echs
	 * @param storeEchs the store_echs value
	 */
	public void setStoreEchs (jkt.hms.masters.business.MasDepartment storeEchs) {
		this.storeEchs = storeEchs;
	}



	/**
	 * Return the value associated with the column: store_expendable
	 */
	public jkt.hms.masters.business.MasDepartment getStoreExpendable () {
		return storeExpendable;
	}

	/**
	 * Set the value related to the column: store_expendable
	 * @param storeExpendable the store_expendable value
	 */
	public void setStoreExpendable (jkt.hms.masters.business.MasDepartment storeExpendable) {
		this.storeExpendable = storeExpendable;
	}



	/**
	 * Return the value associated with the column: store_echs_dispensary_id
	 */
	public jkt.hms.masters.business.MasDepartment getStoreEchsDispensary () {
		return storeEchsDispensary;
	}

	/**
	 * Set the value related to the column: store_echs_dispensary_id
	 * @param storeEchsDispensary the store_echs_dispensary_id value
	 */
	public void setStoreEchsDispensary (jkt.hms.masters.business.MasDepartment storeEchsDispensary) {
		this.storeEchsDispensary = storeEchsDispensary;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreSetup)) return false;
		else {
			jkt.hms.masters.business.StoreSetup storeSetup = (jkt.hms.masters.business.StoreSetup) obj;
			if (null == this.getId() || null == storeSetup.getId()) return false;
			else return (this.getId().equals(storeSetup.getId()));
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