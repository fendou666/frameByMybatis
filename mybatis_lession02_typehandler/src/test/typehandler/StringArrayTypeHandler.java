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
 * Description:  �ַ������� �� VARCHAR����ת����
 * Copyright:   Copyright (c) 2015-2016 All Rights Reserved.
 * Company:     chinasofti.com Inc.
 * @author:     mazheng 
 * @version:    1.0  
 * Create at:   2015��4��30�� ����10:40:39  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2015��4��30��      mazheng      1.0         1.0 Version  
 *
 */
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			String[] parameter, JdbcType jdbcType) throws SQLException {
		String value = "";

		// ѭ������ ƴ�� �Զ��ŷָ���ַ���
		for (String temp : parameter) {
			value = value + temp + ",";
		}
		ps.setString(i, value);
	}

	@Override
	public String[] getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		
		// ��ȡcolumnName�е�����
		String value = rs.getString(columnName);
		String[] result = value.split(",");
		
		return result;
	}

	@Override
	public String[] getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		// ��ȡcolumnName�е�����
		String value = rs.getString(columnIndex);
		String[] result = value.split(",");
		
		return result;
	}

	@Override
	public String[] getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		// ��ȡcolumnName�е�����
		String value = cs.getString(columnIndex);
		String[] result = value.split(",");
		return result;
	}

}
