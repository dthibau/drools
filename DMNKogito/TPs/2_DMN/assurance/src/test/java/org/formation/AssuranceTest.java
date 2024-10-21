package org.formation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.formation.model.Conducteur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntimeFactory;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNDecisionResult;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNResult;
import org.kie.dmn.api.core.DMNRuntime;

public class AssuranceTest {

	DMNRuntime dmnRuntime;
	DMNModel dmnModel;
	DMNContext dmnContext;

	public static String MODEL="assurance";
	public static String NAMESPACE="https://kiegroup.org/dmn/_28077627-2BC9-4821-BFA9-9AAF77F3010C";

	public static String INPUT_NODE="Conducteur";

	@BeforeEach
	public void setUp() {
		KieServices ks = KieServices.Factory.get();
	       KieContainer kContainer = ks.getKieClasspathContainer();   
	       dmnRuntime = KieRuntimeFactory.of(kContainer.getKieBase()).get(DMNRuntime.class);

	       dmnModel = dmnRuntime.getModel(NAMESPACE, MODEL);
	       dmnContext = dmnRuntime.newContext();  
	}
	
	@Test
	public void test20(){
		Conducteur conducteur = new Conducteur(20, 0, 0);

		dmnContext.set(INPUT_NODE, conducteur);
        DMNResult dmnResult =
            dmnRuntime.evaluateAll(dmnModel, dmnContext);


        for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {  
            System.out.println("Conducteur: " + conducteur + ", " +
                    "Decision: '" + dr.getDecisionName() + "', " +
                    "Result: " + dr.getResult());
        }
        assertEquals(500d, ((BigDecimal)dmnResult.getDecisionResultByName("Final Price").getResult()).doubleValue(), 0.001d);
	}	
	
	@Test
	public void test23_5_10(){
		Conducteur driver = new Conducteur(23, 5, 10);
		
		dmnContext.set(INPUT_NODE, driver);
        DMNResult dmnResult =
            dmnRuntime.evaluateAll(dmnModel, dmnContext);


        for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {  
            System.out.println("Driver: " + driver + ", " +
                    "Decision: '" + dr.getDecisionName() + "', " +
                    "Result: " + dr.getResult());
        }

		assertEquals(700d, ((BigDecimal)dmnResult.getDecisionResultByName("Final Price").getResult()).doubleValue(), 0.001d);
	}
}
