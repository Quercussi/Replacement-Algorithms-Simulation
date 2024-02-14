import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OptimalReplacer implements FrameReplacer {

    private final int[] pageSequence;
    private final int frameCount;

    public OptimalReplacer(int[] pageSequence, int frameCount) {
        this.pageSequence = Arrays.copyOf(pageSequence,pageSequence.length);
        this.frameCount = frameCount;
    }

    @Override
    public int simulate() {
        int pageFault = 0;

        List<Integer> lookUpList = Arrays.stream(pageSequence)
                                         .boxed()
                                         .collect(Collectors.toList());
        Set<Integer> pages = new HashSet<>();

        for(int frame : pageSequence) {
            lookUpList.remove(0);
            if(pages.contains(frame))
                continue;

            if(pages.size() >= frameCount) {
                int idx = Integer.MIN_VALUE, removingPage = -1;
                for(Integer upPage : pages) {
                    int upPageIdx = lookUpList.indexOf(upPage);
                    if(upPageIdx == -1) {
                        removingPage = upPage;
                        break;
                    }
                    if(idx < upPageIdx) {
                        idx = upPageIdx;
                        removingPage = upPage;
                    }
                }
                pages.remove(removingPage);
            }

            pages.add(frame);
            pageFault++;
        }

        return pageFault;
    }
}