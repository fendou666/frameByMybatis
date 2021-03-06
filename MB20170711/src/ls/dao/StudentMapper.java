package ls.dao;

import java.util.List;

import ls.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);
//  自定义查询自己添加的
    Student selectByName(String name);
//  返回值以构造方法的形式构建
    Student selectByNameConstruct(String name);
    
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> selectByNameLike(String name);
    List<Student>  selectByNameLikeMoreParam(Student stu);
}