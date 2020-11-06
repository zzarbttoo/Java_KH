<?xml version="1.0" encoding="EUC-KR" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
    <jsp:directive.page language="java"
        contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="EUC-KR" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<title>Insert title here</title>
</head>
<body>

	<h1>POST</h1>
	
	<table border = "1">
		<tr>	
			<th>NAME</th>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<th>ADDRESS</th>
			<td>${dto.addr }</td>
		</tr>
		<tr>
			<th>PHONE</th>
			<td>${dto.phone }</td>
		</tr>
	</table>

</body>
</html>
</jsp:root>