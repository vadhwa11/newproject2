package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HL7_MESSAGE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HL7_MESSAGE"
 */

public abstract class BaseHl7Message  implements Serializable {

	public static String REF = "Hl7Message";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_MSG_NO = "MsgNo";
	public static String PROP_ID = "Id";
	public static String PROP_MAIN_MESSAGE = "MainMessage";
	public static String PROP_MSG_TYPE = "MsgType";


	// constructors
	public BaseHl7Message () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHl7Message (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String hinNo;
	private java.lang.String msgType;
	private java.lang.String msgNo;
	private java.lang.String mainMessage;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: SERVICE_NO
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: SERVICE_NO
	 * @param serviceNo the SERVICE_NO value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: HIN_NO
	 */
	public java.lang.String getHinNo () {
		return hinNo;
	}

	/**
	 * Set the value related to the column: HIN_NO
	 * @param hinNo the HIN_NO value
	 */
	public void setHinNo (java.lang.String hinNo) {
		this.hinNo = hinNo;
	}



	/**
	 * Return the value associated with the column: MSG_TYPE
	 */
	public java.lang.String getMsgType () {
		return msgType;
	}

	/**
	 * Set the value related to the column: MSG_TYPE
	 * @param msgType the MSG_TYPE value
	 */
	public void setMsgType (java.lang.String msgType) {
		this.msgType = msgType;
	}



	/**
	 * Return the value associated with the column: MSG_NO
	 */
	public java.lang.String getMsgNo () {
		return msgNo;
	}

	/**
	 * Set the value related to the column: MSG_NO
	 * @param msgNo the MSG_NO value
	 */
	public void setMsgNo (java.lang.String msgNo) {
		this.msgNo = msgNo;
	}



	/**
	 * Return the value associated with the column: MAIN_MESSAGE
	 */
	public java.lang.String getMainMessage () {
		return mainMessage;
	}

	/**
	 * Set the value related to the column: MAIN_MESSAGE
	 * @param mainMessage the MAIN_MESSAGE value
	 */
	public void setMainMessage (java.lang.String mainMessage) {
		this.mainMessage = mainMessage;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Hl7Message)) return false;
		else {
			jkt.hms.masters.business.Hl7Message hl7Message = (jkt.hms.masters.business.Hl7Message) obj;
			if (null == this.getId() || null == hl7Message.getId()) return false;
			else return (this.getId().equals(hl7Message.getId()));
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