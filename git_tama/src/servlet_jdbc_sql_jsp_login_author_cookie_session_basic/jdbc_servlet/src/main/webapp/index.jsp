<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link rel="stylesheet" href="FormList.css">
</head>
<body>

<header>
  <div>
    <img src="AC_Milan.png" alt="AC MILAN">
  </div>
  <h3 class="header-bar-text">Boss Cu Meo</h3>

</header>

<nav>
  <table>
    <tr>
      <td class="bar-menu-nav">
        <a href="index.jsp">Home</a>
      </td>
      <td class="bar-menu-nav">
        <a href="/customer?action=displayCustomer">Customer</a>
      </td>
      <td class="bar-menu-nav">
        <a href="/employee?action=displayEmployee">Employee</a>
      </td>
      <td class="bar-menu-nav">
        <a href="/service?action=displayService">Service</a>
      </td>
      <td class="bar-menu-nav">
        <a href="/contract?action=displayContract">Contract</a>
      </td>
    </tr>
  </table>
</nav>

<section>
  <aside>
    <ul>
      <li class="menu-side"><a href="#">New Type Customer </a></li>
      <li class="menu-side"><a href="#">New Position</a></li>
      <li class="menu-side"><a href="#">New Division</a></li>
      <li class="menu-side"><a href="#">New Education Degree</a></li>
      <li class="menu-side"><a href="#">New Service Type</a></li>
      <li class="menu-side"><a href="#">New Rent Type</a></li>
      <li class="menu-side"><a href="#">New Attach Service</a></li>
    </ul>
  </aside>

  <article>
    <table>

    </table>
  </article>

</section>

<footer>
  Write by Cú Mèo
</footer>

</body>
</html>