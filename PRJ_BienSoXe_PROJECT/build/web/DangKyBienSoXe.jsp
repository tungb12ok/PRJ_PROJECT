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
                            <h5 class="card-title">Đăng ký biển số xe</h5>
                            <!-- Registration form -->
                            <form action="Regit" method="post">
                                <div class="form-group">
                                    <label for="licensePlate">Biển số xe:</label>
                                    <input type="text" class="form-control" id="licensePlate" name="licensePlate" required>
                                </div>
                                <div class="form-group">
                                    <label for="ownerName">Chủ sở hữu:</label>
                                    <input type="text" class="form-control" id="ownerName" name="ownerName" required>
                                </div>
                                <div class="form-group">
                                    <label for="ownerAddress">Địa chỉ chủ sở hữu:</label>
                                    <input type="text" class="form-control" id="ownerAddress" name="ownerAddress">
                                </div>
                                <div class="form-group">
                                    <label for="registrationDate">Ngày đăng ký:</label>
                                    <input type="date" class="form-control" id="registrationDate" name="registrationDate">
                                </div>
                                <button type="submit" class="btn btn-primary">Đăng ký</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <%@ include file="commons/footer.jsp" %>

    </body>
</html>
