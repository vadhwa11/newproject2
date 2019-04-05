package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_leave_type_mediator_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_leave_type_mediator_history"
 */

public abstract class BaseHrMasLeaveTypeMediatorHistory  implements Serializable {

	public static String REF = "HrMasLeaveTypeMediatorHistory";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHrMasLeaveTypeMediatorHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasLeaveTypeMediatorHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.HrMasLeaveTypeNew leaveType;



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
	 * Return the value associated with the column: leave_type_id
	 */
	public jkt.hms.masters.business.HrMasLeaveTypeNew getLeaveType () {
		return leaveType;
	}

	/**
	 * Set the value related to the column: leave_type_id
	 * @param leaveType the leave_type_id value
	 */
	public void setLeaveType (jkt.hms.masters.business.HrMasLeaveTypeNew leaveType) {
		this.leaveType = leaveType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasLeaveTypeMediatorHistory)) return false;
		else {
			jkt.hms.masters.business.HrMasLeaveTypeMediatorHistory hrMasLeaveTypeMediatorHistory = (jkt.hms.masters.business.HrMasLeaveTypeMediatorHistory) obj;
			if (null == this.getId() || null == hrMasLeaveTypeMediatorHistory.getId()) return false;
			else return (this.getId().equals(hrMasLeaveTypeMediatorHistory.getId()));
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