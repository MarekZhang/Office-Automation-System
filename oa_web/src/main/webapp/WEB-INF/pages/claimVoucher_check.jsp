<%--
  Created by IntelliJ IDEA.
  User: zhangbowen
  Date: 30/07/2020
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.imooc.oa.global.Constant" %>
<jsp:include page="top.jsp"/>


<section id="content_wrapper">
    <section id="content" class="table-layout animated fadeIn">
        <div class="tray tray-center">
            <div class="content-header">
                <h2> Expense Claim Sheet Details </h2>
                <p class="lead"></p>
            </div>
            <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
                <div class="panel heading-border">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> Basic Information </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-2">Purpose</div>
                            <div class="col-md-6">${claimVoucher.cause}</div>
                        </div>
                        <div class="section row">
                            <div class="col-md-2">Creator</div>
                            <div class="col-md-4">${claimVoucher.creator.name}</div>
                            <div class="col-md-2">Create Time</div>
                            <div class="col-md-4"><spring:eval expression="claimVoucher.createTime" /></div>
                        </div>
                        <div class="section row">
                            <div class="col-md-2">Next Approver</div>
                            <div class="col-md-4">${claimVoucher.dealer.name}</div>
                            <div class="col-md-2">Status</div>
                            <div class="col-md-4">${claimVoucher.status}</div>
                        </div>
                        <div class="section-divider mt20 mb40">
                            <span> Expense Claim Details </span>
                        </div>
                        <div class="section row">
                            <c:forEach items="${claimVoucherItems}" var="claimItems">
                                <div class="col-md-3">${claimItems.item}</div>
                                <div class="col-md-3">${claimItems.amount}</div>
                                <div class="col-md-5">${claimItems.comment}</div>
                            </c:forEach>
                        </div>
                        <div class="section row">
                            <div class="col-md-2">Total Amount</div>
                            <div class="col-md-6">${claimVoucher.totalAmount}</div>
                        </div>
                        <div class="section-divider mt20 mb40">
                            <span> Processing Flow </span>
                        </div>
                        <div class="section row">
                            <c:forEach items="${dealRecord}" var="record">
                                <div class="col-md-1">${record.dealSn}</div>
                                <div class="col-md-3"><spring:eval expression="record.dealTime"/> </div>
                                <div class="col-md-1">${record.dealWay}</div>
                                <div class="col-md-2">${record.dealWay}</div>
                                <div class="col-md-5">Remark: ${record.comment}</div>
                            </c:forEach>
                        </div>
                        <form:form id="admin-form" name="addForm" action="/claim_voucher/check" modelAttribute="record">
                            <form:hidden path="claimVoucherId" />
                            <div class="panel-body bg-light">
                                <div class="section">
                                    <label for="comment" class="field prepend-icon">
                                        <form:input path="comment" cssClass="gui-input" placeholder="remark..."/>
                                        <label for="comment" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="panel-footer text-right">

                                    <c:if test="${sessionScope.SessionEmployee.post==Constant.POST_FM || sessionScope.SessionEmployee.post==Constant.POST_GM}">
                                        <button type="submit" class="button" name="dealWay" value="${Constant.DEAL_PASS}" >${Constant.DEAL_PASS}</button>
                                        <button type="submit" class="button" name="dealWay" value="${Constant.DEAL_BACK}" >${Constant.DEAL_BACK}</button>
                                        <button type="submit" class="button" name="dealWay" value="${Constant.DEAL_REJECT}" >${Constant.DEAL_REJECT}</button>
                                    </c:if>
                                    <c:if test="${sessionScope.SessionEmployee.post==Constant.POST_CASHIER}">
                                        <button type="submit" class="button" name="dealWay" value="${Constant.DEAL_PAID}" >${Constant.DEAL_PAID}</button>
                                    </c:if>
                                    <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Quit </button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </section>

</section>


<jsp:include page="bottom.jsp"/>

