package coreservlets;

import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.http.HttpServlet;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class MobileProfile extends HttpServlet {

	private static final long serialVersionUID = 5612023750818929781L;

	private Writer output;
	
	PrintWriter pw = new PrintWriter(output);

	public void doGet() throws JSONException {

		JSONObject json = new JSONObject();
		json.put("email", "japple@email.com");
		json.put("firstname", "Johnny");
		json.put("lastname", "Appleseed");
		json.put("about", "This user currently has no information.");
		
		try {
			pw.write(json.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
