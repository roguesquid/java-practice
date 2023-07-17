public class Pila<T> {
  private Nodo<T> tope;
  private int tamaño;

  public Pila() {
    this.tope = null;
    this.tamaño = 0;
  }

  public int getTamaño() {
    return tamaño;
  }

  public boolean esVacia() {
    return tamaño == 0;
  }

  public void apilar(T elemento) {
    Nodo<T> nuevoNodo = new Nodo<>(elemento);
    if (esVacia()) {
      tope = nuevoNodo;
    } else {
      nuevoNodo.setSiguiente(tope);
      tope = nuevoNodo;
    }
    tamaño++;
  }

  public T desapilar() {
    if (esVacia()) {
      throw new IllegalStateException("La pila está vacía");
    }
    T elemento = tope.getElemento();
    tope = tope.getSiguiente();
    tamaño--;
    return elemento;
  }

  public T tope() {
    if (esVacia()) {
      throw new IllegalStateException("La pila está vacía");
    }
    return tope.getElemento();
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
