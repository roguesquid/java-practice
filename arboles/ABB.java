import java.util.LinkedList;
import java.util.Queue;

class ABB {

  private Node root;

  public ABB() {
    this.root = null;
  }

  /*
   * Retorna la raíz del árbol.
   * 
   * @return Raíz del árbol.
   */
  public Node getRoot() {
    return this.root;
  }

  /*
   * Inserta un dato en el árbol.
   * 
   * @param data Dato a insertar.
   */
  public void insert(int data) {
    root = insertarRecursivo(root, data);
  }

  /*
   * Inserta un dato en el árbol de forma recursiva.
   * 
   * @param nodo Nodo actual.
   * 
   * @param data Dato a insertar.
   * 
   * @return Nodo actualizado.
   */
  private Node insertarRecursivo(Node nodo, int data) {
    if (nodo == null) {
      return new Node(data);
    }

    if (data < nodo.getData()) {
      nodo.setLeft(insertarRecursivo(nodo.getLeft(), data));
    } else if (data > nodo.getData()) {
      nodo.setRight(insertarRecursivo(nodo.getRight(), data));
    }

    return nodo;
  }

  /*
   * Busca un dato en el árbol.
   * 
   * @param dato Dato a buscar.
   * 
   * @return true si el dato se encuentra en el árbol, false en caso contrario.
   */
  public boolean buscar(int dato) {
    return buscarRecursivo(root, dato);
  }

  /*
   * Busca en el arbol recursivamente
   * 
   * @param nodo Nodo actual.
   * 
   * @param dato Dato a buscar.
   * 
   * @return true si el dato se encuentra en el árbol, false en caso contrario.
   */
  private boolean buscarRecursivo(Node nodo, int dato) {
    if (nodo == null) {
      return false;
    }

    if (dato == nodo.getData()) {
      return true;
    }

    if (dato < nodo.getData()) {
      return buscarRecursivo(nodo.getLeft(), dato);
    } else {
      return buscarRecursivo(nodo.getRight(), dato);
    }
  }

  /*
   * Imprime el arbol en INORDEN
   */
  public void imprimirInOrden() {
    imprimirInOrdenRecursivo(root);
    System.out.println();
  }

  /*
   * Imprime el arbol en INORDEN de forma recursiva
   * 
   * @param nodo Nodo actual.
   */
  private void imprimirInOrdenRecursivo(Node nodo) {
    if (nodo != null) {
      imprimirInOrdenRecursivo(nodo.getLeft());
      System.out.print(nodo.getData() + " ");
      imprimirInOrdenRecursivo(nodo.getRight());
    }
  }

  /*
   * Cuenta los nodos de un arbol
   */
  public int contarNodos() {
    return contarNodosRecursivo(root);
  }

  /*
   * Cuenta los nodos de un arbol recursivamente
   * 
   * @param nodo Nodo actual.
   * 
   * @return Cantidad de nodos del arbol.
   */
  private int contarNodosRecursivo(Node nodo) {
    if (nodo == null) {
      return 0;
    }
    return 1 + contarNodosRecursivo(nodo.getLeft()) + contarNodosRecursivo(nodo.getRight());
  }

  /*
   * Cuenta las hojas de un arbol
   */
  public int contarHojas() {
    return contarHojasRecursivo(root);
  }

  /*
   * Cuenta las hojas de un arbol recursivamente
   * 
   * @param nodo Nodo actual.
   * 
   * @return Cantidad de hojas del arbol.
   */
  private int contarHojasRecursivo(Node nodo) {
    if (nodo == null) {
      return 0;
    } else if (nodo.isLeaf()) {
      return 1;
    } else {
      return contarHojasRecursivo(nodo.getLeft()) + contarHojasRecursivo(nodo.getRight());
    }
  }

  /*
   * Retorna la altura del arbol
   */
  public int altura() {
    return alturaRecursivo(root);
  }

