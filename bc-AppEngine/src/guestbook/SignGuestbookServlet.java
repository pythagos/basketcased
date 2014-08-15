package guestbook;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class SignGuestbookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2800778962458456034L;
	private static final Logger log = Logger.getLogger(SignGuestbookServlet.class.getName());
	
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		// One Entity per guestbook
		String guestbookName = request.getParameter("guestbookName");
		String emailDeclared = request.getParameter("email");
		String nameDeclared = request.getParameter("name");
		
		if (guestbookName == null)
		{
			guestbookName = "default";
		}
		if(emailDeclared == null){
			emailDeclared = user.getEmail();
		}
		if(nameDeclared == null){
			nameDeclared = user.getNickname();
		}

		Key guestbookKey = KeyFactory.createKey("Guestbook", guestbookName);

		String content = request.getParameter("message");
		
		if (content == null)
		{
			content = "Greetings!";
		}
		
		if (user != null)
		{
			Entity greeting = new Entity("Greeting", guestbookKey);
			
			Date date = new Date();
			greeting.setProperty("user",  user);
			greeting.setProperty("date", date);
			greeting.setProperty("userId", user.getUserId());
			greeting.setProperty("federatedId", user.getFederatedIdentity());
			greeting.setProperty("domain", user.getAuthDomain());
			greeting.setProperty("content", content);
			greeting.setProperty("nameDeclared", nameDeclared);
			greeting.setProperty("emailDeclared", emailDeclared);
			
			DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
			ds.put(greeting);
		}
		else
		{
			log.info("Anonymous: " + content);
		}

		response.sendRedirect("/guest.jsp?guestbookName=" + guestbookName);
	}
}
