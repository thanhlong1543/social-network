package tp.kits3.ambi.websocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
/**
 *@author Pham Thanh Tam
 */
public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public void destroy() {
    }

    @Override
    public void init(EndpointConfig arg0) {
    }

    @Override
    public String encode(Message message) throws EncodeException {
        try {
        	System.out.println("encoding"+Constants.MAPPER.writeValueAsString(message));
            return Constants.MAPPER.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new EncodeException(message, "Unable to encode message", e);
        }
    }
}
