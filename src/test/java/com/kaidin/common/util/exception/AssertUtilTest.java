package com.kaidin.common.util.exception;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xiaobin
 * @date 2020-08-17 11:28
 */
public class AssertUtilTest {
    private final IExceptionCode TEST_ERR_CODE = new TestException();

    @Test
    public void testIsNull() {
        AssertUtil.isNull(null, TEST_ERR_CODE, "isNull");
        try {
            AssertUtil.isNull(123, TEST_ERR_CODE, "isNull");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isNull", e.getErrMsg());
        }
    }

    @Test
    public void testIsNotNull() {
        AssertUtil.isNotNull(123, TEST_ERR_CODE, "isNotNull");
        try {
            AssertUtil.isNotNull(null, TEST_ERR_CODE, "isNotNull");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isNotNull", e.getErrMsg());
        }
    }

    @Test
    public void testIsTrue() {
        AssertUtil.isTrue(true, TEST_ERR_CODE, "isTrue");
        try {
            AssertUtil.isTrue(false, TEST_ERR_CODE, "isTrue");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isTrue", e.getErrMsg());
        }
    }

    @Test
    public void testIsFalse() {
        AssertUtil.isFalse(false, TEST_ERR_CODE, "isFalse");
        try {
            AssertUtil.isFalse(true, TEST_ERR_CODE, "isFalse");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isFalse", e.getErrMsg());
        }
    }

    @Test
    public void testIsBlank() {
        AssertUtil.isBlank("", TEST_ERR_CODE, "isBlank");
        AssertUtil.isBlank(" ", TEST_ERR_CODE, "isBlank");
        AssertUtil.isBlank(null, TEST_ERR_CODE, "isBlank");
        try {
            AssertUtil.isBlank("a", TEST_ERR_CODE, "isBlank");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isBlank", e.getErrMsg());
        }
    }

    @Test
    public void testIsNotBlank() {
        AssertUtil.isNotBlank("123", TEST_ERR_CODE, "isNotBlank");
        AssertUtil.isNotBlank(" a", TEST_ERR_CODE, "isNotBlank");
        try {
            AssertUtil.isNotBlank(null, TEST_ERR_CODE, "isNotBlank");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isNotBlank", e.getErrMsg());
        }
    }

    @Test
    public void testIsEmpty() {
        AssertUtil.isEmpty("", TEST_ERR_CODE, "isEmpty");
        try {
            AssertUtil.isEmpty("123", TEST_ERR_CODE, "isEmpty");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isEmpty", e.getErrMsg());
        }
        try {
            AssertUtil.isEmpty(" ", TEST_ERR_CODE, "isEmpty");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isEmpty", e.getErrMsg());
        }

        Collection<Integer> collection = null;
        AssertUtil.isEmpty(collection, TEST_ERR_CODE, "isEmpty");
        collection = new LinkedList<>();
        AssertUtil.isEmpty(collection, TEST_ERR_CODE, "isEmpty");
        try {
            collection.add(123);
            AssertUtil.isEmpty(collection, TEST_ERR_CODE, "isEmpty");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isEmpty", e.getErrMsg());
        }

        Map map = null;
        AssertUtil.isEmpty(map, TEST_ERR_CODE, "isEmpty");
        map = new HashMap<>();
        AssertUtil.isEmpty(map, TEST_ERR_CODE, "isEmpty");
        try {
            map.put(123, "123");
            AssertUtil.isEmpty(map, TEST_ERR_CODE, "isEmpty");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isEmpty", e.getErrMsg());
        }
    }

    @Test
    public void testIsNotEmpty() {
        AssertUtil.isNotEmpty("123", TEST_ERR_CODE, "isNotEmpty");
        try {
            AssertUtil.isNotEmpty("", TEST_ERR_CODE, "isNotEmpty");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isNotEmpty", e.getErrMsg());
        }

        Collection<Integer> collection = null;
        try {
            AssertUtil.isNotEmpty(collection, TEST_ERR_CODE, "isNotEmpty");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isNotEmpty", e.getErrMsg());
        }
        collection = new LinkedList<>();
        try {
            AssertUtil.isNotEmpty(collection, TEST_ERR_CODE, "isNotEmpty");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isNotEmpty", e.getErrMsg());
        }
        collection.add(123);
        AssertUtil.isNotEmpty(collection, TEST_ERR_CODE, "isNotEmpty");


        Map map = null;
        try {
            AssertUtil.isNotEmpty(map, TEST_ERR_CODE, "isNotEmpty");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isNotEmpty", e.getErrMsg());
        }
        map = new HashMap<>();
        try {
            AssertUtil.isNotEmpty(map, TEST_ERR_CODE, "isNotEmpty");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isNotEmpty", e.getErrMsg());
        }
        map.put(123, "123");
        AssertUtil.isNotEmpty(map, TEST_ERR_CODE, "isNotEmpty");
    }

    @Test
    public void testIsEquals() {
        AssertUtil.isEquals("123", "123", TEST_ERR_CODE, "isEquals");
        try {
            AssertUtil.isEquals("123", "121", TEST_ERR_CODE, "isEquals");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isEquals", e.getErrMsg());
        }
    }

    @Test
    public void testIsNotEquals() {
        AssertUtil.isNotEquals("123", "121", TEST_ERR_CODE, "isNotEquals");
        try {
            AssertUtil.isNotEquals("123", "123", TEST_ERR_CODE, "isNotEquals");
        } catch (BaseException e) {
            Assert.assertEquals("testErrCode", e.getErrCode());
            Assert.assertEquals("isNotEquals", e.getErrMsg());
        }
    }

    class TestException implements IExceptionCode {

        @Override
        public String getErrCode() {
            return "testErrCode";
        }

        @Override
        public String getErrMsg() {
            return "testErrMsg";
        }
    }
}