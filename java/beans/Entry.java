package beans;
import java.util.Calendar;
import java.util.Date;

public abstract class Entry {
    protected long id;
    protected String title;
    protected Calendar createdTime;
    protected String content;
    protected User creator;

    public Entry(long id, String title, String content, User creator) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creator = creator;
        this.createdTime = Calendar.getInstance();
    }
    
    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public User getCreator() { return creator; }
    public Date getCreatedTime() { return createdTime.getTime(); }
}	