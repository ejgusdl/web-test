<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
	
	<% //스크립트릿: 자바코드. request:요청  / responce:응답
		String id  = request.getParameter("id"); //폼파라메터 값 읽음.파라메터:폼파라메터 이름
		String pwd = request.getParameter("pwd");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");
		String msg = request.getParameter("msg");
		String type = request.getParameter("type");
	%>
	<h3>파라메터 출력</h3>
	id:<%= id %><br/>  <!-- %= 은 자바변수 출력(자바변수를 넣으면 웹페이지에 출력해준다 -->
	pwd:<%= pwd %><br/>
	hobby:<% for(String i:hobby){out.print(i+"<br/>");} %><br/>  <!-- out.print 출력의 다른 방법 -->
	gender:<%= gender %><br/>
	grade:<%= grade %><br/>
	msg:<%= msg %><br/>
	type:<%=type %><br/>
	
</body>
</html>