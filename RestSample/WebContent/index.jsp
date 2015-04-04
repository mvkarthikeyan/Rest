<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="src/jquery.table2excel.js"></script>
<script type="text/javascript">
function call() {
$.ajax({
	method: "GET", 	
	contentType: "application/json",
	  url: "http://localhost:8080/RestSample/company",
	  success: function(data){
				drawTable(data);
	  }
	});
}
function drawTable(data) {
    for (var i = 0; i < data.length; i++) {
        drawRow(data[i]);
    }
}
function drawRow(rowData) {
    var row = $("<tr />");
    $("#excelDataTable").append(row); 
    row.append($("<td>" + rowData.id + "</td>"));
    row.append($("<td>" + rowData.companyName + "</td>"));
    row.append($("<td>" + rowData.contactNumber + "</td>"));
    row.append($("<td>" + rowData.hrPerson + "</td>"));
}
</script>
</head>
<body onload="call()">
<table id="excelDataTable" border="1">
   <tr>
        <th>Id</th>
        <th>Company Name</th>
        <th>Contact Number</th>
        <th>HR</th>
    </tr>
</table>
</body>​
</body>
</html>