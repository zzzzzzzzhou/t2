package cn.yznu.csi.controller;

import cn.yznu.csi.pojo.Dept;
import cn.yznu.csi.pojo.Employee;
import cn.yznu.csi.pojo.Employee_position;
import cn.yznu.csi.pojo.Position;
import cn.yznu.csi.service.ManageEmployeeService;
import cn.yznu.csi.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/13 17:11
 */
@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionService positionService;
    @Autowired
    ManageEmployeeService manageEmployeeService;

    @GetMapping
    public String list(Model model){
        List<Position> positionList = positionService.findAllPosition();
        model.addAttribute("list", positionList);

        List<Employee> employeeList = manageEmployeeService.findALLEmployee();
        model.addAttribute("list1", employeeList);
        for (Employee employee : employeeList){
            employee.setPositionList(positionService.getInfo1(employee.getEmployee_id()));
            System.out.println(employee);
        }
        return "position/list";
    }

    @GetMapping("/list/{position_id}/delete")
    public String delete(@PathVariable long position_id, RedirectAttributes attributes) {
        System.out.println("position_id:"+position_id );
//        int a = Integer.parseInt(dept_num);
//        System.out.println(a+"int");p

        try {
            int n=positionService.deletePosition(position_id);
            if (n!=0){
                attributes.addFlashAttribute("msg", "删除成功");

                return "redirect:/position";
            }
        }catch (Exception e){
            System.out.println(e);
            attributes.addFlashAttribute("msg", "该角色已被引用，删除失败");
            return "redirect:/position";
        }
        return "redirect:/position";
    }

    @GetMapping("/add")
    public String add() {
        return "/position/add";
    }

    @PostMapping("/add/a")
    public String add(
            @RequestParam String position_name,
            @RequestParam String position_job,
            RedirectAttributes attributes) {
        if (position_name == null || position_name == "") {
            attributes.addFlashAttribute("msg", "添加失败，名称不能为空");
            return "redirect:/dept/add";
        }
        Position position=new Position();
//        position.setPosition_id(position_id);
        position.setPosition_job(position_job);
        position.setPosition_name(position_name);
        System.out.println(position.toString());
        int n = positionService.addPosition(position);
        if (n != 0) {
            attributes.addFlashAttribute("msg", "添加成功");
            return "redirect:/position";
        } else {
            attributes.addFlashAttribute("msg", "添加失败，请验证");
            return "redirect:/position/add";
        }
    }

    @GetMapping("/list/{position_id}/update")
    public String update(@PathVariable long position_id , Model model) {
//        System.out.println("-------22222test getInfo---------");
        Position position=positionService.getInfo(position_id);
        System.out.println(position.toString());
        model.addAttribute("position",position);
        return "/position/update";
    }

    @PostMapping("/update/a")
    public String update(
            @RequestParam Long position_id,
            @RequestParam String position_name,
            @RequestParam String position_job,
            RedirectAttributes attributes) {
        if (position_name == null || position_name == "") {
            attributes.addFlashAttribute("msg", "修改失败，名称不能为空");
            return "redirect:/position";
        }
        System.out.println("1111111111111111");
        Position position=new Position();
        position.setPosition_id(position_id);
        position.setPosition_name(position_name);
        position.setPosition_job(position_job);
        System.out.println(position.toString());
        int n = positionService.updatePosition(position);
        if (n != 0) {
            attributes.addFlashAttribute("msg", "修改成功");
            return "redirect:/position";
        } else {
            attributes.addFlashAttribute("msg", "添加失败，请验证");
            return "/position/update";
        }
    }
    @GetMapping("/list/{position_id}/search")
    public String search(@PathVariable long position_id ,Model model) {
        List<Employee_position> employee_positions=positionService.findEmployee(position_id);
        List<Employee> employeeList = new ArrayList<Employee>();
        List<Position> positionList1=new ArrayList<Position>();
                //positionService.getInfo1(Employee_id);
        for (Employee_position employee_position1 : employee_positions){
            employeeList.add(manageEmployeeService.getInfo(employee_position1.getEmployee_id()));
        }

        for (Employee employee : employeeList){
            employee.setPositionList(positionService.getInfo1(employee.getEmployee_id()));
            System.out.println(employee);
        }
        List<Position> positionList = positionService.findAllPosition();
        System.out.println("1111");
        model.addAttribute("list", positionList);
        System.out.println("1111");
        model.addAttribute("list1",employeeList);
        return "/position/list";
    }

    @GetMapping("/list/{Employee_id}/set")
    public String set(@PathVariable long Employee_id, Model model) {
        System.out.println("---------------");
        Employee employee=manageEmployeeService.getInfo(Employee_id);
        employee.setPositionList(positionService.getInfo1(employee.getEmployee_id()));
        model.addAttribute("employee",employee);
        List<Position> positionList=positionService.findAllPosition();
        model.addAttribute("positionList",positionList);
        System.out.println(employee);
        return "/position/set";
    }

    @PostMapping("/set/a")
    public String set(
            @RequestParam Long position_id,
            @RequestParam Long Employee_id,
            Model model,
            RedirectAttributes attributes) {
        System.out.println(position_id+"aaaaaaaa"+Employee_id);
        Employee_position employee_position=new Employee_position();
        employee_position.setEmployee_id(Employee_id);
        employee_position.setPosition_id(position_id);
        System.out.println(employee_position);
        try {
            int n=positionService.setPosition(employee_position);
            Employee employee= manageEmployeeService.getInfo(Employee_id);
            employee.setPositionList(positionService.getInfo1(employee.getEmployee_id()));
            model.addAttribute("employee",employee);
            List<Position> positionList=positionService.findAllPosition();
            model.addAttribute("positionList",positionList);
            System.out.println(employee);
            model.addAttribute("employee",employee);
            if (n != 0) {
                attributes.addFlashAttribute("msg", "添加成功");
                return "/position/set";
            }
        }catch (Exception e){
            attributes.addFlashAttribute("msg", "添加失败，请验证");
            System.out.println(e);
            return "redirect:/position";
        }
        return "redirect:/position/set";
    }

    @GetMapping("/list/delete2")
    public String delete2( @RequestParam Long position_id,
                           @RequestParam Long Employee_id,
                           Model model,
                           RedirectAttributes attributes){
        System.out.println(Employee_id+"aaaaaaaaaaa"+position_id);
        Employee_position employee_position=new Employee_position();
        employee_position.setEmployee_id(Employee_id);
        employee_position.setPosition_id(position_id);
        positionService.delete2(employee_position);
        Employee employee=manageEmployeeService.getInfo(Employee_id);
        employee.setPositionList(positionService.getInfo1(employee.getEmployee_id()));
        model.addAttribute("employee",employee);
        List<Position> positionList=positionService.findAllPosition();
        model.addAttribute("positionList",positionList);
        attributes.addFlashAttribute("msg", "删除成功");
        return "/position/set";
    }

}
