package cn.yznu.csi.controller;

import cn.yznu.csi.dao.DeptDao;
import cn.yznu.csi.pojo.Dept;
import cn.yznu.csi.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ZHY
 * @date 2020/7/11 17:04
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public String index2(Model model) {
        List<Dept> dept_list = deptService.findAllDept();
        for (Dept dept : dept_list) {
            System.out.println(dept);
        }
        model.addAttribute("list", dept_list);
        return "dept/list";
    }

    @GetMapping("/list/{dept_num}/delete")
    public String delete(@PathVariable long dept_num, RedirectAttributes attributes) {
        System.out.println("dept_num123");
        System.out.println(dept_num + "String");
//        int a = Integer.parseInt(dept_num);
//        System.out.println(a+"int");
        deptService.deleteDept(dept_num);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/dept";
    }

    @GetMapping("/add")
    public String add() {
        return "/dept/add";
    }

    @PostMapping("/add/a")
    public String add(
            @RequestParam String dept_name,
            @RequestParam long leader_id,
            @RequestParam String duty,
            RedirectAttributes attributes) {
        if (dept_name == null || dept_name == "") {
            attributes.addFlashAttribute("msg", "添加失败，名称不能为空");
            return "redirect:/dept/add";
        }
        Dept dept = new Dept();
//        Long l=Long.parseLong(leader_id);
        dept.setLeader_id(leader_id);
        dept.setDuty(duty);
        dept.setDept_name(dept_name);
        int n = deptService.addDept(dept);
        if (n != 0) {
            attributes.addFlashAttribute("msg", "添加成功");
            return "redirect:/dept";
        } else {
            attributes.addFlashAttribute("msg", "添加失败，请验证");
            return "redirect:/dept/add";
        }
    }

//    @GetMapping("/update")
//    public String updatehtml(){
//        return "/dept/add";
//    }

    @GetMapping("/list/{dept_num}/update")
    public String update(@PathVariable long dept_num , Model model) {
        System.out.println("-------22222test getInfo---------");
        Dept dept=deptService.getInfo(dept_num);
        System.out.println(dept.toString());
        model.addAttribute("dept",dept);
        return "/dept/update";
    }

    @PostMapping("/update/a")
    public String update(
            @RequestParam Long dept_num,
            @RequestParam String dept_name,
            @RequestParam Long leader_id,
            @RequestParam String duty,
            RedirectAttributes attributes) {
        if (dept_name == null || dept_name == "") {
            attributes.addFlashAttribute("msg", "修改失败，名称不能为空");
            return "redirect:/dept";
        }
        System.out.println("1111111111111111");
        Dept dept = new Dept();
        dept.setLeader_id(leader_id);
        dept.setDept_num(dept_num);
        dept.setDuty(duty);
        dept.setDept_name(dept_name);
        System.out.println(dept.toString());
        int n = deptService.updateDept(dept);
        if (n != 0) {
            attributes.addFlashAttribute("msg", "修改成功");
            return "redirect:/dept";
        } else {
            attributes.addFlashAttribute("msg", "添加失败，请验证");
            return "/dept/update";
        }
    }

}