package ls.dao;

import java.util.List;

import ls.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);
    Student selectByCustomId1(Long id);
    Student selectByCustomId2(Long id);
    Student selectByCustomId3(Long id);
    
    List<Student> selectByConditionIf(Student u);
    List<Student> selectByConditionTrim(Student u);
    List<Student> selectByConditionWhere(Student u);
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}