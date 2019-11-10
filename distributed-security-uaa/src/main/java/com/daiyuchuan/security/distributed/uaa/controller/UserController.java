package com.daiyuchuan.security.distributed.uaa.controller;

import com.daiyuchuan.security.distributed.uaa.entity.Result.ResponseResult;
import com.daiyuchuan.security.distributed.uaa.entity.request.UserVo;
import com.daiyuchuan.security.distributed.uaa.model.UserDo;
import com.daiyuchuan.security.distributed.uaa.serivce.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户操作接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public ResponseResult register(@RequestBody UserDo userDo){
        return userService.svaUser(userDo);
    }

}
