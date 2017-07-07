package ls.test;
import java.io.IOException;
import java.io.InputStream;

import ls.dao.EmpMapper;
import ls.model.Emp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// ��Ҫaddlib������Junit
import org.junit.Test;
public class MBTest {
	@Test
	public void oracleTest(){
		try {
			InputStream cfIpt = Resources.getResourceAsStream("configuration.xml");
			SqlSessionFactory sqlF = new SqlSessionFactoryBuilder().build(cfIpt);
			SqlSession st = sqlF.openSession();
			EmpMapper empMap = st.getMapper(EmpMapper.class);
			Emp empTest = empMap.selectByPrimaryKey((short)7499);
			System.out.println(empTest.getEname());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}