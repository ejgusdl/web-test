package guestbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.cmd.Command;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns="/guestbook/Controller", 
initParams={@WebInitParam(name="mapping",value="/WEB-INF/cmd.properties")})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Properties cmds;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String path = config.getInitParameter("mapping"); //이름이 mapping인 초기화 파라메터의 값을 읽음
		InputStream is = getServletContext().getResourceAsStream(path);
		cmds = new Properties();
		try {
			cmds.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd==null||cmd.equals("")){
			cmd="list";
		}
		String className = cmds.getProperty(cmd);
		try {
			Command command = (Command) Class.forName(className).newInstance();
			command.execute(request,response);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
