package ls.test;

import java.io.IOException;
import java.io.InputStream;

import ls.dao.StudentMapper;
import ls.model.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMoreTableQuery {
	@Test
	public void test1(){
		try {
			InputStream is = Resources.getResourceAsStream("configuration.xml");
			SqlSessionFactory sqfc = new SqlSessionFactoryBuilder().build(is);
			SqlSession ops = sqfc.openSession();
			StudentMapper stuMap = ops.getMapper(StudentMapper.class);
			
//			Student stu = stuMap.selectByPrimaryKey(10L);
//			System.out.println(stu.getName());
			
//			Student stu = stuMap.selectByCustomId(10L);
//			System.out.println(stu.getClas().getName());
			
			Student stu = stuMap.selectByCustomId2(3L);
			System.out.println(stu.getClas().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
