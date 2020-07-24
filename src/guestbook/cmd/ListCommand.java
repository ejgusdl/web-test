package guestbook.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

public class ListCommand extends Command {

	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) {
		this.req = req;
		this.res = res;
		Service service = new ServiceImpl();
		ArrayList<Article> list = service.getAll();
		req.setAttribute("list",list);
		forward("/guestbook/list.jsp");

	}

}
