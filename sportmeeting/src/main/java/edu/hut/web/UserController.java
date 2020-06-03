package edu.hut.web;

import edu.hut.domain.User;
import edu.hut.dto.UserDTO;
import edu.hut.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller("UserController")
@RequestMapping("/user")
@SessionAttributes(value = {"user"},types = {User.class})
public class UserController {

    @Resource(name = "UserService")
    private UserService userService;

    //登录
    @RequestMapping("/login")
    public @ResponseBody User login(@RequestBody UserDTO userDTO, Model model){
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        User user = userService.login(username,password);
        if(user!=null){
            model.addAttribute("user",user);
        }
        return user;
    }

    //获取用户名
    @RequestMapping("/getUsername")
    public @ResponseBody Map<String,String> getUsername(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        return map;
    }

    //退出
    @RequestMapping("/exit")
    public @ResponseBody Map<String,String> exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        Map<String,String> map = new HashMap<>();
        map.put("isdel","yes");
        return map;
    }
}
