package DataSort;

import java.util.ArrayList;

public class Sorter {
    //------ Bubble Sort
    //Bubble Sort Func
    public ArrayList<Node> bubbleSort(ArrayList<Node> nodeList) {
        boolean wasSorted = false;
        for (int i = 0; i < (nodeList.size() - 1); i++) { //For each value in list, if value is larger than next value, switch values
            if (nodeList.get(i).getNodeValue() > nodeList.get(i + 1).getNodeValue()) {
                Node tmp = nodeList.get(i);
                nodeList.set(i, nodeList.get(i + 1));
                nodeList.set(i + 1, tmp);
                wasSorted = true;
            }
        }
        if (wasSorted) { //If values were switched, run sort again until no switches are made
            bubbleSort(nodeList);
        }
        return nodeList;
    }

    //------ Heap Sort
    //Max Heap Converter
    public void convertToHeap(ArrayList<Node> nodeList, int rootNodeIndex, int treeLength) {
        int largestNodeIndex = rootNodeIndex;
        int leftNodeIndex = (rootNodeIndex * 2) + 1;
        int rightNodeIndex = (rootNodeIndex * 2) + 2;

        if (leftNodeIndex < treeLength && nodeList.get(leftNodeIndex).getNodeValue() > nodeList.get(largestNodeIndex).getNodeValue()) {
            largestNodeIndex = leftNodeIndex;
        }

        if (rightNodeIndex < treeLength && nodeList.get(rightNodeIndex).getNodeValue() > nodeList.get(largestNodeIndex).getNodeValue()) {
            largestNodeIndex = rightNodeIndex;
        }

        //If left || right child is larger than root node, switch and run again until no more switches are made || reached end of tree
        if (largestNodeIndex != rootNodeIndex) {
            Node tmp = nodeList.get(largestNodeIndex);
            nodeList.set(largestNodeIndex, nodeList.get(rootNodeIndex));
            nodeList.set(rootNodeIndex, tmp);

            convertToHeap(nodeList, largestNodeIndex, treeLength);
        }
    }

    //Heap Sort Func
    public ArrayList<Node> heapSort(ArrayList<Node> nodeList) {
        for (int i = nodeList.size() / 2 - 1; i >= 0; i--) {
            convertToHeap(nodeList, i, nodeList.size());
        }
        for (int i = nodeList.size() - 1; i > 0; i--) {
            Node tmp = nodeList.get(0);
            nodeList.set(0, nodeList.get(i));
            nodeList.set(i, tmp);
            convertToHeap(nodeList, 0, i);
        }
        return nodeList;
    }
}
