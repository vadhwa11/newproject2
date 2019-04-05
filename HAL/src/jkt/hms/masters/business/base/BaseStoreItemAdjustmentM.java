package jkt.hms.masters.business.base;

import java.io.Serializable;
import java.sql.Date;


/**
 * This is an object that contains data related to the store_item_adjustment_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_item_adjustment_m"
 */

public abstract class BaseStoreItemAdjustmentM  implements Serializable {

	public static String REF = "StoreItemAdjustmentM";
	public static String ITEM_ADJUSTMENT_ID="ItemAdjustmentId" ;
	public static String ADJUSTMENT_NO="AdjustmentNo" ;
	public static String ADJUSTMENT_DATE="AdjustmentDate" ;
	public static String ADJUSTMENT_REMARKS="AdjustmentRemarks" ;
	public static String ADJUSTMENT_LOGIN_DEPT="AdjustmentLoginDept" ;
	
	//private fields
	private int itemAdjustmentId ;
	private String adjustmentNo ;
	private int adjustmentLoginDept ;
	private java.util.Date  adjustmentDate;
	private String adjustmentRemarks ;
	
	private jkt.hms.masters.business.MasEmployee adjustmentAuthority ;
	 


	/**
	 * @return the adjustmentAuthority
	 */
	public jkt.hms.masters.business.MasEmployee getAdjustmentAuthority() {
		return adjustmentAuthority;
	}

	/**
	 * @param adjustmentAuthority the adjustmentAuthority to set
	 */
	public void setAdjustmentAuthority(
			jkt.hms.masters.business.MasEmployee adjustmentAuthority) {
		this.adjustmentAuthority = adjustmentAuthority;
	}

	/**
	 * @return the itemAdjustmentId
	 */
	public int getItemAdjustmentId() {
		return itemAdjustmentId;
	}

	/**
	 * @param itemAdjustmentId the itemAdjustmentId to set
	 */
	public void setItemAdjustmentId(int itemAdjustmentId) {
		this.itemAdjustmentId = itemAdjustmentId;
	}

	/**
	 * @return the adjustmentNo
	 */
	public String getAdjustmentNo() {
		return adjustmentNo;
	}

	/**
	 * @param adjustmentNo the adjustmentNo to set
	 */
	public void setAdjustmentNo(String adjustmentNo) {
		this.adjustmentNo = adjustmentNo;
	}

	
	/**
	 * @return the adjustmentDate
	 */
	public java.util.Date  getAdjustmentDate() {
		return adjustmentDate;
	}

	/**
	 * @param adjustmentDate the adjustmentDate to set
	 */
	public void setAdjustmentDate(java.util.Date  adjustmentDate) {
		this.adjustmentDate = adjustmentDate;
	}

	/**
	 * @return the adjustmentRemarks
	 */
	public String getAdjustmentRemarks() {
		return adjustmentRemarks;
	}

	/**
	 * @param adjustmentRemarks the adjustmentRemarks to set
	 */
	public void setAdjustmentRemarks(String adjustmentRemarks) {
		this.adjustmentRemarks = adjustmentRemarks;
	}

	// constructors
	public BaseStoreItemAdjustmentM () {
		initialize();
	}

	protected void initialize () {}



	public String toString () {
		return super.toString();
	}

	/**
	 * @param adjustmentLoginDept the adjustmentLoginDept to set
	 */
	public void setAdjustmentLoginDept(int adjustmentLoginDept) {
		this.adjustmentLoginDept = adjustmentLoginDept;
	}

	/**
	 * @return the adjustmentLoginDept
	 */
	public int getAdjustmentLoginDept() {
		return adjustmentLoginDept;
	}


}