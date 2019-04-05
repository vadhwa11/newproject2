package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the train_class_group table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="train_class_group"
 */

public abstract class BaseTrainClassGroup implements Serializable {

	public static String REF = "TrainClassGroup";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_RANK_CATEGORY_ID = "RankCategoryId";
	public static String PROP_LST_CHANGE_BY = "LstChangeBy";
	public static String PROP_TRAIN_CLASSES = "TrainClasses";
	public static String PROP_ID = "Id";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";

	// constructors
	public BaseTrainClassGroup() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTrainClassGroup(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String trainClasses;
	private java.lang.String status;
	private java.lang.String lstChangeBy;
	private java.util.Date lstChangedDate;
	private java.lang.String lstChangedTime;

	// many to one
	private jkt.hms.masters.business.MasRankCategory rankCategoryId;

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
	 * Return the value associated with the column: train_classes
	 */
	public java.lang.String getTrainClasses() {
		return trainClasses;
	}

	/**
	 * Set the value related to the column: train_classes
	 * 
	 * @param trainClasses
	 *            the train_classes value
	 */
	public void setTrainClasses(java.lang.String trainClasses) {
		this.trainClasses = trainClasses;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: lst_change_by
	 */
	public java.lang.String getLstChangeBy() {
		return lstChangeBy;
	}

	/**
	 * Set the value related to the column: lst_change_by
	 * 
	 * @param lstChangeBy
	 *            the lst_change_by value
	 */
	public void setLstChangeBy(java.lang.String lstChangeBy) {
		this.lstChangeBy = lstChangeBy;
	}

	/**
	 * Return the value associated with the column: lst_changed_date
	 */
	public java.util.Date getLstChangedDate() {
		return lstChangedDate;
	}

	/**
	 * Set the value related to the column: lst_changed_date
	 * 
	 * @param lstChangedDate
	 *            the lst_changed_date value
	 */
	public void setLstChangedDate(java.util.Date lstChangedDate) {
		this.lstChangedDate = lstChangedDate;
	}

	/**
	 * Return the value associated with the column: lst_changed_time
	 */
	public java.lang.String getLstChangedTime() {
		return lstChangedTime;
	}

	/**
	 * Set the value related to the column: lst_changed_time
	 * 
	 * @param lstChangedTime
	 *            the lst_changed_time value
	 */
	public void setLstChangedTime(java.lang.String lstChangedTime) {
		this.lstChangedTime = lstChangedTime;
	}

	/**
	 * Return the value associated with the column: rank_category_id
	 */
	public jkt.hms.masters.business.MasRankCategory getRankCategoryId() {
		return rankCategoryId;
	}

	/**
	 * Set the value related to the column: rank_category_id
	 * 
	 * @param rankCategoryId
	 *            the rank_category_id value
	 */
	public void setRankCategoryId(
			jkt.hms.masters.business.MasRankCategory rankCategoryId) {
		this.rankCategoryId = rankCategoryId;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.TrainClassGroup))
			return false;
		else {
			jkt.hms.masters.business.TrainClassGroup trainClassGroup = (jkt.hms.masters.business.TrainClassGroup) obj;
			if (null == this.getId() || null == trainClassGroup.getId())
				return false;
			else
				return (this.getId().equals(trainClassGroup.getId()));
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