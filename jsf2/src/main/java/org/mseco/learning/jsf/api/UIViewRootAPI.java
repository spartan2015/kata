package org.mseco.learning.jsf.api;

import java.util.Locale;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class UIViewRootAPI {

	void api(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		UIViewRoot v = ctx.getViewRoot();
		
		/*
If JSP is being used for the view, the viewId is the extra path information of the
request, which is the part of the URI after the servlet name but before any request
parameters. So, for the request http://www.something-funny.com/faces/kindafunny.
jsp, the viewId is /kindafunny.jsp.
		 */
		String viewId = v.getViewId();
		
		/*
   You can use a view identifier to create a new UIViewRoot instance. Creating a
new view isn’t a common application development activity, but you may need to
do it in cases when you want to bypass the navigation system and control the next
page that will be displayed:
		 
		 */
		UIViewRoot uvr = (UIViewRoot)ctx.getApplication().getViewHandler()
			.createView(ctx, "/projecttrack/login.jsp");		
		ctx.setViewRoot(uvr);
		
		Locale l = v.getLocale();
		v.setLocale(l);
		
		
		/*
                                                                     Each render kit
has its own unique identifier, which is usually specified in a JSF configuration file
(the identifier for the standard render kit is stored in the RenderKitFactory.
HTML_BASIC_RENDER_KIT constant). For basic HTML applications, you normally
won’t need to change it—the standard render kit will be enough. However, if you
have multiple render kits available—perhaps an additional kit for a mobile device
and one for enhanced JavaScript and DHTML—you can change the render kit
depending on the user’s preference (or client type).
		 */
		String s = v.getRenderKitId();
		v.setRenderKitId(s);
		
		
		
	}
}
