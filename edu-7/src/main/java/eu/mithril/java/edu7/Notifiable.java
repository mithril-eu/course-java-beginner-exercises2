package eu.mithril.java.edu7;

public interface Notifiable {
    boolean send(String message);
    boolean validateMessage(String message);


    static class EmailNotification implements Notifiable {
        @Override
        public boolean send(String message) {
            if (!validateMessage(message)) {
                return false;
            }
            System.out.println("Email sent: " + message);
            return true;
        }

        @Override
        public boolean validateMessage(String message) {
            return message != null && !message.trim().isEmpty();
        }
    }

    static class SMSNotification implements Notifiable {
        private static final int MAX_LENGTH = 160;

        @Override
        public boolean send(String message) {
            if (!validateMessage(message)) {
                return false;
            }
            System.out.println("SMS sent: " + message);
            return true;
        }

        @Override
        public boolean validateMessage(String message) {
            return message != null && !message.trim().isEmpty()
                    && message.length() <= MAX_LENGTH;
        }
    }

    static class PushNotification implements Notifiable {
        private static final int MAX_LENGTH = 50;

        @Override
        public boolean send(String message) {
            if (!validateMessage(message)) {
                return false;
            }
            System.out.println("Push notification sent: " + message);
            return true;
        }

        @Override
        public boolean validateMessage(String message) {
            return message != null && !message.trim().isEmpty()
                    && message.length() <= MAX_LENGTH;
        }
    }
}
