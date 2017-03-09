package liuhuan.config;

import java.io.File;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("1111111111111");
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("222222222222222");
		return new Class<?>[]{WebConfig.class,SecurityConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		System.out.println("33333333333");
		return new String[]{"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
		//DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
		return new Filter[]{characterEncodingFilter};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		//第一是临时接收上传文件的地址
		//第二个是单个文件的最大值
		//第三个是一次请求中的最大值
		//只有在3.0以上包括3.0的servlet才能用
		//目录必须先存在，不然会报错
		File file = new File("d:/tmp/spittr/uploads");
		if(!file.exists()){
			file.mkdirs();
		}
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(file.getAbsolutePath(), 2*1024*1024, 4*1024*1024, 0);
		registration.setMultipartConfig(multipartConfigElement);
		super.customizeRegistration(registration);
	}

	
	
}
