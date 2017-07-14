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
	private SqlSessionFactory sqfc;
	private SqlSession ops;
	
	@Before
	public void initFactory(){
		InputStream is;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqfc = new SqlSessionFactoryBuilder().build(is);
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
		
		// resultMap��һ��
//			Student stu = stuMap.selectByCustomId1(3L);
//			System.out.println(stu.getClas().getName());
		// resultMap�ڶ���
//			Student stu = stuMap.selectByCustomId2(3L);
//			System.out.println(stu.getClas().getName());
		// resultMap������
//		Student stu = stuMap.selectByCustomId3(3L);
//		System.out.println(stu.getClas().getName());
//		System.out.println(stu);
		
		// ��һ��ֱ�ӵ���Map�з����ķ�ʽ
		Student stu2 = ops.selectOne("ls.dao.StudentMapper.selectByCustomId1", 3L);
		System.out.println(stu2.getClas().getName());
		System.out.println(stu2);
	}
	
	@Test
	// ==============һ������============
//	һ�����治������û�У� ��Ĭ���Ǵ򿪵�
	public void testOneLevelCatch(){
		System.out.println("=========================����һ�����濪ʼ================");
		Student stu2 = ops.selectOne("ls.dao.StudentMapper.selectByCustomId1", 3L);
		System.out.println(stu2);
		System.out.println("=========================����һ������ڶ�������================");
		Student stu3 = ops.selectOne("ls.dao.StudentMapper.selectByCustomId1", 2L);
		System.out.println(stu3);
		System.out.println("=========================����һ���������================");
	}
	
	@Test
	// ==============��������============
	public void testTwoLevelCatch(){
		System.out.println("=========================���Զ������濪ʼ================");
		SqlSession ops1 = sqfc.openSession();
		Student stu1 = ops1.selectOne("ls.dao.StudentMapper.selectByCustomId1", 3L);
		ops1.close();
		System.out.println("=========================���Զ�������ڶ�������================");
		SqlSession ops2 = sqfc.openSession();
		Student stu2 = ops2.selectOne("ls.dao.StudentMapper.selectByCustomId1", 2L);
		ops2.close();
		System.out.println("=========================���Զ����������================");
	}
}