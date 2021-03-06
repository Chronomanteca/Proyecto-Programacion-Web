package com.example.proyectoprogramacionweb.Users.Visitor.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Users.Visitor.Application.Create.VisitorCreator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="Visitor", description = "The Visitor API")
@RequestMapping(value = "/visitors")
public class VisitorCreatePostController {
    @Autowired
    private VisitorCreator creator;

    @Operation(summary = "Create a new Visitor", description = "Create new Visitor", tags = {"Visitor"})
    @PostMapping(value = "/")
    public ResponseEntity execute(@RequestBody VisitorRequest request){
        this.creator.execute(request.visitorId, request.name, request.age, request.phoneNumber, request.email,request.password);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class VisitorRequest{
        private String visitorId;
        private String name;
        private Integer age;
        private Long phoneNumber;
        private String email;
        private String password;

        public String getVisitorId() {
            return visitorId;
        }

        public void setVisitorId(String visitorId) {
            this.visitorId = visitorId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Long getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public VisitorRequest() {
        }
    }
}
