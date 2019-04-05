package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the dg_film_detail table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="dg_film_detail"
 */

public abstract class BaseDgFilmDetail implements Serializable {

	public static String REF = "DgFilmDetail";
	public static String PROP_FILM_SIZE = "FilmSize";
	public static String PROP_RESULT_ENTRY_DETAIL = "ResultEntryDetail";
	public static String PROP_ID = "Id";
	public static String PROP_FILM_USED = "FilmUsed";

	// constructors
	public BaseDgFilmDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgFilmDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String filmSize;
	private java.lang.Integer filmUsed;

	// many to one
	private jkt.hms.masters.business.DgResultEntryDetail resultEntryDetail;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="film_detail_id"
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
	 * Return the value associated with the column: film_size
	 */
	public java.lang.String getFilmSize() {
		return filmSize;
	}

	/**
	 * Set the value related to the column: film_size
	 * 
	 * @param filmSize
	 *            the film_size value
	 */
	public void setFilmSize(java.lang.String filmSize) {
		this.filmSize = filmSize;
	}

	/**
	 * Return the value associated with the column: film_used
	 */
	public java.lang.Integer getFilmUsed() {
		return filmUsed;
	}

	/**
	 * Set the value related to the column: film_used
	 * 
	 * @param filmUsed
	 *            the film_used value
	 */
	public void setFilmUsed(java.lang.Integer filmUsed) {
		this.filmUsed = filmUsed;
	}

	/**
	 * Return the value associated with the column: result_entry_detail_id
	 */
	public jkt.hms.masters.business.DgResultEntryDetail getResultEntryDetail() {
		return resultEntryDetail;
	}

	/**
	 * Set the value related to the column: result_entry_detail_id
	 * 
	 * @param resultEntryDetail
	 *            the result_entry_detail_id value
	 */
	public void setResultEntryDetail(
			jkt.hms.masters.business.DgResultEntryDetail resultEntryDetail) {
		this.resultEntryDetail = resultEntryDetail;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DgFilmDetail))
			return false;
		else {
			jkt.hms.masters.business.DgFilmDetail dgFilmDetail = (jkt.hms.masters.business.DgFilmDetail) obj;
			if (null == this.getId() || null == dgFilmDetail.getId())
				return false;
			else
				return (this.getId().equals(dgFilmDetail.getId()));
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