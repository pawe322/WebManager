<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Create Pet</title>
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Create Product</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createPet">
         <table border="0">
            <tr>
               <td>Name</td>
               <td><input type="text" name="name" value="${pet.name}" /></td>
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
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="petList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>