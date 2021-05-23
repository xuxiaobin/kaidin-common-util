/**
 * kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.random;

import com.kaidin.common.util.random.RandomUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomUtilTest {

	@Test
	public void testNextInt() {
		for (int i = -10; i <= 10; i++) {
			assertEquals(i, RandomUtil.nextInt(i, i));
		}
		for (int i = -10; i <= 10; i++) {
			int randValue = RandomUtil.nextInt(-10, 10);
			assertTrue(-10 <= randValue && 10 >= randValue);
		}

		for (int i = -10; i <= 10; i++) {
			int randValue = RandomUtil.nextInt(10, -10);
			assertTrue(-10 <= randValue && 10 >= randValue);
		}
	}

	@Test
	public void testNextBase36Code() {
		for (int i = 0; i < 1000; i++) {
            assertEquals(11, RandomUtil.nextBase36Code().length());
//			assertTrue(!RandomUtil.nextBase36Code().equals(RandomUtil.nextBase36Code()));
		}
	}

	@Test
	public void testNextBase62Code() {
		for (int i = 0; i < 1000; i++) {
            assertEquals(10, RandomUtil.nextBase62Code().length());
//			assertTrue(!RandomUtil.nextBase62Code().equals(RandomUtil.nextBase36Code()));
		}
	}

	@Test
	public void testNextBase64Code() {
		for (int i = 0; i < 1000; i++) {
//			assertTrue(RandomUtil.nextBase64Code().length() == 10);
			assertNotSame(RandomUtil.nextBase64Code(), RandomUtil.nextBase64Code());
//			System.out.println(RandomUtil.nextBase64Code());
		}
	}
}
