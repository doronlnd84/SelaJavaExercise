package controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Template;

@RestController
public class CatalogController {
  
//‎1.‎	Calling to greetingCard/catalog will return all the templates of the greeting card system :	 
	@GetMapping({"/greetingCard/catalog‎"})
	public String[] greeting()  {
		String[] templateTypes = {"Birthday","NewYear"} ;
		return templateTypes;
	}

}
