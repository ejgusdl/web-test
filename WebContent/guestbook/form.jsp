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
			alert("�ۼ��� �ʼ� �ۼ�");
			return
		}
		if(f.pwd.value==''){
			alert("��й�ȣ �ʼ� �ۼ�");
			return
		}
		if(f.msg.value==''){	
			alert("���� �ʼ� �ۼ�");
			return
		}
		f.submit()
	}
</script>
</head>
<body>
	<h3>���ۼ�</h3>
	<form action="/web0722/guestbook/Controller?cmd=write" method="post" name="f">
		�ۼ���:<input type="text" name="id"><br/>
		��й�ȣ:<input type="password" name="pwd" ><br/>
		����:<br/>
		<textarea rows="10" cols="50" name="msg"></textarea><br/>
		<input type="button" value="�ۼ��ϱ�" onclick="check()">
		<input type="reset" value="�ʱ�ȭ">
	</form>
</body>
</html>