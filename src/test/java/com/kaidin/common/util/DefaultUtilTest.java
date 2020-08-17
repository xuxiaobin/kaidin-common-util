package com.kaidin.common.util;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author xiaobin
 * @date 2020-08-15 17:33
 */
public class DefaultUtilTest {

    @Test
    public void ifNull() {
        Assert.assertEquals(DefaultUtil.ifNull("123", "456"), "123");
        Assert.assertEquals(DefaultUtil.ifNull(null, "456"), "456");
    }

    @Test
    public void ifEmpty() {
        Assert.assertEquals(DefaultUtil.ifEmpty("123", "456"), "123");
        Assert.assertEquals(DefaultUtil.ifEmpty("", "456"), "456");
        Assert.assertEquals(DefaultUtil.ifEmpty(null, "456"), "456");
    }
}