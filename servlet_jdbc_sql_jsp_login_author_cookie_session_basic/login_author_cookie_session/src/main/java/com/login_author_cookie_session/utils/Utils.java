package com.login_author_cookie_session.utils;

import com.login_author_cookie_session.models.Fish;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils<E> {
    public void setPageOffSetAtLimit(HttpServletRequest request, int MAX_LIMIT_DISPLAY, int list_number, String linkNextPage) {
        int max_page = (int) Math.ceil((float) list_number / MAX_LIMIT_DISPLAY);
        request.setAttribute("link", linkNextPage);
        request.setAttribute("max_page", max_page);
    }

    public static Fish createFishByResult(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int price = resultSet.getInt("price");
        String name = resultSet.getString("name");
        String type = resultSet.getString("type");
        Boolean gender = resultSet.getBoolean("gender");
        String avatar = resultSet.getString("avatar");
        return new Fish(id, price, name, type, gender, avatar);
    }

    public static boolean isEnoughPermissionAdmin(HttpServletRequest request) {
        if (SessionUtils.getInstance().getValue(request,"account") != null) {
            if (SessionUtils.getInstance().getValue(request, "account").getUsername().equalsIgnoreCase("admin")) {
                return true;
            }
        }

        Cookie[] cookies;
        cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie value : cookies) {
                if (value.getValue().equalsIgnoreCase("admin")) {
                    return true;
                }
            }
        }
        return false;
    }
}
