package com.assignment.whiskeyauth.service;

import com.assignment.whiskeyauth.controller.WhiskeyAuthController;
import com.assignment.whiskeyauth.rest.WhiskeyAuthRestResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WhiskeyAuthImpl implements WhiskeyAuthController {

    private static final Logger logger = LoggerFactory.getLogger(WhiskeyAuthRestResource.class);

    @Override
    public Map getUser(final OAuth2Authentication user) {
        try {
            final Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("user", user.getUserAuthentication().getPrincipal());
            userInfo.put("authorities", AuthorityUtils.authorityListToSet(
                    user.getUserAuthentication().getAuthorities()));
            return userInfo;
        } catch (final Exception e) {
            logger.info("Unable to retrieve details for user {}", e.getMessage());
            return null;
        }
    }

}
