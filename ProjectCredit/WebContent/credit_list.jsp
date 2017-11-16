<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Credit</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="CreditController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Name</th>
			 <th>Expedition Date</th>
			 <th>Type</th>
			
		</tr>
		<c:forEach var="credit" items="${credits}">
		
		<tr>
			<td>
				<form action= "CreditController">
					<input type = "hidden" name = "id" value= "${credit.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${credit.id}</td>
			<td> ${credit.name}</td>
			<td> ${credit.expeditionDate}</td>
			<td> ${credit.type}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>
	<form action="CreditReport">
				
					<input type = "submit" name = "btn_reporte" value = "Reporte"/>
				</form>

</body>
</html>