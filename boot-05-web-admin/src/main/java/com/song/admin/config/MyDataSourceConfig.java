package com.song.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Description:  自定义方式导入第三方数据源：durid 及后续管理
 *               1、pom中引入druid后，在配置类中将数据源其注册到容器：
 *                  将其绑定到配置文件spring.datasource下的属性；
 *                  开启监控和防火墙功能；
 *               2、配置监控页
 *               3、配置web-jdbc关联监控
 *
 * @Create : 2024/3/20 -11:33
 * @Version : v1.0
 */

@Deprecated   // 后续使用starter方式，取消配置注解，并标记为过时
//@Configuration
public class MyDataSourceConfig {

    @Bean // 此时默认配置的Hikari数据源注册失效，由于@ConditionalOnMissingBean(DataSource.class)
    @ConfigurationProperties(prefix = "spring.datasource") // 绑定spring.datasource下的属性
    public DataSource dataSource() throws SQLException {

        DruidDataSource dataSource = new DruidDataSource();

//        dataSource.setFilters("stat,wall");  // 开启监控数据库功能和防火墙功能|| 但凡datasource下能set的属性，可以在配置文件中指定
        return dataSource;
    }

    /**
     *  配置使用druid的内置监控页
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){

        ServletRegistrationBean<StatViewServlet> registrationBean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
         // 配置监控页登录账号密码
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "123456");

        return registrationBean;
    }

    /**
     *  WebStatFilter用于采集web-jdbc关联监控的数据
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter orangeStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> wSFilterRegistrationBean = new FilterRegistrationBean<>(orangeStatFilter);
        // 监控的url
        wSFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        // 放行的请求
        wSFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");


        return wSFilterRegistrationBean;
    }
}
