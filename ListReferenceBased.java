// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListReferenceBased implements ListInterface {
  // reference to linked list of items
  private Node head; 
  private int numItems; // number of items in list

  public ListReferenceBased() {
    numItems = 0;
    head = null;
  }  // end default constructor

  public boolean isEmpty() {
    return numItems == 0;
  }  // end isEmpty

  public int size() {
    return numItems;
  }  // end size

  private Node find(int index) {
  // --------------------------------------------------
  // Locates a specified node in a linked list.
  // Precondition: index is the number of the desired
  // node. Assumes that 0 <= index <= numItems
  // Postcondition: Returns a reference to the desired 
  // node.
  // --------------------------------------------------
    Node curr = head;
    for (int skip = 0; skip < index; skip++) {
      curr = curr.getNext();
    } // end for
    return curr;
  } // end find

  public Object get(int index) 
                throws ListIndexOutOfBoundsException {
    if (index >= 0 && index < numItems) {
      // get reference to node, then data in node
      Node curr = find(index);
      Object dataItem = curr.getItem();
      return dataItem;
    } 
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on get");
    } // end if
  } // end get

  public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException {
    if (index >= 0 && index <= numItems) {
      if (index == 0) {
        // insert the new node containing item at
        // beginning of list
        Node newNode = new Node(item, head);
        head = newNode;
      } 
      else {
        Node prev = find(index-1);
        // insert the new node containing item after 
        // the node that prev references
        Node newNode = new Node(item, prev.getNext());
        prev.setNext(newNode);
      } // end if
      numItems++;
    } 
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on add");
    } // end if
  }  // end add

  public void remove(int index) 
                     throws ListIndexOutOfBoundsException {
    if (index >= 0 && index < numItems) {
      if (index == 0) {
        // delete the first node from the list
        head = head.getNext();
      } 
      else {
        Node prev = find(index-1);
        // delete the node after the node that prev
        // references, save reference to node
        Node curr = prev.getNext(); 
        prev.setNext(curr.getNext());
      } // end if
      numItems--;
    } // end if
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on remove");
    } // end if
  }   // end remove

  public void removeAll() {
    // setting head to null causes list to be
    // unreachable and thus marked for garbage 
    // collection
    head = null;
    numItems = 0;
  } // end removeAll
  
  /**
   * insert: inserts a new item into a sorted list.
   * @param item    an Object, the item to be inserted 
   * @return none
   * Precondition: list is sorted, and the items on the list implement the Comparable interface.
   * Postcondition: list is still sorted, with the new item inserted.
   */
  public void insert(Object item) 
  {
        // Create a new node and put the given item in it.
        Node newNode = new Node(item);
        
        // Declare variables for traversing the list using the piggybacking technique.
        Node current, prev;
        current = head;
        prev = null;
        
        // Determine the point of insertion.
        while (current!=null && ((Comparable) current.getItem()).compareTo(newNode.getItem()) < 0) {
            //StockItem currentData = (StockItem)current.getItem();
            //StockItem newData = (StockItem)newNode.getItem();
            prev = current;
            current = current.getNext();
        }
      
        // Check for the special case of inserting at the beginning of the list.
        if (prev != null) {
            // The new node is not at the beginning of the list.
            newNode.setNext(current);
            prev.setNext(newNode);
        } // end if
        else {
            // Inserting at the beginning of the list.
            newNode.setNext(head);
            head = newNode;
        } // end else
        
        // We have inserted a new item so increment the number of items.
        this.numItems++;
  } // end method insert
  
  public void insertNoDuplicates(Object item)
  {
        Node newNode = new Node(item);
        
        // Declare variables for traversing the list using the piggybacking technique.
        Node current, prev;
        current = head;
        prev = null;
        boolean flag = false;
        
        while (current!=null) 
        {
            //StockItem currentData = (StockItem)current.getItem();
            //StockItem newData = (StockItem)newNode.getItem();
            if(((Comparable) current.getItem()).compareTo(newNode.getItem()) == 0)
            {
                flag = true;
            }
            prev = current;
            current = current.getNext();
        }
            
            if (!flag)
            {
                this.insert(item);
            }

        
    
  }//end insertNoDuplicates

} // end ListReferenceBased