package com.langmy.jFinal.config;

import com.jfinal.config.Routes;
import com.langmy.jFinal.IndexController;

public class FrontRoutes extends Routes{

	@Override
	public void config() {
		add("/", IndexController.class);
	}

}
