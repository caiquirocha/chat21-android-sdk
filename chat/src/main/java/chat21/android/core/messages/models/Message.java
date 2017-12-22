package chat21.android.core.messages.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.PropertyName;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by stefano on 06/10/2015.
 */
public class Message implements Serializable, Cloneable {
    private static final String TAG = Message.class.getName();

    public static final String STATUS_FIELD_KEY = "status";
    public static final String TIMESTAMP_FIELD_KEY = "timestamp";

    // message status
    public static final long STATUS_FAILED = -100;
    public static final long STATUS_SENDING = 0;
    public static final long STATUS_SENT = 100; //(SALVATO SULLA TIMELINE DEL MITTENTE)
    public static final long STATUS_DELIVERED_TO_RECIPIENT_TIMELINE = 150; //(SALVATO SULLA TIMELINE DEL DESTINATARIO)

    public static final long STATUS_RECEIVED_FROM_RECIPIENT_CLIENT = 200;
    public static final long STATUS_RETURN_RECEIPT = 250;  // from the recipient client app)
    public static final long STATUS_SEEN = 300; // message read from contact

    public static final String DIRECT_CHANNEL_TYPE = "direct";
    public static final String GROUP_CHANNEL_TYPE = "group";

    // message type
    public static final String TYPE_TEXT = "text";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_FILE = "file";

    @Exclude
    String id;

    @PropertyName("sender")
    String sender;

    @PropertyName("sender_fullname")
    String senderFullname;

    @PropertyName("recipient")
    String recipient;

    @PropertyName("recipient_fullname")
    String recipientFullname;

    @PropertyName("text")
    String text;

    @PropertyName("status")
    Long status; //could be null

    @PropertyName("timestamp")
    Long timestamp;

    @PropertyName("type")
    String type;

    @PropertyName("channel_type")
    String channelType;

    @PropertyName("custom_attributes")
    Map<String, Object> customAttributes;


    public Message() {

       // this.status = STATUS_SENDING;
        //this.timestamp = new Date().getTime();
    }

    @Exclude
    public String getId() {
        return id;
    }

    @Exclude
    public void setId(String id) {
        this.id = id;
    }

    @PropertyName("sender")
    public String getSender() {
        return sender;
    }

    @PropertyName("sender")
    public void setSender(String sender) {
        this.sender = sender;
    }

    @PropertyName("recipient")
    public String getRecipient() {
        return recipient;
    }

    @PropertyName("recipient")
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @PropertyName("sender_fullname")
    public String getSenderFullname() {
        return senderFullname;
    }

    @PropertyName("sender_fullname")
    public void setSenderFullname(String senderFullname) {
        this.senderFullname = senderFullname;
    }

    @PropertyName("recipient_fullname")
    public String getRecipientFullname() {
        return recipientFullname;
    }


    @PropertyName("recipient_fullname")
    public void setRecipientFullname(String recipientFullname) {
        this.recipientFullname = recipientFullname;
    }

    @PropertyName("channel_type")
    public String getChannelType() {
        return channelType;
    }

    @PropertyName("channel_type")
    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    @PropertyName("text")
    public String getText() {
        return text;
    }

    @PropertyName("text")
    public void setText(String text) {
        this.text = text;
    }

    @PropertyName("status")
    public Long getStatus() {
        return status;
    }

    @PropertyName("status")
    public void setStatus(Long status) {
        this.status = status;
    }

    @PropertyName("timestamp")
    public Long getTimestamp() {
        return this.timestamp;
    }

    @PropertyName("timestamp")
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


    @PropertyName("type")
    public String getType() {
        return type;
    }

    @PropertyName("type")
    public void setType(String type) {
        this.type = type;
    }


    @Exclude
    public boolean isDirectChannel() {
        if (this.channelType==null || this.channelType.equals(Message.DIRECT_CHANNEL_TYPE)) {
            return true;
        } else {
            return false;
        }
    }

    @Exclude
    public boolean isGroupChannel() {
        if (this.channelType!=null && this.channelType.equals(Message.GROUP_CHANNEL_TYPE)) {
            return true;
        } else {
            return false;
        }
    }

    @PropertyName("custom_attributes")
    public Map<String, Object> getCustomAttributes() {
        return customAttributes;
    }

    @PropertyName("custom_attributes")
    public void setCustomAttributes(Map<String, Object> customAttributes) {
        this.customAttributes = customAttributes;
    }

    @Override
    @Exclude
    public boolean equals(Object object) {
        if (object instanceof Message) {
            Message message = (Message) object;
            if (this.getId().equals(message.getId())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Exclude
    public Object clone(){
        try {
            return super.clone();
        }catch (CloneNotSupportedException cnse) {
            return null;
        }
    }

    @Override
    @Exclude
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", sender_fullname='" + senderFullname + '\'' +
                ", recipient='" + recipient + '\'' +
                ", recipient_fullname='" + recipientFullname + '\'' +
                ", text='" + text + '\'' +
                ", status=" + status +
                ", timestamp=" + timestamp +
                ", type='" + type + '\'' +
                ", channel_type=" + channelType +
                '}';
    }
}
