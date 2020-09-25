<%--
  Created by IntelliJ IDEA.
  User: zhangbowen
  Date: 25/07/2020
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="top.jsp"/>

<section id="content_wrapper">
    <section id="content" class="table-layout animated fadeIn">
        <div class="tray tray-center">
            <div class="content-header">
                <h2> Add Staff </h2>
                <p class="lead"></p>
            </div>
            <div class="admin-form theme-primary mw1000 center-block"
                 style="padding-bottom: 175px;">
                <div class="panel heading-border">
                    <form id="admin-form" name="addForm" action="/employee/add" method="post">
                        <div class="panel-body bg-light">
                            <div class="section-divider mt20 mb40">
                                <span> Basic Information </span>
                            </div>
                            <div class="section row">
                                <div class="col-md-6">
                                    <label for="sn" class="field prepend-icon">
                                        <input id="sn" name="sn" class="gui-input"
                                               placeholder="Staff ID..." type="text" value=""/>
                                        <label for="sn" class="field-icon">
                                            <i class="fa fa-user"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-6">
                                    <label for="name" class="field prepend-icon">
                                        <input id="name" name="name" class="gui-input"
                                               placeholder="Name..." type="text" value=""/>
                                        <label for="name" class="field-icon">
                                            <i class="fa fa-user"></i>
                                        </label>
                                    </label>
                                </div>
                            </div>
                            <div class="section row">
                                <div class="col-md-6">
                                    <label for="sn" class="field select">
                                        <select id="departmentSn" name="departmentSn"
                                                class="gui-input" placeholder="Department...">
                                            <c:forEach items="${dlist}" var="dep">
                                                <option value="${dep.sn}">${dep.name}</option>
                                            </c:forEach>
                                        </select>
                                        <i class="arrow double"></i>
                                    </label>
                                </div>
                                <div class="col-md-6">
                                    <label for="post" class="field select">
                                        <select id="post" name="post" class="gui-input"
                                                placeholder="Duty...">
                                            <c:forEach items="${plist}" var="pos">
                                                <option value=${pos}>${pos}</option>
                                            </c:forEach>
                                        </select>
                                        <i class="arrow double"></i>
                                    </label>
                                </div>
                            </div>
                            <div class="panel-footer text-right">
                                <button type="submit" class="button"> Save</button>
                                <button type="button" class="button"
                                        onclick="javascript:window.history.go(-1);"> Quit
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

</section>

<jsp:include page="bottom.jsp"/>