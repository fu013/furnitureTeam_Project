package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import our.example.furniture.dto.*;
import our.example.furniture.repository.*;

@Controller
public class RegisterController {
    @Autowired
    private RegisterMapper registerMapper;

    private Log log = LogFactory.getLog(this.getClass());

    @PostMapping("/registerSuccess")
    public String RegisterSuccess(RegisterDto registerDto) {
        registerMapper.insertRegister(registerDto);
        return "index";
    }
}
