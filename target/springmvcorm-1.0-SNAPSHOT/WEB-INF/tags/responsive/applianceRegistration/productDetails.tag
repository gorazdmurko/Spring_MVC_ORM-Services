<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="productData" required="true" type="si.zenlab.gg.askostorefront.controllers.forms.ProductConfirmForm" %>
<%@ attribute name="dateString" required="true" type="java.util.Date" %>
<%@ attribute name="warrantyEnd" required="true" type="java.util.Date" %>
<%@ attribute name="extendedWarranties" required="false" type="java.util.List" %>


<div class="row">
    <div class="register__overview-list-img col-xs-5">
        <img src="${productData.imageUrl}">
    </div>
    <div class="favourites__overview-list-content col-sm-6 col-xs-12">
        <div class="favourites__overview-list-product">
            <a href="${cmsContextPath}/p/${productData.productCode}">
                ${productData.customName} <c:out value=" "/> ${productData.productName}
            </a>
        </div>
        <div class="favourites__overview-list-category">
            <p>
                ${productData.productSpec}
            </p>
        </div>
        <div class="favourites__overview-list-sn">
                <span class="sn white__text_c">
                    <spring:theme code="applianceregistration.text.serialnumbershort"/>
                </span>
            ${productData.serialNumber}
            <br/>
            <c:if test="${not empty dateString}">
                    <span class="sn white__text_c">
                        <spring:theme code="applianceregistration.text.purchased"/>
                    </span>
                &nbsp;
                <fmt:formatDate pattern="dd.MM.yyyy" value="${dateString}"/>
                <br/>
            </c:if>
            <c:if test="${not empty warrantyEnd}">
                    <span class="sn white__text_c">
                        <spring:theme code="applianceregistration.text.warrentyTill"/>
                    </span>
                &nbsp;
                <fmt:formatDate pattern="dd.MM.yyyy" value="${warrantyEnd}"/>
                <br/>
            </c:if>
            <c:if test="${not empty extendedWarranties}">
                <c:forEach var="warranty" items="${extendedWarranties}">
                          <span class="sn white__text_c">
                                  ${warranty.name}
                          </span>
                    &nbsp;
                    <fmt:formatDate pattern="dd.MM.yyyy" value="${warranty.endDate}"/>
                    <br/>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
