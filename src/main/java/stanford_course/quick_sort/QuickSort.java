package stanford_course.quick_sort;

public class QuickSort {
	private PivotSelectionStrategy pivotSelectionStrategy;
	private int acc = 0;

	public QuickSort(PivotSelectionStrategy pivotSelectionStrategy) {
		this.pivotSelectionStrategy = pivotSelectionStrategy;
	}

	public void sort(Integer[] arr) {
		acc = 0;
		sort(arr, 0, arr.length - 1);
	}

	public void sort(Integer[] arr, int lo, int high) {
		//base case
		if (high - lo <= 1) {
			return;
		}
		//choose pivot
		int pivotIndex = pivotSelectionStrategy.choosePivot(arr, lo, high);
		//swap pivot to 0 index position
		swap(arr, lo, pivotIndex);
		//partition task
		int finalPivotIndex = partition(arr, lo, high);
		acc += (high - lo);
		sort(arr, lo, finalPivotIndex);
		sort(arr, finalPivotIndex + 1, high);
	}

	//return pivot index
	protected int partition(Integer[] arr, int lo, int high) {
		int i = lo + 1, j = lo + 1;
		int pivot = arr[lo];

		for (int z = lo+1; z <= high; z++) {
			if (pivot > arr[z]) {
				swap(arr, i, j);
				j++;
				i++;
			} else if (pivot <= arr[z]) {
				i++;
			}
		}

		swap(arr, lo, j-1);

		return j - 1;
	}

	private void swap(Integer[] arr, int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}

	public int getAcc() {
		return acc;
	}
}
