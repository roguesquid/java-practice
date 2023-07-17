public class Cola<T> {
  private Nodo<T> frente;
  private Nodo<T> fin;
  private int tamano;

  public Cola() {
    this.frente = null;
    this.fin = null;
    this.tamano = 0;
  }

  /*
   * Devuelve el tamano de la cola.
   */
  public int getTamano() {
    return tamano;
  }

  /*
   * Devuelve true si la cola está vacía, false en caso contrario.
   */
  public boolean esVacia() {
    return tamano == 0;
  }

  /*
   * Agrega un elemento al final de la cola.
   * 
   * @param elemento el elemento a agregar.
   */
  public void encolar(T elemento) {
    Nodo<T> nuevoNodo = new Nodo<>(elemento);
    if (esVacia()) {
      frente = nuevoNodo;
      fin = nuevoNodo;
    } else {
      fin.setSiguiente(nuevoNodo);
      fin = nuevoNodo;
    }
    tamano++;
  }

  /*
   * Elimina el elemento que está en el frente de la cola.
   * 
   * @return el elemento que está en el frente de la cola.
   */
  public T desencolar() {
    if (esVacia()) {
      throw new IllegalStateException("La cola está vacía");
    }
    T elemento = frente.getElemento();
    frente = frente.getSiguiente();
    if (frente == null) {
      fin = null;
    }
    tamano--;
    return elemento;
  }

  /*
   * Devuelve el elemento que está en el frente de la cola.
   * 
   * @return el elemento que está en el frente de la cola.
   */
  public T frente() {
    if (esVacia()) {
      throw new IllegalStateException("La cola está vacía");
    }
    return frente.getElemento();
  }

  private static class Nodo<T> {
    private T elemento;
    private Nodo<T> siguiente;

    public Nodo(T elemento) {
      this.elemento = elemento;
      this.siguiente = null;
    }

    public T getElemento() {
      return elemento;
    }

    public Nodo<T> getSiguiente() {
      return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
      this.siguiente = siguiente;
    }
  }
}
