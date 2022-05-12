<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../assets/fontawesome-free-6.0.0-web/css/all.min.css">
<link rel="stylesheet" href="../assets/css/grid.css">
<link rel="stylesheet" href="../assets/css/style_admin.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <header class="header">
            <div class="header__brand">
                <span style="color: #3982b6;">My</span>
                <span style="color: #fff">Website</span>
            </div>

            <ul class="header__notification">
                <li><i class="fa-solid fa-envelope header__notification-icon"></i></li>
                <li><a href="../logout" class="header__logout">Login Out</a></li>
            </ul>
        </header>        
        
        <div class="body">
            <div class="grid wide-no-max-width">
                <div class="row no-gutters">
                    <div class="col l-2">
                        <div class="nav">
                            <div class="nav__user">
                                <div class="col l-5">
                                    <img src="https://ps.w.org/cbxuseronline/assets/icon-256x256.png?rev=2284897" alt="" width="100%">
                                </div>
                                <div class="col l-7">
                                    <h3 style="font-size: 1.4rem; word-break: break-word; padding-left: 4px;"><%
                                    	out.print(session.getAttribute("user"));
                                    %></h3>
                                    <div>
                                        <span class="nav__status"></span>
                                        <span style="font-size: 1.2rem; color: #AAA">ONLINE</span>
                                    </div>
                                </div>
                            </div>
    
                            <ul class="nav__list">
                                <li><i class="fa-solid fa-border-all" style="margin-right: 6px"></i> DashBoard</li>
                                <li><i class="fa-solid fa-user" style="margin-right: 6px"></i> Staff Manager</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col l-10">
                        <div class="body__main">
                            <div class="body__main-img">
                                <img src="http://www.vnphoto.net/data/p19/21017_img_9803_2756.jpg" alt="" width="100%">
                            </div>
                            
                            <div class="body__main-infor">
                                <table class="body__main-table">
                                    <tr>
                                        <td>ID</td>
                                        <td>Name</td>
                                        <td>MemberID</td>
                                        <td>Class</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Member1</td>
                                        <td>MemberID1</td>
                                        <td>Class1</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Member2</td>
                                        <td>MemberID2</td>
                                        <td>Class2</td>
                                    </tr>
                                </table>
                                <span class="body__main-heading">
                                    Member of the team
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>