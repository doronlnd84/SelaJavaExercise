package controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Template;

@RestController
public class CatalogController {
  
	
	@GetMapping({"/greetingCard/catalog‎"})
	public String[] greeting()  {
		String[] templateTypes = {"Birthday","NewYear"} ;
		return templateTypes;
	}

}
