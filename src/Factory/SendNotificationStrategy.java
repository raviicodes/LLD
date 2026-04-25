package Factory;

 class Notification{
     private  int notificationId;
     private  String message;
     private Channel channel;
     private String contact;

     public int getNotificationId() {
         return notificationId;
     }

     public String getMessage() {
         return message;
     }

     public Channel getChannel() {
         return channel;
     }

     public String getContact() {
         return contact;
     }
 }
public interface SendNotificationStrategy {
    void sendNotification(Notification notification);
}
