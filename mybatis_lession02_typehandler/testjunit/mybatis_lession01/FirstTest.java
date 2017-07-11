package mybatis_lession01;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import test.dao.StudentMapper;
import test.model.Student;

public class FirstTest {

	private String filename = "mybatis-config.xml";
	@Test
	public void test1() {
		
		try {
			InputStream is = Resources.getResourceAsStream(filename);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student = mapper.selectByPrimaryKey(1);
			
			assertNotNull(student);
			System.out.println(student);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
}
