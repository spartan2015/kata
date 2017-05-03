package com.fortech.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	@Autowired
	BookRepository repo;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addObject("list", repo.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value="/view/{id}", method= RequestMethod.GET)
	public String view(@PathVariable("id") Long id, Model model){
		Book book = id != null && id != 0 ? repo.findOne(id) : new Book();
		
		model.addAttribute("book", book);
		
		return "view";
	}
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String save(@RequestParam Long id, @RequestParam String title){
		Book book = null;
		if (id != null && id != 0){
			book = repo.findOne(id);
		}else{
			book = new Book();
		}
		
		book.setTitle(title);
		repo.save(book);
		
		return "redirect:list";
	}

	public void setRepo(BookRepository repo) {
		this.repo = repo;
	}
	
	
}
