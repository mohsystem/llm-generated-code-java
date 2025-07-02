package codestral.task175;

import java.util.List;

interface MountainArray {
    int get(int index);
    int length();
}

class MountainArrayImpl implements MountainArray {
    private final List<Integer> data;

    public MountainArrayImpl(List<Integer> data) {
        this.data = data;
    }

    @Override
    public int get(int index) {
        return data.get(index);
    }

    @Override
    public int length() {
        return data.size();
    }
}
