$(function(){	
	var ctx = top.window.frames[0].document;
	$("#sessionLocaleSelect",ctx).show();
	
	var sel = $("select[name='userSessionLocale']",ctx);
	sel.val("en");
	
	$("input[name='name']",ctx).val("virimia");
	$("input[name='password']",ctx).val("Iucca123");
	
	sel.closest("form").submit();
	sel.closest("form").submit();
});