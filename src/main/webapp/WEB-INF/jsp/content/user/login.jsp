<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
 - Author   : Jacky Efendi
 - Name     : Jacky Efendi
 - Email    : jacky.efendi1@gmail.com
--%>

<br><br>
<div class="jumbotron">
    <div class="alert alert-info">
        <h4>Login</h4>
    </div>
    ${msg}
    <form:form modelAttribute="user" method="POST" action="${loginUrl}" class="form-horizontal" role="form">
        <div class="form-group">
            <form:label class="col-sm-2 control-label" path="username">Username</form:label>
            <div class="col-sm-5">
                <form:input type="text" class="form-control" placeholder="Username" path="username"></form:input>
            </div>
        </div>
        <div class="form-group">
            <form:label class="col-sm-2 control-label" path="password">Password</form:label>
            <div class="col-sm-5">
                <form:input type="password" class="form-control" placeholder="Password" path="password"></form:input>
            </div>
        </div>
        <input class="btn btn-primary" type="submit" value="Submit"/>
    </form:form>
</div>

