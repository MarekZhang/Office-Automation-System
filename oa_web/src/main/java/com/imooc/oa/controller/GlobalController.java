package com.imooc.oa.controller;

import com.imooc.oa.biz.GlobalBiz;
import com.imooc.oa.entity.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller("globalController")
public class GlobalController {
  @Resource(name="globalBiz")
  GlobalBiz globalBiz;

  @RequestMapping("/to_login")
  public String toLogin(){
    return "toLogin";
  }

  @RequestMapping("/login")
  public String login(HttpSession session, @RequestParam String sn, @RequestParam String password){
    Employee employee = globalBiz.login(sn, password);
    if(employee != null){
      session.setAttribute("SessionEmployee", employee);
      return "redirect:detail";
    }
    return "redirect:to_login";
  }

  @RequestMapping("/detail")
  public String login(){
    return "detail";
  }

  @RequestMapping("/quit")
  public String quit(HttpSession session){
    session.setAttribute("SessionEmployee", null);
    return "redirect:to_login";
  }

  @RequestMapping("/to_change_password")
  public String toChangePassword(){
    return "change_psw";
  }

  @RequestMapping("/change_password")
  public String changePassword(HttpSession session, String prevPsw, String newPsw1, String newPsw2) {
    Employee employee = (Employee) session.getAttribute("SessionEmployee");
    if(prevPsw.equals(employee.getPassword())){
      if(newPsw1.equals(newPsw2)){
        employee.setPassword(newPsw1);
        globalBiz.changePassword(employee);
        session.setAttribute("SessionEmployee", null);
        return "redirect:to_login";
      }
    }
    return "redirect:to_change_password";
  }
}
