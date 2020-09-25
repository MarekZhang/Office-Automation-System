<%--
  Created by IntelliJ IDEA.
  User: zhangbowen
  Date: 25/07/2020
  Time: 08:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
    <section id="content_wrapper">
        <section id="content" class="table-layout animated fadeIn">
            <div class="tray tray-center">
                <div class="content-header">
                    <h2> Add Department </h2>
                    <p class="lead"></p>
                </div>
                <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
                    <div class="panel heading-border">
                        <form id="admin-form" name="addForm" action="/department/add" method="post">
                            <div class="panel-body bg-light">
                                <div class="section-divider mt20 mb40">
                                    <span> Basic Information </span>
                                </div>
                                <div class="section row">
                                    <div class="col-md-6">
                                        <label for="sn" class="field prepend-icon">
                                            <input id="sn" name="sn" class="gui-input" placeholder="ID..." type="text" value=""/>
                                            <label for="sn" class="field-icon">
                                                <i class="fa fa-user"></i>
                                            </label>
                                        </label>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="name" class="field prepend-icon">
                                            <input id="name" name="name" class="gui-input" placeholder="Name..." type="text" value=""/>
                                            <label for="name" class="field-icon">
                                                <i class="fa fa-user"></i>
                                            </label>
                                        </label>
                                    </div>
                                </div>
                                <div class="section">
                                    <label for="address" class="field prepend-icon">
                                        <input id="address" name="address" class="gui-input" placeholder="Address..." type="text" value=""/>
                                        <label for="address" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="panel-footer text-right">
                                    <button type="submit" class="button"> Save </button>
                                    <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Quit </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

    </section>
<jsp:include page="bottom.jsp"/>