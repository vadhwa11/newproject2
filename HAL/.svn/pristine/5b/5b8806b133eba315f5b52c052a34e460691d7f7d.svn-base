package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_instruction table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_instruction"
 */

public abstract class BaseMasInstruction  implements Serializable {

	public static String REF = "MasInstruction";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OP_INS_CODE = "OpInsCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_OP_INS_NAME = "OpInsName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasInstruction () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasInstruction (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String opInsCode;
	private java.lang.String opInsName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasOpInstruction> masOpInstructions;



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
	 * Return the value associated with the column: op_ins_code
	 */
	public java.lang.String getOpInsCode () {
		return opInsCode;
	}

	/**
	 * Set the value related to the column: op_ins_code
	 * @param opInsCode the op_ins_code value
	 */
	public void setOpInsCode (java.lang.String opInsCode) {
		this.opInsCode = opInsCode;
	}



	/**
	 * Return the value associated with the column: op_ins_name
	 */
	public java.lang.String getOpInsName () {
		return opInsName;
	}

	/**
	 * Set the value related to the column: op_ins_name
	 * @param opInsName the op_ins_name value
	 */
	public void setOpInsName (java.lang.String opInsName) {
		this.opInsName = opInsName;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: MasOpInstructions
	 */
	public java.util.Set<jkt.hms.masters.business.MasOpInstruction> getMasOpInstructions () {
		return masOpInstructions;
	}

	/**
	 * Set the value related to the column: MasOpInstructions
	 * @param masOpInstructions the MasOpInstructions value
	 */
	public void setMasOpInstructions (java.util.Set<jkt.hms.masters.business.MasOpInstruction> masOpInstructions) {
		this.masOpInstructions = masOpInstructions;
	}

	public void addToMasOpInstructions (jkt.hms.masters.business.MasOpInstruction masOpInstruction) {
		if (null == getMasOpInstructions()) setMasOpInstructions(new java.util.TreeSet<jkt.hms.masters.business.MasOpInstruction>());
		getMasOpInstructions().add(masOpInstruction);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasInstruction)) return false;
		else {
			jkt.hms.masters.business.MasInstruction masInstruction = (jkt.hms.masters.business.MasInstruction) obj;
			if (null == this.getId() || null == masInstruction.getId()) return false;
			else return (this.getId().equals(masInstruction.getId()));
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