package test.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
/**
 * 
 * Filename:    StringArrayTypeHandler.java  
 * Description:  字符串数组 与 VARCHAR类型转换器
 * Copyright:   Copyright (c) 2015-2016 All Rights Reserved.
 * Company:     chinasofti.com Inc.
 * @author:     mazheng 
 * @version:    1.0  
 * Create at:   2015年4月30日 上午10:40:39  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2015年4月30日      mazheng      1.0         1.0 Version  
 *
 */
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			String[] parameter, JdbcType jdbcType) throws SQLException {
		String value = "";

		// 循环数组 拼出 以逗号分割的字符串
		for (String temp : parameter) {
			value = value + temp + ",";
		}
		ps.setString(i, value);
	}

	@Override
	public String[] getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		
		// 获取columnName列的数据
		String value = rs.getString(columnName);
		String[] result = value.split(",");
		
		return result;
	}

	@Override
	public String[] getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		// 获取columnName列的数据
		String value = rs.getString(columnIndex);
		String[] result = value.split(",");
		
		return result;
	}

	@Override
	public String[] getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		// 获取columnName列的数据
		String value = cs.getString(columnIndex);
		String[] result = value.split(",");
		return result;
	}

}
