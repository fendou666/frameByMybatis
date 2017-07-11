package com.mybatis.intercept;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.mysql.jdbc.Connection;

	
@Intercepts({@Signature(
			type=StatementHandler.class,
			method="prepare",
			args={Connection.class}
		)
})	
// java中的数据库对象JDBC处理执行拦截器
public class MyIntercept implements Interceptor {

	@Override
	public Object intercept(Invocation ivk) throws Throwable {
		System.out.println("myInterceptor start");
		StatementHandler sh = (StatementHandler)ivk.getTarget();
		System.out.println("执行的 sql 语句是" + sh.getBoundSql().getSql());
		System.out.println("myInterceptor end");
		return ivk.proceed();
	}

	@Override
	public Object plugin(Object obj) {
		return Plugin.wrap(obj, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		System.out.println("set mm:" + arg0.getProperty("mm"));
	}

}
