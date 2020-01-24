package controllers;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.*;


@RestController
public class GreetingCardController {

	@Autowired
	List<Template> cardStorage;
	
	@PostMapping({"/greetingCard/create/newyear"})
	public List<String> validateNewyearBlanks(@RequestParam Map<String,String> allParams)  {
			return getBlankfields(NewYearTemplate.class, allParams);

	}
	@PostMapping({"/greetingCard/create/birthday"})
	public List<String> validateBirthdayBlanks(@RequestParam Map<String,String> allParams)  {
			return getBlankfields(BirthdayTemplate.class, allParams);

	}
	
	@PutMapping("/greetingCard/create/newyear")
	public void InsertTeplateNewCard(@RequestParam Map<String,String> allParams) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		Template template = new NewYearTemplate();
		createCard(allParams, template);
	
	}
	@PutMapping("/greetingCard/create/birthday")
	public void InsertBirthdayTeplateNewCard(@RequestParam Map<String,String> allParams) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
	Template template = new BirthdayTemplate();
	createCard(allParams, template);
	
	}	
	
	
	
	private List<String> getBlankfields(Class cls, Map<String, String> allParams) {
		ArrayList<String> blanks = new ArrayList<String>();
		//Collect all fields:
		List<String> expectedFields = Arrays.stream(cls.getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
		expectedFields.addAll(Arrays.stream(cls.getSuperclass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList()));
		//add to blanks list any field which associated param is  missing or empty field: 
		for(String expectedField : expectedFields ) {
			String value =  allParams.get(expectedField);
			if(value==null | value =="") {
			blanks.add(expectedField);
			}
		}
		return blanks;
	}
	
private void createCard(Map<String, String> allParams, Template template) throws NoSuchFieldException, IllegalAccessException {
		Class templateClass = template.getClass();
		List<Field> allFields = new ArrayList<Field>();
		
		allFields.addAll(Arrays.asList(templateClass.getDeclaredFields()));
		if(templateClass.getSuperclass() == Template.class)
		allFields.addAll(Arrays.asList(templateClass.getSuperclass().getDeclaredFields()));
		for (Map.Entry<String, String> entry : allParams.entrySet()) {
		Field f =  allFields.stream().filter(fld -> entry.getKey().equals(fld.getName())).findFirst().orElse(null);;
		f.setAccessible(true);
		f.set(template, entry.getValue());
		}
		cardStorage.add(template);
		System.out.println(cardStorage.size());

	}	
}

