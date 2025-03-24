package com.ssydx.securtiy.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.ssydx.securtiy.handler.AllSecurityHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 自动加密器，可以根据数据库中的密码前缀 自动选择加密器 对表单输入的密码加密 然后比较
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // 内存型
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        // 存储在内存
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(org.springframework.security.core.userdetails.User.builder().username("ssydx").password(passwordEncoder().encode("123456")).roles("vip1").build());
		manager.createUser(org.springframework.security.core.userdetails.User.builder().username("zhangsan").password("{noop}123456").authorities("user:query","user:add").roles("vip2").build());
        manager.createUser(org.springframework.security.core.userdetails.User.withUsername("lisi").password(passwordEncoder().encode("123456")).accountLocked(true).build());
        manager.createUser(org.springframework.security.core.userdetails.User.withUsername("wangwu").password(passwordEncoder().encode("123456")).disabled(true).build());
        manager.createUser(new org.springframework.security.core.userdetails.User("zs","{noop}123456",List.of(new SimpleGrantedAuthority("role"))));
    
        return manager;
    }
    
    // SQL
    // @Bean
	// public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSoucre) {
    //     // 存储在SQL数据库
    //     JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSoucre);
    //     // 查
    //     manager.setUsersByUsernameQuery("select username,password,enabled from users where username = ?");
    //     manager.setAuthoritiesByUsernameQuery("select username, authority from authorities where username = ?");
    //     // 存在
    //     manager.setUserExistsSql("select username from users where username = ?");
    //     // 增
    //     manager.setCreateUserSql("insert into users(username,password,enabled) values(?,?,?)");
    //     manager.setCreateAuthoritySql("insert into authorities values(?,?)");
    //     // 删
    //     manager.setDeleteUserSql("delete from users where username = ?");
    //     manager.setDeleteUserAuthoritiesSql("delete from authorities where username = ?");
    //     // 改
    //     manager.setUpdateUserSql("update users set password = ?, enabled = ? where username = ?");
    // 
    //     return manager;
	// }

    // 自定义
    // @Bean UserDetailsService userDetailsService(UserService userService) {
    //     return new UserDetailsService() {
    //         public UserDetails loadUserByUsername(String username) {
    //             User user = userService.getUser(username);
    //             return new CustomUserDetails(username, user.getPassword(), user.getEnabled(), List.of(new SimpleGrantedAuthority(user.getAuthority())));
    //         }
    //     };
    // }

    // @Autowired
    // private SuccessHandler successHandler;
    // @Autowired
    // private LogoutSuccessHandler1 logoutSuccessHandler;
    // @Autowired
    // private myAccessDeniedHandler myAccessDeniedHandler;
    // @Autowired
    // private myAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private AllSecurityHandler allSecurityHandler;
    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/","/index").permitAll()
                .requestMatchers("/level1/**").hasAnyRole("vip1")
                .requestMatchers("/level2/**").hasAnyRole("vip2")
                .requestMatchers("/level3/**").hasAnyRole("vip1", "vip2", "vip3")
                // 登录页面和注销页面记得添加到允许列表
                .requestMatchers("/toLogout").permitAll()
                .requestMatchers("/toLogin").permitAll()
                .requestMatchers("/user/**").permitAll()
                .requestMatchers("/rest/**").authenticated()
                .anyRequest().authenticated()
                ;
        });

        http.formLogin(login -> {
            login
                // 这个页面比较特殊，指定无权限访问时重定位的页面
                .loginPage("/toLogin")
                // 提交登录表单的路径，必须与表单中的相同，注意登录表单必须开启crsf
                .loginProcessingUrl("/virtual_login")
                .usernameParameter("user")
                .passwordParameter("pwd")
                // 成功登录后的重定位路径
                // 对于受保护的路径登录成功会继续访问，如果仍无权限会报错
                // 而如果强制全部重定位则丧失了记忆之前试图访问的路径的功能
                .defaultSuccessUrl("/")
                .failureUrl("/toLogin")
                // .successForwardUrl("/")
                // .failureForwardUrl("/")
                // .successHandler(allSecurityHandler)
                // .failureHandler(allSecurityHandler)
                ;
        });
        http.logout(logout -> {
            logout
                // 提交注销表单的路径，必须与表单中的相同，注意注销表单必须开启crsf
                .logoutUrl("/virtual_logout")
                .deleteCookies("JSESSIONID")
                // 成功注销后重定位的路径
                .logoutSuccessUrl("/")
                // .logoutSuccessHandler(allSecurityHandler)
                ;
        });
        http.rememberMe(checkbox -> {
            checkbox
                .rememberMeParameter("re")
                .tokenValiditySeconds(3600 * 24)
            ;
        });

        // http.csrf(csrf -> {
        //     csrf.disable();
        // });

        http.exceptionHandling(exp -> {
            exp
                .accessDeniedHandler(allSecurityHandler)
            ;
        });

        return http.build();
    }


}
