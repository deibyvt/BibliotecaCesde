package bibliotecaCesde;

import java.util.Scanner;

public class Proyecto {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===== ADMIN =====
        String adminUser = "admin";
        String adminPass = "1234";

        // ===== USUARIOS =====
        String[] usuarios = new String[5];   // usuario
        String[] cedulas = new String[5];
        String[] nombres = new String[5];
        String[] correos = new String[5];
        String[] passwords = new String[5];
        int totalUsuarios = 0;

        //==== Usuario Logueado =====
        String usuarioLoguado = "";
        String cedulaLogueado = "";
        String nombresLogueado = "";
        String correosLogueado = "";
        boolean loginOk = false;

        // ===== LIBROS =====
        String[] codLibros = new String[10];
        String[] titulos = new String[10];
        boolean[] disponibles = new boolean[10];
        int totalLibros = 5; // pre-cargamos 5 libros

        // Pre-cargar 5 libros
        codLibros[0] = "L001";
        titulos[0] = "Java Básico";
        disponibles[0] = true;
        codLibros[1] = "L002";
        titulos[1] = "Python Intermedio";
        disponibles[1] = true;
        codLibros[2] = "L003";
        titulos[2] = "Estructuras de Datos";
        disponibles[2] = true;
        codLibros[3] = "L004";
        titulos[3] = "Bases de Datos";
        disponibles[3] = true;
        codLibros[4] = "L005";
        titulos[4] = "Desarrollo Web";
        disponibles[4] = true;

        // ===== RESERVAS =====
        String[] cedulaReserva = new String[10];
        String[] libroReserva = new String[10];
        int[] diasDevolucion = new int[10];
        int totalReservas = 0;
        String eliminarCed;
        String buscarCedula;

        int opcionPrincipal;

