import java.util.ArrayList;

public class MergeSort {
    private void merge(ArrayList<Integer> array, int left, int middle, int right, Draw draw) throws InterruptedException {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        ArrayList<Integer> L = new ArrayList<>(n1);
        ArrayList<Integer> R = new ArrayList<>(n2);

        for (int i = 0; i < n1; ++i)
            L.add(i, array.get(left + i));
        for (int j = 0; j < n2; ++j)
            R.add(j, array.get(middle + 1 + j));

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {
                array.set(k, L.get(i));
                i++;
            } else {
                array.set(k, R.get(j));
                j++;
            }
            k++;

            // Update visualization
            draw.updateArray(array);
            draw.repaint();
            Thread.sleep(25);  // Adjust this value as needed for visualization
        }

        while (i < n1) {
            array.set(k, L.get(i));
            i++;
            k++;

            // Update visualization
            draw.updateArray(array);
            draw.repaint();
            Thread.sleep(25);  // Adjust this value as needed for visualization
        }

        while (j < n2) {
            array.set(k, R.get(j));
            j++;
            k++;

            // Update visualization
            draw.updateArray(array);
            draw.repaint();
            Thread.sleep(25);  // Adjust this value as needed for visualization
        }
    }

    private void mergeSort(ArrayList<Integer> array, int left, int right, Draw draw) throws InterruptedException {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle, draw);
            mergeSort(array, middle + 1, right, draw);

            merge(array, left, middle, right, draw);
        }
    }

    public void sort(ArrayList<Integer> array, Draw draw) throws InterruptedException {
        mergeSort(array, 0, array.size() - 1, draw);
    }
}
