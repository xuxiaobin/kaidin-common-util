/**
 * kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util;

import org.junit.Assert;
import org.junit.Test;

public class BaseUtilTest {

	@Test
	public void testEquals() {
		Assert.assertTrue(BaseUtil.equals(null, null));
		Assert.assertFalse(BaseUtil.equals(null, "12345"));
		Assert.assertFalse(BaseUtil.equals("12345abc", null));
		Assert.assertTrue(BaseUtil.equals("12345abc", 12345 + "abc"));
		Assert.assertFalse(BaseUtil.equals("12345abC", 12345 + "abc"));
	}

	@Test
	public void testEqualsType() {
		Assert.assertFalse(BaseUtil.equalsType(null, null));
		Assert.assertFalse(BaseUtil.equalsType(null, "12345"));
		Assert.assertFalse(BaseUtil.equalsType("12345abc", null));
		Assert.assertTrue(BaseUtil.equalsType("12345abc", 12345 + "abc"));
		Assert.assertFalse(BaseUtil.equalsType("12345abC", 12345));
	}
}
