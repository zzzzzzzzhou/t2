package cn.yznu.csi.controller;

import cn.yznu.csi.dao.PositionDao;
import cn.yznu.csi.pojo.Dept;
import cn.yznu.csi.pojo.Employee;
import cn.yznu.csi.pojo.Employee_position;
import cn.yznu.csi.pojo.Position;
import cn.yznu.csi.service.DeptService;
import cn.yznu.csi.service.ManageEmployeeService;
import cn.yznu.csi.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/11 14:39
 */
@Controller
public class testController {

    @Autowired
    private DeptService deptServiec;
    @Autowired
    private PositionService positionService;
    @Autowired
    private ManageEmployeeService manageEmployeeService;

    @GetMapping("/")
    public String test(Model model) {
/*
        List<Position> positionList=positionService.getInfo1(7);
        for (Position position: positionList)
            System.out.println(position);
*/


//        Employee_position employee_position=new Employee_position();
//        employee_position.setPosition_id(1);
/*        List<Employee_position> employee_positions=positionService.findEmployee(1);
        for (Employee_position employee_position1 : employee_positions)
            System.out.println(employee_position1);*/


    /*    Employee employee=new Employee();
//        employee.setEmployee_name("周华宇");
        employee.setDept_num(0);
        List<Employee>  employeeList=manageEmployeeService.findEmployee(employee);
        for (Employee employee1: employeeList){
            System.out.println(employee1);
        }*/

        //test findAllDept
//        List<Dept> depts = deptServiec.findAllDept();
//        model.addAttribute("depts",depts);
//        System.out.println("-------11111test findAllDept---------");
//        for (Dept dept : depts ){
//            System.out.println(dept.toString());
//        }

        //test getInfo
//        System.out.println("-------22222test getInfo---------");
//        Dept dept=deptServiec.getInfo(2);
//        System.out.println(dept.toString());

        //test addDept
//        System.out.println("-------33333test addDept---------");
//        Dept dept1=new Dept();
//        dept1.setDept_num(5);
//        dept1.setDept_name("测试部");
//        deptServiec.addDept(dept1);
//        System.out.println(dept1.toString());

//        //test deleteDept
//        System.out.println("-------44444test deleteDept---------");
//        deptServiec.deleteDept(5);
//        return "test";

        //test updateDept
//        System.out.println("-------55555test updateDept---------");
//        Dept dept1=new Dept();
//        dept1.setDept_num(2);
//        dept1.setDept_name("测试2");
//        deptServiec.updateDept(dept1);
//        System.out.println(dept1.toString());

        //test findAllPosition
//        List<Position> positions = positionService.findAllPosition();
//        model.addAttribute("depts", positions);
//        System.out.println("-------66666test findAllPosition---------");
//        for (Position position : positions) {
//            System.out.println(position.toString());
//        }
        return "test";
    }
}
