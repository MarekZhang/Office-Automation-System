<%--
  Created by IntelliJ IDEA.
  User: zhangbowen
  Date: 25/07/2020
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>

<section id="content_wrapper">
    <section id="content" class="table-layout animated fadeIn">
        <div class="tray tray-center">
            <div class="content-header">
                <h2> Change Password </h2>
                <p class="lead"></p>
            </div>
            <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
                <div class="panel heading-border">
                    <form method="post" action="/change_password" id="admin-form">
                        <div class="panel-body bg-light">
                            <div class="section-divider mt20 mb40">
                                <span> Basic Information </span>
                            </div>
                            <div class="section row">
                                <div class="col-md-6">
                                    <label for="old" class="field prepend-icon">
                                        <input type="password" name="prevPsw" id="old" class="gui-input" placeholder="Original Password...">
                                        <label for="old" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                            </div>
                            <div class="section row">
                                <div class="col-md-6">
                                    <label for="new1" class="field prepend-icon">
                                        <input type="password" name="newPsw1" id="new1" class="gui-input" placeholder="New Password...">
                                        <label for="new1" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-6">
                                    <label for="new2" class="field prepend-icon">
                                        <input type="password" name="newPsw2" id="new2" class="gui-input" placeholder="Confirmed Password...">
                                        <label for="new2" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                            </div>
                            <div class="panel-footer text-right">
                                <button type="submit" class="button"> Submit </button>
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
