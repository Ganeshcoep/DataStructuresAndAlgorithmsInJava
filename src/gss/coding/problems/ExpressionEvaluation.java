package gss.coding.problems;

public class ExpressionEvaluation {
    
    public static class Node {
        private Node left;
        private Node right;
        private boolean isOperand;
        
        public boolean isOperand() {
            return isOperand;
        }
        public void setOperand(boolean isOperand) {
            this.isOperand = isOperand;
        }
        public Node(Node left, Node right, boolean isOperand) {
            super();
            this.left = left;
            this.right = right;
            this.isOperand = isOperand;
        }
        public Node getLeft() {
            return left;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public Node getRight() {
            return right;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        
        public int getOperand() {
            // TODO Auto-generated method stub
            return 0;
        }        
        
        public char getOperator() {
            return '+';
        }
        
    }
    
    public static  class OperatorNode extends Node{
        private char operator;
        
        public OperatorNode(Node left, Node right, char operator) {
            super(left, right,false);
            this.operator = operator;
        }

        public char getOperator() {
            return operator;
        }

        public void setOperator(char operator) {
            this.operator = operator;
        }
    }
    
    public static  class OperandNode extends Node{
        private int operand;

        public OperandNode(Node left, Node right, int operand) {
            super(left, right,true);
            this.operand = operand;
        }

        public int getOperand() {
            return operand;
        }

        public void setOperand(int operand) {
            this.operand = operand;
        }
    }

    public ExpressionEvaluation() {
    }
    
    public static int evaluate(Node root) {
        if(root == null )
            return -1;
        if(root.isOperand()){
            return root.getOperand();            
        }else{ // operator
            char optr = root.getOperator();            
            int leftVal = evaluate(root.getLeft());
            int rightVal = evaluate(root.getRight());            
            if(optr == '+')
                return leftVal+rightVal;
        }        
        return 0;
        
    }

    public static void main(String[] args) {        
        Node root = new OperatorNode(null,null,'+');
        OperatorNode plusRight = new OperatorNode(null,null,'+');
        OperatorNode plusLeft = new OperatorNode(null,null,'+');
        root.setLeft(plusLeft);
        root.setRight(plusRight);        
        
        plusLeft.setLeft(new OperandNode(null,null,2));
        plusLeft.setRight(new OperandNode(null,null,3));
        
        plusRight.setLeft(new OperandNode(null,null,2));
        plusRight.setRight(new OperandNode(null,null,3));        
        
        System.out.println(evaluate(root));
    }
}


