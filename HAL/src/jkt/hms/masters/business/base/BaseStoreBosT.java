package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_bos_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_bos_t"
 */

public abstract class BaseStoreBosT  implements Serializable {

	public static String REF = "StoreBosT";
	public static String PROP_CONDITION_OBS = "ConditionObs";
	public static String PROP_CONDITION_REP = "ConditionRep";
	public static String PROP_RETURN_TO_A_F_M_S_D = "ReturnToAFMSD";
	public static String PROP_BOARD_US = "BoardUs";
	public static String PROP_BOS_M = "BosM";
	public static String PROP_CONVERTED_TO_PRODUCE = "ConvertedToProduce";
	public static String PROP_DISPOSED_OFF = "DisposedOff";
	public static String PROP_RETAINED_IN_SERVICE = "RetainedInService";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_BOARD_REDUCED = "BoardReduced";
	public static String PROP_COST_DETAILS = "CostDetails";
	public static String PROP_QTY = "Qty";
	public static String PROP_CONDITION_SER = "ConditionSer";
	public static String PROP_BOARD_REC_SER = "BoardRecSer";
	public static String PROP_CRVNO_DATE = "CrvnoDate";
	public static String PROP_CONDITION_US = "ConditionUs";
	public static String PROP_ITEM = "Item";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_ID = "Id";
	public static String PROP_REPAIR_NECESSARY = "RepairNecessary";
	public static String PROP_BOARD_BACKLOAD = "BoardBackload";
	public static String PROP_BOARD_DESTROY = "BoardDestroy";
	public static String PROP_SR_NO = "SrNo";


