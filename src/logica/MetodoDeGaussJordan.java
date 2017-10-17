/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Fernando
 */
public class MetodoDeGaussJordan {

    /**
     * Función que carga la metriz aumentada y retorna el resultado de cada variable
     * @fuente http://ingeuce.wixsite.com/ingeuce2/productos/ProductListItem1_hplorucy4_1/M%C3%A9todo-de-Gauss-Jordan-en-javaNetbeans
     * @param m matriz double
     * @param r arreglo double
     * @return r arreglo double
     */
    public double[] cargarMatriz(double m[][], double r[]) {

        // recuerde que el metodo de Gauss Jordan trabaja con la idea de convertir la matriz aumentada en la matriz identidad
        for (int i = 0; i <= r.length - 1; i++) {
            double d, c = 0;
            d = m[i][i];// seleccionamos el pivote
            if (Double.isNaN(d)) {
                continue;
            }
            //System.out.println(Double.toString(d/2) + "*fila" + (i + 1) + "\n");// muestra en el area de texto el pivote seleccionado
            for (int s = 0; s <= r.length - 1; s++) {// pasamos a convertir en 1 al pivote seleccionado
                if (Double.isNaN(m[i][s])) {
                    continue;
                }
                m[i][s] = ((m[i][s]) / d);
            }
            r[i] = ((r[i]) / d);
            if (Double.isNaN(r[i])) {
                continue;
            }

            for (int x = 0; x <= r.length - 1; x++) {
                if (i != x) {
                    c = m[x][i];
                    if (Double.isNaN(c)) {
                        continue;
                    }
                    for (int y = 0; y <= r.length - 1; y++) {// se hace cero a todos los elementos de la colunma que no sean el pivote
                        m[x][y] = m[x][y] - c * m[i][y];
                    }
                    r[x] = r[x] - c * r[i];
                }// fin if (i != x)
            }// fin for (int x = 0; x <= r.length - 1; x++)
        }//fin bucle i
        return r;// retorna la solucion l sistema
    }

}
