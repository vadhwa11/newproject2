package jkt.hms.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the STORE_PO_HEADER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="STORE_PO_HEADER"
 */

public abstract class BaseStorePoHeader  implements Serializable {

	public static String REF = "StorePoHeader";


	// constructors
	public BaseStorePoHeader () {
		initialize();
	}

	protected void initialize () {}













	public String toString () {
		return super.toString();
	}


}