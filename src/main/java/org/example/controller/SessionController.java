package org.example.controller;

import org.example.AppFrame;

public class SessionController {
    AppFrame context;
    String token;

    public SessionController(AppFrame context) {
        this.context = context;
        this.token = null;
    }

    public SessionController(AppFrame context, String token) {
        this.context = context;
        this.token = token;
    }

    public void invalidate(){
        System.out.println("auth check");
        if(isAuth()){
            System.out.println("Changing to [LandingPage]");
            context.bringToLandingPage();

            return;
        }
        System.out.println("Changing to [SignUpPage]");
        context.bringToSignUp();
    }

    public boolean isAuth() {
        return token != null && token.length() > 0;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
