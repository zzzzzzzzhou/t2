package cn.yznu.csi.dao;

import cn.yznu.csi.pojo.Employee;
import cn.yznu.csi.pojo.Employee_position;
import cn.yznu.csi.pojo.Position;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/13 16:32
 */

@Mapper
@Repository
public interface PositionDao {

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
