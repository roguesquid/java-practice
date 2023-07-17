public class Mezclar {
  /*
   * Inserta un dato en una pila de forma ordenada.
   * Complejidad: O(n)
   * @param pila Pila en la que se insertará el dato.
   * @param dato Dato a insertar.
   */
  public void insertarOrdenadamente(Pila<Integer> pila, int dato) {
    if (pila.esVacia() || dato > pila.tope()) {
      pila.apilar(dato);
    } else {
      int actual = pila.desapilar();
      insertarOrdenadamente(pila, dato);
      pila.apilar(actual);
    }
  }

  /*
   * Inserta una pila en otra de forma ordenada.
   * Complejidad: O(n^2)
   * @param pila1 Pila que se insertará en la otra.
   * @param pila2 Pila en la que se insertará la otra.
   */
  public void insertarPilaEnOtraOrdenadamente(Pila<Integer> pila1, Pila<Integer> pila2) {
    if (!pila1.esVacia()) {
      int actual = pila1.desapilar();
      insertarPilaEnOtraOrdenadamente(pila1, pila2);
      insertarOrdenadamente(pila2, actual);
      pila1.apilar(actual);
    }
  }

  /*
   * Mezcla dos pilas de forma ordenada.
   * Complejidad: O(n^2)
   * @param pila1 Primera pila a mezclar.
   * @param pila2 Segunda pila a mezclar.
   * @return Pila con los elementos de las dos pilas mezclados de forma ordenada.
   */
  public Pila<Integer> mezclar(Pila<Integer> pila1, Pila<Integer> pila2) {
    Pila<Integer> pila3 = new Pila<>();

    insertarPilaEnOtraOrdenadamente(pila2, pila3);
    insertarPilaEnOtraOrdenadamente(pila1, pila3);

    return pila3;
  }
}
