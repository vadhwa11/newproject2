package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_itax_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_itax_details"
 */

public abstract class BaseHrItaxDetails  implements Serializable {

	public static String REF = "HrItaxDetails";
	public static String PROP_ELEMENT_TYPE = "ElementType";
	public static String PROP_ITAX_HEADER = "ItaxHeader";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_ID = "Id";
	public static String PROP_SECTION = "Section";
	public static String PROP_PAY_ELEMENT = "PayElement";


	// constructors
	public BaseHrItaxDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrItaxDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrItaxDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.HrItaxHeader itaxHeader) {

		this.setId(id);
		this.setItaxHeader(itaxHeader);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String section;
	private java.lang.String payElement;
	private java.math.BigDecimal amount;
	private java.lang.String elementType;

	// many to one
	private jkt.hms.masters.business.HrItaxHeader itaxHeader;



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
	 * Return the value associated with the column: section
	 */
	public java.lang.String getSection () {
		return section;
	}

	/**
	 * Set the value related to the column: section
	 * @param section the section value
	 */
	public void setSection (java.lang.String section) {
		this.section = section;
	}



	/**
	 * Return the value associated with the column: pay_element
	 */
	public java.lang.String getPayElement () {
		return payElement;
	}

	/**
	 * Set the value related to the column: pay_element
	 * @param payElement the pay_element value
	 */
	public void setPayElement (java.lang.String payElement) {
		this.payElement = payElement;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: element_type
	 */
	public java.lang.String getElementType () {
		return elementType;
	}

	/**
	 * Set the value related to the column: element_type
	 * @param elementType the element_type value
	 */
	public void setElementType (java.lang.String elementType) {
		this.elementType = elementType;
	}



	/**
	 * Return the value associated with the column: itax_header_id
	 */
	public jkt.hms.masters.business.HrItaxHeader getItaxHeader () {
		return itaxHeader;
	}

	/**
	 * Set the value related to the column: itax_header_id
	 * @param itaxHeader the itax_header_id value
	 */
	public void setItaxHeader (jkt.hms.masters.business.HrItaxHeader itaxHeader) {
		this.itaxHeader = itaxHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrItaxDetails)) return false;
		else {
			jkt.hms.masters.business.HrItaxDetails hrItaxDetails = (jkt.hms.masters.business.HrItaxDetails) obj;
			if (null == this.getId() || null == hrItaxDetails.getId()) return false;
			else return (this.getId().equals(hrItaxDetails.getId()));
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