<%@page import="beans.Message"%>
<%@page import="beans.Topic"%>
<%@page import="java.util.List"%>
<%@page import="beans.ForumService"%>
<%@page import="beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Diễn đàn</title></head>
<body>
    <% User user = (User) session.getAttribute("currentUser"); %>
    
    <div style="text-align: right;">
        <% if(user != null) { %>
            Chào <%= user.getUsername() %> | <a href="logout">Thoát</a>
        <% } else { %>
            <a href="login.jsp">Đăng nhập</a>
        <% } %>
    </div>

    <h3>Diễn đàn: Chuyện học phí và các chính sách hỗ trợ</h3>

    <% if(user != null) { %>
        <button onclick="window.location.href='newTopic.jsp'">Gửi bài mới</button>
    <% } %>
    <br><br>

    <table border="1" width="100%" cellpadding="5">
        <tr bgcolor="#ddd">
            <th>Chủ đề</th>
            <th>Hồi âm</th>
        </tr>
        <% 
            List<Topic> topics = ForumService.getInstance().getTopics();
            for(Topic t : topics) {
                Message lastMsg = t.getNewMessage();
        %>
        <tr>
            <td>
                <a href="showTopic.jsp?id=<%= t.getId() %>"><b><%= t.getTitle() %></b></a><br>
                <small>
                    Bài mới nhất bởi 
                    <%= (lastMsg != null) ? lastMsg.getCreator().getUsername() : t.getCreator().getUsername() %>, 
                    <%= (lastMsg != null) ? lastMsg.getCreatedTime() : t.getCreatedTime() %>
                </small>
            </td>
            <td align="center"><%= t.getMessageCount() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>