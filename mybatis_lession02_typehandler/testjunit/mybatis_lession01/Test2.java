package mybatis_lession01;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import test.dao.StudentMapper;
import test.model.Student;

public class Test2 {
    InputStream       is;
    SqlSessionFactory factory;
    SqlSession        session;
    String            filename = "mybatis-config.xml";

    @Before
    public void prepar() throws IOException {
        is = Resources.getResourceAsStream(filename);
        factory = new SqlSessionFactoryBuilder().build(is);
        session = factory.openSession();
    }

    @Test
    public void test1() {

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student record = new Student();
        String name = UUID.randomUUID().toString();
       
        record.setName(name);

        // a1:×ãÇò a2:ÀºÇò a3:ÅÅÇò
        record.setInterest(new String[] { "a1",  "a3" });
        mapper.insertSelective(record);
        
        System.out.println(name);
        
        List<Student> list = mapper.selectByName(name);
        
        for (Student temp1: list) {
            System.out.println(temp1);
            for (String temp2: temp1.getInterest()) {
                System.out.println(temp2);
            }
        }
        
        session.commit();
    }
    
    
    
}

