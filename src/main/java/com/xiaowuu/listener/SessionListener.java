package com.xiaowuu.listener;

import com.xiaowuu.controller.system.SystemController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

public class SessionListener implements HttpSessionListener {

	private final static Logger logger = LoggerFactory.getLogger(SystemController.class);

	/**
	 * 用户和Session绑定关系
	 */
	public static final Map<String, HttpSession> USER_SESSION = new HashMap<String, HttpSession>();

	/**
	 * seeionId和用户的绑定关系
	 */
	public static final Map<String, String> SESSIONID_USER = new HashMap<String, String>();


	@Override
	public void sessionCreated(HttpSessionEvent se) {
		String sessionId = se.getSession().getId();
		logger.info("创建 Session sessionId= " + sessionId);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String sessionId = se.getSession().getId();
        //当前session销毁时删除当前session绑定的用户信息     
        //同时删除当前session绑定用户的HttpSession     
		USER_SESSION.remove(SESSIONID_USER.remove(sessionId));
		logger.info("销毁 Session sessionId= " + sessionId);
	}

	/**
	 * 处理一个账号同时只有一个地方登录
	 */
	public static void userLoginHandle(HttpSession session, String account){
		// 获取当前登录用户绑定的HttpSession
		HttpSession existSession = USER_SESSION.get(account);
		if (null != existSession && existSession.getId() != null && !existSession.getId().equals(session.getId())) {
			if (account.equals(SESSIONID_USER.get(session.getId()))) {
				SESSIONID_USER.remove(existSession.getId());
				// 注销前一个 Session
				existSession.invalidate();
			}
		}
	}
	
}
