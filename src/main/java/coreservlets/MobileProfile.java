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

	public void doPost() throws JSONException {

		JSONObject json = new JSONObject();
		json.put("email", "");
		json.put("firstname", "");
		json.put("lastname", "");
		json.put("about", "");
		
		pw.write(json.toString());
	}

}
