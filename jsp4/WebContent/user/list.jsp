<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/common/header.jsp" %>
<html>
<script>
function afterLogin(result){
	var ths = $("table[id='table'] thead tr th");
	var str="";
 	for(var i=0; i<result.length; i++)
	{
 		str += "<tr>";
 		for(var j=0; j<ths.length;j++)
 			{
				var th = ths[j].getAttribute("data-field");
				str += "<td class='text-center'>" + result[i][th] + "</td>";
 			}
 		str += "</tr>";
 	} 
	
 	//< 이너 html과 같은 효과 
	$("#result_tbody").html(str);
}
$(document).ready(function(){

	var url = "list.user";
	var param = {};
	param["cmd"] = "list";


	$.ajax({
		type : "post",
		url : url,
		dataType : "json",
		data : param,
		success : afterLogin,
		error : function(xhr,status){
			alert("에러 : " + xhr.responseText)
		}
	});
	

})

</script>

<body>
	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th class="text-center" data-field="userNo">No</th>
					<th class="text-center" data-field="userId">ID</th>
					<th class="text-center" data-field="userName">Name</th>
					<th class="text-center" data-field="userAge">Age</th>
					<th class="text-center" data-field="userAddress">Address</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
</body>
</html>