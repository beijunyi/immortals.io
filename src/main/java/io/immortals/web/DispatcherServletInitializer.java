package io.immortals.web;

import io.immortals.RuntimeConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {RuntimeConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {};
	}

}
