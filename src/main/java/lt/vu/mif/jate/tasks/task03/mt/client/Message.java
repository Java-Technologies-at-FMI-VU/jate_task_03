package lt.vu.mif.jate.tasks.task03.mt.client;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;
import lombok.Getter;

@Getter
public class Message {

    private static final AtomicLong CORRELATION_SEQ = new AtomicLong();
    
    private final ServerFunction code;
    private final Long correlation;

    public Message(ServerFunction code) {
        this.code = code;
        this.correlation = CORRELATION_SEQ.incrementAndGet();
    }
    
    public ByteBuffer toBytes() {
        ByteBuffer buf = ByteBuffer.allocate(12);
        buf.putInt(code.getCode());
        buf.putLong(correlation);
        buf.rewind();
        return buf;
    }
    
    public static ByteBuffer toBytes(int i) {
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(i);
        b.rewind();
        return b;
    }
    
}
