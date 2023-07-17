public class ejercicios {

  public void insertarFondo(Pila<Integer> pila, int x) {
    if (!pila.esVacia()) {
      int actual = pila.desapilar();
      insertarFondo(pila, x);
      pila.apilar(actual);
    } else {
      pila.apilar(x);
    }
  }
}
