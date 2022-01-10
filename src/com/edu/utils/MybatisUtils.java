package com.edu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {

        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

    }

    public static SqlSession getSqlSession(){
//        System.out.println(sqlSessionFactory);
        return sqlSessionFactory.openSession();
    }

}
