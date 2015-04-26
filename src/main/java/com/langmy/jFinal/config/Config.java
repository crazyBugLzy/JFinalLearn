package com.langmy.jFinal.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;
import com.langmy.jFinal.model.User;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.FREE_MARKER);
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configPlugin(Plugins me) {
		me.add(new EhCachePlugin());

		//C3p0数据源插件
		C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost/testJFinal",
				"root", "19930815");
		me.add(cp);
		// ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);
		arp.addMapping("user", User.class);
	}

	@Override
	public void configRoute(Routes me) {
		me.add(new FrontRoutes());
		me.add(new AdminRoutes());
	}

}
