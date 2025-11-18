<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<body>
    <h3>Tạo chủ đề mới</h3>
    <form action="createTopic" method="POST">
        Tiêu đề: <input type="text" name="title" style="width: 300px"><br><br>
        Nội dung:<br>
        <textarea name="content" rows="5" cols="40"></textarea><br><br>
        <input type="submit" value="Gửi">
        <input type="button" value="Hủy bỏ" onclick="history.back()">
    </form>
</body>
</html>	