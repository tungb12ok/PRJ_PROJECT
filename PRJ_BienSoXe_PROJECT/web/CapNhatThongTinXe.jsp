<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng ký biển số xe</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <!-- Bootstrap JS and Popper.js (optional, for dropdowns) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <%@ include file="commons/navbar.jsp" %>

        <main class="container mt-4">
            <jsp:include page="commons/mess.jsp" />

            <div class="row">
                <div class="col-md-6 offset-md-3">

                    <div class="card">
                        <div class="card-body">
                            <h2>Cập Nhật Thông Tin Xe</h2>
                            <form action="UpdateVehicle" method="post">
                                <!-- Input fields for updating information -->
                                <div class="form-group">
                                    <label for="bienSo">Biển số:</label>
                                    <input type="text" class="form-control" id="bienSo" name="bienSo" value="${thongTinXe.bienSo}" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="loaiXe">Loại xe:</label>
                                    <select class="form-control" id="loaiXe" name="loaiXe">
                                        <c:forEach var="x" items="${listXe}">
                                            <option value="${x.getLoaiXe()}" ${thongTinXe.loaiXe == x.getLoaiXe() ? 'selected' : ''}>${x.getDescription()}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="nhanHieu">Hãng:</label>
                                    <input type="text" class="form-control" id="nhanHieu" name="nhanHieu" value="${thongTinXe.nhanHieu}">
                                </div>
                                <div class="form-group">
                                    <label for="mauSac">Màu sắc:</label>
                                    <input type="text" class="form-control" id="mauSac" name="mauSac" value="${thongTinXe.mauSac}">
                                </div>
                                <div class="form-group">
                                    <label for="namSanXuat">Màu sản xuất:</label>
                                    <input type="text" class="form-control" id="namSanXuat" name="namSanXuat" value="${thongTinXe.namSanXuat}">
                                </div>
                                <div class="form-group">
                                    <label for="soKhung">Số Khung:</label>
                                    <input type="text" class="form-control" id="soKhung" name="soKhung" value="${thongTinXe.soKhung}">
                                </div>
                                <div class="form-group">
                                    <label for="soMay">Số máy:</label>
                                    <input type="text" class="form-control" id="soMay" name="soMay" value="${thongTinXe.soMay}">
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Cập Nhật</button>
                                    <!-- Delete button -->
                                    <a href="updateInfo?id=${thongTinXe.bienSo}&status=BAN" class="btn btn-danger">Ban</a>

                                    <!-- View button -->
                                    <a href="updateInfo?id=${thongTinXe.bienSo}&status=Valid" class="btn btn-info">Xác thực</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <%@ include file="commons/footer.jsp" %>

    </body>
</html>
