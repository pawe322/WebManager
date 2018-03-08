<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Pet</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<h3>Edit Pet</h3>
	<p style="color: red;">${errorString}</p>
	<c:if test="${not empty pet}">
		<form method="POST"
			action="${pageContext.request.contextPath}/editPet">
			<input type="hidden" name="name" value="${pet.name}" />
			<table border="0">
				<tr>
					<td>Name</td>
					<td style="color: red;">${pet.name}</td>
				</tr>
				<tr>
					<td>Type of animal</td>
					<td><input type="text" name="typeOfAnimal" value="${pet.typeOfAnimal}" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" value="${pet.age}" /></td>
				</tr>
				<tr>
					<td>Height[cm]</td>
					<td><input type="text" name="height" value="${pet.height}" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /> 
					<a href="${pageContext.request.contextPath}/petList">Cancel</a></td>
				</tr>
			</table>
		</form>
	</c:if>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>