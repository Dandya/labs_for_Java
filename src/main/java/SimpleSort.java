import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleSort<Type extends Comparable> {

    protected interface Sorter<Type> {
        public List<Type> sort(List<Type> list);
    }

    public SimpleSort(){
    }

    protected class BubbleSort<Type extends Comparable> implements Sorter<Type> {
        public List<Type> sort(List<Type> list) {
            boolean was_change = true;
            while (was_change) {
                was_change = false;
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                        list.set(i - 1, list.set(i, list.get(i - 1)));
                        was_change = true;
                    }
                }
            }
            return list;
        }
    }

    public List<Type> BubbleSort(@NotNull List<Type> list){
        return (new BubbleSort<Type>()).sort(list);
    }

    public List<Type> BubbleSort(@NotNull Type[] list){
        List<Type> tmpList = new ArrayList<>();
        Collections.addAll(tmpList, list);
        return (new BubbleSort<Type>()).sort(tmpList);
    }
}
