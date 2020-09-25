<%--
  Created by IntelliJ IDEA.
  User: zhangbowen
  Date: 25/07/2020
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>

<section id="content_wrapper">
    <section id="content" class="table-layout animated fadeIn">
        <div class="tray tray-center">
            <div class="content-header">
                <h2> Expense Claim Sheet</h2>
                <p class="lead"></p>
            </div>
            <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
                <div class="panel heading-border">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> Basic Information </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-2">Staff ID</div>
                            <div class="col-md-4">${sessionScope.SessionEmployee.sn}</div>
                            <div class="col-md-2">Name</div>
                            <div class="col-md-4">${sessionScope.SessionEmployee.name}</div>
                        </div>
                        <div class="section row">
                            <div class="col-md-2">Department</div>
                            <div class="col-md-4">${sessionScope.SessionEmployee.departmentSn}</div>
                            <div class="col-md-2">Duty</div>
                            <div class="col-md-4">${sessionScope.SessionEmployee.post}</div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Quit </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>


<jsp:include page="bottom.jsp"/>
