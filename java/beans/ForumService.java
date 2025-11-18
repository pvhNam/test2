package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForumService {
    private static ForumService instance;
    private Map<String, User> users;
    private List<Topic> topics;
    private long idCounter = 0;

    private ForumService() {
        users = new HashMap<>();
        topics = new ArrayList<>();
        
        // 1. Tạo dữ liệu User mẫu
        User u1 = new User("nam", "nam", "chuot@gmail.com");
        User u2 = new User("doctorQ", "123", "doc@gmail.com");
        users.put(u1.getUsername(), u1);
        users.put(u2.getUsername(), u2);

        // 2. Tạo dữ liệu Topic mẫu như trong hình
        Topic t1 = new Topic(++idCounter, "Chuyện học phí!!!", "Sao học phí tăng hoài vậy?", u1);
        
        // Thêm vài reply cho topic 1
        t1.addMessage(new Message(++idCounter, "Re: Chuyện học phí", "Tăng theo lộ trình mà", u2));
        
        topics.add(t1);
        topics.add(new Topic(++idCounter, "Thủ tướng quyết định mức học phí", "Tin mới nhận...", u2));
    }

    public static synchronized ForumService getInstance() {
        if (instance == null) instance = new ForumService();
        return instance;
    }

    public User checkUser(String username, String password) {
        User u = users.get(username);
        if (u != null && u.verify(username, password)) {
            return u;
        }
        return null;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopicById(long id) {
        for (Topic t : topics) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public void addTopic(String title, String content, User creator) {
        Topic t = new Topic(++idCounter, title, content, creator);
        // Thêm vào đầu danh sách để cái mới nhất hiện lên trên
        topics.add(0, t); 
    }

    public void addReply(long topicId, String title, String content, User creator) {
        Topic t = getTopicById(topicId);
        if (t != null) {
            t.addMessage(new Message(++idCounter, title, content, creator));
        }
    }
}