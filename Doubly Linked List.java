
// -------------------------------------Doubly Linked List------------------
/*
### Doubly Linked List

A **doubly linked list** is a linear data structure where each node contains three parts:
the data, a reference to the next node, and a reference to the previous node.
This structure allows traversal in both forward and backward directions.

---

### Key Features of a Doubly Linked List

1. **Bidirectional Traversal**  
   Nodes can be traversed in both directions using `next` and `prev` references.

2. **Dynamic Size**  
   The list can grow or shrink dynamically without requiring resizing, unlike arrays.

3. **Extra Memory Usage**  
   Each node stores two references (`next` and `prev`), which requires more memory
   than a singly linked list.

---

### Basic Structure of a Doubly Linked List

#### Node Structure

Each node in a doubly linked list contains:
- **Data** — the value stored in the node
- **Next Reference** — reference to the next node
- **Previous Reference** — reference to the previous node

**Node Definition (Java Example)**:

```java
class Node {
    int data;      // Value stored in node
    Node next;     // Reference to next node
    Node prev;     // Reference to previous node

    Node(int value) {
        this.data = value;
        this.next = null;
        this.prev = null;
    }
}
````

---

### Representation

```
        +-----+---------+         +-----+---------+        +-----+---------+          +-----+---------+
```

null  <---- |  1  |   *---->| <---- |  2  |   *---->| <---- |  3  |   *---->| <---- |  4  |   null   |
+-----+---------+         +-----+---------+        +-----+---------+          +-----+---------+
head                                                                  tail

---

### Common Operations

1. **Insertion**

   * **At Beginning**:
     Create a new node → update its `next` to current head → set head’s `prev` → update head.
   * **At End**:
     Traverse to the tail → link new node using `next` and `prev`.
   * **At Position**:
     Adjust both `next` and `prev` references accordingly.

2. **Deletion**

   * **From Beginning**:
     Move head to `head.next` and set `prev` to `null`.
   * **From End**:
     Move tail to `tail.prev` and set `next` to `null`.
   * **By Value**:
     Re-link adjacent nodes to remove the target node.

3. **Traversal**

   * **Forward Traversal**: Use `next` reference.
   * **Backward Traversal**: Use `prev` reference.

---

### Advantages

* Allows traversal in both directions
* Easier deletion compared to singly linked list
* Efficient insertion and deletion

### Disadvantages

* Requires extra memory for two references per node
* More complex implementation than singly linked list

---

### Conclusion

A doubly linked list is an efficient data structure when bidirectional traversal
is required. Although it uses more memory than a singly linked list, its flexibility
makes it useful in applications such as navigation systems, undo/redo operations,
and memory management. This Java-based explanation provides a clear foundation
for implementing doubly linked lists.
*/

public class NodeClass {
    int data;
    NodeClass next;
    NodeClass prev;
}



import javax.swing.JOptionPane;

public class DoublyLinkedList {

    NodeClass start;

    public intDoublyLinkedList() {
        start = null;
    }

    public void insertAtEnd(int val) {
        NodeClass n1 = new NodeClass();
        n1.data = val;

        if (start == null) {
            start = n1;
        } else {
            NodeClass last = searchLast();
            last.next = n1;
            n1.prev = last;
        }
    }

    public NodeClass searchLast() {
        NodeClass ind = start;
        while (ind.next != null) {
            ind = ind.next;
        }
        return ind;
    }

    public NodeClass searchSpecific(int val) {
        NodeClass ind = start;
        while (ind != null) {
            if (ind.data == val) {
                return ind;
            }
            ind = ind.next;
        }
        return null;
    }

    public void insertAtStart(int val) {
        NodeClass n1 = new NodeClass();
        n1.data = val;

        if (start != null) {
            n1.next = start;
            start.prev = n1;
        }
        start = n1;
    }

    public void update(int newVal, int oldVal) {
        NodeClass up = searchSpecific(oldVal);
        if (up != null) {
            up.data = newVal;
        }
    }

    public void deleteLast() {
        if (start == null) return;

        NodeClass last = searchLast();

        if (last.prev != null) {
            last.prev.next = null;
        } else {
            start = null; 
        }
    }

    public void deleteFirst() {
        if (start == null) return;

        start = start.next;
        if (start != null) {
            start.prev = null;
        }
    }

    public void deleteSpecific(int val) {
        NodeClass del = searchSpecific(val);
        if (del == null) return;

        if (del.prev != null) {
            del.prev.next = del.next;
        } else {
            start = del.next;
        }

        if (del.next != null) {
            del.next.prev = del.prev;
        }
    }

    public void insertBefore(int val, int bef) {
        NodeClass temp = searchSpecific(bef);
        if (temp == null) return;

        NodeClass n1 = new NodeClass();
        n1.data = val;

        n1.next = temp;
        n1.prev = temp.prev;

        if (temp.prev != null) {
            temp.prev.next = n1;
        } else {
            start = n1;
        }

        temp.prev = n1;
    }

    public void insertAfter(int val, int aft) {
        NodeClass temp = searchSpecific(aft);
        if (temp == null) return;

        NodeClass n1 = new NodeClass();
        n1.data = val;

        n1.next = temp.next;
        n1.prev = temp;

        if (temp.next != null) {
            temp.next.prev = n1;
        }

        temp.next = n1;
    }

    public void display() {
        NodeClass temp = start;
        while (temp != null) {
            JOptionPane.showMessageDialog(null, temp.data);
            temp = temp.next;
        }
    }
}
