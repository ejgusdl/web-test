<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		console.log(f.pwd.value);
		if(f.id.value==''){
			alert("작성자 필수 작성");
			return
		}
		if(f.pwd.value==''){
			alert("비밀번호 필수 작성");
			return
		}
		if(f.msg.value==''){	
			alert("내용 필수 작성");
			return
		}
		f.submit()
	}
</script>
</head>
<body>
	<h3>글작성</h3>
	<form action="/web0722/guestbook/Controller?cmd=write" method="post" name="f">
		작성자:<input type="text" name="id"><br/>
		비밀번호:<input type="password" name="pwd" ><br/>
		내용:<br/>
		<textarea rows="10" cols="50" name="msg"></textarea><br/>
		<input type="button" value="작성하기" onclick="check()">
		<input type="reset" value="초기화">
	</form>
</body>
</html>