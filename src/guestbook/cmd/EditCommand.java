package guestbook.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

public class EditCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;
		Service service = new ServiceImpl();
		String content = req.getParameter("content");
		int num = Integer.parseInt(req.getParameter("num"));		
		service.editArticle(new Article(num,null,null,null,content));
		redirect("Controller?cmd=list");

	}

}
