package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_button_form table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_button_form"
 */

public abstract class BaseMasButtonForm  implements Serializable {

	public static String REF = "MasButtonForm";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FORM_NAME = "FormName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FORMULA_USED = "FormulaUsed";
	public static String PROP_URL = "Url";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CLASS_NAME = "ClassName";
	public static String PROP_ID = "Id";
	public static String PROP_BUTTON_NAME = "ButtonName";


	// constructors
	public BaseMasButtonForm () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasButtonForm (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String buttonName;
	private java.lang.String formName;
	private java.lang.String url;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String className;
	private java.lang.String formulaUsed;

	// collections
	private java.util.Set<jkt.hms.masters.business.TemplateApplication> templateApplications;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="button_id"
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
	 * Return the value associated with the column: button_name
	 */
	public java.lang.String getButtonName () {
		return buttonName;
	}

	/**
	 * Set the value related to the column: button_name
	 * @param buttonName the button_name value
	 */
	public void setButtonName (java.lang.String buttonName) {
		this.buttonName = buttonName;
	}



	/**
	 * Return the value associated with the column: form_name
	 */
	public java.lang.String getFormName () {
		return formName;
	}

	/**
	 * Set the value related to the column: form_name
	 * @param formName the form_name value
	 */
	public void setFormName (java.lang.String formName) {
		this.formName = formName;
	}



	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: className
	 */
	public java.lang.String getClassName () {
		return className;
	}

	/**
	 * Set the value related to the column: className
	 * @param className the className value
	 */
	public void setClassName (java.lang.String className) {
		this.className = className;
	}



	/**
	 * Return the value associated with the column: formula_used
	 */
	public java.lang.String getFormulaUsed () {
		return formulaUsed;
	}

	/**
	 * Set the value related to the column: formula_used
	 * @param formulaUsed the formula_used value
	 */
	public void setFormulaUsed (java.lang.String formulaUsed) {
		this.formulaUsed = formulaUsed;
	}



	/**
	 * Return the value associated with the column: TemplateApplications
	 */
	public java.util.Set<jkt.hms.masters.business.TemplateApplication> getTemplateApplications () {
		return templateApplications;
	}

	/**
	 * Set the value related to the column: TemplateApplications
	 * @param templateApplications the TemplateApplications value
	 */
	public void setTemplateApplications (java.util.Set<jkt.hms.masters.business.TemplateApplication> templateApplications) {
		this.templateApplications = templateApplications;
	}

	public void addToTemplateApplications (jkt.hms.masters.business.TemplateApplication templateApplication) {
		if (null == getTemplateApplications()) setTemplateApplications(new java.util.TreeSet<jkt.hms.masters.business.TemplateApplication>());
		getTemplateApplications().add(templateApplication);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasButtonForm)) return false;
		else {
			jkt.hms.masters.business.MasButtonForm masButtonForm = (jkt.hms.masters.business.MasButtonForm) obj;
			if (null == this.getId() || null == masButtonForm.getId()) return false;
			else return (this.getId().equals(masButtonForm.getId()));
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