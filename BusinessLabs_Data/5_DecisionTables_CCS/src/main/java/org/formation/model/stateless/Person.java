package org.formation.model.stateless;

import java.util.Map;

public class Person {

	public enum Type {
        DRIVER,
        PASSENGER
    }
	
	Map<String,Object> map;

	public Map<String, Object> get() {
		return getMap();
	}
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	public int getInteger(String key) {
		return (Integer)map.get(key);
	}
}
