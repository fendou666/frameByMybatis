package ls.test;
import java.io.IOException;
import java.io.InputStream;






import java.util.List;

import ls.dao.StudentMapper;
import ls.model.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
// 需要addlib中添加Junit
import org.junit.Test;
//  要求表必须有主键， 要求表必须是scott用户创建的， 拥有全部权限
public class MBTest {
	public static void main(String[] args) {
		try {
			InputStream cfIpt = Resources.getResourceAsStream("configuration.xml");
			SqlSessionFactory sqlF = new SqlSessionFactoryBuilder().build(cfIpt);
			SqlSession st = sqlF.openSession();
			StudentMapper stuMap = st.getMapper(StudentMapper.class);
//			Student stu = new Student();
//			stu.setId(20L);
//			stu.setLikes(new String[]{"111","222","333"});
//			stuMap.insert(stu);
//			st.commit();
			/*Student stuGet = stuMap.selectByPrimaryKey(19L);
			for(String x: stuGet.getLikes()){
				System.out.println(x);
			}
			*/
//			Student stuGet1 = stuMap.selectByName("小哈");
//			System.out.println(stuGet1.getId());
			
//			Student insetNewStu = new Student();
//			insetNewStu.setId(20L);
//			insetNewStu.setLikes(new String[]{"乒乓","足球", "篮球"});
//			insetNewStu.setName("新兵");
//			insetNewStu.setSex("男");
//			stuMap.insert(insetNewStu);
//			st.commit();
			// =================单个参数============
//			List<Student> stuList = stuMap.selectByNameLike("小");
//			
//			for(Student x: stuList){
//				System.out.println(x.getId() + x.getName() + x.getSex());
//			}
			// =================多个个参数============
//			Student queryStu = new Student();
//			queryStu.setId(5L);
//			queryStu.setName("小");
//			List<Student> stuList2 = stuMap.selectByNameLikeMoreParam(queryStu);
//			
//			for(Student x: stuList2){
//				System.out.println(x.getId() + x.getName() + x.getSex());
//			}
			
			//============调用返回构造方法==========
			Student stuGetC1 = stuMap.selectByNameConstruct("小哈");
			System.out.println(stuGetC1.getId());
			st.close();
			//System.out.println(empTest.getEname());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void oracleTest(){
		// ======获取String[] 的类型是 [Ljava.lang.String;
//		System.out.println(new String[]{"aaa","bbv"});
		try {
			InputStream cfIpt = Resources.getResourceAsStream("configuration.xml");
			SqlSessionFactory sqlF = new SqlSessionFactoryBuilder().build(cfIpt);
			SqlSession st = sqlF.openSession();
			StudentMapper stuMap = st.getMapper(StudentMapper.class);
//			Student stu = new Student();
//			stu.setId(20L);
//			stu.setLikes(new String[]{"111","222","333"});
//			stuMap.insert(stu);
//			st.commit();
			Student stuGet = stuMap.selectByPrimaryKey(19L);
			for(String x: stuGet.getLikes()){
				System.out.println(x);
			}
			
			Student stuGet1 = stuMap.selectByName("小哈");
			//System.out.println(stuGet1.getId());
			st.close();
			//System.out.println(empTest.getEname());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
