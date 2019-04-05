package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the lib_book_return_dt table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="lib_book_return_dt"
 */

public abstract class BaseLibBookReturnDt implements Serializable {

	public static String REF = "LibBookReturnDt";
	public static String PROP_RETURN_HD = "ReturnHd";
	public static String PROP_ISSUE_DT = "IssueDt";
	public static String PROP_BOOK_RETURN = "BookReturn";
	public static String PROP_ID = "Id";

	// constructors
	public BaseLibBookReturnDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibBookReturnDt(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bookReturn;

	// many to one
	private jkt.hms.masters.business.LibBookIssueDetail issueDt;
	private jkt.hms.masters.business.LibBookReturnHd returnHd;

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
	 * Return the value associated with the column: book_return
	 */
	public java.lang.String getBookReturn() {
		return bookReturn;
	}

	/**
	 * Set the value related to the column: book_return
	 * 
	 * @param bookReturn
	 *            the book_return value
	 */
	public void setBookReturn(java.lang.String bookReturn) {
		this.bookReturn = bookReturn;
	}

	/**
	 * Return the value associated with the column: issue_dt_id
	 */
	public jkt.hms.masters.business.LibBookIssueDetail getIssueDt() {
		return issueDt;
	}

	/**
	 * Set the value related to the column: issue_dt_id
	 * 
	 * @param issueDt
	 *            the issue_dt_id value
	 */
	public void setIssueDt(jkt.hms.masters.business.LibBookIssueDetail issueDt) {
		this.issueDt = issueDt;
	}

	/**
	 * Return the value associated with the column: return_hd_id
	 */
	public jkt.hms.masters.business.LibBookReturnHd getReturnHd() {
		return returnHd;
	}

	/**
	 * Set the value related to the column: return_hd_id
	 * 
	 * @param returnHd
	 *            the return_hd_id value
	 */
	public void setReturnHd(jkt.hms.masters.business.LibBookReturnHd returnHd) {
		this.returnHd = returnHd;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LibBookReturnDt))
			return false;
		else {
			jkt.hms.masters.business.LibBookReturnDt libBookReturnDt = (jkt.hms.masters.business.LibBookReturnDt) obj;
			if (null == this.getId() || null == libBookReturnDt.getId())
				return false;
			else
				return (this.getId().equals(libBookReturnDt.getId()));
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