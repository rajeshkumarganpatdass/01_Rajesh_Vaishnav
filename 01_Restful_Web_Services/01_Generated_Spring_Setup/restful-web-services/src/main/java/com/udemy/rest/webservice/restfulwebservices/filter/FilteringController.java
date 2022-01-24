package com.udemy.rest.webservice.restfulwebservices.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	//static will work, only if @JsonFilter("SomeBeanFilter") is removed from SomeBean class
	@GetMapping("/static-filtering")
	public SomeBean retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		return someBean;
	}
	
	@GetMapping("/static-filtering-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		return buildListOfSomeBean();
	}
	
	//dynamic will work, only if @JsonFilter("SomeBeanFilter") is added in SomeBean class
	//dynamic filtering
	// field1,field2
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retrieveSomeBeanDynamic() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(someBean);

		mapping.setFilters(filters);

		return mapping;
	}
	
	//dynamic filtering
	// field2, field3
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retrieveListOfSomeBeans() {
		
		List<SomeBean> lst = buildListOfSomeBean();

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(lst);

		mapping.setFilters(filters);

		return mapping;
	}
	
	private List<SomeBean> buildListOfSomeBean()
	{
		SomeBean someBean1 = new SomeBean("value1", "value2", "value3");
		SomeBean someBean2 = new SomeBean("value21", "value22", "value23");
		SomeBean someBean3 = new SomeBean("value31", "value32", "value33");
		
		List<SomeBean> lst = new ArrayList<>();
		lst.add(someBean1);
		lst.add(someBean2);
		lst.add(someBean3);
		
		return lst;
	}
}
