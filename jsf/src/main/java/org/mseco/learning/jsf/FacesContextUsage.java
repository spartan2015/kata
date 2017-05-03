package org.mseco.learning.jsf;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.servlet.http.HttpSession;

public class FacesContextUsage {

	public String messages() {

		FacesContext c = FacesContext.getCurrentInstance();

		System.out.println(c.getMaximumSeverity());
		
		// clientId is the component id - usefull with validation and conversion errors 
		c.addMessage("clientId", new FacesMessage(FacesMessage.SEVERITY_ERROR,"summary","detail"));
		
		Iterator it = c.getClientIdsWithMessages();
		while (it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}

		it = c.getMessages();
		while (it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}

		return null;
	}
	
	public String viewRoot(){
		FacesContext c = FacesContext.getCurrentInstance();
		
		UIViewRoot r = c.getViewRoot();
		
		return null;
	}
	
	public String controlLifeCycle(){
		FacesContext c = FacesContext.getCurrentInstance();
		
		ResponseStream rs = c.getResponseStream(); // if you need to send an image as response
		ResponseWriter rw = c.getResponseWriter(); // if you nned to send a text as a response
		// if you use either one you need to also use c.responseComplete()

		
		c.renderResponse(); // jump to the render response phase
		c.responseComplete();// this is when you already sent a response to the user - the lifecycle skips even the render resposen phase
		
		return null;
	}
	
	public String accessExternalContext(){
		FacesContext c = FacesContext.getCurrentInstance();
		ExternalContext ec = c.getExternalContext();
		//useful if you need to invalidate the session
		HttpSession s = (HttpSession)ec.getSession(true);
		s.invalidate(); // log out ?		
		//usefull when integrating or migrating old technologies
		/*
		public Object getRequest();
		public Map getRequestMap();
		public Map getRequestParameterMap();
		public Map getRequestParameterValuesMap();
		public Iterator getRequestParameterNames();
		public Map getRequestHeaderMap();
		public Map getRequestHeaderValuesMap();
		public Map getRequestCookieMap();
		public Locale getRequestLocale();
		public Iterator getRequestLocales();
		public String getRequestPathInfo();
		public String getRequestContextPath();
		public Cookie[] getRequestCookies();
		
				
		   ExternalContext also wraps the servlet and portlet authentication methods,
which are usually found in their request objects:
	  public String getAuthType();
	  public String getRemoteUser();
	  public Principal getUserPrincipal();
	  public boolean isUserInRole(String role);
		
		
		 If you want to redirect the user to another URL, you can use this method:
public void redirect(String url) throws IOException;


   To forward control of the request to a URI in the external environment,
use dispatch:
     public void dispatch(String requestURI)
                            throws IOException, FacesException;
For servlets, this is equivalent to RequestDispatcher.forward. For portlets, it uses
the RequestDispatcher.include method instead. It makes sense to use dispatch
when you’re integrating with non-JSF resources in the same web application.


                                                                             If
you want to forward to another JSF view, use FacesContext.setViewRoot instead.



   ExternalContext also provides some methods for encoding URLs, which means
rewriting them so they’ll work properly within servlet or portlet environments:
  public String encodeActionURL(String url);
  public String encodeResourceURL(String url));
  public String encodeURL(String url);
  public String encodeNamespace(String aValue);



    Last but not least, ExternalContext wraps the container’s logging methods
as well:
   public void log(String message);
   public void log(String message, Throwable exception);

		*/
		return null;
	}
}
