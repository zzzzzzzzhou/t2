package cn.yznu.csi.service.Impl;

import cn.yznu.csi.dao.DeptDao;
import cn.yznu.csi.pojo.Dept;
import cn.yznu.csi.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/11 17:02
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public int addDept(Dept dept) {
        return deptDao.save(dept);
    }

    @Override
    public Dept getInfo(long dept_num) {
        return deptDao.getInfo(dept_num);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptDao.updateDept(dept);
    }

    @Override
    public int deleteDept(long dept_num) {
        return deptDao.deleteDept(dept_num);
    }

    @Override
    public List<Dept> findAllDept() {
        return deptDao.findAllDept();
    }
}
