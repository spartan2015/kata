package org.design.patterns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface Controller {
	String execute(HttpServletRequest request, HttpServletResponse response);

}