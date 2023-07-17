public class ejerciciosCola {
  public static void main(String[] args) {
    Cola<Integer> cola = new Cola<>();
    cola.encolar(2);
    cola.encolar(4);
    cola.encolar(6);
    cola.encolar(8);
    cola.encolar(10);

    // System.out.println("Cola: " + cola);
    // double promedio = promedio(cola);
    // System.out.println("Promedio: " + promedio);
    System.out.println(mayor(cola));
    System.out.println(menor(cola));
  }

  public static int mayor(Cola<Integer> cola) {
    if (!cola.esVacia()) {
      int actual = cola.desencolar();
      int otro = mayor(cola);
      cola.encolar(actual);
      return (actual > otro) ? actual : otro;
    }
    return 0;
  }

  public static int menor(Cola<Integer> cola) {
    if (!cola.esVacia()) {
      int actual = cola.desencolar();
      int otro = menor(cola);
      cola.encolar(actual);
      return (actual < otro) ? actual : otro;
    }
    return 0;
  }

  public static int suma(Cola<Integer> cola) {
    if (cola.esVacia()) {
      return 0;
    }

    int actual = cola.desencolar();
    int suma = suma(cola) + actual;
    System.out.print(actual + " ");
    cola.encolar(actual);
    return suma;
  }

  public static double promedio(Cola<Integer> cola) {
    return suma(cola) / cola.getTamano();
  }
}
