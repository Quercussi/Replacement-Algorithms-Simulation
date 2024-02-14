import java.util.Arrays;
import java.util.Objects;

public class FIFOReplacer implements FrameReplacer {

    private final int[] pageSequence;
    private final int frameCount;

    public FIFOReplacer(int[] pageSequence, int frameCount) {
        this.pageSequence = Arrays.copyOf(pageSequence,pageSequence.length);
        this.frameCount = frameCount;
    }

    @Override
    public int simulate() {
        Integer[] frames = new Integer[frameCount];
        int pageFault = 0;
        Arrays.fill(frames,null);

        int i = 0;
        for(int page : pageSequence) {
            if(contains(frames,page))
                continue;

            frames[i] = page;
            i = (i + 1) % frameCount;
            pageFault++;
        }

        return pageFault;
    }

    private boolean contains(Integer[] arr, Integer x) {
        for(Integer n : arr)
            if (Objects.equals(n, x))
                return true;

        return false;
    }
}
