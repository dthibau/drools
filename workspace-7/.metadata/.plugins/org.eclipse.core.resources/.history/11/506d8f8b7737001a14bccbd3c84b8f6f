package org.formation.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.drools.template.ObjectDataCompiler;

public class GenerateurTemplate {

	public static void main(String[] args) {
		
		// Generating from maps
		Collection<Map<String,Object>> paramMaps = new ArrayList<Map<String,Object>>();
		Map<String, Object> row1= new HashMap<String,Object>();
		row1.put("ageMin", 18);
		row1.put("ageMax", 25);
		row1.put("prixBase", 500);
		paramMaps.add(row1);

		Map<String, Object> row2= new HashMap<String,Object>();
		row2.put("ageMin", 25);
		row2.put("ageMax", 150);
		row2.put("prixBase", 300);
		paramMaps.add(row2);
		
		GenerateurTemplate me = new GenerateurTemplate();
		System.out.println(me.compile(paramMaps));

		}

	public String compile(Collection<Map<String,Object>> paramMaps) {
		// populate paramMaps

		ObjectDataCompiler converter = new ObjectDataCompiler();

		InputStream templateStream = this.getClass().getResourceAsStream("/org/formation/dtables/age.drt" );

		return converter.compile( paramMaps, templateStream );

	}
}
