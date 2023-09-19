package com.huoranger.controller;

import com.huoranger.annotation.Datasource;
import com.huoranger.entity.User;
import com.huoranger.enums.DatasourceEnum;
import com.huoranger.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/datasource")
public class DatasourceController {

    @Resource
    private UserService userService;

    @GetMapping("/1")
    @Datasource(DatasourceEnum.DATASOURCE1)
    public List<User> datasource1() {
        return userService.users();
    }

    @GetMapping("/2")
    @Datasource(DatasourceEnum.DATASOURCE2)
    public List<User> datasource2() {
        return userService.users();
    }
}
