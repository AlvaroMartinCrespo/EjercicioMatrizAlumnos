package Relacion9;

import java.util.Random;
import java.util.Scanner;

public class PrincipalEjercicio1 {

	public static final int NUMERO_ALUMNOS = 8;
	public static final int NOTA_LIMITE_APROBADO = 5;
	public static final int NOTA_MAXIMA = 10;
	public static final String[] ASIGNATURAS = { "PROGRAMACION", "BASE DE DATOS", "LENGUAJES DE MARCA" };

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int matrizNotas[][] = new int[NUMERO_ALUMNOS][ASIGNATURAS.length];
		String asignatura;
		int indiceAlumno;

		cargarNotasMatriz(matrizNotas);

		imprimirNotas(matrizNotas);

		numeroDeSuspensosPorAlumno(matrizNotas);

		System.out.println("Introduce asignatura:");
		asignatura = teclado.nextLine();

		notaMediaDeAsignatura(matrizNotas, asignatura);
		
		alumnosSuspensas(matrizNotas);
		
		System.out.println();
		System.out.println("Introduce el número del alumnos que quieres saber la mejor nota:");
		indiceAlumno=teclado.nextInt();
		mejorNotaAlumno(indiceAlumno, matrizNotas, ASIGNATURAS);

	}

	/**
	 * Carga los datos de la matriz con notas aleatorias entre 0 y 10
	 * 
	 * @param matrizNotas
	 */
	private static void cargarNotasMatriz(int matrizNotas[][]) {

		int indiceAlumno, indiceAsignatura;

		Random serie = new Random();

		for (indiceAlumno = 0; indiceAlumno < matrizNotas.length; indiceAlumno++) {

			for (indiceAsignatura = 0; indiceAsignatura < matrizNotas[0].length; indiceAsignatura++) {

				matrizNotas[indiceAlumno][indiceAsignatura] = serie.nextInt(NOTA_MAXIMA + 1); // DE
																								// 0
																								// A
																								// NOTA_MAXIMA
			}
		}
	}

	/**
	 * Imprime las notas por pantalla
	 * 
	 * @param matrizNotas
	 */
	private static void imprimirNotas(int matrizNotas[][]) {

		int indiceAlumno, indiceAsignatura;

		for (int i = 0; i < ASIGNATURAS.length; i++) {
			System.out.print("\t" + ASIGNATURAS[i]);
		}

		System.out.println();

		for (indiceAlumno = 0; indiceAlumno < matrizNotas.length; indiceAlumno++) {

			System.out.print("Alumno " + (indiceAlumno + 1) + "    ");

			for (indiceAsignatura = 0; indiceAsignatura < matrizNotas[0].length; indiceAsignatura++) {

				System.out.print(matrizNotas[indiceAlumno][indiceAsignatura]);
				System.out.print("\t\t");
			}
			System.out.println();
		}

	}

	/**
	 * Realiza un listado donde aparezca para cada alumno cuantos suspensos tiene
	 */

	private static void numeroDeSuspensosPorAlumno(int matrizNotas[][]) {

		int suspensos = 0;

		System.out.println();

		System.out.println(".:SUSPENSOS:.");

		System.out.println();

		for (int i = 0; i < matrizNotas.length; i++) {

			for (int j = 0; j < matrizNotas[i].length; j++) {

				if (matrizNotas[i][j] < NOTA_LIMITE_APROBADO) {
					suspensos++;

				}

			}

			System.out.println("ALumno " + (i + 1) + " tiene " + suspensos + " suspensos");
			suspensos = 0;

		}

		System.out.println();

	}

	private static void notaMediaDeAsignatura(int matrizNotas[][], String asignatura) {

		int indiceAsignatura, suma = 0;
		double media;

		asignatura = asignatura.toLowerCase();

		if (asignatura.equals("programacion")) {

			indiceAsignatura = 0;

		} else if (asignatura.equals("base de datos")) {

			indiceAsignatura = 1;

		} else {

			indiceAsignatura = 2;

		}

		for (int i = 0; i < matrizNotas.length; i++) {

			suma += matrizNotas[i][indiceAsignatura];

		}

		media = suma / 8.0;
//		media=suma/NUMERO_ALUMNOS;

		System.out.println();
		System.out.println(".:MEDIA:.");

		if (indiceAsignatura == 0) {

			System.out.println("Media Programación: " + media);

		} else if (indiceAsignatura == 1) {

			System.out.println("Media Base de Datos: " + media);

		} else {

			System.out.println("Media Lenguaje de Marcas: " + media);

		}

	}

	private static void alumnosSuspensas(int matrizNotas[][]) {

		int suspensos = 0;
		int suspensos5 = 0, suspensos4 = 0, suspensos3 = 0, suspensos2 = 0, suspensos1 = 0, suspensos0 = 0;

		for (int i = 0; i < matrizNotas.length; i++) {

			for (int j = 0; j < matrizNotas[i].length; j++) {

				if (matrizNotas[i][j] < NOTA_LIMITE_APROBADO) {
					suspensos++;

				}

			}

			if (suspensos == 0) {

			} else if (suspensos == 1) {

				suspensos1++;

			} else if (suspensos == 2) {

				suspensos2++;

			} else if (suspensos == 3) {

				suspensos3++;

			} else if (suspensos == 4) {

				suspensos4++;

			} else {

				suspensos5++;

			}

			suspensos = 0;

		}

		System.out.println();

		System.out.println(".:NUMERO DE SUSPENSOS:.");
		System.out.println(
				"Número de alumnos que han suspendido 5: " + suspensos5 + "\nNúmero de alumnos que han suspendido 4: "
						+ suspensos4 + "\nNúmero de alumnos que han suspendido 3: " + suspensos3
						+ "\nNúmero de alumnos que han suspendido 2: " + suspensos2
						+ "\nNúmero de alumnos que han suspendido 1: " + suspensos1
						+ "\nNúmero de alumnos que han suspendido 0: " + suspensos0);

	}

	private static void mejorNotaAlumno(int indiceAlumno, int matrizNotas[][], String ASIGNATURAS[]) {
		
		int mejorNota=0, indiceNota=0;
		
		indiceAlumno-=1;
		
		for(int j=0;j<matrizNotas[indiceAlumno].length;j++) {
			
			if(mejorNota<matrizNotas[indiceAlumno][j]) {
				
				mejorNota=matrizNotas[indiceAlumno][j];
				indiceNota=j;
				
			}
			
		}
		
		System.out.println("Alumno " + (indiceAlumno+1) + ":" + " La mejor nota es " + matrizNotas[indiceAlumno][indiceNota] + " en " + ASIGNATURAS[indiceNota]);
		
	}

}
