package cn.yznu.csi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ZHYd
 * @date 2020/7/13 15:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    private long position_id;
    private String position_name;
    private String position_job;
    List<Employee> employeeList;
}
