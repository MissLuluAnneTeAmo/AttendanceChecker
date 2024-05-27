public class EventMaker {

    protected String EventName;
    protected int Date;

    public EventMaker (String EventName, int Date){
        this.EventName = EventName;
        this.Date = Date;

    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "EventMaker{" +
                "EventName='" + EventName + '\'' +
                ", Date=" + Date +
                '}';
    }
}
