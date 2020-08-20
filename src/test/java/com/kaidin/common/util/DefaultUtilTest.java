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
        Assert.assertEquals("123", DefaultUtil.ifNull("123", "456"));
        Assert.assertEquals("456", DefaultUtil.ifNull(null, "456"));
    }

    @Test
    public void ifEmpty() {
        Assert.assertEquals("123", DefaultUtil.ifEmpty("123", "456"));
        Assert.assertEquals("456", DefaultUtil.ifEmpty("", "456"));
        Assert.assertEquals("456", DefaultUtil.ifEmpty(null, "456"));
    }
}