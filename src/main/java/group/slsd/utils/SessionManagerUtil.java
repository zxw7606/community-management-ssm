package group.slsd.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionManagerUtil {

	/**
	 * principal 相同用户在线数量
	 */
	private static Map<Object, Integer> currentOnlineMap = new ConcurrentHashMap<Object, Integer>();

	private static AtomicInteger allOnlineCount = new AtomicInteger(0);

	public static void setUserOnlineCount(Object principal, Integer count) {
		if (count == null) {
			return;
		}
		currentOnlineMap.put(principal, count);
	}

	public static Integer getUserOnlineCount(Object principal) {
		Integer count = currentOnlineMap.get(principal);
		if (null == count) {
			return 1;
		}
		return count;
	}

	public static void addOnlineCount() {
		allOnlineCount.incrementAndGet();
	}

	public static int getOnlineCount() {
		return allOnlineCount.get();
	}

}
