package guestbook.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

public class WriteCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;
		Service service = new ServiceImpl();
		String result = "/web0722/guestbook/Controller?cmd=list";
		String writer = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String msg = req.getParameter("msg");
		Article a = new Article(0,writer,pwd,null,msg);
		service.addArticle(a);
		redirect(result);
		

	}

}
