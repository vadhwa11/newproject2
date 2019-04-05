package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the inpatient_document table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="inpatient_document"
 */

public abstract class BaseInpatientDocument implements Serializable {

	public static String REF = "InpatientDocument";
	public static String PROP_DOCUMENT = "Document";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_ID = "Id";

	// constructors
	public BaseInpatientDocument() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInpatientDocument(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasDocument document;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="inpatient_document_id"
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	/**
	 * Return the value associated with the column: document_id
	 */
	public jkt.hms.masters.business.MasDocument getDocument() {
		return document;
	}

	/**
	 * Set the value related to the column: document_id
	 * 
	 * @param document
	 *            the document_id value
	 */
	public void setDocument(jkt.hms.masters.business.MasDocument document) {
		this.document = document;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.InpatientDocument))
			return false;
		else {
			jkt.hms.masters.business.InpatientDocument inpatientDocument = (jkt.hms.masters.business.InpatientDocument) obj;
			if (null == this.getId() || null == inpatientDocument.getId())
				return false;
			else
				return (this.getId().equals(inpatientDocument.getId()));
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