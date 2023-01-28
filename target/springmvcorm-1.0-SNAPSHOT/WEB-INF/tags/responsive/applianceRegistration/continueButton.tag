<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="buttonLabel" required="false" %>
<%@ attribute name="buttonCss" required="false" %>
<%@ attribute name="wrapperCss" required="false" %>

<c:if test="${empty buttonLabel}">
    <c:set var="buttonLabel" value="CONTINUE"/>
<%--    <c:set var="buttonLabel" value="checkout.multi.hostedOrderPageError.continue"/>--%>
</c:if>
<c:if test="${empty buttonCss}">
    <c:set var="buttonCss" value="col-md-6 col-md-offset-6 text__align__center"/>
</c:if>
<c:if test="${empty wrapperCss}">
    <c:set var="wrapperCss" value="row"/>
</c:if>


<div class="${wrapperCss}">
    <div class="${buttonCss}">
        <button type="submit" class="button button-full button--transparent-drk" tabindex="46">
            <label>${buttonLabel}</label>
<%--            <spring:theme code="${buttonLabel}"/>--%>
        </button>
    </div>
</div>