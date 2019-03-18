package it.prova.gescaresa.web.servlet.contribuente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet("/PrepareInsertContribuenteServlet")
public class PrepareInsertContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	@Autowired
//	private MunicipioService municipioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public PrepareInsertContribuenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/insertForm.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
