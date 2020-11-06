import cx_Oracle

#DB 연결
connection = cx_Oracle.connect('master02_semi/semi@qclass.iptime.org:1521/xe')
cursor = connection.cursor()

cursor.execute('SELECT USERID, ID, PASSWORD, PASSWORD_KEY, NAME, PHONE, ADDR, DETAILADDR, USERTYPE, GENDER, HEIGHT, 	UPLOADIMG, CAREER, MYCOMMENT, ADMIT, SIGNOUT FROM PSTM_USERINFO ORDER BY USERID DESC')

for result in cursor:
    print(result[4])

cursor.close()
connection.close()
		
		
	
		
	
