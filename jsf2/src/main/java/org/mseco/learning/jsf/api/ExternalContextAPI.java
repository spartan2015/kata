package org.mseco.learning.jsf.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.Map;
import java.util.Set;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class ExternalContextAPI {
	public void execute(ActionEvent ev){
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		ExternalContext ectx = ctx.getExternalContext();
		
		// it's generic to support both servlet and portlet
		
		// access attributes in map form
		Map map = null;
				
		map = ectx.getRequestCookieMap(); System.out.println(map);
		
		map = ectx.getRequestHeaderMap(); System.out.println(map);
		
		map = ectx.getRequestHeaderValuesMap(); System.out.println(map);
		
		map = ectx.getRequestParameterMap(); System.out.println(map);
		
		map = ectx.getRequestParameterValuesMap(); System.out.println(map);
						
		map = ectx.getSessionMap(); System.out.println(map);
		
		map = ectx.getApplicationMap(); System.out.println(map);
		
		map = ectx.getInitParameterMap(); System.out.println(map);
		
		HttpSession session = (HttpSession)ectx.getSession(false);
		//session.invalidate();
		
		
		// resources
		
		ectx.getRequestContextPath();		
		Set<String> paths = ectx.getResourcePaths(null);
		System.out.println(paths);
		
		ectx.getResourceAsStream("resource.txt");
		try {
			URL resourceURL = ectx.getResource("");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServletContext sctx = (ServletContext)ectx.getContext();
		
		ectx.getRequestLocales();
		
		// get context authentification methods
		
		/*
           ExternalContext.BASIC_AUTH
           ExternalContext.CLIENT_CERT_AUTH
           ExternalContext.DIGEST_AUTH
           ExternalContext.FORM_AUTH
		 */
		String authType = ectx.getAuthType();		
		String remoteUser = ectx.getRemoteUser();
		Principal userPrincipal = ectx.getUserPrincipal();
		boolean b = ectx.isUserInRole("theRole");
		
		
		Object response = ectx.getResponse(); // either servletResponse or portletResponse
		
		
		// redirect to another URL
		try {
			ectx.redirect("http://google.ro");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// forward the control of the request to a uri in the external environment
		/*
		 * For servlets, this is equivalent to RequestDispatcher.forward. For portlets, it uses
the RequestDispatcher.include method instead. It makes sense to use dispatch
when you’re integrating with non-JSF resources in the same web application. 

If you want to forward to another JSF view, use FacesContext.setViewRoot instead.

		 */
		try {
			ectx.dispatch("anotherServlet");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// encoding URLs
		/*
		 * You generally won’t need to use these for application development because encod-
ing is handled automatically by components or their renderers. (They’re quite
useful for developing components and renderers, however.) If you’re outputting
markup directly, however, they’re a necessity. Use encodeActionURL anytime you’re
outputting a URL for an action, encodeResourceURL for other links within a page
(like an image), and encodeURL for any other URLs. Most of time, these methods
just call HttpServletResponse.encodeURL, but their general purpose is to make
sure that the web container and portlet container properly understand the URL.

		 */
		String result = ectx.encodeActionURL("url"); System.out.println(result);
		result = ectx.encodeResourceURL("url"); System.out.println(result);
		result = ectx.encodeNamespace("url"); System.out.println(result);
		
		
		
		// LOGGIN
		ectx.log("wee");
		ectx.log("ext", new Throwable());
		
	}
}
