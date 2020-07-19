package cn.yznu.csi.service;

import cn.yznu.csi.pojo.Dept;
import cn.yznu.csi.pojo.Employee;
import cn.yznu.csi.pojo.Employee_position;
import cn.yznu.csi.pojo.Position;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/13 15:55
 */
public interface PositionService {
    List<Position> findAllPosition();
    int deletePosition(long position_id);
    int addPosition(Position position);
    int updatePosition(Position position);
    int setPosition(Employee_position employee_position);
    Position getInfo(long position_id);
    List<Employee_position> findEmployee(long position_id);
    List<Position> getInfo1(long Employee_id);
    Position gitPosition_id(String position_name);
    int delete2(Employee_position employee_position);


}
