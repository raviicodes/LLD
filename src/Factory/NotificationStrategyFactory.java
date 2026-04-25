package Factory;

public class NotificationStrategyFactory {

    public static SendNotificationStrategy getNotificationStrategy(Channel channel){
         switch (channel){
             case Channel.SMS -> {
                  return new SmsSendNotificationStreategy();
             }

             case Channel.EMAIL-> {
                  return new EmailSendNotificationStrategy();
             }
             default -> throw new  UnsupportedOperationException("no strategy with this channel");
         }
    }

}
