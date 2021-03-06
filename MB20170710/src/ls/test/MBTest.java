package ls.test;
import java.io.IOException;
import java.io.InputStream;





import ls.dao.StudentMapper;
import ls.model.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// 需要addlib中添加Junit
import org.junit.Test;
//  要求表必须有主键， 要求表必须是scott用户创建的， 拥有全部权限
public class MBTest {
	@Test
	public void oracleTest(){
		// ======获取String[] 的类型是 [Ljava.lang.String;
//		System.out.println(new String[]{"aaa","bbv"});
		try {
			InputStream cfIpt = Resources.getResourceAsStream("configuration.xml");
			SqlSessionFactory sqlF = new SqlSessionFactoryBuilder().build(cfIpt);
			SqlSession st = sqlF.openSession();
			StudentMapper stuMap = st.getMapper(StudentMapper.class);
			Student stu = new Student();
			stu.setId(20L);
			stu.setLikes(new String[]{"111","222","333"});
			stuMap.insert(stu);
			st.commit();
//			Student stuGet = stuMap.selectByPrimaryKey(19L);
//			for(String x: stuGet.getLikes()){
//				System.out.println(x);
//			}
			st.close();
			//System.out.println(empTest.getEname());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
