package org.formation.model.stateless;

import java.util.Map;

public class Policy {

	private String insurerName;
	private String productLineName;
	
	private Map<Person.Type,Person> persons;
}
