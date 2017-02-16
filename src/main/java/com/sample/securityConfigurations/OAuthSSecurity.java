package com.sample.securityConfigurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * Created by aanu.oyeyemi on 1/6/17.
 * Project name -> OAuthS
 */
@Configuration
@EnableWebSecurity
public class OAuthSSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("root")
                .password("root")
                .roles("ADMIN,USER")
                ;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .anonymous()
                .disable()
                .authorizeRequests()
                .antMatchers("/oauth/token")
                .permitAll()
                ;
    }

    @Bean
    public TokenStore getTokenStore(){
        return new InMemoryTokenStore();
    }

    @Bean
    public TokenApprovalStore getTokenApprovalStore(){
        TokenApprovalStore tokenApprovalStore=new TokenApprovalStore();
        tokenApprovalStore.setTokenStore(getTokenStore());
        return  tokenApprovalStore;
    }

    @Bean
    public TokenStoreUserApprovalHandler getTokenApproval(){
        TokenStoreUserApprovalHandler tokenStoreUserApprovalHandler=new TokenStoreUserApprovalHandler();
        tokenStoreUserApprovalHandler.setTokenStore(getTokenStore());
        tokenStoreUserApprovalHandler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        tokenStoreUserApprovalHandler.setClientDetailsService(clientDetailsService);


        return tokenStoreUserApprovalHandler;
    }

}
