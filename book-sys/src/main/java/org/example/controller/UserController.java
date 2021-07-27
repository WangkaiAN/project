package org.example.controller;

import org.example.exception.AppException;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据抓包数据
     * */
    @PostMapping("/login")
    public Object login(@RequestBody User input,
                        HttpServletRequest req){
        User query = userService.queryByUsername(input.getUsername());
        if(query == null){
            throw new AppException("用户不存在");
        }
        if(query.getPassword().equals(input.getPassword())){
            throw new AppException("账号或密码错误");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",query);
        return null;
    }
    /**
     * /api/user/logout
     * */
    @GetMapping("/logout")
    public Object logout(HttpSession session){
        session.removeAttribute("user");
        return null;
    }

    /**
     * /api/user/query
     * */
    @GetMapping("/query")
    public Object query(User user){
        List<User> users = userService.query(user);
        return users;
    }
    /**
     * /api/user/register
     * */
    @PostMapping("/register")
    public Object register(@RequestBody User user){
        int n = userService.register(user);
        return null;
    }
    /**
     * /api/user/queryById
     * */
    @GetMapping("/queryById")
    public Object queryById(Integer id){
        User user = userService.queryById(id);
        return user;
    }
    /**
     * /api/user/update
     * Post
     * */
    @PostMapping("/update")
    public Object update(@RequestBody User user){
        int n = userService.update(user);
        return null;
    }
    /**
     * /api/user/delete?
     * Get
     * */
    @GetMapping("/delete")
    public Object delete(@RequestParam("ids") List<Integer> ids){
        int n = userService.delete(ids);
        return null;
    }
}
