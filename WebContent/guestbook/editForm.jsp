<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	function edit(num,pwd) {
		checkPwd = prompt("작성글 비밀번호를 입력하세요");
		if(checkPwd==pwd){
			ta = document.getElementById("content"); //인자의 아이디로 요소를 찾아 객체로 만듬.
			str = ta.value;
// 			alert(str);
			location.href="/web0722/guestbook/Controller?cmd=edit&content="+str+"&num="+num;
			
			//로케이션은 이동할 위치를 나타냄. 자바스크립스 객체
		}else{
			alert("비밀번호 틀렸어~취소");
		}
		
	}
	function del(num,pwd) {
		checkPwd = prompt("작성글 비밀번호를 입력하세요");
		if(checkPwd==pwd){
			location.href="/web0722/guestbook/Controller?cmd=del&num="+num;
		}else{
			alert("비밀번호 틀렸어~취소");
		}
	}
</script>
</head>
<body>
	<!-- ${a.num} 값을 html 소스에 출력해줌 -->
	<h3>${a.num}번 글</h3>
	<table border="1">
		<tr>
			<th>작성자</th><td><input type="text" name="writer" value="${a.writer}" readonly></td>
		</tr>
		<tr>
			<th>작성일</th><td><input type="text" name="w_date" value="${a.w_date}" readonly></td>
		</tr>
		<tr>
			<th>글내용</th><td><textarea id="content">${a.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="edit" onclick="edit(${a.num},'${a.pwd}')"> <!-- a.pwd 문자열임으로 따움표롤 묶어준다 -->
				<input type="button" value="delete" onclick="del(${a.num},'${a.pwd}')">
			</td>
		</tr>
	</table>
</body>
</html>