package com.kaidin.common.util.encrypt;

import com.kaidin.common.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author xiaobin
 * @date 2020-08-19 16:49
 */
public class Md5UtilTest {
    private static String STR_12345    = "123456";
    private static String STR_ADMIN123 = "admin123";
    private static String STR_NULL     = null;
    private static File FILE         = new File(Md5UtilTest.class.getClassLoader().getResource("input/md5TestFile.txt").getFile());

    @Test
    public void testStrMd5() {
        Assert.assertEquals("e10adc3949ba59abbe56e057f20f883e", EncryptUtil.md5(STR_12345));
        Assert.assertEquals("0192023a7bbd73250516f069df18b500", EncryptUtil.md5(STR_ADMIN123));
        Assert.assertEquals("d41d8cd98f00b204e9800998ecf8427e", EncryptUtil.md5(StringUtil.EMPTY_STR));
        Assert.assertNull(EncryptUtil.md5(STR_NULL));
    }

    @Test
    public void testByteArryMd5() {
        Assert.assertEquals("e10adc3949ba59abbe56e057f20f883e", EncryptUtil.md5(STR_12345.getBytes()));
        Assert.assertEquals("0192023a7bbd73250516f069df18b500", EncryptUtil.md5(STR_ADMIN123.getBytes()));
        Assert.assertEquals("d41d8cd98f00b204e9800998ecf8427e", EncryptUtil.md5(StringUtil.EMPTY_STR.getBytes()));
        Assert.assertNull(EncryptUtil.md5(STR_NULL));
    }

    @Test
    public void testFileMd5() throws IOException {
        String md5OfFile = Md5Util.md5(FILE);
        Assert.assertEquals("518ca85c349252d4a49989d5a2db264b", md5OfFile);
    }
}