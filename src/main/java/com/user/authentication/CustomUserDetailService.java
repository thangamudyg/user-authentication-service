package com.user.authentication;

import com.user.repository.UserRepository;
import com.user.security.SecurityRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Thangamudy Gurusamy
 * Date : 13/04/24
 * Package : com.user.authentication
 */
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        com.user.model.UserDetails userDetails = userRepository.findByLoginId(username);
        if(userDetails == null){
            throw new UsernameNotFoundException("User " + username + " does not exists");
        }
        final List<SecurityRole> roles = List.of(SecurityRole.valueOf(userDetails.getSecurityRole()));
        final List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
        return new User(passwordEncoder.encode(userDetails.getLoginId()), passwordEncoder.encode(userDetails.getPassword()), true, true,
                true, true, authorities);
    }
    private User createUser(final String username, final String password, final List<SecurityRole> roles) {
        final List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
        return new User(username, password, true, true, true, true, authorities);
    }
}
