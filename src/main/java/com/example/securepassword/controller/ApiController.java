package com.example.securepassword.controller;

import com.example.securepassword.record.BodyRequest;
import com.example.securepassword.record.FailureResponse;
import com.example.securepassword.service.PasswordService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ApiController {

    @Autowired
    private PasswordService passwordService;

    @Operation(summary = "Validate password", tags = "Password")
    @PostMapping(path = "/validate-password", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FailureResponse> password(@RequestBody BodyRequest request){

        List<String> failures = passwordService.validatePass(request.password());
        if (!failures.isEmpty()){
            return ResponseEntity.badRequest().body(new FailureResponse(failures));
        }
        return ResponseEntity.ok().build();
    }
}
