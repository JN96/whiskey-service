package com.assignment.whiskeyauth.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Map;

public interface WhiskeyAuthController {

    Map getUser(final OAuth2Authentication user);

}
