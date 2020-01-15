package org.formation.helper;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;

public class MyAgendaListener extends DefaultAgendaEventListener {

	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		// TODO Auto-generated method stub
		System.out.println("************\nAfter Match Fired " + event +"\n**********");
	}

	@Override
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("************\nAfter Rule Flow Activated " + event +"\n**********");
	}

	@Override
	public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("************\nAfter Rule Flow Deactivated " + event +"\n**********");
	}

	@Override
	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("************\nAgenda group popped " + event +"\n**********");
	}

	@Override
	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("************\nAgenda group pushed " + event +"\n**********");
	}

	@Override
	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		// TODO Auto-generated method stub
		System.out.println("************\nBefore Match Fired " + event +"\n**********");
	}

	@Override
	public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("************\nBefore Rule Flow Group Activated " + event+"\n**********");
	}

	@Override
	public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("************\nBefore Rule Flow Group Deactivated " + event+"\n**********");
	}

	@Override
	public void matchCancelled(MatchCancelledEvent event) {
		// TODO Auto-generated method stub
		System.out.println("************\nMatch cancelled " + event+"\n**********");
	}

	@Override
	public void matchCreated(MatchCreatedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("************\nMatch Created " + event+"\n**********");
	}

	
}
