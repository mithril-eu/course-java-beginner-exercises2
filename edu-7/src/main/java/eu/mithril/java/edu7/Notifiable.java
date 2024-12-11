package eu.mithril.java.edu7;

public interface Notifiable {
    boolean send(String message);
    boolean validateMessage(String message);
}
