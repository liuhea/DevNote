
// 链表 先进后出

/**
*
*(1)定义节点模型
* 两个属性：存放的数据data，存放下一个节点的引用。	
*/
public class Node {

	/**
	*存放的数据，以int类型为例
	*/
	public int data;

	/**
	* 存放节点的变量，默认为null
	*/
	public Node next;

	/**
	* 构造方法，在构造时能够给data赋值
	*/
	public Node(int data){
		this.data=data;
	}
}

/**
* (2)单链表的简单操作
*  增、删、获取总长度、排序、遍历等
*/
public class MyLink {
	Node head = null; // 头节点

	/**
	* 增加操作：直接在链表的最后插入新增的节点即可
	*      	   将原本最后的一个节点的next指向新节点。
	*/
	public void addNode(Node node){
		if (head == null) {
            head = newNode;
            return;
        }

		// 链表中有节点，遍历到最后一个节点。
		Node temp = head; 
		// 一个移动的指针，把头结点看做是一个指向节点的指针。
		// 遍历单链表，直到遍历到最后一个则跳出循环
		while(temp.next != null ){
			temp = temp.next;
		}
		temp.next = node;
	}

	/**
	* 删除第index个节点
	*/
	public boolean deleteNode(int index){
		if (index < 1 || index > length()) {
			return false;
		}
		int i = 1;
		Node preNode = head;
		Node curNode = preNode.next;
		while(curNode != null){
			if (i == index) {
				preNode.next = curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return false;
	}

	/**
	* 	返回节点长度
	*/
	public int length(){
		int length = 0;
		Node tmp = head;
		while(tmp !=null ){
			length++;
			tmp = tmp.next;
		}
		return length;
	}
}
