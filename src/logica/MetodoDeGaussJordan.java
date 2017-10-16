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

    public double[] cargarMatriz(double m[][], double r[]) {

        // recuerde que el metodo de Gauss Jordan trabaja con la idea de convertir la matriz aumentada en la matriz identidad
        for (int i = 0; i <= r.length - 1; i++) {
            double d, c = 0;
            d = m[i][i];// seleccionamos el pivote
            for (int s = 0; s <= r.length - 1; s++) {// pasamos a convertir en 1 al pivote seleionado
                m[i][s] = ((m[i][s]) / d);
            }
            r[i] = ((r[i]) / d);

            for (int x = 0; x <= r.length - 1; x++) {
                if (i != x) {
                    c = m[x][i];
                    for (int y = 0; y <= r.length - 1; y++) {// se hace cero a todos los elemntos de la colunma que no sean el pivote
                        m[x][y] = m[x][y] - c * m[i][y];
                    }
                    r[x] = r[x] - c * r[i];
                }// fin if (i != x)
            }// fin for (int x = 0; x <= r.length - 1; x++)
        }//fin bucle i
        return r;// retorna la solucion l sistema
    }
}
