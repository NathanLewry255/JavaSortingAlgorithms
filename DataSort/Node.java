package DataSort;

public class Node {
    private int mNodeID;
    private int mNodeValue;

    public Node(int nodeID, int nodeValue){
        mNodeID = nodeID;
        mNodeValue = nodeValue;
    }

    public int getNodeID(){
        return mNodeID;
    }
    public int getNodeValue(){
        return mNodeValue;
    }

    public String getNodeToString(){
        return "[" + mNodeID + " = " + mNodeValue + "]";
    }
}
