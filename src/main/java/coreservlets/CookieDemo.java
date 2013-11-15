package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = getCookie(request, response);
		printResponse(response, cookie);
	}

	private Cookie getCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie cookie = null;
		Cookie[] cookiesArray = request.getCookies();
		if (cookiesArray != null) {
			for (int i = 0; i < cookiesArray.length; i++) {
				if (cookiesArray[i].getName().equals("za_cookie")) {
					cookie = cookiesArray[i];
				}
			}
			if (cookie != null) {
				System.out.println("Cookie retrieved.");
			} else {
				int timeToExpireCookie = new Integer(getServletContext()
						.getInitParameter("time-to-expire-cookie")).intValue();
				cookie = new Cookie("za_cookie", Long.toString(new Date()
						.getTime()));
				cookie.setMaxAge(timeToExpireCookie);
				cookie.setPath(request.getContextPath());
				System.out.println("Cookie created.");
				response.addCookie(cookie);
			}
		}
		return cookie;
	}

	private void printResponse(HttpServletResponse response, Cookie cookie)
			throws IOException {
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");
		printWriter.println("<html>");
		printWriter.println("<head><Title>Cookie Output</Title></head>");
		printWriter.println("<body>");
		printWriter.println("Cookie Name: " + cookie.getName() + "<br>");
		printWriter.println("Cookie Value: " + cookie.getValue() + "<br>");
		printWriter.println("Cookie Expires: " + cookie.getMaxAge()
				+ " seconds<br>");
		printWriter.println("</body>");
		printWriter.println("</html>");
	}

}
