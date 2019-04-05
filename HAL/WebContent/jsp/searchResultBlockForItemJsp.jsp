<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * searchResultBlock.jsp  
 * Purpose of the JSP -  This is for Search Result Block.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.6
--%>



<div id="resultnavigation">
<form name="paging" method="post" action="">
|---<span currStart">1</span> to <span id="currEnd">10</span> of	<span id="totalRecs"></span> ---|

<input class="previous" type="button" name="firstpage" value="f"	onClick="navigate(this)" cursor:pointer; accesskey="f" /></td>
<input type="button" name="prevpage" value="p"	onClick="navigate(this)" accesskey="p" class="singlePrev" />

Page <span id="current">1 </span> of <span id="total"></span>
<input class="singleNext" type="button" name="nextpage" value="n" onClick="navigate(this)" accesskey="n" />
<input class="next" type="button" name="lastpage" value="l" onClick="navigate(this)" accesskey="l" />
<input type="text" name="pageno" id="pageno" MAXLENGTH="4"/>
<input type="button" name="ok" value="Go"	onClick="goToPage(pageno.value)" class="button" />
</form>

</div>

