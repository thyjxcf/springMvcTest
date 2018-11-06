package com.hzgg.spring.test;

import com.hzgg.spring.dao.UserDao;
import com.hzgg.spring.entity.User;
import javafx.application.Application;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

/**
 * Created by luf on 2018/11/6.
 */
public class UserDaoTest {

    private static Logger logger = Logger.getLogger(UserDaoTest.class);

    public static void main(String[] args) {
//        testMybatis();
        testSpringMybatis();
    }
    private static void testMybatis(){

        InputStream config = UserDaoTest.class.getClassLoader().getResourceAsStream("mybatis/mybatis.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        SqlSession session = factory.openSession(true);

        try{
           UserDao userDao = session.getMapper(UserDao.class);
           List<User> userList = userDao.getAllUsers();
           logger.info(userList);
           userList.forEach(user -> logger.info(user.getUsername() + " , " + user.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    private static void testSpringMybatis(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        SqlSessionFactory factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");

        SqlSession sqlSession = factory.openSession(true);
        try{

            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> users =userDao.getAllUsers();
            users.forEach(user -> logger.info(user.getUsername() + " "  + user.getAddress()));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
