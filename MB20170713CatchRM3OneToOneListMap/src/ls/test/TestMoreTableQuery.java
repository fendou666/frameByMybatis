package ls.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Test
	// ==============一级缓存============
//	一级缓存不能配置没有， 它默认是打开的
	public void testOneLevelCatch(){
		System.out.println("=========================测试一级缓存开始================");
		Student stu2 = ops.selectOne("ls.dao.StudentMapper.selectByCustomId1", 3L);
		System.out.println(stu2);
		System.out.println("=========================测试一级缓存第二个调用================");
		Student stu3 = ops.selectOne("ls.dao.StudentMapper.selectByCustomId1", 2L);
		System.out.println(stu3);
		System.out.println("=========================测试一级缓存结束================");
	}
	
	@Test
	// ==============二级缓存============
	public void testTwoLevelCatch(){
		System.out.println("=========================测试二级缓存开始================");
		SqlSession ops1 = sqfc.openSession();
		Student stu1 = ops1.selectOne("ls.dao.StudentMapper.selectByCustomId1", 3L);
		ops1.close();
		System.out.println("=========================测试二级缓存第二个调用================");
		SqlSession ops2 = sqfc.openSession();
		Student stu2 = ops2.selectOne("ls.dao.StudentMapper.selectByCustomId1", 2L);
		ops2.close();
		System.out.println("=========================测试二级缓存结束================");
	}
	
	@Test
	// ================测试Map和List参数============
	public void testMapAndList(){
		StudentMapper stuMap = ops.getMapper(StudentMapper.class);
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(2);
		idList.add(3);
		idList.add(5);
		idList.add(6);
		idList.add(7);
		idList.add(8);
		idList.add(9);
//		List<Student> listStu = stuMap.selectByList(idList);
//		System.out.println(listStu);
//		========================Map第一种方式===============
		Map<String, Object> testMap = new HashMap<String, Object>();
		testMap.put("clsIdM", 2);
		testMap.put("idListM", idList);
		List<Student> MapStu = stuMap.selectByMap1(testMap);
		for(Student s: MapStu){
			System.out.println(s);
		}
//		====================Map第二种对象方式================
		Map<String, Object> testMap2 = new HashMap<String, Object>();
		Student stuMapO = new Student();
		stuMapO.setClassid(2);
		testMap.put("clsIdM", stuMapO);
		testMap.put("idListM", idList);
		List<Student> MapStu2 = stuMap.selectByMap2(testMap);
		for(Student s: MapStu2){
			System.out.println(s);
		}
	}
}
