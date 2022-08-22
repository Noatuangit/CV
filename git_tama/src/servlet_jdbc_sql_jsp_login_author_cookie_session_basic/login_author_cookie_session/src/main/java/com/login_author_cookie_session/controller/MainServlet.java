package com.login_author_cookie_session.controller;

import com.login_author_cookie_session.models.Fish;
import com.login_author_cookie_session.service.FishService;
import com.login_author_cookie_session.utils.QuerySelectTable;
import com.login_author_cookie_session.utils.Utils;
import com.login_author_cookie_session.utils.ValidData;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "main", value = "/mainServlet")
public class MainServlet extends HttpServlet {
    public void init() {

    }

    final int MAX_DISPLAY_IN_LIST = 8;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("display");
        switch (action) {
            case "addNew": {
                displayFormFishAdd(request, response);
                break;
            }
            case "edit": {
                displayFormFishEdit(request, response);
                break;
            }
            case "display": {
                displayMainMenu(request, response);
                break;
            }
            case "infoFish": {
                infoFishSelect(request, response);
                break;
            }
        }
    }

    private void infoFishSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FishService fishService = new FishService();
        int id = Integer.parseInt(request.getParameter("id"));
        Fish fish = fishService.searchById(id);
        request.setAttribute("fish", fish);
        request.getRequestDispatcher("InfoFish.jsp").forward(request, response);
    }

    private void displayFormFishEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Utils.isEnoughPermissionAdmin(request)) {
            request.getRequestDispatcher("EditFish.jsp").forward(request, response);
            return;
        }
        request.setAttribute("message", "Not Permission To Create");
        displayMainMenu(request, response);
    }

    private void displayMainMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FishService fishService = new FishService();
        int offset = Integer.parseInt(Optional.ofNullable(request.getParameter("offset")).orElse("0"));
        List<Fish> fishList = fishService.getListFollow(QuerySelectTable.Fish, MAX_DISPLAY_IN_LIST, offset);
        int count_list = fishService.countListFollow(QuerySelectTable.countFish);
        Utils<Fish> utils = new Utils<>();
        utils.setPageOffSetAtLimit(request, MAX_DISPLAY_IN_LIST, count_list, "/mainServlet?action=display");
        request.setAttribute("list", fishList);
        request.getRequestDispatcher("MainList.jsp").forward(request, response);

    }

    private void displayFormFishAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Utils.isEnoughPermissionAdmin(request)) {
            request.getRequestDispatcher("Create.jsp").forward(request, response);
            return;
        }
        request.setAttribute("message", "Not Permission To Create");
        displayMainMenu(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "addNew": {
                addFish(request, response);
                break;
            }
            case "edit": {
                editFish(request, response);
                break;
            }
        }
    }


    private void addFish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkValid = ValidData.isNotCorrectData(request, "name", "price");
        if (!checkValid.equalsIgnoreCase("true")) {
            request.setAttribute("message", checkValid);
            request.getRequestDispatcher("Create.jsp").forward(request, response);
            return;
        }
        FishService fishService = new FishService();
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String type = ValidData.hasNotEmptyData(request,response,"type","Create.jsp");
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        String avatar = ValidData.hasNotEmptyData(request,response,"avatar","Create.jsp");
        fishService.addNew(new Fish(0, price, name, type, gender, avatar));
        request.setAttribute("message", "add new success!!!");
        request.getRequestDispatcher("Create.jsp").forward(request, response);
    }

    private void editFish(HttpServletRequest request, HttpServletResponse response) {
    }


    public void destroy() {

    }
}