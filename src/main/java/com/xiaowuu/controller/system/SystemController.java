package com.xiaowuu.controller.system;

import com.xiaowuu.common.ResultObject;
import com.xiaowuu.entity.user.UserAdmin;
import com.xiaowuu.listener.SessionListener;
import com.xiaowuu.service.user.UserAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 登陆 用的类
 */
@RestController
@RequestMapping(value = "/system")
public class SystemController {

	private final static Logger logger = LoggerFactory.getLogger(SystemController.class);

	@Autowired
	private UserAdminService userAdminService;

	@RequestMapping(value = "login")
	public Object login(HttpServletRequest request, String userName, String password
						) {
		ResultObject<UserAdmin> result = new ResultObject();
		try {
			result = checkUser(userName, password);
			if (result.isSuccess()) {
				HttpSession session = request.getSession();
				SessionListener.userLoginHandle(session, userName);
				// 添加用户与HttpSession的绑定
				SessionListener.USER_SESSION.put(userName, session);
				// 添加sessionId和用户的绑定
				SessionListener.SESSIONID_USER.put(session.getId(), userName);

				UserAdmin userAdmin = result.getResult();
				session.setAttribute("USERINFO", userAdmin);

				userAdmin.setId(1);
				userAdmin.setLastLoginIp(getLocalIp(request));
				userAdmin.setLastLoginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				userAdminService.updateByLogin(userAdmin);

				result.setSuccess(true);
				result.setMessage("登录成功");
				result.setCode(0);
			} else {
				result.setMessage("登录失败");
			}
		} catch (Exception e) {
			logger.error("登录失败", e);
		}
		return result;
	}

	@RequestMapping(value = "valLogin")
	public Object valLogin(String userName, String password
                           ) {
		ResultObject result = new ResultObject();
		try {
			result = checkUser(userName, password);
			if (result.isSuccess()) {
				result.setCode(0);
				result.setMessage("检查登录成功");
			}
		} catch (Exception e){
			logger.error("检查登录失败", e);
		}
		return result;
	}

	/**
	 * 检查用户
	 * @param userName
	 * @param password
	 * @return
	 */
	private ResultObject checkUser(String userName, String password) {
		ResultObject result = new ResultObject();
		result.setSuccess(false);
		result.setCode(-1);
		UserAdmin adminUser = userAdminService.findUserByNameAndPsw(userName,password);
		if (adminUser != null) {
			result.setCode(0);
			result.setSuccess(true);
			result.setMessage("登陆成功");
			result.setResult(adminUser);
		} else {
			// 用户不存在
			result.setCode(-1);
			result.setMessage("用户不存在!");
		}
		return result;
	}
//
//	@RequestMapping(value = "loginOut")
//	public Object loginOut(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.invalidate();
//		return "success";
//	}
//
//
//	@RequestMapping(value = "timeout")
//	public Object timeout(HttpServletRequest request) {
//		if (request.getSession().getAttribute("USERINFO") == null)
//			return -1;
//		return 0;
//	}
//
	/**
	 * 获取用户信息, 菜单权限
	 */
	@RequestMapping(value = "getUserInfo")
	public Object getUserInfo(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
//			map.put("menus", menus);
		List<String> menus = new ArrayList<>();
		menus.add("/system/merchant/merchant");
		menus.add("/system/merchant/account");
		menus.add("/system/product/productList");
		menus.add("/system/product/cultivationScheme");
		menus.add("/system/product/landClaim");
		menus.add("/system/product/label");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
//		menus.add("/system/merchant/merchant");
			map.put("menus", menus);
//			map.put("user", user);
		return map;
	}

	/**
	 * 从Request对象中获得客户端IP
	 */
	private String getLocalIp(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		String forwarded = request.getHeader("X-Forwarded-For");
		String realIp = request.getHeader("X-Real-IP");
		String ip;
		if (realIp == null) {
			if (forwarded == null) {
				ip = remoteAddr;
			} else {
				ip = remoteAddr + "/" + forwarded.split(",")[0];
			}
		} else {
			if (realIp.equals(forwarded)) {
				ip = realIp;
			} else {
				if(forwarded != null){
					forwarded = forwarded.split(",")[0];
				}
				ip = realIp + "/" + forwarded;
			}
		}
		return ip;
	}
}
