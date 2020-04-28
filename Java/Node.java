
/*
 * File: Node.java
 * Created by Nirav Galani
 * Example code created for Lab04, CSC115 201901
 */

public class Node{

        public String item;
        public Node next;

        public Node(String item, Node next){
                this.item = item;
                this.next = next;
        }

        public Node(String item){
                this.item = item;
                this.next = null;
        }

        public Node(){
                this("nothing", null);
        }

        public String getItem(){
                return this.item;
        }

        public void setItem(String item){
                this.item = item;
        }

        public String toString(){
                return "Item: " + this.item;
        }

}
