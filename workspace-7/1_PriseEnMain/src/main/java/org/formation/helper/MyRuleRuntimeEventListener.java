package org.formation.helper;

import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;

public class MyRuleRuntimeEventListener implements RuleRuntimeEventListener{


	public void objectDeleted(ObjectDeletedEvent event) {
		System.out.println("************\nObject deleted " + event +"\n**********");


	}

	public void objectInserted(ObjectInsertedEvent event) {
		System.out.println("************\nObject inserted " + event +"\n**********");


	}

	public void objectUpdated(ObjectUpdatedEvent event) {
		System.out.println("************\nObject updated " + event +"\n**********");


	}

}
