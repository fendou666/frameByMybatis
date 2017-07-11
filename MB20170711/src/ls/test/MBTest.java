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
// ��Ҫaddlib������Junit
import org.junit.Test;
//  Ҫ��������������� Ҫ���������scott�û������ģ� ӵ��ȫ��Ȩ��
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
//			Student stuGet1 = stuMap.selectByName("С��");
//			System.out.println(stuGet1.getId());
			
//			Student insetNewStu = new Student();
//			insetNewStu.setId(20L);
//			insetNewStu.setLikes(new String[]{"ƹ��","����", "����"});
//			insetNewStu.setName("�±�");
//			insetNewStu.setSex("��");
//			stuMap.insert(insetNewStu);
//			st.commit();
			// =================��������============
//			List<Student> stuList = stuMap.selectByNameLike("С");
//			
//			for(Student x: stuList){
//				System.out.println(x.getId() + x.getName() + x.getSex());
//			}
			// =================���������============
//			Student queryStu = new Student();
//			queryStu.setId(5L);
//			queryStu.setName("С");
//			List<Student> stuList2 = stuMap.selectByNameLikeMoreParam(queryStu);
//			
//			for(Student x: stuList2){
//				System.out.println(x.getId() + x.getName() + x.getSex());
//			}
			
			//============���÷��ع��췽��==========
			Student stuGetC1 = stuMap.selectByNameConstruct("С��");
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
		// ======��ȡString[] �������� [Ljava.lang.String;
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
			
			Student stuGet1 = stuMap.selectByName("С��");
			//System.out.println(stuGet1.getId());
			st.close();
			//System.out.println(empTest.getEname());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}