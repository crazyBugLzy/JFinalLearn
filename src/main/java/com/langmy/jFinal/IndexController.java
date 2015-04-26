package com.langmy.jFinal;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheName;
import com.langmy.jFinal.model.User;

public class IndexController extends Controller{
	
	public static Logger LOG  = LoggerFactory.getLogger(IndexController.class);
	
	public void index(){
		renderFreeMarker("/index.html");
	}
	
	public void showText(){
		renderText("Show Text");
	}
	
	@ActionKey("actionKey")
	public void testActionKey(){
		renderText("Test ActionKey");
	}
	
	@Before(CacheInterceptor.class)
	@CacheName("userList")
	public void testDB() {
		List<User> users = User.dao.find("select * from user");
//		List<User> users = User.dao.find("select * from user where id=?",2);
//		Page<User> users = User.dao.paginate(1, 10, "select *","from user where id=?",2);
//		for(User user :users.getList()){
//			System.out.println(user.toString()+user.getStr("user_acc"));
//		}
		/*User user = new User();
		user.set("user_acc", "accNew");
		user.set("name", "nameNew");
		boolean flag = user.save();
		System.out.println(flag);*/
		if(LOG.isDebugEnabled()){
			LOG.debug(users.toString());
		}
		setAttr("user", users);
		renderFreeMarker("/test.html");
	}
	
	public void covertJson(){
		renderJson(new User().set("user_acc", "acc"));
	}

}
