<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList, guestbook.Article" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		
	}
</script>
</head>
<body>
	<h3>�����</h3>
	<a href="/web0722/guestbook/Controller?cmd=writeForm">���ۼ�</a><br/>
	<table border="1">
		<form action="" method="post" name="f">
			<tr>
				<td>�۹�ȣ</td><td>�ۼ���</td><td>�ۼ���</td><td>�۳���</td>
			</tr>
		<%
			ArrayList<Article> list = (ArrayList<Article>)request.getAttribute("list");
			for(Article a : list){
		%>	
			<!-- get������� �Ķ������ ���� url�� �����¹� ?�Ķ����=��-->
			<tr>
				<td><a href="/web0722/guestbook/Controller?cmd=editForm&num=<%=a.getNum()%>"><%=a.getNum() %></a></td>
				<td><%=a.getWriter() %></td><td><%=a.getW_date() %></td><td><%=a.getContent() %></td>
			</tr>
		</form>
		<% } %>
	</table>
</body>
</html>