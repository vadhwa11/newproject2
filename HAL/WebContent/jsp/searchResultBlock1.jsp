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

<div id="resultnavigation1">
<form name="paging1" method="post" action="">
<script type="text/javascript">
	
function onEnter(evt, frm ) {
 var keyCode = null;

 if( evt.which ) {
 keyCode = evt.which;
 } else if( evt.keyCode ) {
 keyCode = evt.keyCode;
 }
 if( 13 == keyCode ) {
 frm.ok.click();
 return false;
 }
 return true;
 }
</script>

  
  <span id="currStart1"  style="display: none;">1</span>
  <span id="currEnd1" style="display: none;">5</span>
  <span	id="totalRecs1" style="display: none;"></span>
  <!--
  <input type="hidden" id="totalRecs" name=""/>
    <input type="hidden" id="currEnd" name=""/>
    
    
        <input type="hidden" id="currStart" name=""/>
--><input type="button" class="previous" name="firstpage1" value="f"	onClick="navigate11(this)" accesskey="f" />
<input type="button" name="prevpage1" value="p" onClick="navigate11(this)" accesskey="p" class="singlePrev" /> Page <span id="current1">1</span> of <span
	id="total1">2</span> 
	<input type="button" name="nextpage1" value="n" onClick="navigate11(this)" accesskey="n" class="singleNext" /> 
	<input type="button" name="lastpage1" value="l" onClick="navigate11(this)" accesskey="l" class="next" /> 
	<input name="pageno1" type="text" id="pageno1" MAXLENGTH="4" tabindex=1 onkeypress="return onEnter(event,paging);" /> 
	<input type="button" value="Go" class="button" name="ok" tabindex="1"
	onClick="goToPage(pageno1.value)" /></form>
</div>