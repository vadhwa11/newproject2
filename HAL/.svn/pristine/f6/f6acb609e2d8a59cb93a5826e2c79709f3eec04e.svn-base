package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * store_tender_invita_letter_to_vender table. Do not modify this class because
 * it will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="store_tender_invita_letter_to_vender"
 */

public abstract class BaseStoreTenderInvitaLetterToVender implements
		Serializable {

	public static String REF = "StoreTenderInvitaLetterToVender";
	public static String PROP_TENDER_M = "TenderM";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_DATE = "Date";
	public static String PROP_INVITATION_LETTER = "InvitationLetter";
	public static String PROP_ID = "Id";
	public static String PROP_GROUP = "Group";

	// constructors
	public BaseStoreTenderInvitaLetterToVender() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderInvitaLetterToVender(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date date;

	// many to one
	private jkt.hms.masters.business.StoreTenderInvitationLetter invitationLetter;
	private jkt.hms.masters.business.StoreTenderM tenderM;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasStoreGroup group;

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
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * 
	 * @param date
	 *            the date value
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * Return the value associated with the column: invitation_letter_id
	 */
	public jkt.hms.masters.business.StoreTenderInvitationLetter getInvitationLetter() {
		return invitationLetter;
	}

	/**
	 * Set the value related to the column: invitation_letter_id
	 * 
	 * @param invitationLetter
	 *            the invitation_letter_id value
	 */
	public void setInvitationLetter(
			jkt.hms.masters.business.StoreTenderInvitationLetter invitationLetter) {
		this.invitationLetter = invitationLetter;
	}

	/**
	 * Return the value associated with the column: tender_m_id
	 */
	public jkt.hms.masters.business.StoreTenderM getTenderM() {
		return tenderM;
	}

	/**
	 * Set the value related to the column: tender_m_id
	 * 
	 * @param tenderM
	 *            the tender_m_id value
	 */
	public void setTenderM(jkt.hms.masters.business.StoreTenderM tenderM) {
		this.tenderM = tenderM;
	}

	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier() {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * 
	 * @param supplier
	 *            the supplier_id value
	 */
	public void setSupplier(jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.MasStoreGroup getGroup() {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * 
	 * @param group
	 *            the group_id value
	 */
	public void setGroup(jkt.hms.masters.business.MasStoreGroup group) {
		this.group = group;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderInvitaLetterToVender))
			return false;
		else {
			jkt.hms.masters.business.StoreTenderInvitaLetterToVender storeTenderInvitaLetterToVender = (jkt.hms.masters.business.StoreTenderInvitaLetterToVender) obj;
			if (null == this.getId()
					|| null == storeTenderInvitaLetterToVender.getId())
				return false;
			else
				return (this.getId().equals(storeTenderInvitaLetterToVender
						.getId()));
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