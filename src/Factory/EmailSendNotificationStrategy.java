package Factory;

public class EmailSendNotificationStrategy implements SendNotificationStrategy{
    @Override
    public void sendNotification(Notification notification) {
        System.out.println(notification.getMessage()+" email send to "+notification.getContact());
    }
}
