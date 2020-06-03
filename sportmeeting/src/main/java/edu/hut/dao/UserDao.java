package edu.hut.dao;

import edu.hut.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public interface UserDao {

    public User findById(int id);

    User login(@Param("username") String username, @Param("password") String password);
}
