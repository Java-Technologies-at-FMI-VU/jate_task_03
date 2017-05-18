package lt.vu.mif.jate.tasks.task03.mt.client;

import java.nio.ByteBuffer;
import lombok.Getter;

@Getter
public class MessageWithArgs extends Message {

    private final Long op1;
    private final Long op2;
    
    public MessageWithArgs(ServerFunction code, Long op1, Long op2) {
        super(code);
        this.op1 = op1;
        this.op2 = op2;
    }
    
    @Override
    public ByteBuffer toBytes() {
        ByteBuffer buf = ByteBuffer.allocate(28);
        buf.putInt(getCode().getCode());
        buf.putLong(getCorrelation());
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
    
}
