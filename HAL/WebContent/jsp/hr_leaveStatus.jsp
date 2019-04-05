<%@ page import="static jkt.hms.util.RequestConstants.*" %>

<script>
	
</script>

<form name="<%=LEAVE_STATUS%>" method="post" action="">
	<div class="titleBg"><h2>Types of leave status  </h2></div>
	<div class="clear"></div>
	<div class="Block">
	<!-- <h4><a href="javascript:void(0)" onclick="submitForm('leaveStatus','leave?method=showWaitingLeavesEncashment');"> Waiting for Encashment Approval</a></h4>
	<br /> -->
	<div class="clear"></div>
	<h4><a href="javascript:void(0)" onclick="submitForm('leaveStatus','leave?method=showWaitingLeaves');"> Waiting for Approval</a></h4> 
	<br />
	<div class="clear"></div>
	<h4><a href="javascript:void(0)" onclick="submitForm('leaveStatus','leave?method=showApprovedLeavecancel');"> Approved Leave cancel</a> </h4>
	<br />
	<div class="clear"></div>
	<h4><a href="javascript:void(0)" onclick="submitForm('leaveStatus','leave?method=showApprovedLeaves');"> Approved</a> </h4>
	<br />
		<div class="clear"></div>
	<h4><a href="javascript:void(0)" onclick="submitForm('leaveStatus','leave?method=showDisapprovedLeaves');"> Disapproved</a> </h4>
	<br />
	<div class="clear"></div>
	</div>

</form>

