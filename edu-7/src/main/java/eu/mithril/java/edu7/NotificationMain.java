package eu.mithril.java.edu7;

/*
 * Simple Notification System demonstrating interfaces
 *
 * Requirements:
 * - Email can send any length message
 * - SMS has maximum 160 characters
 * - Push notification has maximum 50 characters
 *
 * 1. Notifiable interface with methods:
 *    - send(String message)
 *    - validateMessage(String message)
 *
 * 2. Implement different notification types:
 *    - EmailNotification
 *    - SMSNotification
 *    - PushNotification
 *
 * 3. Each implementation should:
 *    - validate character limits
 *
 */
public class NotificationMain {

    public static void main(String[] args) {
        // Test messages
        String shortMessage = "Hello!";
        String mediumMessage = "This is a longer message that should work for SMS but not for push notifications.";
        String longMessage = "This is a very long message that should only work for email. It keeps going to make sure " +
                "we exceed the SMS character limit of 160 characters. This message would be typical for " +
                "email communications where we need to send more detailed information.";

        // Test each type of notification
        System.out.println("Testing Email Notification:");
        System.out.println("--------------------------");
        testNotification(new EmailNotification(), shortMessage, mediumMessage, longMessage);

        System.out.println("\nTesting SMS Notification:");
        System.out.println("------------------------");
        testNotification(new SMSNotification(), shortMessage, mediumMessage, longMessage);

        System.out.println("\nTesting Push Notification:");
        System.out.println("---------------------------");
        testNotification(new PushNotification(), shortMessage, mediumMessage, longMessage);
    }

    private static void testNotification(Notifiable notification, String... messages) {
        for (String message : messages) {
            System.out.println("\nMessage length: " + message.length());
            System.out.println("Valid: " + notification.validateMessage(message));
            System.out.println("Send result: " + notification.send(message));
        }
    }
}
