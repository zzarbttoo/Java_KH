<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>일정 목록 보기</h1>

	<form action="CalController.do" method="post">
		<input type="hidden" name="command" value="muldel" />

		<jsp:useBean id="util" class="com.cal.controller.Util"></jsp:useBean>

		<table border="1">
			<col width="50px" />
			<col width="50px" />
			<col width="300px" />
			<col width="200px" />
			<col width="100px" />

			<tr>
				<th><input type="checkbox" name="all" onclick="" /></th>
				<th>번호</th>
				<th>제목</th>
				<th>일정</th>
				<th>작성일</th>
			</tr>


			<c:choose>
				<c:when test="${empty list }">

					<tr>
						<td colspan="5">---------------작성된 일정이 존재하지
							않습니다--------------</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="dto">
						<tr>
							<th><input type="checkbox" name="chk" value="${dto.seq}" /></th>
							<td>${dto.seq }</td>
							<td><a href="#">${dto.title }</a></td>
							<td><jsp:setProperty property="toDates" name="util" value="${dto.mdate }"/>
                           <jsp:getProperty property="toDates" name="util"/>
							</td>
							<td><fmt:formatDate value="${dto.regdate }"
									pattern="yyyy:MM:dd" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>

			</c:choose>
		</table>


	</form>


</body>
</html>