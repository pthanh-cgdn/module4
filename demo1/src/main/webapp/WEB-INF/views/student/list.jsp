<%--
  Created by IntelliJ IDEA.
  User: tphan
  Date: 28/6/24
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">CodeGyme</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/student">Student</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Teacher</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Class</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<a href="/students?action=create">
    <button class="btn btn-primary mt-4">Thêm</button>
</a>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Order</th>
        <th>Name</th>
        <th>Address</th>
        <th>Point</th>
        <th>Student type</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}" varStatus="order">
    <tr>
        <td>${order.count}</td>
        <td>${student.name}</td>
        <td>${student.address}</td>
        <td>${student.point}</td>
        <td>
            <c:choose>
                <c:when test="${student.point >=8}">Hoc sinh gioi</c:when>
                <c:when test="${student.point >=6.5}">Hoc sinh kha</c:when>
                <c:when test="${student.point >=5}">Hoc sinh trung binh</c:when>
                <c:otherwise>Hoc sinh yeu</c:otherwise>
            </c:choose>
        </td>
        <td>
            <a href="/students?action=edit&id=${student.id}"><button class="btn btn-warning">Sửa</button></a>
            <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal${student.id}">Xóa
            </button>
            <div class="modal fade" id="deleteModal${student.id}" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Xóa học sinh</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Bạn có muốn xóa học sinh có tên là ${student.name}?
                            <p style="color: red">Hành động này không thể hoàn tác!!!!!</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                            <form method="post" action="/students?action=delete">
                                <button type="submit" class="btn btn-primary">Xác nhận</button>
                                <input type ="hidden" name="id" value="${student.id}">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </td>
        </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
