/**
 ************************************************
 * @source: PagedArray.java
 * @descriptions: Paging Control
 * @author 
 * ---------------------------------------------
 * Create Date :
 * Modify :
 ***********************************************
 */

package jkt.hms.util;

import java.io.Serializable;

public class PagedArray implements Serializable {

	private int numOfRows; // line count per 1 page
	private Object[] pagedArray;
	private int currentPage; // current page no
	private int totalPage; // total page count
	private int beginPage;
	private int endPage;
	private int pageCount; // displaing page count
	private int totalRecords; // total records count

	public PagedArray(Object[] pPagedArray, int pCurrentPage, int pNumOfRows,
			int pPageCount, int pTotalPage, int pBeginPage, int pEndPage,
			int pTotalRecords) {
		this.pagedArray = pPagedArray;
		this.numOfRows = pNumOfRows;
		this.currentPage = pCurrentPage;
		this.totalPage = pTotalPage;
		this.beginPage = pBeginPage;
		this.endPage = pEndPage;
		this.pageCount = pPageCount;
		this.totalRecords = pTotalRecords;
	}

	/**
	 * 계산된 페이지만큼의 Object[]를 리턴한다.
	 */
	public Object[] getPagedArray() {
		return this.pagedArray;
	}

	/**
	 * 현재 페이지
	 */
	public int getCurrentPage() {
		return this.currentPage;
	}

	/**
	 * 총 페이지수
	 */
	public int getTotalPage() {
		return this.totalPage;
	}

	/**
	 * 한 페이지에 보여줄 라인수
	 */
	public int getNumOfRows() {
		return this.numOfRows;
	}

	/**
	 * 시작 페이지
	 */
	public int getBeginPage() {
		return this.beginPage;
	}

	/**
	 * 마지막 페이지
	 */
	public int getEndPage() {
		return this.endPage;
	}

	/**
	 * 한 화면에 보여줄 페이지의 갯수
	 */
	public int getPageCount() {
		return this.pageCount;
	}

	/**
	 * 총 레코드수
	 */
	public int getTotalCount() {
		return this.totalRecords;
	}

	public int getFirstRowIdx() {
		return this.numOfRows * (this.currentPage - 1) + 1;
	}

	/**
	 * return Hidden Value (using HTML hidden tag)
	 */
	public String getPageIndexHiddenTag() {
		
		String HiddenTag = "<input type='hidden' name='numOfRows' value='"
				+ this.numOfRows + "'>\n"
				+ "<input type='hidden' name='currPage' id='currPage' value='"
				+ this.currentPage + "'>";
          //System.out.println("Hidden--->"+HiddenTag);
		return HiddenTag;
	}

	public String showFirstIndex() {
		StringBuffer retStr = new StringBuffer();

		if (this.beginPage == 1) {
			retStr.append("");
		} else {
			retStr
					.append("<a href=\"javascript:goPage(1)\">First<<</a>&nbsp;&nbsp;");
		}

		return retStr.toString();
	}

	public String showPreviousIndex() {
		StringBuffer retStr = new StringBuffer();
		int iPage = this.beginPage - 1;

		if (this.beginPage == 1) {
			retStr.append("");
		} else {
			retStr.append("<a href=\"javascript:goPage(" + iPage
					+ ")\">Prev<</a>&nbsp;&nbsp;");
		}

		return retStr.toString();
	}

	public String showLastIndex() {
		StringBuffer retStr = new StringBuffer();

		if (this.endPage == this.totalPage) {
			retStr.append("");
		} else {
			retStr.append("&nbsp;&nbsp;<a href=\"javascript:goPage("
					+ this.totalPage + ")\">>>Last</a>");
		}

		return retStr.toString();
	}

	public String showNextIndex() {
		StringBuffer retStr = new StringBuffer();
		int iPage = this.endPage + 1;

		if (this.endPage == this.totalPage) {
			retStr.append("");
		} else {
			retStr.append("&nbsp;&nbsp;<a href=\"javascript:goPage(" + iPage
					+ ")\">>Next</a>");
		}

		return retStr.toString();
	}

	public String showIndex() {
		final int currentPage = this.getCurrentPage();
		final int endPage = this.getTotalPage();
		StringBuffer retStr = new StringBuffer();

		retStr.append(showFirstIndex());
		retStr.append(showPreviousIndex());

		for (int targetPage = this.beginPage; targetPage <= this.endPage; targetPage++) {

			if (currentPage == targetPage) {
				retStr.append("<font color = red>").append(
						"<b>" + targetPage + "</b>").append("</font>");
			} else {
				retStr.append("<a href=\"javascript:goPage('" + targetPage
						+ "')\" style='text-decoration:none' >");
				retStr.append("[" + targetPage + "]").append("</a>");
			}

			if (targetPage != endPage) {
				retStr.append(" ");
			}
		}

		retStr.append(showNextIndex());
		retStr.append(showLastIndex());

		return retStr.toString();
	}

	public String showSelectPage() {
		final int currentPage = this.getCurrentPage();
		final int endPage = this.getTotalPage();
		StringBuffer retStr = new StringBuffer();

		retStr
				.append("<SELECT NAME='selPage' onChange='goPage(this.value)'>\n");
		for (int targetPage = 1; targetPage <= endPage; targetPage++) {
			retStr.append("<OPTION VALUE='" + targetPage + "'");
			if (currentPage == targetPage) {
				retStr.append(" SELECTED");
			}
			retStr.append(">" + targetPage + "</OPTION>\n");
		}
		retStr.append("</select> / " + endPage);
		return retStr.toString();
	}
}
