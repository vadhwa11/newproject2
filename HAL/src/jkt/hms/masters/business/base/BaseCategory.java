package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CATEGORY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CATEGORY"
 */

public abstract class BaseCategory  implements Serializable {

	public static String REF = "Category";
	public static String PROP_CATEGORIES = "Categories";


	// constructors
	public BaseCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCategory (java.lang.Integer categoryid) {
		this.setCategoryid(categoryid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer categoryid;

	// fields
	private java.lang.String categories;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="CATEGORYID"
     */
	public java.lang.Integer getCategoryid () {
		return categoryid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param categoryid the new ID
	 */
	public void setCategoryid (java.lang.Integer categoryid) {
		this.categoryid = categoryid;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: CATEGORIES
	 */
	public java.lang.String getCategories () {
		return categories;
	}

	/**
	 * Set the value related to the column: CATEGORIES
	 * @param categories the CATEGORIES value
	 */
	public void setCategories (java.lang.String categories) {
		this.categories = categories;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Category)) return false;
		else {
			jkt.hms.masters.business.Category category = (jkt.hms.masters.business.Category) obj;
			if (null == this.getCategoryid() || null == category.getCategoryid()) return false;
			else return (this.getCategoryid().equals(category.getCategoryid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCategoryid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCategoryid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}