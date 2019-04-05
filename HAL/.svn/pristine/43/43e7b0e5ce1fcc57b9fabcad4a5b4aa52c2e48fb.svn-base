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
<!-- |---- <span id="currStart">1</span> to <span id="currEnd">5</span> From <span	id="totalRecs"></span>
  ----|- -->
  
  <span id="currStart"  style="display: none;">1</span>
  <span id="currEnd" style="display: none;">5</span>
  <span	id="totalRecs" style="display: none;"></span>
  <!--
  <input type="hidden" id="totalRecs" name=""/>
    <input type="hidden" id="currEnd" name=""/>
    
    
        <input type="hidden" id="currStart" name=""/>
--><input type="button" class="previous" name="firstpage" value="f"	onClick="navigate(this)" accesskey="f" />
<input type="button" name="prevpage" value="p" onClick="navigate(this)" accesskey="p" class="singlePrev" /> Page <span id="current">1</span> of <span
	id="total">2</span> 
	<input type="button" name="nextpage" value="n" onClick="navigate(this)" accesskey="n" class="singleNext" /> 
	<input type="button" name="lastpage" value="l" onClick="navigate(this)" accesskey="l" class="next" /> 
	<input name="pageno" type="text" id="pageno" MAXLENGTH="4" tabindex=1 onkeypress="return onEnter(event,paging);" /> 
	<input type="button" value="Go" class="button" name="ok" tabindex="1"
	onClick="goToPage(pageno.value)" /></form>
</div>