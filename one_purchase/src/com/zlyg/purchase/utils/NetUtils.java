package com.zlyg.purchase.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class NetUtils {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getHardwareAddress()));
	}

	public static String getLocalHostName() {
		String hostName = "";
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostName = addr.getHostName();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return hostName;
	}

	public static String[] getAllLocalHostIP() {
		String[] ret = null;
		try {
			String hostName = getLocalHostName();
			if (hostName.length() > 0) {
				InetAddress[] addrs = InetAddress.getAllByName(hostName);
				if (addrs.length > 0) {
					ret = new String[addrs.length];
					for (int i = 0; i < addrs.length; i++) {
						ret[i] = addrs[i].getHostAddress();
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ret;
	}

	public static String[] getHardwareAddress() {
		List<String> ret = new ArrayList<String>();

		try {
			Enumeration<NetworkInterface> e = NetworkInterface
					.getNetworkInterfaces();
			while (e.hasMoreElements()) {
				NetworkInterface ni = e.nextElement();
				byte[] mac = ni.getHardwareAddress();
				if (mac == null) {
					continue;
				}
				String mac_s = hexByte(mac[0]) + "-" + hexByte(mac[1]) + "-"
						+ hexByte(mac[2]) + "-" + hexByte(mac[3]) + "-"
						+ hexByte(mac[4]) + "-" + hexByte(mac[5]);
				if ("00-00-00-00-00-00".equals(mac_s)) {
					continue;
				}
				ret.add(mac_s);
			}
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		Collections.sort(ret);
		return ret.toArray(new String[ret.size()]);
	}

	private static String hexByte(byte b) {
		String s = "000000" + Integer.toHexString(b);
		return s.substring(s.length() - 2);
	}

	public static String getMachineCode() {
		try {
			return MD5Utils.stringMD5(Arrays.toString(NetUtils
					.getHardwareAddress()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
