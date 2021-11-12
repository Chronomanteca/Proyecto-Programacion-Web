package com.example.proyectoprogramacionweb.Users.Enterprise.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Users.Enterprise.Application.Create.EnterpriseCreator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="Enterprise",description = "The Enterprise API")
@RequestMapping(value = "/enterprises")
public class CreateEnterprisePostController {

    @Autowired
    EnterpriseCreator creator;

    @Operation(summary = "Create a new Enterprise", description = "Create new Enterprise", tags = {"Enterprise"})
    @PostMapping(value = "/")
    public ResponseEntity execute(@RequestBody EnterpriseRequest request){
        this.creator.execute(request.getEnterpriseId(),request.getName(),request.getEnterpriseEmail(), request.getEnterprisePassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
    static class EnterpriseRequest{
        private String enterpriseId;
        private String name;
        private String enterpriseEmail;
        private String enterprisePassword;

        public String getEnterpriseEmail() {
            return enterpriseEmail;
        }

        public void setEnterpriseEmail(String enterpriseEmail) {
            this.enterpriseEmail = enterpriseEmail;
        }

        public String getEnterprisePassword() {
            return enterprisePassword;
        }

        public void setEnterprisePassword(String enterprisePassword) {
            this.enterprisePassword = enterprisePassword;
        }

        public String getEnterpriseId() {
            return this.enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public EnterpriseRequest(){}
    }
}
