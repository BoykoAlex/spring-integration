/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.twitter.config;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Oleg Zhurakousky
 *
 */
public class TestReceivingUsingNamespace {

	@Test
	@Ignore
	/*
	 * In order to run this test you need to provide values to the twitter.properties file
	 */
	public void testUpdatesWithRealTwitter() throws Exception{
		CountDownLatch latch = new CountDownLatch(1);
		new ClassPathXmlApplicationContext("TestReceivingUsingNamespace-context.xml", this.getClass());
		System.out.println("done");
		latch.await(10000, TimeUnit.SECONDS);
		
	}
}
