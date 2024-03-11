package com.song.boot.config;

import com.song.boot.bean.Pet;
import com.song.boot.converter.GuiguMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.List;

/**
 * ClassName:WebConfig
 * Package:com.song.boot.config
 * Description:    1、自定义 一个 HiddenHttpMethodFilter.class过滤器，修改默认的 _method为喜欢的值（用于REST风格）
 *                 2、手动开启矩阵变量功能：
 *                      方式一：@Bean注册实现WebMvcConfigurer接口的类的实例；
 *                      方式二：配置类直接实现WebMvcConfigurer接口；
*                      然后其中重写configurePathMatch方法，修改其中UrlPathHelper处理路径的规则
 * @Author: songhuayu
 * @Create: 2024/1/8 -17:18
 * @Version: v1.0
 */

@Configuration(proxyBeanMethods = false)
/**
 *  public class WebConfig implements WebMvcConfigurer{
 */
public class WebConfig {

/*    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        //  设为false不移除;之后的内容
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }*/

//   @Bean方式注册实现了WebMvcConfigurer接口的类，匿名内部类方式
    @Bean
    public WebMvcConfigurer webMvcConfigurernichacha(){
        return new WebMvcConfigurer() {

/*            @Override   //  自定义内容协商管理（会覆盖SpringMVC自动配置的内容协商管理，自定义了几个策略系统就有几个）
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

                // 1、 基于参数的内容协商策略
                // Map<String, MediaType> mediaTypes：保存url中format对应的参数值及其映射的媒体类型的Map
                Map<String, MediaType> mediaTypes = new HashMap<>();
                // 指定支持解析哪些参数对应哪些媒体类型
                mediaTypes.put("json", MediaType.APPLICATION_JSON);
                mediaTypes.put("xml", MediaType.APPLICATION_XML);
                mediaTypes.put("gg",MediaType.parseMediaType("application/x-guigu")); //添加自定义的映射
                ParameterContentNegotiationStrategy paramStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
//                paramStrategy.setParameterName("ff"); 修改 默认的 format为 ff

                // 2、 基于请求头的内容协商策略
                HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();

                configurer.strategies(Arrays.asList(paramStrategy, headerStrategy));
            }*/

            @Override   // 不覆盖SpringMVC配置的内容协商，在这之上添加，也可通过
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                configurer.mediaType( "gg", MediaType.parseMediaType("application/x-guigu"));
            }


            @Override    // 添加自定义的消息转换器
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new GuiguMessageConverter());
            }

            @Override          // 开启矩阵变量处理
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                //  设为false，不移除;之后的内容，从而使矩阵变量生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            //添加格式转换器，规则：将String类型的"阿猫，3" 转换为 Pet(阿猫,3)
            // 由于Converter接口带有泛型参数，目前无法完全用lambda简化
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(
/*                        (Converter<String, Pet>) v -> {
                    if(v!=null || v!=""){
                        Pet pet = new Pet();
                        String[] params = v.split(",");
                        pet.setName(params[0]);
                        pet.setAge(Integer.parseInt(params[1]));
                        return pet;
                    }
                    return null;
                }*/
                new Converter<String, Pet>(){
                    @Override
                    public Pet convert(String source) {
                        if(source!=null || source!=""){
                            Pet pet = new Pet();
                            String[] params = source.split(",");
                            pet.setName(params[0]);
                            pet.setAge(Integer.parseInt(params[1]));
                            return pet;
                        }
                        return null;
                    }
                }
                );
            }
        };
    }



    /*
     * 设置请求映射中的方法过滤器之一：修改默认的_method为_m
     */
    @Bean
    public HiddenHttpMethodFilter myHHMF(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }
}
