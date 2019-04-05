package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mom_agenda_summary table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mom_agenda_summary"
 */

public abstract class BaseMomAgendaSummary implements Serializable {

	public static String REF = "MomAgendaSummary";
	public static String PROP_AGENDA_SUMMARY_POINTS = "AgendaSummaryPoints";
	public static String PROP_ID = "Id";
	public static String PROP_SUMMARY = "Summary";

	// constructors
	public BaseMomAgendaSummary() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMomAgendaSummary(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String agendaSummaryPoints;

	// many to one
	private jkt.hms.masters.business.MasAgendaPointForWorkServices summary;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="mom_agenda_summary_id"
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
	 * Return the value associated with the column: agenda_summary_points
	 */
	public java.lang.String getAgendaSummaryPoints() {
		return agendaSummaryPoints;
	}

	/**
	 * Set the value related to the column: agenda_summary_points
	 * 
	 * @param agendaSummaryPoints
	 *            the agenda_summary_points value
	 */
	public void setAgendaSummaryPoints(java.lang.String agendaSummaryPoints) {
		this.agendaSummaryPoints = agendaSummaryPoints;
	}

	/**
	 * Return the value associated with the column: summary_id
	 */
	public jkt.hms.masters.business.MasAgendaPointForWorkServices getSummary() {
		return summary;
	}

	/**
	 * Set the value related to the column: summary_id
	 * 
	 * @param summary
	 *            the summary_id value
	 */
	public void setSummary(
			jkt.hms.masters.business.MasAgendaPointForWorkServices summary) {
		this.summary = summary;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MomAgendaSummary))
			return false;
		else {
			jkt.hms.masters.business.MomAgendaSummary momAgendaSummary = (jkt.hms.masters.business.MomAgendaSummary) obj;
			if (null == this.getId() || null == momAgendaSummary.getId())
				return false;
			else
				return (this.getId().equals(momAgendaSummary.getId()));
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