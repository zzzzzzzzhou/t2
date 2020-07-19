package cn.yznu.csi.service.Impl;

import cn.yznu.csi.dao.ManageEmployeeDao;
import cn.yznu.csi.pojo.Employee;
import cn.yznu.csi.service.ManageEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/14 9:15
 */
@Service
public class ManageEmployeeServiceImpl implements ManageEmployeeService {
    @Autowired
    ManageEmployeeDao manageEmployeeDao;
    @Override
    public int addEmployee(Employee employee) {
        return manageEmployeeDao.addEmployee(employee);
    }

    @Override
    public int deleteEmployee(long Employee_id) {
        return manageEmployeeDao.deleteEmployee(Employee_id);
    }

    @Override
    public int updateEmlpoyee(Employee employee) {
        return manageEmployeeDao.updateEmlpoyee(employee);
    }

    @Override
    public List<Employee> findALLEmployee() {
        return manageEmployeeDao.findALLEmployee();
    }

    @Override
    public  List<Employee> findEmployee(Employee employee) {
        return manageEmployeeDao.findEmployee(employee);
    }

    @Override
    public Employee getInfo(long Employee_id) {
        return manageEmployeeDao.getInfo(Employee_id);
    }
}
