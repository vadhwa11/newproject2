package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the proposal_for_hro_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="proposal_for_hro_entry"
 */

public abstract class BaseProposalForHroEntry  implements Serializable {

	public static String REF = "ProposalForHroEntry";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_SUBJECT = "Subject";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_ID = "Id";
	public static String PROP_DISPATCH = "Dispatch";
	public static String PROP_PROPSAL_DATE = "PropsalDate";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";
	public static String PROP_TEXT_CONTENT = "TextContent";
	public static String PROP_EMPLOYEE_NAME = "EmployeeName";
	public static String PROP_DEPARTMENT_NAME = "DepartmentName";


	// constructors
	public BaseProposalForHroEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProposalForHroEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.lang.String departmentName;
	private java.util.Date propsalDate;
	private java.lang.String subject;
	private java.lang.String textContent;
	private java.lang.String lstChangedBy;
	private java.util.Date lstChangedDate;
	private java.lang.String lstChangedTime;
	private java.lang.String status;
	private java.lang.String dispatch;

	// many to one
	private jkt.hms.masters.business.MasEmployee employeeName;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="proposal_hro_entry_id"
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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
	}



	/**
	 * Return the value associated with the column: department_name
	 */
	public java.lang.String getDepartmentName () {
		return departmentName;
	}

	/**
	 * Set the value related to the column: department_name
	 * @param departmentName the department_name value
	 */
	public void setDepartmentName (java.lang.String departmentName) {
		this.departmentName = departmentName;
	}



	/**
	 * Return the value associated with the column: propsal_date
	 */
	public java.util.Date getPropsalDate () {
		return propsalDate;
	}

	/**
	 * Set the value related to the column: propsal_date
	 * @param propsalDate the propsal_date value
	 */
	public void setPropsalDate (java.util.Date propsalDate) {
		this.propsalDate = propsalDate;
	}



	/**
	 * Return the value associated with the column: subject
	 */
	public java.lang.String getSubject () {
		return subject;
	}

	/**
	 * Set the value related to the column: subject
	 * @param subject the subject value
	 */
	public void setSubject (java.lang.String subject) {
		this.subject = subject;
	}



	/**
	 * Return the value associated with the column: text_content
	 */
	public java.lang.String getTextContent () {
		return textContent;
	}

	/**
	 * Set the value related to the column: text_content
	 * @param textContent the text_content value
	 */
	public void setTextContent (java.lang.String textContent) {
		this.textContent = textContent;
	}



	/**
	 * Return the value associated with the column: lst_changed_by
	 */
	public java.lang.String getLstChangedBy () {
		return lstChangedBy;
	}

	/**
	 * Set the value related to the column: lst_changed_by
	 * @param lstChangedBy the lst_changed_by value
	 */
	public void setLstChangedBy (java.lang.String lstChangedBy) {
		this.lstChangedBy = lstChangedBy;
	}



	/**
	 * Return the value associated with the column: lst_changed_date
	 */
	public java.util.Date getLstChangedDate () {
		return lstChangedDate;
	}

	/**
	 * Set the value related to the column: lst_changed_date
	 * @param lstChangedDate the lst_changed_date value
	 */
	public void setLstChangedDate (java.util.Date lstChangedDate) {
		this.lstChangedDate = lstChangedDate;
	}



	/**
	 * Return the value associated with the column: lst_changed_time
	 */
	public java.lang.String getLstChangedTime () {
		return lstChangedTime;
	}

	/**
	 * Set the value related to the column: lst_changed_time
	 * @param lstChangedTime the lst_changed_time value
	 */
	public void setLstChangedTime (java.lang.String lstChangedTime) {
		this.lstChangedTime = lstChangedTime;
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
	 * Return the value associated with the column: dispatch
	 */
	public java.lang.String getDispatch () {
		return dispatch;
	}

	/**
	 * Set the value related to the column: dispatch
	 * @param dispatch the dispatch value
	 */
	public void setDispatch (java.lang.String dispatch) {
		this.dispatch = dispatch;
	}



	/**
	 * Return the value associated with the column: employee_name
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeName () {
		return employeeName;
	}

	/**
	 * Set the value related to the column: employee_name
	 * @param employeeName the employee_name value
	 */
	public void setEmployeeName (jkt.hms.masters.business.MasEmployee employeeName) {
		this.employeeName = employeeName;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ProposalForHroEntry)) return false;
		else {
			jkt.hms.masters.business.ProposalForHroEntry proposalForHroEntry = (jkt.hms.masters.business.ProposalForHroEntry) obj;
			if (null == this.getId() || null == proposalForHroEntry.getId()) return false;
			else return (this.getId().equals(proposalForHroEntry.getId()));
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