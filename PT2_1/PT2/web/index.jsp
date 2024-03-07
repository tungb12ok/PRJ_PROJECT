<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>INFOMATION DISCLOSURE</h1>
        <form action="send" method="post">
            <table>
                <tr>
                <input type="hidden" name="id" value="${t.id}">
                </tr>
                <tr>
                    <td>
                        <label for="name">Name:</label>
                    </td>
                    <td>
                        <input type="text" id="name" name="name" value="${t.name}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="birthday">Birthday:</label>
                    </td>
                    <td>
                        <input type="date" id="birthday" name="birthday" value="${t.dob}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="address">Address:</label>
                    </td>
                    <td>
                        <input type="text" id="address" name="address" value="${t.address}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="courses">Courses:</label>
                    </td>
                    <td>
                        <select name="courses" id="courses" size="7">
                            <option value="1">English</option>
                            <option value="2">Japanese</option>
                            <option value="3">Chinese</option>
                            <option value="4">Korean</option>
                            <option value="5">Office</option>
                            <option value="6">Web design</option>
                            <option value="7">Java</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="teachingQuality">Teaching Quality:</label>
                    </td>
                    <td>
                        <select name="teachingQuality" id="teachingQuality">
                            <option value="Good" ${'Good' eq t.teachQual ? 'selected' : ''}>Good</option>
                            <option value="Very Good" ${'Very Good' eq t.teachQual ? 'selected' : ''}>Very Good</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Send" />
                    </td>
                    <td>
                        <input type="reset" value="Reset" />
                    </td>
                </tr>
            </table>
        </form>


        <h1>Information</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Address</th>
                    <th>Course</th>
                    <th>Teaching Quality</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="teacher" items="${listT}">
                    <tr>
                        <td>${teacher.getId()}</td>
                        <td>${teacher.getName()}</td>
                        <td>${teacher.getDob()}</td>
                        <td>${teacher.getAddress()}</td>
                        <td>${teacher.getC().getName()}</td>
                        <td>${teacher.teachQual}</td>
                        <td>
                            <a href="send?id=${teacher.getId()}">Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
