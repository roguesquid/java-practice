public class LinkedList<T> {
  private Node<T> head;
  private int size;

  public LinkedList() {
    this.head = null;
    this.size = 0;
  }

  /*
   * Metodo que retorna el tamano de la lista
   * 
   * @return tamano de la lista
   */
  public int getSize() {
    return size;
  }

  /*
   * Metodo que verifica si la lista esta vacia
   * 
   * @return true si la lista esta vacia, false en caso contrario
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /*
   * Metodo que agrega un elemento a la lista
   * 
   * @param element elemento a agregar
   */
  public void add(T element) {
    Node<T> newNode = new Node<>(element);
    if (isEmpty()) {
      head = newNode;
    } else {
      Node<T> current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
    size++;
  }

  /*
   * Metodo que remueve un elemento de la lista
   * 
   * @param element elemento a remover
   */
  public void remove(T element) {
    if (isEmpty()) {
      return;
    }
    if (head.getElement().equals(element)) {
      head = head.getNext();
      size--;
      return;
    }
    Node<T> current = head;
    Node<T> previous = null;
    while (current != null && !current.getElement().equals(element)) {
      previous = current;
      current = current.getNext();
    }
    if (current != null) {
      previous.setNext(current.getNext());
      size--;
    }
  }

  /*
   * Metodo que verifica si un elemento esta en la lista
   * 
   * @param element elemento a buscar
   * 
   * @return true si el elemento esta en la lista, false en caso contrario
   */
  public boolean contains(T element) {
    Node<T> current = head;
    while (current != null) {
      if (current.getElement().equals(element)) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  /*
   * Metodo que imprime los elementos de la lista
   */
  public void printList() {
    Node<T> current = head;
    while (current != null) {
      System.out.print(current.getElement() + " ");
      current = current.getNext();
    }
    System.out.println();
  }

  private static class Node<T> {
    private T element;
    private Node<T> next;

    public Node(T element) {
      this.element = element;
      this.next = null;
    }

    public T getElement() {
      return element;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }
  }
}
