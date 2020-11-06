<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	file : ${fileObj.name }
	<br/> desc : ${fileObj.desc }
	<br/>

	<form action="download" method="post">
		<input type="hidden" name="name" value="${fileObj.name }" /> <input
			type="submit" value="download" />
	</form>

	<!-- 
		tomcat web.xml 아래쪽에 mime-type (Multipurpose Internet Mail Extension)
		request header에 지정되는, 데이터가 어떤 종류의 stram인지 나타내는 프로토콜
		
		mime-type 추가 
		<mime-mapping>
			<extension>hwp</extension>
			<mime-type>applicatoin/unknown</mime-type>
		</mime-mapping>
	 -->
</body>
</html>