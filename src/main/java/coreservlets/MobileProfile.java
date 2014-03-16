package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class MobileProfile extends HttpServlet {

	private static final long serialVersionUID = 5612023750818929781L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter rw = response.getWriter(); // WRITER
		
		JSONObject json = new JSONObject();
		
		HttpSession session = request.getSession(true);
		
		try {
			json.put("sessionid", session.getId());
			json.put("email", session.getAttribute("email"));
			json.put("firstname", session.getAttribute("firstname"));
			json.put("lastname", session.getAttribute("lastname"));
			json.put("about", session.getAttribute("about"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			rw.print(e);
		}
		
		rw.print(json.toString());
	}

}
