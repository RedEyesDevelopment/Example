<html>
<body>

<%

// Grab the variables from the form.
    String firstName = request.getParameter("foo");
    String lastName = request.getParameter("bar");
    String sex = request.getParameter("baz");
%>
<%-- Print out the variables. --%>
<h1>Hello, <%=firstName%> <%=lastName%>!</h1>
I see that you are <%=sex%>.

</body>
</html>

