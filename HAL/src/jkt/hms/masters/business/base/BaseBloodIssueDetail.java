package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_issue_detail table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="blood_issue_detail"
 */

public abstract class BaseBloodIssueDetail implements Serializable {

	public static String REF = "BloodIssueDetail";
	public static String PROP_ISSUE_HEADER = "IssueHeader";
	public static String PROP_STOCK_DETAIL = "StockDetail";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBloodIssueDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodIssueDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.BloodIssueHeader issueHeader;
	private jkt.hms.masters.business.BloodStockDetail stockDetail;

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
	 * Return the value associated with the column: issue_header_id
	 */
	public jkt.hms.masters.business.BloodIssueHeader getIssueHeader() {
		return issueHeader;
	}

	/**
	 * Set the value related to the column: issue_header_id
	 * 
	 * @param issueHeader
	 *            the issue_header_id value
	 */
	public void setIssueHeader(
			jkt.hms.masters.business.BloodIssueHeader issueHeader) {
		this.issueHeader = issueHeader;
	}

	/**
	 * Return the value associated with the column: stock_detail_id
	 */
	public jkt.hms.masters.business.BloodStockDetail getStockDetail() {
		return stockDetail;
	}

	/**
	 * Set the value related to the column: stock_detail_id
	 * 
	 * @param stockDetail
	 *            the stock_detail_id value
	 */
	public void setStockDetail(
			jkt.hms.masters.business.BloodStockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodIssueDetail))
			return false;
		else {
			jkt.hms.masters.business.BloodIssueDetail bloodIssueDetail = (jkt.hms.masters.business.BloodIssueDetail) obj;
			if (null == this.getId() || null == bloodIssueDetail.getId())
				return false;
			else
				return (this.getId().equals(bloodIssueDetail.getId()));
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