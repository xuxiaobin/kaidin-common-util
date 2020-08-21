package com.kaidin.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author xiaobin
 * @date 2020-08-21 11:35
 */
public class FileUtilTest {
    @Test
    public void testWriteRead() throws IOException {
        String fileName = TestCfg.OUTPUT_PATH + File.separator + "test.log";
        // 测试写文件
        FileUtil.write(fileName, "test 123", true);
        FileUtil.write(fileName, "\ntest 456", true);
        FileUtil.writeAppend(fileName, "\ntest 789");
        // 读取验证
        List<String> contentList = FileUtil.readFile(fileName, 0);
        Assert.assertEquals("test 123", contentList.get(0));
        Assert.assertEquals("test 456", contentList.get(1));
        Assert.assertEquals("test 789", contentList.get(2));
        contentList = FileUtil.readFile(fileName, 1);
        Assert.assertEquals("test 456", contentList.get(0));
        Assert.assertEquals("test 789", contentList.get(1));

        // 覆盖写入并验证文件长度
        FileUtil.write(fileName, "test abc", false);
        Assert.assertEquals(8, FileUtil.getFileSize(fileName));

        // 最后删除
        FileUtil.deleteFiles(fileName);
    }

    @Test
    public void testDownloadFile() {
//        FileUtil.downloadFile();
    }

    @Test
    public void testCopyDeleteFiles() throws IOException {
        String testCopyDir = TestCfg.OUTPUT_PATH + File.separator + "imageCopy";

        FileUtil.deleteFiles(testCopyDir);
        FileUtil.copyFiles(TestCfg.INPUT_PATH + File.separator + "image", testCopyDir);
        Assert.assertEquals(111227, FileUtil.getFileSize(testCopyDir));

        FileUtil.deleteFiles(testCopyDir);
        Assert.assertEquals(0, FileUtil.getFileSize(testCopyDir));
    }

    @Test
    public void testGetFileSize() {
        Assert.assertEquals(111227L, FileUtil.getFileSize(TestCfg.INPUT_PATH + "image"));
    }

    @Test
    public void testAsDisplaySize() {
        Assert.assertEquals("0B", FileUtil.asDisplaySize(0));
        Assert.assertEquals("1023B", FileUtil.asDisplaySize(1023));
        Assert.assertEquals("1.00K", FileUtil.asDisplaySize(1024));
        Assert.assertEquals("11.77M", FileUtil.asDisplaySize(12345678));
    }
}