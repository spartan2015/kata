/*
 * unable to find tapestry 3 and with 4 it does not work
 * */
//package tapestry3integration;
//
//import java.util.Map;
//
//import javax.servlet.ServletContext;
//
//import org.apache.tapestry.engine.BaseEngine;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//import org.apache.tapestry.request.RequestContext;
//
//public class SpringTapestryEngine extends BaseEngine {
//	private static final String SPRING_CONTEXT_KEY = "springContext";
//
//	protected void setupForRequest(RequestContext context) {
//		super.setupForRequest(context);
//		Map global = (Map) getGlobal();
//		ApplicationContext appContext = (ApplicationContext) global.get(SPRING_CONTEXT_KEY);
//		
//		if (appContext == null) {
//			ServletContext servletContext = context.getServlet()
//					.getServletContext();
//
//			appContext = WebApplicationContextUtils
//					.getWebApplicationContext(servletContext);
//			global.put(SPRING_CONTEXT_KEY, appContext);
//		}
//	}
//
//}
