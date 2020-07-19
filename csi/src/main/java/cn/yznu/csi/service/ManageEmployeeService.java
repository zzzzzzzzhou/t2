package cn.yznu.csi.service;

import cn.yznu.csi.pojo.Employee;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/14 9:05
 */
public interface ManageEmployeeService {
    int addEmployee(Employee employee);
    int deleteEmployee(long Employee_id);
    int updateEmlpoyee(Employee employee);
    List<Employee> findALLEmployee();
    List<Employee> findEmployee(Employee employee);
    Employee getInfo(long Employee_id);
}
