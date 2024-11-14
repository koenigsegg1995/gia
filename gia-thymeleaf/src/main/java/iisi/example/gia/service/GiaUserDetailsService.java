package iisi.example.gia.service;

import iisi.example.gia.userauth.dto.UserAuthDTO;
import iisi.example.gia.userauth.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class GiaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAuthService userAuthService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        // 從資料庫查詢使用者
        UserAuthDTO userAuthDTO = userAuthService.findByUsername(username);

        if(userAuthDTO == null){
            throw new UsernameNotFoundException("此用戶名無法找到用戶:" + username);
        }

        // 轉成 UserDetails
        return User
                .withUsername(userAuthDTO.getUsername())
                .password(userAuthDTO.getPassword())
                .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_" + userAuthDTO.getRole())))
                .build();
    }

}
