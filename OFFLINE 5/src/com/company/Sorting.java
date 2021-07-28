package com.company;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

    private List<Integer> list;

    void sort()
    {
        int n = list.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (list.get(j) < list.get(min_idx))
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = list.get(min_idx);
            list.set(min_idx, list.get(i));
            list.set(i, temp);
        }
    }

    public boolean sortCheck(List<Integer> unsorted) {

        list = new ArrayList<Integer>(unsorted);
        sort();
        for(int i = 0; i < list.size() - 1 ; i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) > list.get(j))
                    return false;
            }
        }
        return true;
    }

    public boolean elementCheck(List<Integer> unsorted) {

        System.out.println("Unsorted");
        System.out.println(unsorted);
        System.out.println("Sorted");
        System.out.println(list + "\n");
        boolean[] check = new boolean[list.size()];

        for(int i = 0; i < list.size(); i++){
            check[i] = false;
        }

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(i).equals(unsorted.get(j)) && !check[j]){

                    check[j] = true;
                }
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(!check[i])
                return false;
        }
        return true;

    }
}
