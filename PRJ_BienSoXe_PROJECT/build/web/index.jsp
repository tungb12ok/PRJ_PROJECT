<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tra cứu biển số xe</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <!-- Bootstrap JS and Popper.js (optional, for dropdowns) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="commons/navbar.jsp" />



        <!-- Your main content goes here -->
        <main class="container mt-4">
            <!-- News Slider -->
            <h2 class="text-center m-30">Tin tức</h2>
            <div id="newsSlider" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://tracuubiensoxe.net/wp-content/uploads/2022/07/1657551159388.jpg" class="d-block w-100" alt="News 1">
                    </div>
                    <div class="carousel-item">
                        <img src="https://tracuubiensoxe.net/wp-content/uploads/2022/07/Screenshot_2022-07-11-22-16-42-48.jpg" class="d-block w-100" alt="News 2">
                    </div>
                    <!-- Add more carousel items as needed -->
                </div>
                <a class="carousel-control-prev" href="#newsSlider" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#newsSlider" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <!-- License Plate Lookup -->
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Tra cứu biển số xe</h5>
                            <!-- Add your license plate lookup form here -->
                            <form action="TraCuu" method="get">
                                <div class="form-group">
                                    <label for="licensePlate">Biển số xe:</label>
                                    <input type="text" class="form-control" id="licensePlate" name="id" required>
                                </div>
                                <button type="submit" class="btn btn-primary">Tra cứu</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
            <c:if test="${mess != null}">
                <p class="text-danger">Không tìm thấy thông tin cho biển số xe này.</p>
            </c:if>
            <c:if test="${xe != null}">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Thông Tin Xe</h5>
                        <table class="table">
                            <tbody>
                                <tr>
                                    <th scope="row">Biển Số Xe:</th>
                                    <td>${xe.bienSo}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Chủ Sở Hữu:</th>
                                    <td>${b.chuSoHuu}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Địa Chỉ:</th>
                                    <td>${b.diaChiChuSoHuu}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Ngày Đăng Ký:</th>
                                    <td>${b.ngayDangKy}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Nhãn Hiệu:</th>
                                    <td>${xe.nhanHieu}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Màu Sắc:</th>
                                    <td>${xe.mauSac}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Năm Sản Xuất:</th>
                                    <td>${xe.namSanXuat}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>


            <!-- Other Sections -->
            <div class="mt-4">
                <h2>Xe nổi bật</h2>
                <!-- Add your featured vehicles section content here -->
                <p>Các xe đẹp và nổi bật trong danh sách.</p>
            </div>

            <div class="mt-4">
                <h2>Liên hệ</h2>
                <!-- Add your contact information section content here -->
                <p>Liên hệ chúng tôi để biết thêm thông tin.</p>
            </div>
        </main>

        <jsp:include page="commons/footer.jsp" />
        <style>
            /* Đặt kích thước tối đa cho hình ảnh trong carousel */
            #newsSlider .carousel-item img {
                max-height: 300px; /* Đặt chiều cao tối đa của ảnh */
                max-width: 100%; /* Đặt chiều rộng tối đa của ảnh */
                margin: auto; /* Đảm bảo hình ảnh được căn giữa trong khung hình */
            }
        </style>
    </body>
</html>
