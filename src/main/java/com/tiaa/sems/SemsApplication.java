package com.tiaa.sems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.Filter;

@SpringBootApplication
public class SemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SemsApplication.class, args);
	}
	
	@Bean
	public RestTemplate geTemplate() {
		return new RestTemplate();
	}
	
//	@Bean
//	public Mapper getMapper() {
//		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
//		dozerBeanMapper.setMappingFiles(Arrays.asList("mapping.xml"));
//		return dozerBeanMapper;
//	}
	
	@Bean
	public ErrorPageFilter errorPageFilter() {
	    return new ErrorPageFilter();
	}

	@Bean
	public FilterRegistrationBean<Filter> disableSpringBootErrorFilter(ErrorPageFilter filter) {
	    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
	    filterRegistrationBean.setFilter(filter);
	    filterRegistrationBean.setEnabled(false);

	    return filterRegistrationBean;
	}
	
	@Bean
	public Mapper mapper(@Value(value = "classpath*:mapping.xml") Resource[] resourceArray) throws IOException {
	    List<String> mappingFileUrlList = new ArrayList<>();
	    for (Resource resource : resourceArray) {
	        mappingFileUrlList.add(String.valueOf(resource.getURL()));
	    }
	    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
	    dozerBeanMapper.setMappingFiles(mappingFileUrlList);
	    return dozerBeanMapper;
	}

}
