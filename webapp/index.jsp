<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Đăng nhập</title></head>
<body>
    <div align="center">
        <h3>Đăng nhập</h3>
        <form action="login" method="POST">
            Tên đăng nhập: <input type="text" name="username"><br>
            Mật khẩu: <input type="password" name="password"><br>
            <input type="submit" value="Đăng nhập">
        </form>
        <h4 style="color:red">${error}</h4>
    </div>
</body>
</html>