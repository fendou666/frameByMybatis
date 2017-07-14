package ls.dao;

import ls.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);
    Student selectByCustomId1(Long id);
    Student selectByCustomId2(Long id);
    Student selectByCustomId3(Long id);
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}