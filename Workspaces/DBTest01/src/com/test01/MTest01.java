package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//JDBC 
		//1. driver 연결 : ojdbc6.jar 꼭!!
		//Class.forName에는 리플렉션 개념이 들어가있다
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. 계정 연결 (아이디, 패스워드, 어디에 연결할 지)<- 오라클 서버를 의미한다 <- 오라클 서버의 주소를 찾아와야한다
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		//java.sql package에 들어가있다 
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. query 준비
		//sql만들 때 젤 앞과 뒤는 공백을 넣는 것이 국룰임
		String sql = " SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO "
				+" FROM EMP ";
		//interface
		Statement stmt = con.createStatement();
		//4. query 실행 및 리턴
		//select 쿼리를 전달하면 table이 나온다 
		//statement 객체가 쿼리를 실행했다
		//실행 결과를 ResultSet에다가 넣었다
	
		ResultSet rs = stmt.executeQuery(sql);
		//Resultset에서 한줄씩 들고 올 것이다
		while(rs.next()) {
			
			//첫번째 컬럼에 있는 값 실행해줘요
			//컬럼 이름을 쓰거나, 쿼리 순서를 써주면 된다
			//데이터 베이스에서 하나하나 꺼내왔다
//			System.out.println(rs.getInt(1) + "\t"
//					+rs.getString(2) +"\t"
//					+rs.getString(3) + "\t"
//					+rs.getInt(4) + "\t"
//					+rs.getDate("HIREDATE") + "\t"
//					+rs.getDouble("SAL") + "\t"
//					+rs.getDouble("COMM") + "\t"
//					+rs.getInt("DEPTNO")
//					);
//			
			
			 System.out.printf("%5d\t",rs.getInt(1));
	         System.out.printf("%6s\t",rs.getString(2));
	         System.out.printf("%10s\t",rs.getString(3));
	         System.out.printf("%5d\t",rs.getInt(4));
	         System.out.printf("%s\t",rs.getDate("HIREDATE"));
	         System.out.printf("%.1f\t",rs.getDouble(6));
	         System.out.printf("%.1f\t",rs.getDouble("COMM"));
	         System.out.printf("%4d\t",rs.getInt("DEPTNO"));
	         System.out.println();
			
			
			
		}
		
		//5. db 종료
		// 가장 먼저 열었던 것이 가장 마지막에 닫아져야한다
		
		rs.close();
		stmt.close();
		con.close();
	}
	
}
