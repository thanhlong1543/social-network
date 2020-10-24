package tp.kits3.ambi.websocket;

import java.io.IOException;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
/**
 *@author Pham Thanh Tam
 */
public class MessageDecoder implements Decoder.Text<Message> {

    @Override
    public void destroy() {
    }

    @Override
    public void init(EndpointConfig arg0) {
    }

    @Override
    public Message decode(String arg0) throws DecodeException {
        try {
            return Constants.MAPPER.readValue(arg0, Message.class);
        } catch (IOException e) {
            throw new DecodeException(arg0, "Unable to decode text to Message", e);
        }
    }

    @Override
    public boolean willDecode(String arg0) {
        return arg0.contains(Constants.USER_NAME_KEY) && arg0.contains(Constants.MESSAGE_KEY);
    }
}
