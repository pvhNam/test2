<%@page import="beans.Message"%>
<%@page import="beans.Topic"%>
<%@page import="beans.ForumService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Xem chủ đề</title></head>
<body>
    <%
        String idParam = request.getParameter("id");
        Topic t = ForumService.getInstance().getTopicById(Long.parseLong(idParam));
    %>
    
    <a href="listTopics.jsp">Danh sách chủ đề</a>
    <h3>Chủ đề: <%= t.getTitle() %></h3>
    <p>Gửi bởi: <b><%= t.getCreator().getUsername() %></b> lúc <%= t.getCreatedTime() %></p>
    <div style="background-color: #f9f9f9; padding: 10px; border: 1px solid #ccc">
        <%= t.getContent() %>
    </div>
    
    <div style="text-align: right; margin: 10px 0;">
        <a href="replyTopic.jsp?id=<%= t.getId() %>">Trả lời</a>
    </div>

    <% for(Message m : t.getMessages()) { %>
        <div style="border: 1px solid #ccc; margin-bottom: 10px;">
            <div style="background-color: #eee; padding: 5px;">
                <b><%= m.getCreator().getUsername() %></b> - <%= m.getCreatedTime() %>
                <span style="float:right"><b><%= m.getTitle() %></b></span>
            </div>
            <div style="padding: 10px;">
                <%= m.getContent() %>
            </div>
        </div>
    <% } %>
</body>
</html>