package test;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;

    public Message(byte[] data )
    {
        this.data=data;
        this.asText=data.toString();
        this.asDouble=tryparse(this.asText);
        this.date=new Date();
    }

    public Message(String asText)
    {
        this.asText = asText;
        this.data = asText.getBytes();
        this.asDouble = tryparse(asText);
        this.date = new Date();

}

    public Message(double asDouble)
    {
        this(Double.toString(asDouble));
    }

    private double tryparse(String data)
    {
        try {
           return Double.parseDouble(data);
        }
        catch (NumberFormatException exception)
        {
            return Double.NaN;
        }
    }


}
