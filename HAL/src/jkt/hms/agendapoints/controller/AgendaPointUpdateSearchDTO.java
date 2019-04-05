package jkt.hms.agendapoints.controller;

public class AgendaPointUpdateSearchDTO {
	private String fromDate;
	private String toDate;
	private String agendaNo;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getAgendaNo() {
		return agendaNo;
	}

	public void setAgendaNo(String agendaNo) {
		this.agendaNo = agendaNo;
	}

}
