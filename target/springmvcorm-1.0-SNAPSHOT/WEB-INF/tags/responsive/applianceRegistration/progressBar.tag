<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="pring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="noSteps" required="true" %>
<%@ attribute name="currStep" required="true" %>

<div>
    <div class="row no__margin">
        <div class="col-md-12">
            <div class="address-header">
                <div class="address-header__steps u--align-center">
                    <ul class="step-progress progressbar__text">
                        <c:forEach begin="1" end="${noSteps}" varStatus="loop">
                            <c:choose>
                                <c:when test="${loop.current > currStep}">
                                    <c:set var="cssClass" value="milestone--pass-curr"/>
                                </c:when>
                                <c:when test="${loop.current == currStep}">
                                    <c:set var="cssClass" value="milestone--active"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="cssClass" value=""/>
                                </c:otherwise>
                            </c:choose>

                            <li class="step-progress__milestone ${cssClass}">
                                <div class="step-progress__tail"></div>
                                <div class="step-progress__circle"></div>
                                <div class="step-progress__text">
                                    <div class="step-progress__number">
                                            ${loop.current}
                                    </div>
                                    <span>
<%--                                        <spring:theme code="applianceregistration.step.description.${loop.current}"/>--%>
                                        <spring:theme text="DESCRIPTION ${loop.current}" />
                                    </span>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="address-header__headline">
                    <div class="address-header">
                        <div class="address-header__headline">
                            <h3 class="address-header__heading u--uppercase u--align-center">
                                <c:choose>
                                    <c:when test="${registrationType=='update'}">
<%--                                        <spring:theme code="applianceregistration.text.updateyourappliances"/>--%>
                                        <spring:theme text="Update your Appliance" />
                                    </c:when>
                                    <c:otherwise>
<%--                                        <spring:theme code="applianceregistration.text.registeryourappliances"/>--%>
                                        <pring:theme text="Register your Appliance" />
                                    </c:otherwise>
                                </c:choose>
                            </h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>