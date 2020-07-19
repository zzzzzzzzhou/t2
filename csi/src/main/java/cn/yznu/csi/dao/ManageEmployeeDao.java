package cn.yznu.csi.dao;

import cn.yznu.csi.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/14 9:14
 */
@Mapper
@Repository
public interface ManageEmployeeDao {
    int addEmployee(Employee employee);
    int deleteEmployee(long Employee_id);
    int updateEmlpoyee(Employee employee);
    List<Employee> findALLEmployee();
    List<Employee> findEmployee(Employee employee);
    List<Employee> findEmployee2(Employee employee);
    Employee getInfo(long Employee_id);
}
