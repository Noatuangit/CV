package com.login_author_cookie_session.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ValidData {
    static Map<String, String> mapData = new HashMap<>();

    static {
        mapData.put("name", "^[a-zA-Z ,.'-]+$");
        mapData.put("price", "^\\d+$");
    }

    public static String isNotCorrectData(HttpServletRequest request, String name, String price) {
        if (!request.getParameter(name).matches(mapData.get(name))) {
            return "Name Not Have Number";
        }

        if (!request.getParameter(price).matches(mapData.get(price))) {
            return "Price must bigger zero";
        }
        return "true";
    }

    public static String hasNotEmptyData(HttpServletRequest request, HttpServletResponse response, String name, String pathReturn) throws ServletException, IOException {
        String result = request.getParameter(name);
        if (result.trim().isEmpty()) {
            request.setAttribute("message",name + " not Empty");
            request.getRequestDispatcher(pathReturn).forward(request,response);
        }
        return result;
    }
}

