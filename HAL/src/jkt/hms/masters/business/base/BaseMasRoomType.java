package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_room_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_room_type"
 */

public abstract class BaseMasRoomType  implements Serializable {

	public static String REF = "MasRoomType";
	public static String PROP_STATUS = "Status";
	public static String PROP_ROOM_TYPE_NAME = "RoomTypeName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ROOM_TYPE_CODE = "RoomTypeCode";


	// constructors
	public BaseMasRoomType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasRoomType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String roomTypeCode;
	private java.lang.String roomTypeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasRoom> masRooms;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="room_type_id"
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
	 * Return the value associated with the column: room_type_code
	 */
	public java.lang.String getRoomTypeCode () {
		return roomTypeCode;
	}

	/**
	 * Set the value related to the column: room_type_code
	 * @param roomTypeCode the room_type_code value
	 */
	public void setRoomTypeCode (java.lang.String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}



	/**
	 * Return the value associated with the column: room_type_name
	 */
	public java.lang.String getRoomTypeName () {
		return roomTypeName;
	}

	/**
	 * Set the value related to the column: room_type_name
	 * @param roomTypeName the room_type_name value
	 */
	public void setRoomTypeName (java.lang.String roomTypeName) {
		this.roomTypeName = roomTypeName;
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
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: MasRooms
	 */
	public java.util.Set<jkt.hms.masters.business.MasRoom> getMasRooms () {
		return masRooms;
	}

	/**
	 * Set the value related to the column: MasRooms
	 * @param masRooms the MasRooms value
	 */
	public void setMasRooms (java.util.Set<jkt.hms.masters.business.MasRoom> masRooms) {
		this.masRooms = masRooms;
	}

	public void addToMasRooms (jkt.hms.masters.business.MasRoom masRoom) {
		if (null == getMasRooms()) setMasRooms(new java.util.TreeSet<jkt.hms.masters.business.MasRoom>());
		getMasRooms().add(masRoom);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasRoomType)) return false;
		else {
			jkt.hms.masters.business.MasRoomType masRoomType = (jkt.hms.masters.business.MasRoomType) obj;
			if (null == this.getId() || null == masRoomType.getId()) return false;
			else return (this.getId().equals(masRoomType.getId()));
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