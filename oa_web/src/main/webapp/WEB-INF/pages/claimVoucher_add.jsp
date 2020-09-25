<%--
  Created by IntelliJ IDEA.
  User: zhangbowen
  Date: 27/07/2020
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>

<section id="content_wrapper">
    <section id="content" class="table-layout animated fadeIn">
        <div class="tray tray-center">
            <div class="content-header">
                <h2> Expense Claim Sheet </h2>
                <p class="lead"></p>
            </div>
            <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
                <div class="panel heading-border">
                    <form:form id="admin-form" name="addForm" action="/claim_voucher/add" modelAttribute="claimVoucherDTO">
                        <div class="panel-body bg-light">
                            <div class="section-divider mt20 mb40">
                                <span> Basic Information </span>
                            </div>
                            <div class="section">
                                <label for="claimVoucher.cause" class="field prepend-icon">
                                    <form:input path="claimVoucher.cause" cssClass="gui-input" placeholder="Purpose..."/>
                                    <label for="claimVoucher.cause" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section-divider mt20 mb40">
                                <span> Expense Claim Detials </span>
                            </div>
                            <div class="section row" id="items">
                                <div>
                                    <div class="col-md-3">
                                        <label for="items[0].item" class="field prepend-icon">
                                            <form:select path="items[0].item" cssClass="gui-input" placeholder="type of expense..." items="${items}"/>
                                        </label>
                                    </div>
                                    <div class="col-md-3">
                                        <label for="items[0].amount" class="field prepend-icon">
                                            <form:input path="items[0].amount" cssClass="gui-input money" placeholder="amount..."/>
                                            <label for="items[0].amount" class="field-icon">
                                                <i class="fa fa-lock"></i>
                                            </label>
                                        </label>
                                    </div>
                                    <div class="col-md-5">
                                        <label for="items[0].comment" class="field prepend-icon">
                                            <form:input path="items[0].comment" cssClass="gui-input" placeholder="remark..."/>
                                            <label for="items[0].comment" class="field-icon">
                                                <i class="fa fa-lock"></i>
                                            </label>
                                        </label>
                                    </div>
                                    <div class="col-md-1" style="text-align:right;">
                                        <button type="button" class="button"> X </button>
                                    </div>
                                </div>
                            </div>
                            <div class="section row">
                                <div class="col-md-3">
                                    <label for="totalMoney" class="field prepend-icon">
                                        <form:input id="totalMoney" path="claimVoucher.totalAmount" cssClass="gui-input" placeholder="Total Amount..." readonly="true" type="text"/>
                                        <label for="totalMoney" class="field-icon">
                                            <i class="fa fa-user"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="section" style="text-align:right;">
                                    <div class="col-md-9">
                                        <button type="button" class="button" id="addItemButton"> + </button>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer text-right">
                                <button type="submit" class="button"> Save </button>
                                <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Quit </button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </section>

</section>


<jsp:include page="bottom.jsp"/>
