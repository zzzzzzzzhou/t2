package cn.yznu.csi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZHY
 * @date 2020/7/11 16:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {//部门
    private long dept_num;
    private long leader_id;
    private String dept_name;
    private String duty;
}
