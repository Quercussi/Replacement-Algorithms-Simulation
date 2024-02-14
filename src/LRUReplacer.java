import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LRUReplacer implements  FrameReplacer{

    private final int[] pageSequence;
    private final int frameCount;

    public LRUReplacer(int[] pageSequence, int frameCount) {
        this.pageSequence = Arrays.copyOf(pageSequence,pageSequence.length);
        this.frameCount = frameCount;
    }

    @Override
    public int simulate() {
        Deque<Integer> frames = new ArrayDeque<>();
        int pageFault = 0;

        for(int page : pageSequence) {
            // Push the detected page back to the end of the deque
            if(frames.remove(page)) {
                frames.add(page);
                continue;
            }

            pageFault++;

            if(frames.size() >= frameCount)
                frames.remove();

            frames.add(page);
        }

        return pageFault;
    }
}
