package com.southwest.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private static final SqlSessionFactory sqlSessionFactory;
//    创建mybatis的连接池
    static {
        String resource = "com/southwest/mybatisConfig.xml";
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        Configuration config;
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    private static final ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = t.get();
        if (sqlSession==null){
            sqlSession = sqlSessionFactory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }
//    关闭SqlSession对象
    public static void myClose(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.close();
            t.remove();
        }
    }
}
