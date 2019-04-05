/**
 ************************************************
 * @source: PageUtil.java
 * @descriptions: Paging Control
 * @author 
 * ---------------------------------------------
 * Create Date : 2007.07.31
 * Modify :
 ***********************************************
 */

package jkt.hms.util;

import java.lang.reflect.Array;

public class PageUtil {

	private int defaultNumOfRows = 5;
	private int defaultPageCount = 5;

	private int totalRecords;
	private Object[] originArray;
	private Object[] pagedArray;
	private int numOfRows;
	private int pageCount;
	private int currentPage;
	private int totalPage;
	private int beginPage;
	private int endPage;

	public PagedArray convertToPagedArrayIndex(Object[] pagedArray, Box box)
			throws Exception {

		if (pagedArray == null)
			return null;
		this.originArray = pagedArray; // originArray
		this.totalRecords = originArray.length;
		this.currentPage = box.getInt("currPage") == 0 ? 1 : box
				.getInt("currPage");
		this.pageCount = box.getInt("pageCount") == 0 ? defaultPageCount : box
				.getInt("pageCount");
		this.numOfRows = convertNumOfRows(40);
		this.totalPage = calculateTotalPage(this.numOfRows, this.totalRecords);
		this.beginPage = calculateBeginPage(this.currentPage, this.pageCount);
		this.endPage = calculateEndPage(this.beginPage, this.pageCount,
				this.totalPage);
		this.pagedArray = calculatePagedArray(this.originArray);
		this.originArray = null; // supposed to be garbage collected

		// if ( this.currentPage > this.totalPage ) this.currentPage--;
		// if ( this.currentPage > this.totalPage ) this.currentPage =
		// this.totalPage;
		return new PagedArray(this.pagedArray, this.currentPage,
				this.numOfRows, this.pageCount, this.totalPage, this.beginPage,
				this.endPage, this.totalRecords);
	}
	
	// javed 
	public PagedArray convertToPagedArrayIndex1(Object[] pagedArray, Box box)
	throws Exception {

if (pagedArray == null)
	return null;
this.originArray = pagedArray; // originArray
this.totalRecords = originArray.length;
this.currentPage = box.getInt("currPage") == 0 ? 1 : box
		.getInt("currPage");
this.pageCount = box.getInt("pageCount") == 0 ? defaultPageCount : box
		.getInt("pageCount");
//this.numOfRows = convertNumOfRows(40);
this.numOfRows = convertNumOfRows(pagedArray.length);
System.out.println("javed no of row  "+this.numOfRows);
this.totalPage = calculateTotalPage(this.numOfRows, this.totalRecords);
this.beginPage = calculateBeginPage(this.currentPage, this.pageCount);
this.endPage = calculateEndPage(this.beginPage, this.pageCount,
		this.totalPage);
this.pagedArray = calculatePagedArray(this.originArray);
this.originArray = null; // supposed to be garbage collected

// if ( this.currentPage > this.totalPage ) this.currentPage--;
// if ( this.currentPage > this.totalPage ) this.currentPage =
// this.totalPage;
return new PagedArray(this.pagedArray, this.currentPage,
		this.numOfRows, this.pageCount, this.totalPage, this.beginPage,
		this.endPage, this.totalRecords);
}
	
	
	public PagedArray convertToPagedArrayIndexLen(Object[] pagedArray, Box box,int j)
	throws Exception {

if (pagedArray == null)
	return null;
this.originArray = pagedArray; // originArray
this.totalRecords = originArray.length;
this.currentPage = box.getInt("currPage") == 0 ? 1 : box
		.getInt("currPage");
this.pageCount = box.getInt("pageCount") == 0 ? defaultPageCount : box
		.getInt("pageCount");
this.numOfRows = convertNumOfRows(j);
this.totalPage = calculateTotalPage(this.numOfRows, this.totalRecords);
this.beginPage = calculateBeginPage(this.currentPage, this.pageCount);
this.endPage = calculateEndPage(this.beginPage, this.pageCount,
		this.totalPage);
this.pagedArray = calculatePagedArray(this.originArray);
this.originArray = null; // supposed to be garbage collected

// if ( this.currentPage > this.totalPage ) this.currentPage--;
// if ( this.currentPage > this.totalPage ) this.currentPage =
// this.totalPage;
return new PagedArray(this.pagedArray, this.currentPage,
		this.numOfRows, this.pageCount, this.totalPage, this.beginPage,
		this.endPage, this.totalRecords);
}

	
	
	
	
	
	
	
	
	
	
	
	

	private int calculateTotalPage(int numOfRows, int recCnt) throws Exception {
		int totalPage = 0;
		if (recCnt == 0 || numOfRows == -1)
			totalPage = 1;
		else {
			totalPage = (int) Math.ceil((double) (recCnt) / numOfRows);
		}
		return totalPage;
	}

	private int calculateBeginPage(int currPage, int pageCnt) throws Exception {
		return ((currPage - 1) / pageCnt) * pageCnt + 1;
	}

	private int calculateEndPage(int bPage, int pageCnt, int totPage)
			throws Exception {
		int iEndPage = bPage + pageCnt - 1;
		return Math.min(iEndPage, totPage);
	}

	private int calculateStartInx(int currentPage, int numOfRows)
			throws Exception {
		int startInx = (currentPage - 1) * numOfRows;
		if (startInx < 0)
			startInx = 0;

		return startInx;

	}

	private int calculateEndInx(int startInx, int numOfRows, int recCnt)
			throws Exception {
		int endInx = startInx + numOfRows;
		endInx = (endInx > recCnt) ? recCnt : endInx;

		return endInx;

	}

	private Object[] calculatePagedArray(Object[] originArray) throws Exception {
		int startInx = calculateStartInx(this.currentPage, this.numOfRows);
		int endInx = calculateEndInx(startInx, this.numOfRows,
				this.totalRecords);
		int arraySize = endInx - startInx;
		Class c = originArray.getClass().getComponentType();
		// //System.out.println("Name of class-----"+c+
		// "---value of current page--"+this.currentPage+"--value of no of rows---"+this.numOfRows+"--value total records---"+this.totalRecords+"-- value of end index--"+endInx+"--value of start index----"+startInx);
		Object array = Array.newInstance(c, arraySize);
		System.arraycopy(originArray, startInx, array, 0, arraySize);

		return (Object[]) array;
	}

	private int convertNumOfRows(int pRows) throws Exception {
		int numOfRows = 0;
		if (pRows == 0 || pRows < -1)
			numOfRows = defaultNumOfRows;
		else if (pRows == -1)
			numOfRows = this.totalRecords;
		else
			numOfRows = pRows;

		return numOfRows;
	}

}
