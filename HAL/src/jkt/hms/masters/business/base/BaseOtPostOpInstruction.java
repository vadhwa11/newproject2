package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_post_op_instruction table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_post_op_instruction"
 */

public abstract class BaseOtPostOpInstruction  implements Serializable {

	public static String REF = "OtPostOpInstruction";
	public static String PROP_ID = "Id";
	public static String PROP_OT_POST_ANAESTHESIA_PROCEDURE = "OtPostAnaesthesiaProcedure";
	public static String PROP_PRE_OP_INSTRUCTION = "PreOpInstruction";


	// constructors
	public BaseOtPostOpInstruction () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPostOpInstruction (java.lang.Integer id) {
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
	private jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure;



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
	 * Return the value associated with the column: ot_post_anaesthesia_procedure_id
	 */
	public jkt.hms.masters.business.OtPostAnaesthesiaProcedure getOtPostAnaesthesiaProcedure () {
		return otPostAnaesthesiaProcedure;
	}

	/**
	 * Set the value related to the column: ot_post_anaesthesia_procedure_id
	 * @param otPostAnaesthesiaProcedure the ot_post_anaesthesia_procedure_id value
	 */
	public void setOtPostAnaesthesiaProcedure (jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure) {
		this.otPostAnaesthesiaProcedure = otPostAnaesthesiaProcedure;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPostOpInstruction)) return false;
		else {
			jkt.hms.masters.business.OtPostOpInstruction otPostOpInstruction = (jkt.hms.masters.business.OtPostOpInstruction) obj;
			if (null == this.getId() || null == otPostOpInstruction.getId()) return false;
			else return (this.getId().equals(otPostOpInstruction.getId()));
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