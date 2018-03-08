<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <title>Pet List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Pet List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Type of Animal</th>
          <th>Age</th>
          <th>Height[cm]</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${petList}" var="pet" >
          <tr>
             <td>${pet.id}</td>
             <td>${pet.name}</td>
             <td>${pet.typeOfAnimal}</td>
             <td>${pet.age}</td>
             <td>${pet.height}</td>
             <td>
                <a href="editPet?name=${pet.name}">Edit</a>
             </td>
             <td>
                <a href="deletePet?name=${pet.name}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createPet" >Create Pet</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>