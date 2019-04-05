package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hms_notice_board table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hms_notice_board"
 */

public abstract class BaseHmsNoticeBoard implements Serializable {

	public static String REF = "HmsNoticeBoard";
	public static String PROP_STATUS = "Status";
	public static String PROP_SER_TIME = "SerTime";
	public static String PROP_ID = "Id";
	public static String PROP_SER_DATE = "SerDate";
	public static String PROP_DESC = "Desc";

	// constructors
	public BaseHmsNoticeBoard() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHmsNoticeBoard(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String desc;
	private java.lang.String status;
	private java.util.Date serDate;
	private java.lang.String serTime;

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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDesc() {
		return desc;
	}

	/**
	 * Set the value related to the column: description
	 * 
	 * @param desc
	 *            the description value
	 */
	public void setDesc(java.lang.String desc) {
		this.desc = desc;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getSerDate() {
		return serDate;
	}

	/**
	 * Set the value related to the column: date
	 * 
	 * @param serDate
	 *            the date value
	 */
	public void setSerDate(java.util.Date serDate) {
		this.serDate = serDate;
	}

	/**
	 * Return the value associated with the column: time
	 */
	public java.lang.String getSerTime() {
		return serTime;
	}

	/**
	 * Set the value related to the column: time
	 * 
	 * @param serTime
	 *            the time value
	 */
	public void setSerTime(java.lang.String serTime) {
		this.serTime = serTime;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.HmsNoticeBoard))
			return false;
		else {
			jkt.hms.masters.business.HmsNoticeBoard hmsNoticeBoard = (jkt.hms.masters.business.HmsNoticeBoard) obj;
			if (null == this.getId() || null == hmsNoticeBoard.getId())
				return false;
			else
				return (this.getId().equals(hmsNoticeBoard.getId()));
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