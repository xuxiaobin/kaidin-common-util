/**
 * kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.query;

import com.kaidin.common.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;

public class SortContainerTest {

	@Test
	public void testGetSort() {
		SortRequest instance = new SortRequest();
		Assert.assertEquals(StringUtil.EMPTY_STR, instance.toSortSql());
		instance.addSortDesc("dddd");
		instance.addSort("222222");
		instance.addSort("11111");
		instance.addSort("aaa");
		instance.addSortDesc("bbbb");
		instance.addSort("cccc");
		Assert.assertEquals(" order by dddd desc, 222222 asc, 11111 asc, aaa asc, bbbb desc, cccc asc", instance.toSortSql());
	}
}
