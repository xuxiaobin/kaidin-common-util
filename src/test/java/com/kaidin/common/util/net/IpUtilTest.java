/**
 * Kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.net;

import java.net.SocketException;
import java.util.Arrays;

import org.junit.Test;

import com.kaidin.common.util.constant.ConstType;

import static org.junit.Assert.*;

public class IpUtilTest {
	public static void main(String[] args) {
		for (long i = ConstType.ip.MIN_VALUE; i <= ConstType.ip.MAX_VALUE; i++) {
			if (!IpUtil.isIpAddr(IpUtil.asStringIp(i))) {
				System.out.println(i);
			}
		}
	}

	@Test
	public void testGetLocalHostIp() throws SocketException {
		System.out.println(IpUtil.getLocalHostIp());
		//		assertEquals("172.16.18.182", IpUtil.getLocalHostIp());
	}

	@Test
	public void testIsIpAddr() {
        assertTrue(IpUtil.isIpAddr("0.0.0.0"));
		assertTrue(IpUtil.isIpAddr("255.255.255.255"));
		assertFalse(IpUtil.isIpAddr("256.255.255.255"));
		assertFalse(IpUtil.isIpAddr("255.255.255."));
	}

	@Test
	public void testAsByteIp() {
		assertArrayEquals(new byte[]{0, 0, 0, 0}, IpUtil.asByteIp("0.0.0.0"));
		assertArrayEquals(new byte[]{-1, -1, -1, -1}, IpUtil.asByteIp("255.255.255.255"));
		assertArrayEquals(new byte[]{127, 0, 5, 1}, IpUtil.asByteIp("127.0.5.1"));
		assertArrayEquals(new byte[]{127, 0, -1, 1}, IpUtil.asByteIp("127.0.255.1"));
	}

	@Test
	public void testAsIntIp() {
		assertEquals(0x00_00_00_00, IpUtil.asIntIp("0.0.0.0"));
		assertEquals(0xff_ff_ff_ff, IpUtil.asIntIp("255.255.255.255"));
		assertEquals(0x7f_00_00_01, IpUtil.asIntIp("127.0.0.1"));
		assertEquals(0x7f_00_c8_01, IpUtil.asIntIp("127.0.200.1"));
	}

	@Test
	public void testAsLongIp() {
		assertEquals(ConstType.ip.MIN_VALUE, IpUtil.asLongIp("0.0.0.0"));
		assertEquals(ConstType.ip.MAX_VALUE, IpUtil.asLongIp("255.255.255.255"));
	}

	@Test
	public void testAsStringIpByte() {
		assertEquals("0.0.0.0", IpUtil.asStringIp(new byte[] { 0, 0, 0, 0 }));
		assertEquals("255.255.255.255", IpUtil.asStringIp(new byte[] { -1, -1, -1, -1 }));
		assertEquals("127.0.0.1", IpUtil.asStringIp(new byte[] { 127, 0, 0, 1 }));
		assertEquals("127.0.200.1", IpUtil.asStringIp(new byte[] { 127, 0, -56, 1 }));
	}

	@Test
	public void testAsStringIpInt() {
		assertEquals("0.0.0.0", IpUtil.asStringIp(0x00_00_00_00));
		assertEquals("255.255.255.255", IpUtil.asStringIp(0xff_ff_ff_ff));
		assertEquals("127.0.0.1", IpUtil.asStringIp(0x7f_00_00_01));
		assertEquals("127.0.200.1", IpUtil.asStringIp(0x7f_00_c8_01));
	}

	@Test
	public void testAsStringIpLong() {
		assertEquals("0.0.0.0", IpUtil.asStringIp(ConstType.ip.MIN_VALUE));
		assertEquals("255.255.255.255", IpUtil.asStringIp(ConstType.ip.MAX_VALUE));
		assertEquals("127.0.0.1", IpUtil.asStringIp(ConstType.ip.LOCALHOST_VALUE));
	}
}
