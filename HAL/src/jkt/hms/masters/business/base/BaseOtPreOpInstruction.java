package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_pre_op_instruction table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_pre_op_instruction"
 */

public abstract class BaseOtPreOpInstruction  implements Serializable {

	public static String REF = "OtPreOpInstruction";
	public static String PROP_ID = "Id";
	public static String PROP_OT_PRE_ANAESTHESIA_PROC_NOTES_MAIN = "OtPreAnaesthesiaProcNotesMain";
	public static String PROP_PRE_OP_INSTRUCTION = "PreOpInstruction";


	// constructors
	public BaseOtPreOpInstruction () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPreOpInstruction (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String preOpInstruction;

	// many to one
	private jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain otPreAnaesthesiaProcNotesMain;



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
	 * Return the value associated with the column: pre_op_instruction
	 */
	public java.lang.String getPreOpInstruction () {
		return preOpInstruction;
	}

	/**
	 * Set the value related to the column: pre_op_instruction
	 * @param preOpInstruction the pre_op_instruction value
	 */
	public void setPreOpInstruction (java.lang.String preOpInstruction) {
		this.preOpInstruction = preOpInstruction;
	}



	/**
	 * Return the value associated with the column: ot_pre_anaesthesia_proc_notes_main_id
	 */
	public jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain getOtPreAnaesthesiaProcNotesMain () {
		return otPreAnaesthesiaProcNotesMain;
	}

	/**
	 * Set the value related to the column: ot_pre_anaesthesia_proc_notes_main_id
	 * @param otPreAnaesthesiaProcNotesMain the ot_pre_anaesthesia_proc_notes_main_id value
	 */
	public void setOtPreAnaesthesiaProcNotesMain (jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain otPreAnaesthesiaProcNotesMain) {
		this.otPreAnaesthesiaProcNotesMain = otPreAnaesthesiaProcNotesMain;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPreOpInstruction)) return false;
		else {
			jkt.hms.masters.business.OtPreOpInstruction otPreOpInstruction = (jkt.hms.masters.business.OtPreOpInstruction) obj;
			if (null == this.getId() || null == otPreOpInstruction.getId()) return false;
			else return (this.getId().equals(otPreOpInstruction.getId()));
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