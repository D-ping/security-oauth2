package com.daiyuchuan.security.distributed.uaa.serivce.impl;

import com.daiyuchuan.security.distributed.uaa.common.utils.ResultUtils;
import com.daiyuchuan.security.distributed.uaa.dao.repository.UserRepository;
import com.daiyuchuan.security.distributed.uaa.entity.Result.ResponseResult;
import com.daiyuchuan.security.distributed.uaa.entity.request.UserVo;
import com.daiyuchuan.security.distributed.uaa.model.UserDo;
import com.daiyuchuan.security.distributed.uaa.serivce.UserDetailService;
import com.daiyuchuan.security.distributed.uaa.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServerImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailService userDetailService;

    @Override
    public ResponseResult svaUser(UserDo userDo)  {
        userDo.setPassword(BCrypt.hashpw(userDo.getPassword(),BCrypt.gensalt()));
        if (userDo.getGender()==null){
            userDo.setGender((byte) 0);
        }
        userDo.setGmtCreate(new Date());
        UserDo user = userRepository.save(userDo);
        if (user==null){
           return ResultUtils.fail();
        }
        return ResultUtils.success();
    }

}
