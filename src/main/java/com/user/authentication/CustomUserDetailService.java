package com.user.authentication;

import com.user.security.SecurityRole;
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
    private final Map<String, User> availableUsers = new HashMap<String, User>();
    public CustomUserDetailService(PasswordEncoder passwordEncoder) {
        availableUsers.put("user", createUser("user", passwordEncoder.encode("userPass"),
                Arrays.asList(SecurityRole.USER)));
        availableUsers.put("admin", createUser("admin", passwordEncoder.encode("adminPass"),
                Arrays.asList(SecurityRole.ADMIN)));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(availableUsers.get(username))
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " does not exists"));
    }
    private User createUser(final String username, final String password, final List<SecurityRole> roles) {
        final List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
        return new User(username, password, true, true, true, true, authorities);
    }
}
