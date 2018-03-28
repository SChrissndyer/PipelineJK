package com.revature.ajextest;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class MyServletTest {
    
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void correctUsernameInRequest() throws ServletException, IOException {
        request.addParameter("username", "scott");
        request.addParameter("password", "tiger");

        //servlet.doPost(request, response);

        assertEquals("text/html", response.getContentType());

        // ... etc
    }
}