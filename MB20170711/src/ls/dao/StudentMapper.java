package ls.dao;

import java.util.List;

import ls.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);
//  �Զ����ѯ�Լ����ӵ�
    Student selectByName(String name);
//  ����ֵ�Թ��췽������ʽ����
    Student selectByNameConstruct(String name);
    
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> selectByNameLike(String name);
    List<Student>  selectByNameLikeMoreParam(Student stu);
}