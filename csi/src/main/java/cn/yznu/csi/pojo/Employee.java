package cn.yznu.csi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/13 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {//员工
    private  long Employee_id;
    private String employeeloginname;
    private String employeepassword;
    private long dept_num;
    private String employee_name;
    private  String sex;
    private  String hobby;
    private long age;
    List<Position> positionList;
}
