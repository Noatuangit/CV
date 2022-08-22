package com.login_author_cookie_session.controller;

import com.login_author_cookie_session.models.Account;
import com.login_author_cookie_session.service.AccountService;
import com.login_author_cookie_session.utils.InitTable;
import com.login_author_cookie_session.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@WebServlet(name = "login", value = "/loginAccount")

public class Login extends HttpServlet {
    @Override
    public void init() {
//        try (Connection connection = InitTable.getConnect();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(InitTable.initDecentralization);
//            statement.executeUpdate(InitTable.initTableFish);
//            statement.executeUpdate(InitTable.initAccount);
//            statement.executeUpdate(InitTable.initTableOrder);
//            statement.executeUpdate(InitTable.insertDecentralization);
//            statement.executeUpdate(InitTable.insertAccount);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = Optional.ofNullable(req.getParameter("action")).orElse("login");
        switch (action) {
            case "loginAccount": {
                loginAccount(req, resp);
                break;
            }
            case "logoutAccount": {
                logoutAccount(req, resp);
                break;
            }
        }
    }

    private void logoutAccount(HttpServletRequest req, HttpServletResponse resp) {
        SessionUtils.getInstance().removeSession(req, "account");
        
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("username") ||
                    cookie.getName().equalsIgnoreCase("author")) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        try {
            resp.sendRedirect("/mainServlet?action=display");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loginAccount(HttpServletRequest req, HttpServletResponse resp) {
        AccountService service = new AccountService();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = Optional.ofNullable(req.getParameter("remember")).orElse("session");

        if (!service.isExistsAccount(username, password)) {
            req.setAttribute("massage", "Account not exists!!!");
            try {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        Account account = service.selectAccountByName(username, password);
        if (remember.equals("session")) {
//            HttpSession session = req.getSession();
//            session.setAttribute("account", service.selectAccountByName(username, password));
            SessionUtils.getInstance().putValue(req, "account", account);
        } else {
            Cookie uCookie = new Cookie("username", account.getUsername());
            Cookie authorCookie = new Cookie("author", account.getDecentralization().getAuthor());
            uCookie.setMaxAge(60 * 60 * 24);
            authorCookie.setMaxAge(60 * 60 * 24);
            resp.addCookie(uCookie);
            resp.addCookie(authorCookie);
        }
        try {
            req.setAttribute("message", String.format("Hello comeback %s", username));
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