  /*
   * Retorna la altura del arbol recursivamente
   * 
   * @param nodo Nodo actual.
   * 
   * @return Altura del arbol.
   */
  private int alturaRecursivo(Node nodo) {
    if (nodo == null) {
      return 0;
    }

    int alturaIzquierda = alturaRecursivo(nodo.getLeft());
    int alturaDerecha = alturaRecursivo(nodo.getRight());
    return (alturaDerecha > alturaIzquierda) ? alturaDerecha + 1 : alturaIzquierda + 1;
  }

  /*
   * Retorna la profundidad de un nodo
   */
  public int profundidad(int dato) {
    return calcularProfundidad(root, dato, 1);
  }

  /*
   * Retorna la profundidad de un nodo recursivamente
   * 
   * @param nodo Nodo actual.
   * 
   * @param dato Dato a buscar.
   */
  private int calcularProfundidad(Node nodo, int dato, int nivel) {
    if (nodo == null) {
      return -1; // retorna -1 si no consigue al nodo
    }

    if (nodo.getData() == dato) {
      return nivel;
    }

    int profundidadIzquierda = calcularProfundidad(nodo.getLeft(), dato, nivel + 1);
    int profundidadDerecha = calcularProfundidad(nodo.getRight(), dato, nivel + 1);

    if (profundidadIzquierda != -1) {
      return profundidadIzquierda;
    } else if (profundidadDerecha != -1) {
      return profundidadDerecha;
    } else {
      return -1;
    }
  }

  /*
   * Imprime el arbol por niveles
   * 
   * @param nodo Nodo actual.
   * 
   * @param nivel Nivel a imprimir del subarbol.
   */
  private void imprimirPorNivel(Node nodo, int nivel) {
    if (nodo == null) {
      return;
    }

    if (nivel == 0) {
      System.out.println(nodo.getData());
    } else {
      imprimirPorNivel(nodo.getLeft(), nivel - 1);
      imprimirPorNivel(nodo.getRight(), nivel - 1);
    }
  }

  /*
   * Busca el abuelo de un nodo
   * 
   * @param elemento Nodo a buscar abuelo.
   * 
   * @return Abuelo del nodo.
   */
  private Node buscarAbuelo(Node elemento) {
    if (elemento == null || elemento == root) {
      return null;
    }

    Node padre = buscarPadre(root, elemento);

    if (padre != null) {
      Node abuelo = buscarPadre(padre, elemento);
      return abuelo;
    }

    return null;
  }

  /*
   * Busca el padre de un nodo
   * 
   * @param actual Nodo actual.
   * 
   * @param elemento Nodo a buscar padre.
   * 
   * @return Padre del nodo.
   */
  private Node buscarPadre(Node actual, Node elemento) {
    if (actual == null) {
      return null;
    }

    if ((actual.getLeft() != null && actual.getLeft() == elemento)
        || (actual.getRight() != null && actual.getRight() == elemento)) {
      return actual;
    }

    Node resultadoIzquierdo = buscarPadre(actual.getLeft(), elemento);
    if (resultadoIzquierdo != null) {
      return resultadoIzquierdo;
    }

    Node resultadoDerecho = buscarPadre(actual.getRight(), elemento);
    if (resultadoDerecho != null) {
      return resultadoDerecho;
    }

    return null;
  }

  public int calcularAltura() {
    if (root == null) {
      return 0;
    }

    Queue<Node> cola = new LinkedList<>();
    cola.offer(root);
    int altura = 0;

    while (!cola.isEmpty()) {
      int nivelSize = cola.size();

      for (int i = 0; i < nivelSize; i++) {
        Node nodoActual = cola.poll();

        if (nodoActual.getLeft() != null) {
          cola.offer(nodoActual.getLeft());
        }
        if (nodoActual.getRight() != null) {
          cola.offer(nodoActual.getRight());
        }
      }

      altura++;
    }

    return altura;
  }

  public static class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }

    public int getData() {
      return this.data;
    }

    public Node getLeft() {
      return this.left;
    }

    public Node getRight() {
      return this.right;
    }

    public void setData(int data) {
      this.data = data;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    public boolean isLeaf() {
      return this.left == null && this.right == null;
    }
  }
}