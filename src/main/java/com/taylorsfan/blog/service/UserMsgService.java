package com.taylorsfan.blog.service;

import com.taylorsfan.blog.vo.UserVo;

import java.util.List;
import java.util.Set;

/**
 * @author taylorsfan
 */
public interface UserMsgService {

    List<UserVo> findFanMsgByUserId(int id);

    List<UserVo> findFocusMsgByUserId(int id);

    UserVo findMsgByUserId(int id);

    Set<String> findRoleNameList(String username);

    Set<String> findPermissionNameList(String username);


}
