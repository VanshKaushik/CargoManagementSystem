<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<!-- //cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css
 --><link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">


<script type="text/javascript">

$(document).ready(function () {
    $('#cargtab').DataTable({
        pagingType: 'full_numbers',
    });
});
</script>

</head>
<body>
<h3>View  Cargo</h3>
<a href="/">AddCargo</a>
<table id="cargtab" class="table">
<thead class="thead-dark">
<tr>
<th>
CargoNumber
</th>
<th>
Name
</th>
<th>
Email
</th>
<th>
Phno
</th>

<th>Edit</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<c:forEach items="${cargos}" var="carg">
<tr>
<td>${carg.cno}</td>
<td>${carg.name}</td>
<td>${carg.email}</td>
<td>${carg.phno}</td>

<td><a href="editCarg?cid=${carg.cno}">Edit</a></td>
     <td><a href="deleteCarg?cid=${carg.cno}">Delete</a>

</tr>

</c:forEach>

</tbody>

</table>
</body>
</html>