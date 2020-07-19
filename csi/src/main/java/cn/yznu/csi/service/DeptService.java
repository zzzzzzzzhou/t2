package cn.yznu.csi.service;

import cn.yznu.csi.pojo.Dept;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/11 16:47
 */
public interface DeptService {
    int addDept(Dept dept);

    Dept getInfo(long dept_num);

    int updateDept(Dept dept);

    int deleteDept(long dept_num);

    List<Dept> findAllDept();
}
