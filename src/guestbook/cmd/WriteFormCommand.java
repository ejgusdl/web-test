package guestbook.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Service;
import guestbook.ServiceImpl;

public class WriteFormCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;
		forward("/guestbook/form.jsp");

	}

}
