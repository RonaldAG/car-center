<%@ page import="br.com.carsoft.servlet.CreateCarServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h2>Hello ${requestScope.carName} !</h2>
     <form action="/homepage" method="post">
            <button type="submit">Voltar para home</button>
     </form>
</body>
</html>