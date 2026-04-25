package Factory;

public class SmsSendNotificationStreategy implements SendNotificationStrategy{
    @Override
    public void sendNotification(Notification notification) {
        System.out.println(notification.getMessage()+" sms send to "+notification.getContact());
    }
}
