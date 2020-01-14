package org.formation.test;

import java.util.Collection;

import org.formation.helper.RuleRunner;
import org.formation.model.stateful.Alarm;
import org.formation.model.stateful.Fire;
import org.formation.model.stateful.Room;
import org.formation.model.stateful.Sprinkler;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.rule.FactHandle;

public class TestFire {
	static RuleRunner ruleRunner;
	FactHandle[] factHandles;
	Room kitchen = new Room("kitchen");
	Room salon = new Room("salon");
	Sprinkler sprinklerKitchen = new Sprinkler(kitchen);
	Sprinkler sprinklerSalon = new Sprinkler(salon);
	
	@BeforeClass
	public static void init(){
		ruleRunner = new RuleRunner();
	}
	
	@After
	public void end() {
		ruleRunner.closeLogger();
		ruleRunner.disposeSession();
	}
	@Before
	public void initTest() {
		ruleRunner.initStatefulSession();
	}
	
	@Test
	public void testNofire(){
		System.out.println("************ No Fire ************");
		Object[] facts =new Object[4];
		facts[0] = kitchen;
		facts[1] = salon;
		facts[2] = sprinklerKitchen;
		facts[3] = sprinklerSalon;

		factHandles = ruleRunner.insertFacts(facts);
		ruleRunner.fireAllRules();

		Assert.assertFalse(sprinklerKitchen.isOn());
		Collection<FactHandle> fhs = ruleRunner.getAllFacts();
		System.out.println(fhs);
		System.out.println(fhs.size());
	}
	@Test
	public void testFireInKitchen(){
		System.out.println("************ Fire In Kitchen ************");
		Object[] facts =new Object[5];
		facts[0] = kitchen;
		facts[1] = salon;
		facts[2] = sprinklerKitchen;
		facts[3] = sprinklerSalon;
		facts[4] = new Fire(kitchen);

		ruleRunner.insertFacts(facts);
		ruleRunner.fireAllRules();

		Assert.assertTrue(sprinklerKitchen.isOn());
	}
	@Test
	public void testStopFireInKitchen(){
		System.out.println("************ Stop fire In Kitchen ************");
		Object[] facts =new Object[5];
		facts[0] = kitchen;
		facts[1] = salon;
		facts[2] = sprinklerKitchen;
		facts[3] = sprinklerSalon;
		facts[4] = new Fire(kitchen);

		factHandles = ruleRunner.insertFacts(facts);
		ruleRunner.fireAllRules();
		
		System.out.println(ruleRunner.getSprinklerOns());
		Assert.assertTrue(sprinklerKitchen.isOn());
		Assert.assertTrue(existAlarm());
		ruleRunner.retractFact(factHandles[4]);
		ruleRunner.fireAllRules();
		Assert.assertFalse(existAlarm());
	}


	@Test
	public void testStopFireInSalonButStillFireInKitchen(){
		System.out.println("************ Stop Fire In Salon But Still In Kitchen ************");
		Object[] facts =new Object[6];
		facts[0] = kitchen;
		facts[1] = salon;
		facts[2] = sprinklerKitchen;
		facts[3] = sprinklerSalon;
		facts[4] = new Fire(kitchen);
		facts[5] = new Fire(salon);

		factHandles = ruleRunner.insertFacts(facts);
		ruleRunner.fireAllRules();

		 
		Assert.assertTrue(sprinklerKitchen.isOn());
		Assert.assertTrue(sprinklerSalon.isOn());
		Assert.assertTrue(existAlarm());
		ruleRunner.retractFact(factHandles[5]);
		ruleRunner.fireAllRules();
		Assert.assertTrue(sprinklerKitchen.isOn());
		Assert.assertFalse(sprinklerSalon.isOn());
		Assert.assertTrue(existAlarm());

	}

	private boolean existAlarm() {
		Collection<FactHandle> fHandles = ruleRunner.getFacts(Alarm.class);
		System.out.println("there is "+fHandles.size()+" alarm(s) ");
		return fHandles.size() > 0;
	}
}
