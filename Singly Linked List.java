// ------------------------------Singly Linked List-------------------
/*
### Singly Linked List

A **singly linked list** is a linear data structure where each element (called a node)
contains two parts: the data and a reference (pointer) to the next node.
It supports dynamic memory allocation and allows efficient insertion and deletion.

Example Structure:

+-----+---------+    +-----+---------+    +-----+---------+    +-----+---------+
|  1  |   *---->|    |  2  |   *---->|    |  3  |   *---->|    |  4  |  null   |
+-----+---------+    +-----+---------+    +-----+---------+    +-----+---------+
  head node                                               tail node (next = null)


#### Structure of a Node

Each node in a singly linked list contains:

1. **Data** — The value stored in the node
2. **Next Reference** — A reference to the next node

**Node Definition (Java Example)**:

```java
class Node {
    int data;      // Value stored in node
    Node next;     // Reference to next node

    Node(int value) {
        this.data = value;
        this.next = null;
    }
}

Alright, Usman — here’s your whole description rewritten cleanly **for Java**, not C++. Same style, same flow, just fully Java-accurate. You can paste this directly into your repository or comment block.

---

````java
// ------------------------------Singly Linked List-------------------
/*
### Singly Linked List

A **singly linked list** is a linear data structure where each element (called a node)
contains two parts: the data and a reference (pointer) to the next node.
It supports dynamic memory allocation and allows efficient insertion and deletion.

Example Structure:

+-----+---------+    +-----+---------+    +-----+---------+    +-----+---------+
|  1  |   *---->|    |  2  |   *---->|    |  3  |   *---->|    |  4  |  null   |
+-----+---------+    +-----+---------+    +-----+---------+    +-----+---------+
  head node                                               tail node (next = null)


#### Structure of a Node

Each node in a singly linked list contains:

1. **Data** — The value stored in the node
2. **Next Reference** — A reference to the next node

**Node Definition (Java Example)**:

```java
class Node {
    int data;      // Value stored in node
    Node next;     // Reference to next node

    Node(int value) {
        this.data = value;
        this.next = null;
    }
}
````

#### Characteristics

1. **Dynamic Size**
   The list can grow or shrink as needed, unlike arrays with fixed size.

2. **Efficient Insertions/Deletions**
   Elements can be added or removed without shifting data.

3. **Single Direction**
   Traversal is only from head to tail using `next` references.

---

### Basic Operations in a Singly Linked List

1. **Insertion**

   * **At Beginning:**
     Create a new node → set its `next` to current head → update head.
   * **At End:**
     Traverse to the last node → set its `next` to the new node.
   * **At Position:**
     Traverse to the target index → adjust references to insert.

2. **Deletion**

   * **From Beginning:**
     Move head to `head.next`.
   * **From End:**
     Traverse to the second-last node → set its `next` to null.
   * **By Value:**
     Locate the node → re-link previous node’s `next` to skip it.

3. **Traversal**
   Start from head → visit each node until reaching `null`.

4. **Search**
   Traverse to find a node containing a specific value.

5. **Reversal**
   Reverse the direction of all `next` references.

---

### SinglyLinkedList Class (Java)

1. Contains a private `head` reference pointing to the first node.
2. Provides methods for:

   * insertion at beginning
   * insertion at end
   * deletion by value
   * display (printing)
   * optional destructor-like cleanup using garbage collection

---

### Advantages

* **Dynamic Size** — grows/shrinks as required
* **Fast Insert/Delete** — especially at beginning

### Disadvantages

* **No Random Access** — must traverse sequentially
* **Extra Memory** — each node stores an extra reference

---

### Conclusion

A singly linked list is a powerful and flexible data structure for situations requiring frequent insertions and deletions. Although it lacks random access and has slight memory overhead, it remains one of the most important data structures in computer science.
This Java-based explanation and implementation provide a solid foundation for understanding and building your own linked list operations.
*/




import javax.swing.JOptionPane;

public class intLinkedList {
	NodeClass start ;
	public intLinkedList() {
		start = null;
	}
	
	public void insertAtEnd(int val) {
		NodeClass n1 = new NodeClass();
		n1.data = val;
		n1.next = null;
		if(start == null) {
			start = n1;
		}
		else {
			NodeClass last = searchLast();
			last.next = n1;
		}
			
	}
	
	public NodeClass searchLast() {
		NodeClass ind = start;
		while(ind.next != null) {
			ind = ind.next;
		}
		return ind;
	}
	
	public NodeClass searchSpecific(int val) {
		NodeClass ind = start;
		while(ind.next != null) {
			if(ind.data == val) {
				return ind;
			}
			ind = ind.next;
		}
		return null;
	}
	
	public NodeClass search2ndLast() {
		NodeClass ind = start;
		NodeClass last = ind;
		while(ind.next != null) {
			last = ind.next;
			ind = ind.next;
		}
		return last;
	}
	
	public NodeClass searchBefore(int val) {
		NodeClass ind = start;
		NodeClass last = null;
		while(ind.next != null) {
			if(ind.data == val) {
				return last;
			}
			last = ind.next;
			ind = ind.next;
		}
		return null;
	}
	
	public void insertAtStart(int val) {
		NodeClass n1 = new NodeClass();
		n1.data = val;
		NodeClass temp = start;
		start = n1;
		n1 = temp;
	}
	
	public void update(int newVal , int oldVal) {
		NodeClass up = searchSpecific(oldVal);
		up.data = newVal;
	}
	
	public void deleteLast() {
		NodeClass del = search2ndLast();
		del.next = null;
	}
	
	public void deleteFirst() {
		NodeClass del = search2ndLast();
		NodeClass temp = del.next;
		start = temp.next;
		del.next = null;
	}
	
	public void deleteSpecific(int val) {
		
	}
	
	public void insertefore(int val , int bef) {
		NodeClass n1 = new NodeClass();
		n1.data = val;
		
		NodeClass temp = searchBefore(bef);
		NodeClass temp1 = searchSpecific(bef);
		
		n1.next = 	temp1;
		temp.next = n1;
	}
	
	public void insertAfter ( int val , int aft) {
		NodeClass n1 = new NodeClass();
		n1.data = val;
		NodeClass temp = searchSpecific(aft);
		n1.next = temp.next;
		temp.next = n1;
	}
	
	public void display() {
		NodeClass temp = start;
		while(temp.next != null) {
			JOptionPane.showMessageDialog(null, temp.data);
			temp = temp.next;
		}
	}
}

