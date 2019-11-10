package com.daiyuchuan.security.distributed.uaa.serivce;

import com.daiyuchuan.security.distributed.uaa.entity.Result.ResponseResult;
import com.daiyuchuan.security.distributed.uaa.entity.request.UserVo;
import com.daiyuchuan.security.distributed.uaa.model.UserDo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface UserService {
    ResponseResult svaUser(UserDo userDo);
}