	// constructors
	public BaseStoreBosT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreBosT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreBosT (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item,
		jkt.hms.masters.business.StoreBosM bosM,
		java.lang.Integer srNo,
		java.lang.String serialNo,
		java.lang.Integer qty) {

		this.setId(id);
		this.setItem(item);
		this.setBosM(bosM);
		this.setSrNo(srNo);
		this.setSerialNo(serialNo);
		this.setQty(qty);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String serialNo;
	private java.lang.Integer qty;
	private java.lang.Integer conditionSer;
	private java.lang.String boardRecSer;
	private java.lang.String crvnoDate;
	private java.lang.String remarks;
	private java.math.BigDecimal costDetails;
	private java.lang.Integer conditionRep;
	private java.lang.Integer conditionUs;
	private java.lang.Integer conditionObs;
	private java.lang.String boardBackload;
	private java.lang.String boardUs;
	private java.lang.String boardDestroy;
	private java.lang.String boardReduced;
	private java.lang.Integer retainedInService;
	private java.lang.Integer repairNecessary;
	private java.lang.Integer disposedOff;
	private java.lang.Integer returnToAFMSD;
	private java.lang.Integer convertedToProduce;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreBosM bosM;



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
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * @param srNo the sr_no value
	 */
	public void setSrNo (java.lang.Integer srNo) {
		this.srNo = srNo;
	}



	/**
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.String getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * @param serialNo the serial_no value
	 */
	public void setSerialNo (java.lang.String serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty () {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * @param qty the qty value
	 */
	public void setQty (java.lang.Integer qty) {
		this.qty = qty;
	}



	/**
	 * Return the value associated with the column: condition_ser
	 */
	public java.lang.Integer getConditionSer () {
		return conditionSer;
	}

	/**
	 * Set the value related to the column: condition_ser
	 * @param conditionSer the condition_ser value
	 */
	public void setConditionSer (java.lang.Integer conditionSer) {
		this.conditionSer = conditionSer;
	}



	/**
	 * Return the value associated with the column: board_rec_ser
	 */
	public java.lang.String getBoardRecSer () {
		return boardRecSer;
	}

	/**
	 * Set the value related to the column: board_rec_ser
	 * @param boardRecSer the board_rec_ser value
	 */
	public void setBoardRecSer (java.lang.String boardRecSer) {
		this.boardRecSer = boardRecSer;
	}



	/**
	 * Return the value associated with the column: crvno_date
	 */
	public java.lang.String getCrvnoDate () {
		return crvnoDate;
	}

	/**
	 * Set the value related to the column: crvno_date
	 * @param crvnoDate the crvno_date value
	 */
	public void setCrvnoDate (java.lang.String crvnoDate) {
		this.crvnoDate = crvnoDate;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: cost_details
	 */
	public java.math.BigDecimal getCostDetails () {
		return costDetails;
	}

	/**
	 * Set the value related to the column: cost_details
	 * @param costDetails the cost_details value
	 */
	public void setCostDetails (java.math.BigDecimal costDetails) {
		this.costDetails = costDetails;
	}



	/**
	 * Return the value associated with the column: condition_rep
	 */
	public java.lang.Integer getConditionRep () {
		return conditionRep;
	}

	/**
	 * Set the value related to the column: condition_rep
	 * @param conditionRep the condition_rep value
	 */
	public void setConditionRep (java.lang.Integer conditionRep) {
		this.conditionRep = conditionRep;
	}



	/**
	 * Return the value associated with the column: condition_us
	 */
	public java.lang.Integer getConditionUs () {
		return conditionUs;
	}

	/**
	 * Set the value related to the column: condition_us
	 * @param conditionUs the condition_us value
	 */
	public void setConditionUs (java.lang.Integer conditionUs) {
		this.conditionUs = conditionUs;
	}



	/**
	 * Return the value associated with the column: condition_obs
	 */
	public java.lang.Integer getConditionObs () {
		return conditionObs;
	}

	/**
	 * Set the value related to the column: condition_obs
	 * @param conditionObs the condition_obs value
	 */
	public void setConditionObs (java.lang.Integer conditionObs) {
		this.conditionObs = conditionObs;
	}



	/**
	 * Return the value associated with the column: board_backload
	 */
	public java.lang.String getBoardBackload () {
		return boardBackload;
	}

	/**
	 * Set the value related to the column: board_backload
	 * @param boardBackload the board_backload value
	 */
	public void setBoardBackload (java.lang.String boardBackload) {
		this.boardBackload = boardBackload;
	}



	/**
	 * Return the value associated with the column: board_us
	 */
	public java.lang.String getBoardUs () {
		return boardUs;
	}

	/**
	 * Set the value related to the column: board_us
	 * @param boardUs the board_us value
	 */
	public void setBoardUs (java.lang.String boardUs) {
		this.boardUs = boardUs;
	}



	/**
	 * Return the value associated with the column: board_destroy
	 */
	public java.lang.String getBoardDestroy () {
		return boardDestroy;
	}

	/**
	 * Set the value related to the column: board_destroy
	 * @param boardDestroy the board_destroy value
	 */
	public void setBoardDestroy (java.lang.String boardDestroy) {
		this.boardDestroy = boardDestroy;
	}



	/**
	 * Return the value associated with the column: board_reduced
	 */
	public java.lang.String getBoardReduced () {
		return boardReduced;
	}

	/**
	 * Set the value related to the column: board_reduced
	 * @param boardReduced the board_reduced value
	 */
	public void setBoardReduced (java.lang.String boardReduced) {
		this.boardReduced = boardReduced;
	}



	/**
	 * Return the value associated with the column: retained_in_service
	 */
	public java.lang.Integer getRetainedInService () {
		return retainedInService;
	}

	/**
	 * Set the value related to the column: retained_in_service
	 * @param retainedInService the retained_in_service value
	 */
	public void setRetainedInService (java.lang.Integer retainedInService) {
		this.retainedInService = retainedInService;
	}



	/**
	 * Return the value associated with the column: repair_necessary
	 */
	public java.lang.Integer getRepairNecessary () {
		return repairNecessary;
	}

	/**
	 * Set the value related to the column: repair_necessary
	 * @param repairNecessary the repair_necessary value
	 */
	public void setRepairNecessary (java.lang.Integer repairNecessary) {
		this.repairNecessary = repairNecessary;
	}



	/**
	 * Return the value associated with the column: disposed_off
	 */
	public java.lang.Integer getDisposedOff () {
		return disposedOff;
	}

	/**
	 * Set the value related to the column: disposed_off
	 * @param disposedOff the disposed_off value
	 */
	public void setDisposedOff (java.lang.Integer disposedOff) {
		this.disposedOff = disposedOff;
	}



	/**
	 * Return the value associated with the column: return_to_AFMSD
	 */
	public java.lang.Integer getReturnToAFMSD () {
		return returnToAFMSD;
	}

	/**
	 * Set the value related to the column: return_to_AFMSD
	 * @param returnToAFMSD the return_to_AFMSD value
	 */
	public void setReturnToAFMSD (java.lang.Integer returnToAFMSD) {
		this.returnToAFMSD = returnToAFMSD;
	}



	/**
	 * Return the value associated with the column: converted_to_produce
	 */
	public java.lang.Integer getConvertedToProduce () {
		return convertedToProduce;
	}

	/**
	 * Set the value related to the column: converted_to_produce
	 * @param convertedToProduce the converted_to_produce value
	 */
	public void setConvertedToProduce (java.lang.Integer convertedToProduce) {
		this.convertedToProduce = convertedToProduce;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: bos_m_id
	 */
	public jkt.hms.masters.business.StoreBosM getBosM () {
		return bosM;
	}

	/**
	 * Set the value related to the column: bos_m_id
	 * @param bosM the bos_m_id value
	 */
	public void setBosM (jkt.hms.masters.business.StoreBosM bosM) {
		this.bosM = bosM;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreBosT)) return false;
		else {
			jkt.hms.masters.business.StoreBosT storeBosT = (jkt.hms.masters.business.StoreBosT) obj;
			if (null == this.getId() || null == storeBosT.getId()) return false;
			else return (this.getId().equals(storeBosT.getId()));
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