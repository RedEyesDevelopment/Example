<html>
<body>
<pre>
<%
    java.util.Enumeration e = request.getHeaderNames();

    while (e.hasMoreElements())
    {
        String headerName = (String) e.nextElement();
        out.print(headerName+": ");

        java.util.Enumeration h = request.getHeaders(headerName);

        while (h.hasMoreElements())
        {
            String header = (String) h.nextElement();
            out.print(header);
            if (h.hasMoreElements()) out.print(", ");
        }
        out.println();
    }
%>
</pre>
</body>
</html>

