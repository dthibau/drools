/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.formation.test;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleTest {
	static final Logger LOG = LoggerFactory.getLogger(RuleTest.class);
	
	@Test
	public void test() {
		KieServices kieServices = KieServices.Factory.get();
        
		KieContainer kContainer = kieServices.getKieClasspathContainer();
        Results verifyResults = kContainer.verify();
        for (Message m : verifyResults.getMessages()) {
        	LOG.info("{}", m);
        }
        
	    LOG.info("Creating kieBase");
	    KieBase kieBase = kContainer.getKieBase();
        
        LOG.info("There should be rules: ");
        for ( KiePackage kp : kieBase.getKiePackages() ) {
        	for (Rule rule : kp.getRules()) {
        		LOG.info("kp " + kp + " rule " + rule.getName());
        	}
        }

	    LOG.info("Creating kieSession");
	    KieSession kSession = kContainer.newKieSession("ksession-rules");
        LOG.info("kSession"+kSession);
        
        LOG.info("Now running data");
        

        
        LOG.info("Final checks");


        
	}
}