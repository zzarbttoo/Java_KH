<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="com.cal.controller.*"
	import="com.cal.dao.*" import="com.cal.controller.*"
	import="com.cal.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#calendar {
	border-collapse: collapse;
	border: 1px solid grey;
}

#calendar th {
	width: 80px;
	border: 1px solid gray;
}

#calendar td {
	width: 80px;
	height: 80px;
	border: 1px solid gray;
	text-align: left;
	vertical-align: top;
	position: relative;
}

a {
	text-decoration: none;
}

#clist>p {
	font-size: 5px;
	margin: 1px;
	background-color: skyblue;
}

.cPreview{
	position:absolute;
	top : -30px;
	left : 10px;
	background-color : skyblue;
	width : 40px;
	height : 40px;
	text-align : center;
	line-height: 40px;
	border-radius : 40px 40px 40px 1px;
}

</style>

<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript">
	$(function() {

		$(".countView").hover(
				function() {
					var aCountView = $(this);
					var year = $(".y").text().trim();
					var month = $(".m").text().trim();
					var cDate = aCountView.text().trim();

					var yyyyMMdd = year + isTwo(month) + isTwo(cDate);

					$.ajax({
						type : "POST",
						url : "CalCountAjax.do",
						data : "id=kh&yyyyMMdd=" + yyyyMMdd,
						dataType : "json",
						async : false,
						success : function(msg) {

							var count = msg.calCount;
							aCountView.after("<div class ='cPreview'>" + count
									+ "</div>");

						},
						error : function() {

							alert("서버 통신 실패");
						}

					});

				}, function() {

					$(".cPreview").remove();

				});

	});

	function isTwo(n) {

		return (n.length < 2) ? "0" + n : n;

	}
</script>
</head>
<%
	Calendar cal = Calendar.getInstance();

int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH) + 1;

String paramYear = request.getParameter("year");
String paramMonth = request.getParameter("month");

if (paramYear != null) {
	year = Integer.parseInt(paramYear);

}

if (paramMonth != null) {

	month = Integer.parseInt(paramMonth);
}

if (month > 12) {

	month = 1;
	year++;

}

if (month < 1) {

	month = 12;
	year--;

}

//현재 년도, 현재 월, 해당 월의 1일
cal.set(year, month - 1, 1);

//1일의 요일
//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

//현재 월의 마지막 일
System.out.println(cal.getMaximum(Calendar.DAY_OF_MONTH));

//달력에 일정 표현 

CalDao dao = new CalDao();
String yyyyMM = year + Util.isTwo(month + "");
System.out.println(yyyyMM);
List<CalDto> clist = dao.calendarViewList("kh", yyyyMM);
%>
<body>

	<table id="calendar">
		<caption>
			<a href="calendar.jsp?year=<%=year - 1%>&month=<%=month%>">◁</a> <a
				href="calendar.jsp?year=<%=year%>&month = <%=month - 1%>">◀</a> <span
				class="y"><%=year%></span> 년 <span class="m"><%=month%></span> 월 <a
				href="calendar.jsp?year=<%=year%>&month=<%=month + 1%>">▶</a> <a
				href="calendar.jsp?year=<%=year + 1%>&month = <%=month%>">▷</a>
		</caption>

		<tr>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th>토</th>
			<th>일</th>
		<tr>

			<%
				//공백
			for (int i = 0; i < dayOfWeek - 1; i++) {

				out.print("<td>&nbsp;</td>");

			}

			for (int i = 1; i <= lastDay; i++) {
			%>


			<td><a class="countView"
				style="color:<%=Util.fontColor(i, dayOfWeek)%>"
				href="CalController.do?command=list&year=<%=year%>&month=<%=month%>&date=<%=i%>"><%=i%></a>
				<a
				href="insertcalboard.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastDay=<%=lastDay%>">
					<img alt="일정 추가" src="img/pen.png"
					style="width: 10px; height: 10px;" />
			</a>

				<div id="clist">
					<%=Util.getCalView(i, clist)%>
				</div></td>

			<%
				if ((dayOfWeek - 1 + i) % 7 == 0) {

				out.print("</tr><tr>");
			}
			}

			for (int i = 0; i < (7 - (dayOfWeek - 1 + lastDay) % 7) % 7; i++) {

				out.print("<td>&nbsp;</td>");
			}
			%>
		
	</table>



</body>
</html>