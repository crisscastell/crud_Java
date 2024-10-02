import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void  pausar() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Presione ENTER para continuar...");
        scanner.nextLine();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Contacto> listaCont = new ArrayList<>();
        while(true){
            System.out.println("AGENDA DE CONTACTOS \n1.Agregar \n2.Mostrar lista \n3.Buscar \n4.Actualizar \n5.Eliminar \n6.Salir");

            int opcion=0;
            while (opcion<=0 || opcion>=7){

                try {
                    System.out.println("Elige una opcion: ");
                    opcion = (int) Validador.validarNumeros(scanner.nextInt());
                } catch (NumeroInvalidoException e){
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e){
                    System.out.println("debes ingresar un numero entero");
                    System.out.println(e.getMessage());
                    scanner.next();
                } catch (NumberFormatException e){
                    System.out.println("debes ingresar un numero entero");
                }
            }

            scanner.nextLine();

            if(opcion == 1){

                String nombre=null;
                while (nombre == null){
                    System.out.print("Ingrese el nombre del contacto: ");
                    try {
                        nombre = Validador.validarLetras(scanner.nextLine());
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    } catch (Exception e){
                        System.out.println("Error no controlado");
                        System.out.println(e.getMessage());
                    }
                }

                String apellido=null;
                while (apellido == null){
                    System.out.print("Ingrese el apellido  del contacto: ");
                    try {
                        apellido = Validador.validarLetras(scanner.nextLine());
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    } catch (Exception e){
                        System.out.println("Error no controlado");
                        System.out.println(e.getMessage());
                    }
                }

                int telefono=0;
                while (true){

                    try {
                        System.out.println("Ingrese el telefono del contacto: ");
                        telefono = (int) Validador.validarNumeroEntero(scanner.nextInt());
                        break;
                    } catch (NumeroInvalidoException e){
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e){
                        System.out.println("debes ingresar un numero entero");
                        System.out.println(e.getMessage());
                        scanner.next();
                    } catch (NumberFormatException e){
                        System.out.println("debes ingresar un numero entero");
                    }
                }

                listaCont.add(new Contacto(nombre,apellido,telefono));

            }
            if (opcion==2){
                if (listaCont.isEmpty()){
                    System.out.println("No hay ningun contacto agregado");

                }else {
                    for (Contacto x : listaCont) {
                        System.out.println("Nombre:"+x.nombre);
                        System.out.println("Apellido:"+x.apellido);
                        System.out.println("Telefono:"+x.telefono+"\n----------------");
                    }
                    pausar();
                }

            }
            if(opcion==3){
                if (listaCont.isEmpty()){
                    System.out.println("No hay ningun contacto agregado");
                    pausar();

                }else {
                    System.out.println("Ingrese el nombre del contacto que desea buscar: ");
                    String nombreBuscar = scanner.nextLine();

                    for(int i = 0; i < listaCont.size(); i++){
                        Contacto cont =listaCont.get(i);

                        if (listaCont.get(i).nombre.equalsIgnoreCase(nombreBuscar)){

                            System.out.println("Nombre:"+cont.nombre);
                            System.out.println("Apellido:"+cont.apellido);
                            System.out.println("Telefono:"+cont.telefono+"\n----------------");
                            pausar();

                        }else{
                            System.out.println("No existe este contacto");
                            pausar();

                        }

                    }

                }

            }
            if (opcion==4){
                if (listaCont.isEmpty()){
                    System.out.println("No hay ningun contacto agregado");
                    pausar();

                }else{
                    for (Contacto par : listaCont) {
                        System.out.println(par);
                    }
                    System.out.println("Ingrese el nombre del contacto que desea actualizar: ");
                    String nombreActualizar=scanner.nextLine();

                    for(int i = 0; i < listaCont.size(); i++){
                        Contacto cont = listaCont.get(i);


                        if (listaCont.get(i).nombre.equalsIgnoreCase(nombreActualizar)){

                            int opc=0;
                            while (opc<=0 || opc>=6) {

                                try {
                                    System.out.println("Que desea actualizar? \n1.Nombre\n2.Apellido \n3.Telefono\n4.Todas\n5.Cancelar");
                                    opc = (int) Validador.validarNumeros(scanner.nextInt());
                                } catch (NumeroInvalidoException e) {
                                    System.out.println(e.getMessage());
                                } catch (InputMismatchException e) {
                                    System.out.println("debes ingresar un numero entero");
                                    System.out.println(e.getMessage());
                                    scanner.next();
                                } catch (NumberFormatException e) {
                                    System.out.println("debes ingresar un numero entero");
                                }
                            }

                            scanner.nextLine();

                            if (opc==1){
                                String nuevoNombre=null;
                                while (nuevoNombre == null){
                                    System.out.print("Ingrese el nombre del contacto: ");
                                    try {
                                        nuevoNombre = Validador.validarLetras(scanner.nextLine());
                                    } catch (IllegalArgumentException e){
                                        System.out.println(e.getMessage());
                                    } catch (Exception e){
                                        System.out.println("Error no controlado");
                                        System.out.println(e.getMessage());
                                    }
                                }
                                cont.nombre=nuevoNombre;
                            }
                            if (opc==2){
                                String nuevoApellido=null;
                                while (nuevoApellido == null){
                                    System.out.print("Ingrese el apellido  del contacto: ");
                                    try {
                                        nuevoApellido = Validador.validarLetras(scanner.nextLine());
                                    } catch (IllegalArgumentException e){
                                        System.out.println(e.getMessage());
                                    } catch (Exception e){
                                        System.out.println("Error no controlado");
                                        System.out.println(e.getMessage());
                                    }
                                }
                                cont.apellido=nuevoApellido;
                            }
                            if (opc==3){
                                int nuevoTelefono=0;
                                while (true){

                                    try {
                                        System.out.println("Ingrese el telefono del contacto: ");
                                        nuevoTelefono = (int) Validador.validarNumeroEntero(scanner.nextInt());
                                        break;
                                    } catch (NumeroInvalidoException e){
                                        System.out.println(e.getMessage());
                                    } catch (InputMismatchException e){
                                        System.out.println("debes ingresar un numero entero");
                                        System.out.println(e.getMessage());
                                        scanner.next();
                                    } catch (NumberFormatException e){
                                        System.out.println("debes ingresar un numero entero");
                                    }
                                }
                                cont.telefono=nuevoTelefono;

                            }
                            if (opc==4){
                                String nuevoNombre=null;
                                while (nuevoNombre == null){
                                    System.out.print("Ingrese el nombre del contacto: ");
                                    try {
                                        nuevoNombre = Validador.validarLetras(scanner.nextLine());
                                    } catch (IllegalArgumentException e){
                                        System.out.println(e.getMessage());
                                    } catch (Exception e){
                                        System.out.println("Error no controlado");
                                        System.out.println(e.getMessage());
                                    }
                                }

                                String nuevoApellido=null;
                                while (nuevoApellido == null){
                                    System.out.print("Ingrese el apellido  del contacto: ");
                                    try {
                                        nuevoApellido = Validador.validarLetras(scanner.nextLine());
                                    } catch (IllegalArgumentException e){
                                        System.out.println(e.getMessage());
                                    } catch (Exception e){
                                        System.out.println("Error no controlado");
                                        System.out.println(e.getMessage());
                                    }
                                }

                                int nuevoTelefono=0;
                                while (true){

                                    try {
                                        System.out.println("Ingrese el telefono del contacto: ");
                                        nuevoTelefono = (int) Validador.validarNumeroEntero(scanner.nextInt());
                                        break;
                                    } catch (NumeroInvalidoException e){
                                        System.out.println(e.getMessage());
                                    } catch (InputMismatchException e){
                                        System.out.println("debes ingresar un numero entero");
                                        System.out.println(e.getMessage());
                                        scanner.next();
                                    } catch (NumberFormatException e){
                                        System.out.println("debes ingresar un numero entero");
                                    }
                                }
                                cont.telefono=nuevoTelefono;
                                cont.apellido=nuevoApellido;
                                cont.nombre=nuevoNombre;
                            }
                            if(opc==5){
                                return;
                            }
                        }else {
                            System.out.println("No existe esa persona");
                            pausar();

                        }
                    }
                }
            }
            if (opcion==5){
                if (listaCont.isEmpty()){
                    System.out.println("No hay ningun contacto agregado");
                    pausar();

                }
                for (Contacto par : listaCont) {
                    System.out.println(par);
                }
                System.out.println("Ingrese el nombre: ");
                String n=scanner.nextLine();

                for(int i = 0; i < listaCont.size(); i++){
                    if (listaCont.get(i).nombre.equalsIgnoreCase(n)){
                        listaCont.remove(i);
                        System.out.println("El contacto " + n + " ha sido eliminado.");
                        pausar();

                    }else {
                        System.out.println("No existe ese contacto");
                        pausar();

                    }

                }

            }
            if (opcion==6){
                break;
            }

        }
    }
}