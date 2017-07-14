package ls.dao;

import java.util.List;
import java.util.Map;

import ls.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);
    Student selectByCustomId1(Long id);
    Student selectByCustomId2(Long id);
    Student selectByCustomId3(Long id);
    
    List<Student> selectByList(List<Integer> idList);
    List<Student> selectByMap1(Map<String, Object> testMap);
    List<Student> selectByMap2(Map<String, Object> testMap);
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}