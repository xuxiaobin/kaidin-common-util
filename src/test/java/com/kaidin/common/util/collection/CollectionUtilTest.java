package com.kaidin.common.util.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author xiaobin
 * @date 2020-08-16 07:29
 */
public class CollectionUtilTest {

    @Test
    public void testIsEmpty() {
        Collection<String> collection = null;
        Assert.assertTrue(CollectionUtil.isEmpty(collection));
        collection = new ArrayList<>();
        Assert.assertTrue(CollectionUtil.isEmpty(collection));

        String[] array = null;
        Assert.assertTrue(CollectionUtil.isEmpty(array));
        array = new String[5];
        Assert.assertTrue(CollectionUtil.isEmpty(array));
        array[3] = "123";
        Assert.assertFalse(CollectionUtil.isEmpty(array));

        Map<String, String> map = null;
        Assert.assertTrue(CollectionUtil.isEmpty(map));
        map = new HashMap<>();
        Assert.assertTrue(CollectionUtil.isEmpty(map));
    }

    @Test
    public void testIsNotEmpty() {
        Collection<String> collection = Arrays.asList("123");
        Assert.assertTrue(CollectionUtil.isNotEmpty(collection));

        String[] array = null;
        Assert.assertFalse(CollectionUtil.isNotEmpty(array));
        array = new String[5];
        Assert.assertFalse(CollectionUtil.isNotEmpty(array));
        array[3] = "123";
        Assert.assertTrue(CollectionUtil.isNotEmpty(array));

        Map<String, String> map = new HashMap<>();
        map.put("122", "123");
        Assert.assertTrue(CollectionUtil.isNotEmpty(map));
    }

    @Test
    public void testAsArray() {
        Assert.assertNull(CollectionUtil.asArray(null));

        Collection<String> dataList = Arrays.asList("123", "abc", "xxx", "yyy");
        Object[] objArrray = {"123", "abc", "xxx", "yyy"};
        Assert.assertEquals(objArrray, CollectionUtil.asArray(dataList));
    }

    @Test
    public void testAsArrayList() {
        Assert.assertNull(CollectionUtil.asArrayList(null));
        Collection<String> dataList = Arrays.asList("123", "abc", "xxx", "yyy");
        Object[] objArrray = {"123", "abc", "xxx", "yyy"};
        Assert.assertEquals(dataList, CollectionUtil.asArrayList(objArrray));
    }

    @Test
    public void testSubList() {
        List<String> strList = Arrays.asList("123", "456", "abc", "xxx", "yyy");
        Assert.assertEquals(strList.subList(0, 2), CollectionUtil.subList(strList, 2));
        Assert.assertEquals(strList.subList(1, 2), CollectionUtil.subList(strList, 1, 2));
        Assert.assertEquals(strList, CollectionUtil.subList(strList, 100));
        Assert.assertEquals(strList.subList(1, strList.size()), CollectionUtil.subList(strList, 1, 100));

        Assert.assertNull(CollectionUtil.subList(null, 2));
        Assert.assertEquals(new ArrayList<>(), CollectionUtil.subList(new ArrayList<>(), 2));
    }

    @Test
    public void testDecode() {
        Object[] objArrray = {"123", "abc", 789, "xyz", "aaa", "bbb"};
        Assert.assertEquals(CollectionUtil.decode("123", "xxx", "abc", "123", objArrray), "abc");
        Assert.assertEquals(CollectionUtil.decode(789, "xxx", "abc", "123", objArrray), "xyz");
        Assert.assertEquals(CollectionUtil.decode(null, "xxx", "abc", "123", objArrray), "xxx");
        Assert.assertEquals(CollectionUtil.decode(null, "xxx", null, "123", objArrray), "123");
    }
}