// public class StackClass {
//     static class Node {
//         int data;
//         Node next;
//         Node head;

//         public Node(int data) {
//             this.data = data;
//             next = null;
//         }
//         //
//     }

//     static class Stack {
//         public static Node head;
//         public static boolean isEmpty() {
//             return head == null;
//         }

//         // push function
//         public static void push(int data) {
//             Node newNode = new Node(data);
//             if (isEmpty()) {
//                 head = newNode;
//                 return;
//             }
//             newNode.next = head;
//             head = newNode;
//         }

//         // Pop function
//         public static int pop() {
//             if (isEmpty()) {
//                 return -1;
//             }
//             int top = head.data;
//             head = head.next;
//             return top;
//         }

//         // Peek Function
//         public static int peek() {
//             if (isEmpty()) {
//                 return -1;
//             }
//             return head.data;
//         }
//     }

//     public static void main(String args[]) {
//         Stack s = new Stack();
//         s.push(10);
//         s.push(20);
//         s.push(30);

//         while (!s.isEmpty()) {
//             System.out.println(s.peek());
//             s.pop();
//         }
//     }
// }

public class StackClass{
    static class Node{
        int data;
        Node next;
        Node head;

       public  Node(int data){
        this.data = data;
        next = null;
       }
    }
     static class Stack{
        public static Node head;
        // private static StackClass.Stack s;
    public static boolean isEmpty(){
        return head == null;
    } 
   // Push function in the Stack class
   public static void push(int data){
       Node newNode = new Node(data);
    if(isEmpty()){
       head = newNode;
       return;
    }
    newNode.next = head;
    head = newNode;
   }   
   // Pop Function 
   public static int pop(int data){
    if(isEmpty()){
        return -1;
    }
    int top = head.data;
    head = head.next;
     return top;
   }
   // peek function
   public static int peek(){
    if(isEmpty()){
        return -1;
    }
    return head.data;
   }
   public static void main (String args[]){
    Stack s = new Stack();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);

    while(!s.isEmpty()){
        System.out.println(s.peek());
        s.pop(0);
    }
   }
}
}