package cn.yznu.csi.service.Impl;

import cn.yznu.csi.dao.PositionDao;
import cn.yznu.csi.pojo.Employee;
import cn.yznu.csi.pojo.Employee_position;
import cn.yznu.csi.pojo.Position;
import cn.yznu.csi.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/13 16:08
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;

    @Override
    public List<Position> findAllPosition() {
        return positionDao.findAllPosition();
    }

    @Override
    public int deletePosition(long position_id) {
        return positionDao.deletePosition(position_id);
    }

    @Override
    public int addPosition(Position position) {
        return positionDao.addPosition(position);
    }

    @Override
    public int updatePosition(Position position) {
        return positionDao.updatePosition( position);
    }

    @Override
    public int setPosition(Employee_position employee_position) {
        return positionDao.setPosition(employee_position);
    }

    @Override
    public Position getInfo(long position_id) {
        return positionDao.getInfo(position_id);
    }

    @Override
    public List<Employee_position> findEmployee(long position_id) {
        return positionDao.findEmployee(position_id);
    }

    @Override
    public List<Position> getInfo1(long Employee_id) {
        return positionDao.getInfo1(Employee_id);
    }

    @Override
    public Position gitPosition_id(String position_name) {
        return positionDao.gitPosition_id(position_name);
    }

    @Override
    public int delete2(Employee_position employee_position) {
        return positionDao.delete2(employee_position);
    }
}
