<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page
	import = "com.pstm.tcp.*"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type ="text/css">
	
	.textprintwrapper{
		height: 500px;
		width : 400px;
		background-color: grey;
	}
	
	.textinputwrapper{
		height : 100px;
		width : 400px;
		background-color : skyblue;
	}
	
</style>
<body>
<% 
	//우리는 여
	 ChatClientApp chatClient= new ChatClientApp(1);
%>


	<div class = "textprintwrapper">
		<input type = "text" readonly = "readonly" name = "textfield" class = "textfield">
	</div>
	<div class = "textinputwrapper">
		<input type = "text" name = "typearea" class = "typearea">
		
	</div></body>
</html>