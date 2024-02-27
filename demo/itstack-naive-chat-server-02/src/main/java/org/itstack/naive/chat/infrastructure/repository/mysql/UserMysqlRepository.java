package org.itstack.naive.chat.infrastructure.repository.mysql;

import org.itstack.naive.chat.domain.repository.IUserRepository;
import org.itstack.naive.chat.infrastructure.dao.UserDao;
import org.itstack.naive.chat.infrastructure.po.UserEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 虫洞栈：https://bugstack.cn
 * 公众号：bugstack虫洞栈 | 欢迎关注并获取更多专题案例源码
 * Create by 小傅哥 on @2020
 */
@Repository("userMysqlRepository")
public class UserMysqlRepository implements IUserRepository {

    @Resource
    private UserDao userDao;

    @Override
    public void save(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    @Override
    public UserEntity query(Long id) {
        return userDao.query(id);
    }
}
