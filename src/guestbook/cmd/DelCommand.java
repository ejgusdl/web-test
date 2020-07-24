package guestbook.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Service;
import guestbook.ServiceImpl;

public class DelCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;
		Service service = new ServiceImpl();
		service.delArticle(Integer.parseInt(req.getParameter("num")));
		redirect("Controller?cmd=list");
	}

}
