package binary_search;

import java.util.Arrays;

public class NLocations {
    int findLocations(int[] centers, int d) {
        Arrays.sort(centers);

        // min distance should be the middle center(s);
        long total = getTotal(centers, centers[centers.length / 2]);
        if (total > d) {
            return 0;
        }

        // find left boundary
        int left = -1_000_000_000;
        int right = centers[centers.length / 2];
        while (left < right) {
            int mid = left + (right - left) / 2;
            long t = getTotal(centers, mid);
            if (t > d) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int min = left;
        // System.out.println(min);

        // find right boundary
        right = 1_000_000_000;
        left = centers[centers.length / 2];
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            long t = getTotal(centers, mid);
            if (t > d) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left - min + 1;
    }

    long getTotal(int[] centers, int loc) {
        long sum = 0;
        for (int c : centers) {
            sum += Math.abs(loc - c);
        }
        return sum * 2;
    }
}
