package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_book_surgeon table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_book_surgeon"
 */

public abstract class BaseOtBookSurgeon  implements Serializable {

	public static String REF = "OtBookSurgeon";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_ROLE = "Role";
	public static String PROP_ID = "Id";
	public static String PROP_BOOKING = "Booking";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BaseOtBookSurgeon () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtBookSurgeon (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer orderNo;
	private java.lang.String role;

	// many to one
	private jkt.hms.masters.business.OtBooking booking;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: orderNo
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: orderNo
	 * @param orderNo the orderNo value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: role
	 */
	public java.lang.String getRole () {
		return role;
	}

	/**
	 * Set the value related to the column: role
	 * @param role the role value
	 */
	public void setRole (java.lang.String role) {
		this.role = role;
	}



	/**
	 * Return the value associated with the column: booking_id
	 */
	public jkt.hms.masters.business.OtBooking getBooking () {
		return booking;
	}

	/**
	 * Set the value related to the column: booking_id
	 * @param booking the booking_id value
	 */
	public void setBooking (jkt.hms.masters.business.OtBooking booking) {
		this.booking = booking;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtBookSurgeon)) return false;
		else {
			jkt.hms.masters.business.OtBookSurgeon otBookSurgeon = (jkt.hms.masters.business.OtBookSurgeon) obj;
			if (null == this.getId() || null == otBookSurgeon.getId()) return false;
			else return (this.getId().equals(otBookSurgeon.getId()));
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