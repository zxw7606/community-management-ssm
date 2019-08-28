package group.slsd.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManagerUtil {

	/**
	 * principal 相同用户在线数量
	 */
	private static Map<Object, Integer> currentOnlineMap = new ConcurrentHashMap<Object, Integer>();


	public static void setUserOnlineCount(Object principal, Integer count) {
		if (count == null) {
			return;
		}
		currentOnlineMap.put(principal, count);
	}

	public static Integer getUserOnlineCount(Object principal) {
		return currentOnlineMap.get(principal);
	}

}
