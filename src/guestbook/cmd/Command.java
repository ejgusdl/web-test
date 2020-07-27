package guestbook.cmd;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command { //추상메서드 포함
	protected HttpServletRequest req;
	protected HttpServletResponse res;
	
	//명령을 실행
	public abstract void execute(HttpServletRequest req,HttpServletResponse res);//요청을 실행
	
	public void forward(String url){
		RequestDispatcher rd = req.getRequestDispatcher(url);
		try{
			rd.forward(req, res);
		}catch (ServletException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void redirect(String url) {
		try{
			res.sendRedirect(url);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
