package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sims_mims_contradiction table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sims_mims_contradiction"
 */

public abstract class BaseSimsMimsContradiction  implements Serializable {

	public static String REF = "SimsMimsContradiction";
	public static String PROP_INTRACTION = "Intraction";
	public static String PROP_ITEM = "Item";
	public static String PROP_CONTRA_ITEM = "ContraItem";
	public static String PROP_ID = "Id";


	// constructors
	public BaseSimsMimsContradiction () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSimsMimsContradiction (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String intraction;

	// many to one
	private jkt.hms.masters.business.MasStoreItem contraItem;
	private jkt.hms.masters.business.MasStoreItem item;



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
	 * Return the value associated with the column: intraction
	 */
	public java.lang.String getIntraction () {
		return intraction;
	}

	/**
	 * Set the value related to the column: intraction
	 * @param intraction the intraction value
	 */
	public void setIntraction (java.lang.String intraction) {
		this.intraction = intraction;
	}



	/**
	 * Return the value associated with the column: contra_item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getContraItem () {
		return contraItem;
	}

	/**
	 * Set the value related to the column: contra_item_id
	 * @param contraItem the contra_item_id value
	 */
	public void setContraItem (jkt.hms.masters.business.MasStoreItem contraItem) {
		this.contraItem = contraItem;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SimsMimsContradiction)) return false;
		else {
			jkt.hms.masters.business.SimsMimsContradiction simsMimsContradiction = (jkt.hms.masters.business.SimsMimsContradiction) obj;
			if (null == this.getId() || null == simsMimsContradiction.getId()) return false;
			else return (this.getId().equals(simsMimsContradiction.getId()));
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