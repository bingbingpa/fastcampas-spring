package com.bingbingpa.cli.res;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class ResourceExample implements ResourceLoaderAware {
	private ResourceLoader resourceLoader;
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	public void print() {
		System.out.println(this.resourceLoader);
	}
}
