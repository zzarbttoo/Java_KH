<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="com.login.dao.*"
	import = "com.login.dto.*"
	import="java.util.List"
 %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//1.
	String command = request.getParameter("command");
	System.out.printf("[%s]\n", command);
	
	//2.
	MYDao dao = new MYDao();
	
	if(command.equals("login")){
		
		String myid= request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		MYDto dto = dao.login(myid, mypw);
		if(dto!=null){
			
			//3.
			//session : 만료될 때 까지 프로젝트 전체에서 사용
			session.setAttribute("login", dto);
		
			//setMaxInactiveInterval() :default 30분. 음수일 때 무제한
			session.setMaxInactiveInterval(10*60);
		
			//4.
			if(dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
				
			}else if(dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			}else{
			%>
				<script type = "text/javascript">
					alert("login 실패-id나 pw를 다시 확인해주세요");
					location.href="index.jsp";
				</script>
			
			<%
			} 
		}
		
	}else if(command.equals("logout")){
		//session 만료
		session.invalidate();
		response.sendRedirect("index.jsp");
	}else if(command.equals("listall")){
		//1. x
		//2. 
		List<MYDto> list = dao.selectListAll();
		//3.
		request.setAttribute("list", list);
		//4. 
		pageContext.forward("adminlistall.jsp");
		
	}else if(command.equals("listenabled")){
		
		List<MYDto> list = dao.selectListEnabled();
		
		request.setAttribute("list", list);
		pageContext.forward("listenabled.jsp");
		
	}else if(command.equals("registform")){
		response.sendRedirect("registform.jsp");
		
	}else if(command.equals("registformres")){
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name =request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		MYDto dto = new MYDto(id, password, name, address, phone, email);
		
		int res = dao.register(dto);
		
		if(res > 0){
		
			%>
			<script type= "text/javascript">
				alert("입력 성공");
				location.href="index.jsp";
			</script>
			<%
			
		}else{
			
			%>
			<script type ="text/javascript">
				alert("입력 실패");
				location.href = "registform.jsp";
			
			</script>
			
			<% 
		}
	}else if(command.equals("idchk")){
		
		String id = request.getParameter("id");
		System.out.println("되는거 맞냐");
		System.out.println(id);
		MYDto dto = dao.idCheck(id);
		boolean idnotused = true;
		
		if(dto.getMyid()!=null){
			
			idnotused = false;
			
		}
		
		System.out.println(idnotused);
		
	response.sendRedirect("idchk.jsp?idnotused="+idnotused);
	}else if(command.equals("updaterole")){
		//1.
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		//2.
		MYDto dto = dao.selectOne(myno);
		
		request.setAttribute("dto", dto);
		
		pageContext.forward("adminupdaterole.jsp");
		
		
		
	}else if(command.equals("updateroleres")){
		//1. 
		
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		//2. 
		int res = dao.updateUserRole(myno, myrole);
		//3. X
		
		//4.
		if (res >0){
			
%>
		<script type = "text/javascript">
			alert("등급 변경 성공");
			location.href="adminmain.jsp";
		</script>
<% 
			
		}else{
			
			
%>

		<script type = "text/javascript">
			alert("등급 변경 실패");
			location.href="adminupdaterole.jsp";
		</script>
<% 
		}
		
	}
	
	
	
	
	
%>


</body>
</html>