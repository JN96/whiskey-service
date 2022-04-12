package com.assignment.whiskeyauth.rest;

import com.assignment.whiskeyauth.controller.WhiskeyAuthController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class WhiskeyAuthRestResource {

    @Autowired
    private WhiskeyAuthController whiskeyAuthController;

    private static final Logger logger = LoggerFactory.getLogger(WhiskeyAuthRestResource.class);

    @PostMapping("/user")
    public Map<String, Object> getUser(final OAuth2Authentication user) {
        try {
            return whiskeyAuthController.getUser(user);
        } catch (final Exception e) {
            return null;
        }
    }

}
