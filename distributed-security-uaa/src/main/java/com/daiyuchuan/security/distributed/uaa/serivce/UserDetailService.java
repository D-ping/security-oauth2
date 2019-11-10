package com.daiyuchuan.security.distributed.uaa.serivce;

import com.daiyuchuan.security.distributed.uaa.dao.repository.UserRepository;
import com.daiyuchuan.security.distributed.uaa.model.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDo user = userRepository.findUserDoByUsername(username);
        return user;
    }
}