        do {
            System.out.println("""
                    ===== BIBLIOTECA CESDE =====
                    Seleciones la opcion correcta:
                    Desea ingresar como:
                    1) Administrador
                    2) Usuario
                    3) Salir
                    """);
            opcionPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcionPrincipal) {


                case 1:// ================= ADMIN =================
                    System.out.print("Usuario admin: ");
                    String uAdmin = sc.nextLine();
                    System.out.print("Contraseña: ");
                    String pAdmin = sc.nextLine();

                    if (uAdmin.equals(adminUser) && pAdmin.equals(adminPass)) {
                        System.out.println("✅Ingreso exitoso");

                        int opAdmin;
                        do {
                            System.out.println("""
                                    --- MENÚ ADMIN ---
                                    1) Usuarios
                                    2) Libros 
                                    3) Reservas 
                                    4) Salir
                                    """);
                            opAdmin = sc.nextInt();
                            sc.nextLine();
                            switch (opAdmin) {
                                case 1: // Usuario
                                    int opCrudUser;
                                    do {
                                        System.out.println("""
                                                Crud Usuarios por el admin, desea:
                                                1) Crear Usurio
                                                2) Actualizar Usuario
                                                3) Eliminar Usuario
                                                4) Ver Usuarios
                                                5) Atras
                                                """);
                                        opCrudUser = sc.nextInt();
                                        sc.nextLine();
                                        switch (opCrudUser) {
                                            case 1:// crear usuario
                                                if (totalUsuarios < nombres.length) {
                                                    System.out.println("Por favor ingrese los datos del usuario:");
                                                    System.out.println("Ingrese el nombre: ");
                                                    nombres[totalUsuarios] = sc.nextLine();
                                                    System.out.println("Ingrese la Cedula: ");
                                                    cedulas[totalUsuarios] = sc.nextLine();
                                                    System.out.println("Ingrese el correo: ");
                                                    correos[totalUsuarios] = sc.nextLine();
                                                    System.out.println("Ingrese la contraseña: ");
                                                    passwords[totalUsuarios] = sc.nextLine();
                                                    totalUsuarios++;
                                                    System.out.println("✅Usuario creado correctamente");
                                                } else System.out.println("No se puedo registrar mas usuarios");
                                                break;

                                            case 2: // lo buscamos por la cedula y actualizamos los datos
                                                boolean update = true;
                                                do {

                                                    System.out.println("Ingrese  la cedula que desea buscar: ");
                                                    buscarCedula = sc.next();
                                                    for (int j = 0; j < totalUsuarios; j++) {
                                                        if (buscarCedula.equalsIgnoreCase(cedulas[j])) {
                                                            System.out.println("Usuario encontrado:");
                                                            System.out.println("Nombre: " + nombres[j]);
                                                            System.out.println("Correo: " + correos[j]);
                                                            System.out.println("Contraseña: " + passwords[j]);
                                                            System.out.println("Ingrese los datos del usuario que va  a actualizar");
                                                            System.out.println("Ingrese el nuevo nombre:");
                                                            nombres[j] = sc.nextLine();
                                                            System.out.println("Ingrese la nueva cédula:");
                                                            cedulas[j] = sc.nextLine();
                                                            System.out.println("Ingrese el nuevo correo:");
                                                            correos[j] = sc.nextLine();
                                                            System.out.println("Ingrese la nueva contraseña:");
                                                            passwords[j] = sc.nextLine();
                                                            System.out.println("✅Usuario actualizado correctamente.");
                                                            update = true;
                                                            break;
                                                        } else if (j == totalUsuarios - 1) {
                                                            System.out.println("no se encontro el usuario");
                                                            System.out.println("desea volver a buscar otro usuario 'si' o 'no': ");
                                                            String confirmacion = sc.next();
                                                            if (confirmacion.equals("no")) {
                                                                update = false;
                                                                break;
                                                            } else {
                                                                update = true;
                                                                break;
                                                            }
                                                        }
                                                    }

                                                } while (update);
                                                break;
                                            case 3:// lo eliminamos tambien por la cedula
                                                System.out.println("Ingrese la cédula del usuario a eliminar:");
                                                eliminarCed = sc.nextLine();
                                                for (int j = 0; j < totalUsuarios; j++) {
                                                    if (eliminarCed.equalsIgnoreCase(cedulas[j])) {
                                                        for (int k = j; k < totalUsuarios - 1; k++) {
                                                            nombres[k] = nombres[k + 1];
                                                            cedulas[k] = cedulas[k + 1];
                                                            correos[k] = correos[k + 1];
                                                            passwords[k] = passwords[k + 1];
                                                        }
                                                        nombres[totalUsuarios - 1] = null;
                                                        cedulas[totalUsuarios - 1] = null;
                                                        correos[totalUsuarios - 1] = null;
                                                        passwords[totalUsuarios - 1] = null;
                                                        totalUsuarios--;
                                                        System.out.println("✅Usuario eliminado correctamente.");
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 4: // mostramos todos los registros exitosos
                                                System.out.println("✅Lista de usuarios registrados exitosamente");
                                                for (int i = 0; i < totalUsuarios; i++) {
                                                    System.out.println((i + 1) + ") " + "Nombre: " + nombres[i] + " | Cédula: " + cedulas[i] + " | Correo: " + correos[i]);
                                                }
                                                break;
                                            case 5:
                                                System.out.println("Volviendo al menú admin...");
                                                break;
                                            default:
                                                System.out.println("Opción inválida.");
                                                break;
                                        }
                                    } while (opCrudUser != 5);
                                    break;

                                case 2: //LIBROS
                                    boolean opLibros = true;
                                    int opCrudLibros;
                                    do {
                                        System.out.println("""
                                                1) Crear libros
                                                2) Actualizar libros
                                                3) Eliminar libros
                                                4) Ver libros
                                                5) Atras """);

                                        opCrudLibros = sc.nextInt();
                                        switch (opCrudLibros) {
                                            case 1: // crear libro

                                                if (totalLibros < codLibros.length) {
                                                    System.out.println("Codigo del libro:");
                                                    codLibros[totalLibros] = sc.next();
                                                    sc.nextLine();
                                                    System.out.println("Por favor ingrese el nombre del libro");
                                                    titulos[totalLibros] = sc.nextLine();
                                                    disponibles[totalLibros] = true;
                                                    System.out.println("Libro ingresado con exito");
                                                    totalLibros++;
                                                } else {
                                                    System.out.println("No se pueden crear mas Libros almacenamiento lleno");
                                                }
                                                break;
                                            case 2: // Actualizar

                                                boolean cont = true;

                                                do {
                                                    System.out.println("Por favor ingrese el codigo del libro que desea actualizar");
                                                    String codBuscar = sc.next();
                                                    sc.nextLine();

                                                    for (int i = 0; i <= totalLibros-1; i++) {
                                                        if (codLibros[i].equalsIgnoreCase(codBuscar)) {
                                                            System.out.println("Libro encontrado");
                                                            System.out.println("Codigo: " + codLibros[i]);
                                                            System.out.println("Titulo del libro: " + titulos[i]);

                                                            if (disponibles[i]) {
                                                                System.out.println("Libro disponible");
                                                            } else {
                                                                System.out.println("Libro no disponible");
                                                            }
                                                            // pedir los nuevos datos del libro
                                                            System.out.println("Ingrese el nuevo titulo: ");
                                                            titulos[i] = sc.nextLine();
                                                            cont = false;
                                                            break;
                                                        } else if (i == totalLibros-1){
                                                            System.out.println("Codigo no encontrado");
                                                            System.out.println("Quieres busca otro codigo? 'si' o 'no':");
                                                            String respuesta = sc.next();
                                                            if(respuesta.equalsIgnoreCase("si")){
                                                                cont = true;
                                                                break;
                                                            }else{
                                                                cont = false;
                                                                break;
                                                            }

                                                        }

                                                    }
                                                }while (cont);
                                                break;
                                            case 3: // Eliminar
                                                System.out.println("Ingrese el codigo del libro que desea eliminar");
                                                String codEliminar = sc.next();

                                                int contador = totalLibros;

                                                for (int i = 0; i <= totalLibros-1; i++) {
                                                    if (codLibros[i].equalsIgnoreCase(codEliminar)) {
                                                        for (int k = i; k < contador - 1; k++) {
                                                            codLibros[k] = codLibros[k + 1];
                                                            titulos[k] = titulos[k + 1];
                                                            disponibles[k] = disponibles[k + 1];
                                                        }
                                                        codLibros[totalLibros-1] = null;
                                                        titulos[totalLibros-1] = null;
                                                        disponibles[totalLibros-1] = false;
                                                        totalLibros--;
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 4: //Ver
                                                System.out.println("Lista de libros");


                                                for (int i = 0; i < 10; i++) {
                                                    System.out.println("Codigo:  " +codLibros [i] + "   Titulo:  " + titulos [i] + "   Disponibles:  " + disponibles [i]);
                                                }

                                                break;
                                            default: // Volver atras
                                                opLibros = false;
                                                break;
                                        }
                                    } while (opLibros);

                                case 3: // reservas
                                    int opCrudReservas;
                                    do {
                                        System.out.println("""
                                            crud reservas
                                            1) crear reserva
                                            2) actualizar reserva
                                            3) eliminar reserva
                                            4) ver reservas
                                            5) atras
                                            """);

                                        opCrudReservas = sc.nextInt();
                                        sc.nextLine();

                                        switch (opCrudReservas) {

                                            case 1: // crear reserva
                                                if (totalReservas < cedulaReserva.length) {
                                                    System.out.println("cedula del usuario:");
                                                    String ced = sc.nextLine();

                                                    // buscar si existe
                                                    boolean existe = false;
                                                    for (int i = 0; i < totalUsuarios; i++) {
                                                        if (cedulas[i].equalsIgnoreCase(ced)) {
                                                            existe = true;
                                                            break;
                                                        }
                                                    }

                                                    if (!existe) {
                                                        System.out.println("usuario no encontrado");
                                                        break;
                                                    }

                                                    System.out.println("codigo del libro:");
                                                    String cod = sc.nextLine();

                                                    int posLibro = -1;
                                                    for (int i = 0; i < totalLibros; i++) {
                                                        if (codLibros[i].equalsIgnoreCase(cod)) {
                                                            posLibro = i;
                                                            break;
                                                        }
                                                    }

                                                    if (posLibro == -1) {
                                                        System.out.println("libro no encontrado");
                                                        break;
                                                    }

                                                    if (!disponibles[posLibro]) {
                                                        System.out.println("libro no disponible");
                                                        break;
                                                    }

                                                    System.out.println("dias de devolucion:");
                                                    int dias = sc.nextInt();
                                                    sc.nextLine();

                                                    cedulaReserva[totalReservas] = ced;
                                                    libroReserva[totalReservas] = cod;
                                                    diasDevolucion[totalReservas] = dias;
                                                    totalReservas++;

                                                    disponibles[posLibro] = false;

                                                    System.out.println("reserva creada");
                                                } else {
                                                    System.out.println("no se pueden crear mas reservas");
                                                }
                                                break;

                                            case 2: // actualizar reserva
                                                System.out.println("cedula de la reserva a actualizar:");
                                                String cedAct = sc.nextLine();

                                                int posRes = -1;
                                                for (int i = 0; i < totalReservas; i++) {
                                                    if (cedulaReserva[i].equalsIgnoreCase(cedAct)) {
                                                        posRes = i;
                                                        break;
                                                    }
                                                }

                                                if (posRes == -1) {
                                                    System.out.println("reserva no encontrada");
                                                    break;
                                                }

                                                System.out.println("nuevo codigo de libro:");
                                                String nuevoCod = sc.nextLine();

                                                int posLibroNuevo = -1;
                                                for (int i = 0; i < totalLibros; i++) {
                                                    if (codLibros[i].equalsIgnoreCase(nuevoCod)) {
                                                        posLibroNuevo = i;
                                                        break;
                                                    }
                                                }

                                                if (posLibroNuevo == -1) {
                                                    System.out.println("libro no encontrado");
                                                    break;
                                                }

                                                if (!disponibles[posLibroNuevo]) {
                                                    System.out.println("libro no disponible");
                                                    break;
                                                }

                                                // liberar libro anterior
                                                for (int i = 0; i < totalLibros; i++) {
                                                    if (codLibros[i].equalsIgnoreCase(libroReserva[posRes])) {
                                                        disponibles[i] = true;
                                                        break;
                                                    }
                                                }

                                                libroReserva[posRes] = nuevoCod;

                                                System.out.println("nuevos dias:");
                                                diasDevolucion[posRes] = sc.nextInt();
                                                sc.nextLine();

                                                disponibles[posLibroNuevo] = false;

                                                System.out.println("reserva actualizada");
                                                break;

                                            case 3: // eliminar reserva
                                                System.out.println("cedula de la reserva a eliminar:");
                                                String cedElim = sc.nextLine();

                                                int posElim = -1;
                                                for (int i = 0; i < totalReservas; i++) {
                                                    if (cedulaReserva[i].equalsIgnoreCase(cedElim)) {
                                                        posElim = i;
                                                        break;
                                                    }
                                                }

                                                if (posElim == -1) {
                                                    System.out.println("reserva no encontrada");
                                                    break;
                                                }

                                                // liberar libro
                                                for (int i = 0; i < totalLibros; i++) {
                                                    if (codLibros[i].equalsIgnoreCase(libroReserva[posElim])) {
                                                        disponibles[i] = true;
                                                        break;
                                                    }
                                                }

                                                for (int i = posElim; i < totalReservas - 1; i++) {
                                                    cedulaReserva[i] = cedulaReserva[i + 1];
                                                    libroReserva[i] = libroReserva[i + 1];
                                                    diasDevolucion[i] = diasDevolucion[i + 1];
                                                }

                                                cedulaReserva[totalReservas - 1] = null;
                                                libroReserva[totalReservas - 1] = null;
                                                diasDevolucion[totalReservas - 1] = 0;

                                                totalReservas--;

                                                System.out.println("reserva eliminada");
                                                break;

                                            case 4: // ver reservas
                                                for (int i = 0; i < totalReservas; i++) {
                                                    System.out.println("cedula: " + cedulaReserva[i] +
                                                            " libro: " + libroReserva[i] +
                                                            " dias: " + diasDevolucion[i]);
                                                }
                                                break;

                                            case 5:
                                                break;

                                            default:
                                                System.out.println("opcion invalida");
                                                break;
                                        }

                                    } while (opCrudReservas != 5);
                                    break;
                                default:
                                    break;
                            }
                        } while (opAdmin < 4);
                        break;
                    }
                case 2:// ================= USUARIO =================
                    int opUsuario;
                    do {
                        System.out.println("""
                                --- USUARIO ---
                                1) Registrarse
                                2) Iniciar sesión
                                3) Atras.
                                """);
                        opUsuario = sc.nextInt();
                        sc.nextLine();

                        switch (opUsuario) {

                            case 1: // Registro

                                if (totalUsuarios <= usuarios.length-1) {
                                    System.out.print("Usuario: ");
                                    usuarios[totalUsuarios] = sc.nextLine();
                                    System.out.print("Cédula: ");
                                    cedulas[totalUsuarios] = sc.nextLine();
                                    System.out.print("Nombre: ");
                                    nombres[totalUsuarios] = sc.nextLine();
                                    System.out.print("Correo: ");
                                    correos[totalUsuarios] = sc.nextLine();
                                    System.out.print("Contraseña: ");
                                    passwords[totalUsuarios] = sc.nextLine();
                                    totalUsuarios++;
                                    System.out.println("✅Registro exitoso");
                                } else {
                                    System.out.println("Limite de registros alcanzados... \nLo sentimos no puedes registrarte...");
                                }

                                break;

                            case 2: // Login

                                System.out.print("Usuario: ");
                                String userLogin = sc.nextLine();
                                System.out.print("Contraseña: ");
                                String passLogin = sc.nextLine();

                                for (int i = 0; i < totalUsuarios; i++) {
                                    if (usuarios[i].equals(userLogin) && passwords[i].equals(passLogin)) {
                                        usuarioLoguado = usuarios[i];
                                        cedulaLogueado = cedulas[i];
                                        nombresLogueado = nombres[i];
                                        correosLogueado = correos[i];
                                        loginOk = true;
                                        break;
                                    }
                                    if (i >= totalUsuarios - 1 && !usuarios[i].equals(userLogin) && !passwords[i].equals(passLogin)) {
                                        System.out.println("Usuario y Contraseña Erroneos...");
                                        break;
                                    }
                                }
                                if (loginOk) {
                                    int menuUser;
                                    do {
                                        System.out.println("""
                                                --- MENÚ USUARIO ---
                                                1) Ver perfil
                                                2) editar perfil
                                                3) Ver libros
                                                4) Reservar
                                                5) Ver mis reservas
                                                6) cerrar sesion
                                                """);
                                        menuUser = sc.nextInt();
                                        sc.nextLine();

                                        switch (menuUser) {
                                            case 1:// ver perfil
                                                System.out.printf("""
                                                                           PERFIL %s
                                                        =============================================
                                                            Nombre Usuario: %s
                                                            Cedula: %s
                                                            Nombres y Apellidos: %s 
                                                            Corroe Electronico: %s
                                                        =============================================
                                                        """,usuarioLoguado, usuarioLoguado, cedulaLogueado, nombresLogueado, correosLogueado);
                                                System.out.println("\n\n");
                                                break;
                                            case 2:// editar perfil
                                                for (int i = 0; i < totalUsuarios; i++) {
                                                    if (usuarios[i].equals(usuarioLoguado)) {
                                                        System.out.printf("""
                                                                     Informacion Usuario
                                                        =============================================
                                                            Nombre Usuario: %s
                                                            Cedula: %s
                                                            Nombres y Apellidos: %s
                                                            Corroe Electronico: %s
                                                        =============================================
                                                        """,usuarioLoguado, cedulaLogueado, nombresLogueado, correosLogueado);
                                                        System.out.println("\n\n");

                                                        System.out.print("Usuario: ");
                                                        usuarios[i] = sc.nextLine();
                                                        System.out.print("Cédula: ");
                                                        cedulas[i] = sc.nextLine();
                                                        for (int j = 0; j < totalReservas; j++) {
                                                            if (cedulaReserva[j].equals(cedulaLogueado)) {
                                                                cedulaReserva[j] = cedulas[i];
                                                            }
                                                        }
                                                        System.out.print("Nombre: ");
                                                        nombres[i] = sc.nextLine();
                                                        System.out.print("Correo: ");
                                                        correos[i] = sc.nextLine();
                                                        System.out.print("Contraseña: ");
                                                        passwords[i] = sc.nextLine();
                                                        totalUsuarios++;
                                                        System.out.println("✅Actualizacion exitosa");
                                                        usuarioLoguado = usuarios[i];
                                                        cedulaLogueado = cedulas[i];
                                                        nombresLogueado = nombres[i];
                                                        correosLogueado = correos[i];
                                                        break;
                                                    }
                                                }
                                                System.out.println("\n\n");
                                                break;
                                            case 3:// ver libros
                                                System.out.println("Libros Disponibles:\n");
                                                for (int i = 0; i < totalLibros; i++) {
                                                    if (disponibles[i]){
                                                        System.out.printf("""
                                                                    Codigo: %s
                                                                        Titulo: %s
                                                                """, codLibros[i], titulos[i]);
                                                    }
                                                }
                                                System.out.println("\n\n");
                                                break;
                                            case 4:// Reservar (crear una reserva)
                                                String nuevaReserva = "si";
                                                do {

                                                    System.out.println("Libros Disponibles:\n");
                                                    for (int i = 0; i < totalLibros; i++) {
                                                        if (disponibles[i]){
                                                            System.out.printf("""
                                                                        Codigo: %s
                                                                            Titulo: %s
                                                                    """, codLibros[i], titulos[i]);
                                                        }
                                                    }
                                                    System.out.println("escribe el codigo del libro que deseas reservar:");
                                                    String cod = sc.next();
                                                    for (int i = 0; i < totalLibros; i++) {
                                                        if (codLibros[i].equalsIgnoreCase(cod)){
                                                            cedulaReserva[totalReservas] = cedulaLogueado;
                                                            libroReserva[totalReservas] = codLibros[i];
                                                            diasDevolucion[totalReservas] = 15;
                                                            disponibles[i] = false;
                                                            System.out.println("Reserva Exitosa...");
                                                            totalReservas ++;
                                                            break;
                                                        } else if (i == totalLibros-1 && !codLibros[i].equalsIgnoreCase(cod)) {
                                                            System.out.println("Codigo no existe..");
                                                            break;
                                                        }
                                                    }
                                                    System.out.println("Deseas Reservar de nuevo 'si' o 'no':");
                                                    nuevaReserva = sc.next();

                                                }while(nuevaReserva.equalsIgnoreCase("si"));
                                                break;
                                            case 5:// Ver mis reservas
                                                System.out.println("""
                                                                  Mis Reservas
                                                        ================================
                                                        """);

                                                for (int i = 0; i < totalReservas; i++) {
                                                    if (cedulaReserva[i].equals(cedulaLogueado)) {
                                                        for (int j = 0; j < totalLibros; j++) {
                                                            if (codLibros[j].equalsIgnoreCase(libroReserva[i])) {
                                                                System.out.printf("""
                                                                    Codigo: %s
                                                                        Titulo: %s
                                                                        Dias Restante: %d
                                                                """,codLibros[j], titulos[j], diasDevolucion[i]);
                                                                diasDevolucion[i] --;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }

                                                System.out.println("\n\n");
                                                break;
                                            default:
                                                usuarioLoguado = "";
                                                cedulaLogueado = "";
                                                nombresLogueado = "";
                                                correosLogueado = "";
                                                loginOk = false;
                                                break;
                                        }
                                    } while (loginOk);
                                }
                            default:
                                break;
                        }
                    } while (opUsuario < 3);

                default:
                    break;
            }
        } while (opcionPrincipal < 3);

        sc.close();
    }
}