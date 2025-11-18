package beans;
import java.util.Stack;

public class Topic extends Entry {
    private Stack<Message> messages;

    public Topic(long id, String title, String content, User creator) {
        super(id, title, content, creator);
        this.messages = new Stack<>();
    }

    public void addMessage(Message message) {
        this.messages.push(message);
    }

    public Message getNewMessage() {
        if (messages.isEmpty()) return null;
        return messages.peek(); // Lấy phần tử mới nhất trong Stack
    }
    
    public Stack<Message> getMessages() {
        return messages;
    }
    
    public int getMessageCount() {
        return messages.size();
    }
}