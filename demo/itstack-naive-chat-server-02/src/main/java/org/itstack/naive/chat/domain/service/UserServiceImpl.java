package org.itstack.naive.chat.domain.service;

import org.itstack.naive.chat.application.service.UserService;
import org.itstack.naive.chat.domain.model.aggregates.UserRichInfo;
import org.itstack.naive.chat.domain.model.vo.UserInfo;
import org.itstack.naive.chat.domain.model.vo.UserSchool;
import org.itstack.naive.chat.domain.repository.IUserRepository;
import org.itstack.naive.chat.infrastructure.po.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 虫洞栈：https://bugstack.cn
 * 公众号：bugstack虫洞栈 | 欢迎关注并获取更多专题案例源码
 * Create by 小傅哥 on @2020
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userRepository")
    private IUserRepository userRepository;

    @Override
    public UserRichInfo queryUserInfoById(Long id) {
        
        // 查询资源库
        UserEntity userEntity = userRepository.query(id);

        UserInfo userInfo = new UserInfo();
        userInfo.setName(userEntity.getName());

        // TODO 查询学校信息，外部接口
        UserSchool userSchool_01 = new UserSchool();
        userSchool_01.setSchoolName("振华高级实验中学");

        UserSchool userSchool_02 = new UserSchool();
        userSchool_02.setSchoolName("东北电力大学");

        List<UserSchool> userSchoolList = new ArrayList<>();
        userSchoolList.add(userSchool_01);
        userSchoolList.add(userSchool_02);

        UserRichInfo userRichInfo = new UserRichInfo();
        userRichInfo.setUserInfo(userInfo);
        userRichInfo.setUserSchoolList(userSchoolList);

        return userRichInfo;
    }

}
