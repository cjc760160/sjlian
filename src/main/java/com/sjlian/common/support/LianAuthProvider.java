package com.sjlian.common.support;

import com.sjlian.dao.UserDAO;
import com.sjlian.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * spring security自定义验证
 * Created by lian on 17/7/12.
 */
@Component
public class LianAuthProvider implements AuthenticationProvider {
    @Autowired
    private UserDAO userDAO;


    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        if (!"admin".equals(name)){
            throw new UsernameNotFoundException("user not exits");
        }
        if(!"password".equals(password)){
            throw new BadCredentialsException("password invalid");
        }
//        User user = userDAO.findByName(name);
//        if (user == null){
//            throw UsernameNotFoundException("用户名不存在", null);
//        }
        List<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(name, password, authorities);
        return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());

    }

    public boolean supports(Class<?> aClass) {
        return false;
    }
}
