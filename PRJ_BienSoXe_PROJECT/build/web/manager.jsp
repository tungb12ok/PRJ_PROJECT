<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .btn-group a {
                text-decoration: none;
                color: white;
            }

            th.sortable {
                cursor: pointer;
            }

            th.sortable::after {
                content: '\25B2'; /* Unicode character for upward arrow */
                padding-left: 5px;
                opacity: 0.6;
            }

            th.asc::after {
                content: '\25B2'; /* Unicode character for upward arrow */
                opacity: 1;
            }

            th.desc::after {
                content: '\25BC'; /* Unicode character for downward arrow */
                opacity: 1;
            }
        </style>

    </head>
    <body>

        <jsp:include page="commons/navbar.jsp" />

        <div class="container mt-5">
            <h1>Danh Sách Biển Số Xe</h1>
            <jsp:include page="commons/mess.jsp" />

            <input type="text" id="searchInput" placeholder="Search...">
            <hr>
            <a href="Regit" class="btn btn-success">
                Đăng Ký Biển Số Xe
            </a>
            <table class="table">
                <thead>
                    <tr>
                        <th class="sortable" onclick="sortTable(0)">Biển số xe</th>
                        <th class="sortable" onclick="sortTable(1)">Chủ sở hữu</th>
                        <th class="sortable" onclick="sortTable(2)">Địa chỉ</th>
                        <th class="sortable" onclick="sortTable(3)">Ngày Đăng Ký</th>
                        <th class="sortable" onclick="sortTable(4)">Status</th>
                        <th class="sortable" onclick="sortTable(5)">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Sample data, replace this with dynamic data from your server-side -->
                    <c:forEach var="i" items="${list}">
                        <tr>
                            <td>${i.bienSo}</td>
                            <td>${i.chuSoHuu}</td>
                            <td>${i.diaChiChuSoHuu}</td>
                            <td>${i.ngayDangKy}</td>
                            <td>${i.status}</td>
                            <td>
                                <a href="UpdateVehicle?id=${i.bienSo}" class="btn btn-success">Thông Tin xe</a>
                                <c:if test="${i.status ne 'Active'}">
                                    <a href="ActiveBien?id=${i.bienSo}" class="btn btn-primary">Xác Thực</a>
                                </c:if>
                            </td>

                        </tr>
                    </c:forEach>
                    <!-- Add more rows for additional orders -->
                </tbody>
            </table>
        </div>

        <jsp:include page="commons/footer.jsp" />
        <script>
            // Filter functionality
            document.getElementById("searchInput").addEventListener("keyup", function () {
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("searchInput");
                filter = input.value.toUpperCase();
                table = document.querySelector(".table");
                tr = table.getElementsByTagName("tr");

                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[1]; // Change index to match the column you want to filter
                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            });

            // Sorting functionality
            function sortTable(columnIndex) {
                var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
                table = document.querySelector(".table");
                switching = true;
                dir = "asc"; // Set the default direction to ascending

                while (switching) {
                    switching = false;
                    rows = table.getElementsByTagName("tr");

                    for (i = 1; i < (rows.length - 1); i++) {
                        shouldSwitch = false;
                        x = rows[i].getElementsByTagName("td")[columnIndex];
                        y = rows[i + 1].getElementsByTagName("td")[columnIndex];

                        if (dir === "asc") {
                            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                                shouldSwitch = true;
                                break;
                            }
                        } else if (dir === "desc") {
                            if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                                shouldSwitch = true;
                                break;
                            }
                        }
                    }

                    if (shouldSwitch) {
                        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                        switching = true;
                        switchcount++;
                    } else {
                        if (switchcount === 0 && dir === "asc") {
                            dir = "desc";
                            switching = true;
                        }
                    }
                }

                // Add/remove classes to show sorting direction
                var headers = document.querySelectorAll(".sortable");
                headers.forEach(function (header) {
                    header.classList.remove("asc", "desc");
                });
                var clickedHeader = document.querySelector(".sortable:nth-child(" + (columnIndex + 1) + ")");
                clickedHeader.classList.toggle("asc", dir === "asc");
                clickedHeader.classList.toggle("desc", dir === "desc");
            }
        </script>

    </body>
</html>
