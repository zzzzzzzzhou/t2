package cn.yznu.csi.dao;

import cn.yznu.csi.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/11 16:56
 */
@Mapper
@Repository
public interface DeptDao {
    List<Dept> findAllDept();
    Dept getInfo(long dept_num);
    int save(Dept dept);//新增部门
    int updateDept(Dept dept);
    int deleteDept(long dept_num);
}
