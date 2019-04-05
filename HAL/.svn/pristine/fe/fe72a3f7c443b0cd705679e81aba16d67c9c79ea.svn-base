package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_application table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_application"
 */

public abstract class BaseMasApplication implements Serializable {

	public static String REF = "MasApplication";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_PARENT_ID = "ParentId";
	public static String PROP_URL = "Url";
	public static String PROP_APPLICATION = "application";
	public static String PROP_NAME = "Name";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasApplication() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasApplication(java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String name;
	private java.lang.String parentId;
	private java.lang.String url;
	private java.lang.Integer orderNo;

	// many to one
	private jkt.hms.masters.business.MasApplication application;

	// collections
	private java.util.Set<jkt.hms.masters.business.GroupApplication> groupApplications;
	private java.util.Set<jkt.hms.masters.business.UsergroupApplications> usergroupApplications;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="assigned" column="app_id"
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * 
	 * @param name
	 *            the name value
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * Return the value associated with the column: parent_id
	 */
	public java.lang.String getParentId() {
		return parentId;
	}

	/**
	 * Set the value related to the column: parent_id
	 * 
	 * @param parentId
	 *            the parent_id value
	 */
	public void setParentId(java.lang.String parentId) {
		this.parentId = parentId;
	}

	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl() {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * 
	 * @param url
	 *            the url value
	 */
	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo() {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * 
	 * @param orderNo
	 *            the order_no value
	 */
	public void setOrderNo(java.lang.Integer orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * Return the value associated with the column: parent_id
	 */
	public jkt.hms.masters.business.MasApplication getApplication() {
		return application;
	}

	/**
	 * Set the value related to the column: parent_id
	 * 
	 * @param application
	 *            the parent_id value
	 */
	public void setApplication(
			jkt.hms.masters.business.MasApplication application) {
		this.application = application;
	}

	/**
	 * Return the value associated with the column: GroupApplications
	 */
	public java.util.Set<jkt.hms.masters.business.GroupApplication> getGroupApplications() {
		return groupApplications;
	}

	/**
	 * Set the value related to the column: GroupApplications
	 * 
	 * @param groupApplications
	 *            the GroupApplications value
	 */
	public void setGroupApplications(
			java.util.Set<jkt.hms.masters.business.GroupApplication> groupApplications) {
		this.groupApplications = groupApplications;
	}

	public void addToGroupApplications(
			jkt.hms.masters.business.GroupApplication groupApplication) {
		if (null == getGroupApplications())
			setGroupApplications(new java.util.TreeSet<jkt.hms.masters.business.GroupApplication>());
		getGroupApplications().add(groupApplication);
	}

	/**
	 * Return the value associated with the column: UsergroupApplications
	 */
	public java.util.Set<jkt.hms.masters.business.UsergroupApplications> getUsergroupApplications() {
		return usergroupApplications;
	}

	/**
	 * Set the value related to the column: UsergroupApplications
	 * 
	 * @param usergroupApplications
	 *            the UsergroupApplications value
	 */
	public void setUsergroupApplications(
			java.util.Set<jkt.hms.masters.business.UsergroupApplications> usergroupApplications) {
		this.usergroupApplications = usergroupApplications;
	}

	public void addToUsergroupApplications(
			jkt.hms.masters.business.UsergroupApplications usergroupApplications) {
		if (null == getUsergroupApplications())
			setUsergroupApplications(new java.util.TreeSet<jkt.hms.masters.business.UsergroupApplications>());
		getUsergroupApplications().add(usergroupApplications);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasApplication))
			return false;
		else {
			jkt.hms.masters.business.MasApplication masApplication = (jkt.hms.masters.business.MasApplication) obj;
			if (null == this.getId() || null == masApplication.getId())
				return false;
			else
				return (this.getId().equals(masApplication.getId()));
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