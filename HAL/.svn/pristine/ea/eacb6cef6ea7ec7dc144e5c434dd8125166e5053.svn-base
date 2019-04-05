package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pending_hro_proposal table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pending_hro_proposal"
 */

public abstract class BasePendingHroProposal  implements Serializable {

	public static String REF = "PendingHroProposal";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_PROPOSAL_HRO_ENTRY_ID = "ProposalHroEntryId";
	public static String PROP_PENDING_HRO_PROPOSAL_ID = "PendingHroProposalId";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_DISPATCH = "Dispatch";


	// constructors
	public BasePendingHroProposal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePendingHroProposal (java.lang.Integer pendingHroProposalId) {
		this.setPendingHroProposalId(pendingHroProposalId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer pendingHroProposalId;

	// fields
	private java.lang.String dispatch;
	private java.lang.String status;
	private java.lang.String lastChangedBy;
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;

	// many to one
	private jkt.hms.masters.business.ProposalForHroEntry proposalHroEntryId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pending_hro_proposal_id"
     */
	public java.lang.Integer getPendingHroProposalId () {
		return pendingHroProposalId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param pendingHroProposalId the new ID
	 */
	public void setPendingHroProposalId (java.lang.Integer pendingHroProposalId) {
		this.pendingHroProposalId = pendingHroProposalId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: dispatch
	 */
	public java.lang.String getDispatch () {
		return dispatch;
	}

	/**
	 * Set the value related to the column: dispatch
	 * @param dispatch the dispatch value
	 */
	public void setDispatch (java.lang.String dispatch) {
		this.dispatch = dispatch;
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
	 * Return the value associated with the column: last_changed_by
	 */
	public java.lang.String getLastChangedBy () {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * @param lastChangedBy the last_changed_by value
	 */
	public void setLastChangedBy (java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}



	/**
	 * Return the value associated with the column: last_changed_date
	 */
	public java.util.Date getLastChangedDate () {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_changed_date
	 * @param lastChangedDate the last_changed_date value
	 */
	public void setLastChangedDate (java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}



	/**
	 * Return the value associated with the column: last_changed_time
	 */
	public java.lang.String getLastChangedTime () {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_changed_time
	 * @param lastChangedTime the last_changed_time value
	 */
	public void setLastChangedTime (java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
	}



	/**
	 * Return the value associated with the column: proposal_hro_entry_id
	 */
	public jkt.hms.masters.business.ProposalForHroEntry getProposalHroEntryId () {
		return proposalHroEntryId;
	}

	/**
	 * Set the value related to the column: proposal_hro_entry_id
	 * @param proposalHroEntryId the proposal_hro_entry_id value
	 */
	public void setProposalHroEntryId (jkt.hms.masters.business.ProposalForHroEntry proposalHroEntryId) {
		this.proposalHroEntryId = proposalHroEntryId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PendingHroProposal)) return false;
		else {
			jkt.hms.masters.business.PendingHroProposal pendingHroProposal = (jkt.hms.masters.business.PendingHroProposal) obj;
			if (null == this.getPendingHroProposalId() || null == pendingHroProposal.getPendingHroProposalId()) return false;
			else return (this.getPendingHroProposalId().equals(pendingHroProposal.getPendingHroProposalId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPendingHroProposalId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPendingHroProposalId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}