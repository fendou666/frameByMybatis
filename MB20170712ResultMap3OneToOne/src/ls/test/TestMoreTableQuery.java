package ls.test;

import java.io.IOException;
import java.io.InputStream;

import ls.dao.StudentMapper;
import ls.model.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class TestMoreTableQuery {
	private SqlSession ops;
	
	@Before
	public void initFactory(){
		InputStream is;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			SqlSessionFactory sqfc = new SqlSessionFactoryBuilder().build(is);
			ops = sqfc.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1(){
		StudentMapper stuMap = ops.getMapper(StudentMapper.class);
//			Student stu = stuMap.selectByPrimaryKey(10L);
//			System.out.println(stu.getName());
		
		// resultMap第一种
//			Student stu = stuMap.selectByCustomId1(3L);
//			System.out.println(stu.getClas().getName());
		// resultMap第二种
//			Student stu = stuMap.selectByCustomId2(3L);
//			System.out.println(stu.getClas().getName());
		// resultMap第三种
//		Student stu = stuMap.selectByCustomId3(3L);
//		System.out.println(stu.getClas().getName());
//		System.out.println(stu);
		
		// 另一种直接调用Map中方法的方式
		Student stu2 = ops.selectOne("ls.dao.StudentMapper.selectByCustomId1", 3L);
		System.out.println(stu2.getClas().getName());
		System.out.println(stu2);
	}
	
}
