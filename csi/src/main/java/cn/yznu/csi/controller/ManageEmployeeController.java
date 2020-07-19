package cn.yznu.csi.controller;

import cn.yznu.csi.pojo.Dept;
import cn.yznu.csi.pojo.Employee;
import cn.yznu.csi.pojo.Position;
import cn.yznu.csi.service.ManageEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/14 9:27
 */
@Controller
@RequestMapping("/ManageEmployee")
public class ManageEmployeeController {
    @Autowired
    ManageEmployeeService manageEmployeeService;

    @GetMapping
    public String index(Model model) {
        List<Employee> employeeList = manageEmployeeService.findALLEmployee();
//        for (Employee employee : employeeList) {
//            System.out.println(employee);
//        }
        model.addAttribute("list", employeeList);
        return "/ManageEmployee/list";
    }

    @GetMapping("/list/{Employee_id}/delete")
    public String delete(@PathVariable long Employee_id, RedirectAttributes attributes) {
        System.out.println("Employee_id:" + Employee_id);
//        int a = Integer.parseInt(dept_num);
//        System.out.println(a+"int");
        manageEmployeeService.deleteEmployee(Employee_id);
        System.out.println("删除成功");
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/ManageEmployee";
    }

    @GetMapping("/add")
    public String add() {
        return "/ManageEmployee/add";
    }

    @PostMapping("/add/a")
    public String add(
            @RequestParam String employeeloginname,
            @RequestParam String employeepassword,
            @RequestParam long dept_num,
            @RequestParam String employee_name,
            @RequestParam String sex,
            @RequestParam String hobby,
            @RequestParam long age,
            RedirectAttributes attributes) {
        if (employeeloginname == null || employeeloginname == ""
                || employeeloginname == null || employeeloginname == ""
                || employeepassword == null || employeepassword == ""
                || employee_name == null || employee_name == ""
                || sex == null || sex == ""
                || hobby == null || hobby == "" ) {
            attributes.addFlashAttribute("msg", "添加失败，属性不能为空");
            return "redirect:/ManageEmployee/add";
        }
        Employee employee = new Employee();
//        Long l=Long.parseLong(leader_id);
        employee.setEmployeeloginname(employeeloginname);
        employee.setEmployeepassword(employeepassword);
        employee.setDept_num(dept_num);
        employee.setEmployee_name(employee_name);
        employee.setSex(sex);
        employee.setHobby(hobby);
        employee.setAge(age);
        int n = manageEmployeeService.addEmployee(employee);
        if (n != 0) {
            attributes.addFlashAttribute("msg", "添加成功");
            return "redirect:/ManageEmployee";
        } else {
            attributes.addFlashAttribute("msg", "添加失败，请验证");
            return "redirect:/ManageEmployee/add";
        }
    }

    @GetMapping("/list/{Employee_id}/update")
    public String update(@PathVariable long Employee_id , Model model) {
        System.out.println("-------22222test getInfo---------"+Employee_id);
        Employee employee=manageEmployeeService.getInfo(Employee_id);
        System.out.println("-------22222test getInfo---------");
        System.out.println(employee.toString());
        model.addAttribute("employee",employee);
        return "/ManageEmployee/update";
    }

    @PostMapping("/update/a")
    public String update(
            @RequestParam Long Employee_id,
            @RequestParam String employeeloginname,
            @RequestParam String employeepassword,
            @RequestParam long dept_num,
            @RequestParam String employee_name,
            @RequestParam String sex,
            @RequestParam String hobby,
            @RequestParam long age,
            RedirectAttributes attributes) {
        if (employeeloginname == null || employeeloginname == ""
                || employeeloginname == null || employeeloginname == ""
                || employeepassword == null || employeepassword == ""
                || employee_name == null || employee_name == ""
                || sex == null || sex == ""
                || hobby == null || hobby == "" ) {
            attributes.addFlashAttribute("msg", "添加失败，属性不能为空");
            return "redirect:/ManageEmployee/add";
        }
        System.out.println("1111111111111111");
        Employee employee = new Employee();
//        Long l=Long.parseLong(leader_id);
        employee.setEmployeeloginname(employeeloginname);
        employee.setEmployeepassword(employeepassword);
        employee.setDept_num(dept_num);
        employee.setEmployee_name(employee_name);
        employee.setSex(sex);
        employee.setHobby(hobby);
        employee.setAge(age);
        employee.setEmployee_id(Employee_id);
        System.out.println(employee.toString());
        int n = manageEmployeeService.updateEmlpoyee(employee);
        if (n != 0) {
            attributes.addFlashAttribute("msg", "修改成功");
            return "redirect:/ManageEmployee";
        } else {
            attributes.addFlashAttribute("msg", "添加失败，请验证");
            return "/ManageEmployee/update";
        }
    }

    @PostMapping("/search")
    public String search(
            @RequestParam long dept_num,
            @RequestParam String employee_name,
            Model model,
            RedirectAttributes attributes) {
        if ((employee_name == null || employee_name == "") && dept_num==0) {
            attributes.addFlashAttribute("msg", "查询失败，属性不能全为空");
            return "redirect:/ManageEmployee";
        }
        if ((employee_name == null || employee_name == "") && dept_num!=0){
            Employee employee2=new Employee();
            employee2.setDept_num(dept_num);
            List<Employee>  employeeList2 = manageEmployeeService.findEmployee(employee2);
            model.addAttribute("list",employeeList2);
            attributes.addFlashAttribute("msg","第一次查询成功");
            System.out.println("111111");
            return "/ManageEmployee/list";
        }
        System.out.println(dept_num+"and"+employee_name);
        Employee employee = new Employee();
        employee.setDept_num(dept_num);
        employee.setEmployee_name(employee_name);
        List<Employee>  employeeList = manageEmployeeService.findEmployee(employee);
        model.addAttribute("list",employeeList);
        if (employeeList != null) {
            for (Employee employee1 : employeeList)
                System.out.println(employee1);
            attributes.addFlashAttribute("msg", "查询成功");
            System.out.println("22222222");
            return "/ManageEmployee/list";
        } else {
            attributes.addFlashAttribute("msg", "未查询到相关信息");
            System.out.println("333333333");
            return "/ManageEmployee/list";
        }
    }
}
