package com.example.proyectoprogramacionweb.Users.Enterprise.Infrastructure.Controllers;


import com.example.proyectoprogramacionweb.Users.Enterprise.Application.Login.EnterpriseLogin;
import com.example.proyectoprogramacionweb.Users.Enterprise.Application.Login.EnterpriseLoginResponse;
import com.example.proyectoprogramacionweb.Users.Visitor.Application.Login.VisitorLogin;
import com.example.proyectoprogramacionweb.Users.Visitor.Application.Login.VisitorLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Login")
public class LoginEnterprisePostController {

    public EnterpriseLogin getEnterpriseLogin() {
        return enterpriseLogin;
    }

    public void setEnterpriseLogin(EnterpriseLogin enterpriseLogin) {
        this.enterpriseLogin = enterpriseLogin;
    }

    @Autowired
    private EnterpriseLogin enterpriseLogin;


    @PostMapping(value = "/Enterprise")
    public ResponseEntity<HashMap<String, Object>> execute(@RequestBody EnterpriseLoginRequest request){
        EnterpriseLoginResponse response = this.enterpriseLogin.execute(request.getMail(),request.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    static  class EnterpriseLoginRequest{
        private String mail;
        private String password;

        public EnterpriseLoginRequest(String mail, String password) {
            this.mail = mail;
            this.password = password;
        }

        public EnterpriseLoginRequest() { }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
