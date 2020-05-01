package lt.vu.mif.jate.tasks.task03.mt.client;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

public class Message {

    private static final AtomicLong CORRELATION_SEQ = new AtomicLong();
    
    private final ServerFunction code;
    private final Long correlation;
    private final Long delay;
    private final Long op1;
    private final Long op2;
    
    public Message(ServerFunction code, Long op1, Long op2, Long delay) {
        this.code = code;
        this.op1 = op1;
        this.op2 = op2;
        this.correlation = CORRELATION_SEQ.incrementAndGet();
        this.delay = delay;
    }
    
    public ByteBuffer toBytes() {
        ByteBuffer buf = ByteBuffer.allocate(4 + 8 + 8 + 8 + 8);
        buf.putInt(code.getCode());
        buf.putLong(correlation);
        buf.putLong(delay);
        buf.putLong(op1);
        buf.putLong(op2);
        buf.rewind();
        return buf;
    }
    
    public static ByteBuffer toBytes(int i) {
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(i);
        b.rewind();
        return b;
    }

    public Long getCorrelation() {
        return correlation;
    }

    public ServerFunction getCode() {
        return code;
    }
    
}
