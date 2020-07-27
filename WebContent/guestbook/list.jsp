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
	<h3>방명록</h3>
<!-- 	el은 servlet에서 setAttribute한 객체를 다이렉트로 접근.페이지에서 자바코드를 쓰지않아서 깔끔(vo(dto)에 디폴트 생성자,setter,getter를 작성) -->
<!-- 	<a href=""${pageContext.request.contextPath}/guestbook/Controller?cmd=writeForm">글작성</a><br/> -->
	<a href="/web0722/guestbook/Controller?cmd=writeForm">글작성</a><br/>
	<table border="1">
		<form action="" method="post" name="f">
			<tr>
				<td>글번호</td><td>작성자</td><td>작성일</td><td>글내용</td>
			</tr>
		<%
			ArrayList<Article> list = (ArrayList<Article>)request.getAttribute("list");
			for(Article a : list){
		%>	
			<!-- get방식으로 파라메터의 값을 url로 보내는법 ?파라메터=값-->
			<tr>
				<td><a href="/web0722/guestbook/Controller?cmd=editForm&num=<%=a.getNum()%>"><%=a.getNum() %></a></td>
				<td><%=a.getWriter() %></td><td><%=a.getW_date() %></td><td><%=a.getContent() %></td>
			</tr>
		</form>
		<% } %>
	</table>
</body>
</html>