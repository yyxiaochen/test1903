package com.southwest.Util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }
//代理类的业务方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession sqlSession = null;
        Object obj = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
//        处理业务逻辑
            obj = method.invoke(target,args);
//        提交事务
            sqlSession.commit();
        }catch (Exception e){
//            出现异常，回滚事务
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(sqlSession);
        }
        return obj;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
}
