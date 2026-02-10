package bibliotecaCesde;

import java.util.Scanner;

public class Proyecto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== USUARIOS =====
        String[] usuarios = new String[5];   // usuario
        String[] cedulas = new String[5];
        String[] nombres = new String[5];
        String[] correos = new String[5];
        String[] passwords = new String[5];
        String[] roles = new String[5];
        int totalUsuarios = 0;

        // ===== ADMIN =====
        usuarios[0] = "admin";
        cedulas[0] = "1234";
        nombres[0] = "administrador";
        correos[0] = "admin@gmail.com";
        passwords[0] = "1234";
        roles[0] = "admin";
        totalUsuarios++;

        //==== Usuario Logueado =====
        String usuarioLoguado = "";
        String cedulaLogueado = "";
        String nombresLogueado = "";
        String correosLogueado = "";
        String rolLogueados = "";
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
        String[] estadoReserva = new String[10];

        int opcionPrincipal;

        do {
            System.out.println("""
                    ====================================
                    ========== BIBLIOTECA CESDE ========
                    ====================================
                        Seleciones la opcion correcta:
                        Desea ingresar como:
                        1) Registrarse
                        2) Iniciar Session
                        3) Salir
                    ====================================
                    """);
            opcionPrincipal = sc.nextInt();
            sc.nextLine();
            switch (opcionPrincipal){
                case 1: // Registro

                    if (totalUsuarios-1 <= usuarios.length-1) {
                        boolean exist;
                        do {
                            exist=false;
                            System.out.print("Usuario: ");
                            usuarios[totalUsuarios] = sc.nextLine();
                            System.out.println("\n");
                            for (int i = 0; i < totalUsuarios; i++) {
                                if (usuarios[i].equals(usuarios[totalUsuarios])) {
                                    System.out.println("nombre de usuario ya existente ingrese otro...");
                                    System.out.println("\n");
                                    exist = true;
                                }
                            }
                        }while(exist);
                        do {
                            exist=false;
                            System.out.print("Cedula: ");
                            cedulas[totalUsuarios] = sc.nextLine();
                            System.out.println("\n");
                            for (int i = 0; i < totalUsuarios; i++) {
                                if (cedulas[i].equals(cedulas[totalUsuarios])) {
                                    System.out.println("Cedula de usuario ya existente ingrese otro...");
                                    System.out.println("\n");
                                    exist = true;
                                }
                            }
                        }while(exist);
                        System.out.print("Nombre: ");
                        nombres[totalUsuarios] = sc.nextLine();
                        do {
                            exist=false;
                            System.out.print("Correo: ");
                            correos[totalUsuarios] = sc.nextLine();
                            System.out.println("\n");
                            for (int i = 0; i < totalUsuarios; i++) {
                                if (correos[i].equals(correos[totalUsuarios])) {
                                    System.out.println("Correo de usuario ya existente ingrese otro...");
                                    System.out.println("\n");
                                    exist = true;
                                }
                            }
                        }while(exist);
                        System.out.print("Contraseña: ");
                        passwords[totalUsuarios] = sc.nextLine();
                        roles[totalUsuarios] = "user";
                        totalUsuarios++;
                        System.out.println("✅Registro exitoso");
                        System.out.println("\n");
                    } else {
                        System.out.println("Limite de registros alcanzados... \nLo sentimos no puedes registrarte...");
                        System.out.println("\n");
                    }

                    break;

                case 2: // Login

                    for (int j = 0; j < 4; j++) {
                        if (j < 3) {
                            System.out.println("\n");
                            System.out.print("Usuario: ");
                            String userLogin = sc.nextLine();
                            System.out.print("Contraseña: ");
                            String passLogin = sc.nextLine();
                            System.out.println("\n");

                            for (int i = 0; i < totalUsuarios; i++) {
                                if (usuarios[i].equals(userLogin) && passwords[i].equals(passLogin)) {
                                    usuarioLoguado = usuarios[i];
                                    cedulaLogueado = cedulas[i];
                                    nombresLogueado = nombres[i];
                                    correosLogueado = correos[i];
                                    rolLogueados = roles[i];
                                    loginOk = true;
                                    break;
                                } else if (i == totalUsuarios - 1) {
                                    System.out.println("""
                                    ==================================
                                     Usuario y Contraseña Erroneos...
                                    ==================================
                                    """);
                                    System.out.println("\n");
                                    break;
                                }
                            }
                            break;
                        } else if (j == 3) {
                            System.out.println("""
                                    ======================
                                     DEMASIADOS INTENTOS
                                    ======================
                                    """);
                            System.out.println("\n");
                            loginOk = false;
                        }
                    }



                    if (loginOk){
                        switch (rolLogueados){
                            case "admin":
                                int opAdmin;
                                do {
                                    System.out.println("""
                                    ===============================
                                    ---------- MENÚ ADMIN ---------
                                    ===============================
                                            1) Usuarios
                                            2) Libros 
                                            3) Reservas 
                                            4) Salir
                                    ===============================
                                    """);
                                    opAdmin = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("\n");
                                    switch (opAdmin) {
                                        case 1: // Usuario
                                            int opCrudUser;
                                            do {
                                                System.out.println("""
                                                ============================================
                                                     Administración de Usuarios:
                                                ============================================
                                                            1) Crear Usurio
                                                            2) Actualizar Usuario
                                                            3) Eliminar Usuario
                                                            4) Ver Usuarios
                                                            5) Atras
                                                ============================================
                                                """);
                                                opCrudUser = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("\n");
                                                switch (opCrudUser) {
                                                    case 1:// crear usuario
                                                        if (totalUsuarios-1 < nombres.length-1) {
                                                            System.out.println("================================================");
                                                            System.out.println("   Por favor ingrese los datos del usuario:");
                                                            System.out.println("================================================");
                                                            boolean exist;
                                                            do {
                                                                exist=false;
                                                                System.out.print("Usuario: ");
                                                                usuarios[totalUsuarios] = sc.nextLine();
                                                                for (int i = 0; i < totalUsuarios; i++) {
                                                                    if (usuarios[i].equals(usuarios[totalUsuarios])) {
                                                                        System.out.println("Usuario ya existente ingrese otro...");
                                                                        exist = true;
                                                                    }
                                                                }
                                                            }while(exist);
                                                            do {
                                                                exist=false;
                                                                System.out.print("Cedula: ");
                                                                cedulas[totalUsuarios] = sc.nextLine();
                                                                System.out.println("\n");
                                                                for (int i = 0; i < totalUsuarios; i++) {
                                                                    if (cedulas[i].equals(cedulas[totalUsuarios])) {
                                                                        System.out.println("Cedula de usuario ya existente ingrese otro...");
                                                                        System.out.println("\n");
                                                                        exist = true;
                                                                    }
                                                                }
                                                            }while(exist);
                                                            System.out.print("Nombre: ");
                                                            nombres[totalUsuarios] = sc.nextLine();
                                                            do {
                                                                exist=false;
                                                                System.out.print("Correo: ");
                                                                correos[totalUsuarios] = sc.nextLine();
                                                                System.out.println("\n");
                                                                for (int i = 0; i < totalUsuarios; i++) {
                                                                    if (correos[i].equals(correos[totalUsuarios])) {
                                                                        System.out.println("Correo de usuario ya existente ingrese otro...");
                                                                        System.out.println("\n");
                                                                        exist = true;
                                                                    }
                                                                }
                                                            }while(exist);
                                                            System.out.println("Ingrese la contraseña: ");
                                                            passwords[totalUsuarios] = sc.nextLine();
                                                            do {
                                                                System.out.println("Ingrese el role: 'admin' o 'user'");
                                                                roles[totalUsuarios] = sc.nextLine();
                                                                if (!roles[totalUsuarios].equalsIgnoreCase("admin") && !roles[totalUsuarios].equalsIgnoreCase("user")) {
                                                                    System.out.println("""
                                                                        ==================================
                                                                         El rol debe ser 'admin' o 'user'
                                                                        ==================================
                                                                    """);
                                                                    System.out.println("\n");
                                                                }
                                                            }while(!roles[totalUsuarios].equalsIgnoreCase("admin") && !roles[totalUsuarios].equalsIgnoreCase("user"));

                                                            totalUsuarios++;
                                                            System.out.println("✅Usuario creado correctamente");
                                                            System.out.println("\n");
                                                        } else {
                                                            System.out.println("No se puedo registrar mas usuarios");
                                                            System.out.println("\n");
                                                        }
                                                        break;

                                                    case 2: // lo buscamos por la cedula y actualizamos los datos
                                                        if (totalUsuarios == 0) {
                                                            System.out.println("❌ No hay usuarios para actualizar.");
                                                            System.out.println("\n");
                                                            break;
                                                        }
                                                        boolean update = true;
                                                        do {
                                                            int usuarioACt;

                                                            do {
                                                                System.out.println("""
                                                                    =============================
                                                                        Que deseas actualizar:
                                                                    =============================
                                                                        1) Usuario Completo.
                                                                        2) Rol de un Usuario.
                                                                    =============================
                                                                    """);
                                                                usuarioACt = sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("\n");
                                                                if (usuarioACt != 1 && usuarioACt != 2) {
                                                                    System.out.println("Debes elegir 'Usuario Completo' o 'Rol de un Usuario'");
                                                                    System.out.println("\n");
                                                                }
                                                            }while(usuarioACt != 1 && usuarioACt != 2);


                                                            System.out.println("Ingrese  la cedula que desea buscar: ");
                                                            buscarCedula = sc.next();
                                                            sc.nextLine();
                                                            System.out.println("\n");
                                                            for (int j = 0; j < totalUsuarios; j++) {
                                                                if (buscarCedula.equalsIgnoreCase(cedulas[j])) {
                                                                    if (usuarioACt == 1) {
                                                                        System.out.println("Usuario encontrado:");
                                                                        System.out.println("Nombre: " + nombres[j]);
                                                                        System.out.println("Correo: " + correos[j]);
                                                                        System.out.println("Contraseña: " + passwords[j]);
                                                                        System.out.println("Rol: " + roles[j]);
                                                                        System.out.println("\n");
                                                                        System.out.println("Ingrese los datos del usuario que va  a actualizar");
                                                                        System.out.println("Ingrese el nuevo nombre:");
                                                                        nombres[j] = sc.next();
                                                                        sc.nextLine();
                                                                        System.out.println("Ingrese la nueva cédula:");
                                                                        cedulas[j] = sc.nextLine();
                                                                        System.out.println("Ingrese el nuevo correo:");
                                                                        correos[j] = sc.nextLine();
                                                                        System.out.println("Ingrese la nueva contraseña:");
                                                                        passwords[j] = sc.nextLine();

                                                                        do {
                                                                            System.out.println("Ingrese el role: 'admin' o 'user'");
                                                                            roles[j] = sc.nextLine();
                                                                            if (!roles[j].equalsIgnoreCase("admin") && !roles[j].equalsIgnoreCase("user")) {
                                                                                System.out.println("El rol debe ser 'admin' o 'user'");
                                                                                System.out.println("\n");
                                                                            }
                                                                        }while(!roles[j].equalsIgnoreCase("admin") && !roles[j].equalsIgnoreCase("user"));
                                                                    }
                                                                    if (usuarioACt == 2) {
                                                                        System.out.println("Usuario encontrado:");
                                                                        System.out.println("Nombre: " + nombres[j]);
                                                                        System.out.println("Correo: " + correos[j]);
                                                                        System.out.println("Contraseña: " + passwords[j]);
                                                                        System.out.println("Rol: " + roles[j]);
                                                                        do {
                                                                            System.out.println("Ingrese el role: 'admin' o 'user'");
                                                                            roles[j] = sc.nextLine();
                                                                            if (!roles[j].equalsIgnoreCase("admin") && !roles[j].equalsIgnoreCase("user")) {
                                                                                System.out.println("El rol debe ser 'admin' o 'user'");
                                                                                System.out.println("\n");
                                                                            }
                                                                        }while(!roles[j].equalsIgnoreCase("admin") && !roles[j].equalsIgnoreCase("user"));
                                                                    }
                                                                    System.out.println("✅Usuario actualizado correctamente.");
                                                                    System.out.println("\n");
                                                                    update = false;
                                                                    break;
                                                                } else if (j == totalUsuarios - 1) {
                                                                    System.out.println("no se encontro el usuario");
                                                                    System.out.println("desea volver a buscar otro usuario 'si' o 'no': ");
                                                                    String confirmacion = sc.next();
                                                                    System.out.println("\n");
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
                                                        if (totalUsuarios == 0) {
                                                            System.out.println("❌ No hay usuarios para eliminar.");
                                                            System.out.println("\n");
                                                            break;
                                                        }
                                                        System.out.println("Ingrese la cédula del usuario a eliminar:");
                                                        eliminarCed = sc.nextLine();
                                                        System.out.println("\n");
                                                        for (int i = 0; i < totalUsuarios; i++) {
                                                            if (eliminarCed.equals(cedulas[i])) {
                                                                for (int k = i; k < totalUsuarios - 1; k++) {
                                                                    nombres[i] = nombres[k + 1];
                                                                    cedulas[i] = cedulas[k + 1];
                                                                    correos[i] = correos[k + 1];
                                                                    passwords[i] = passwords[k + 1];
                                                                    roles[i] = roles[k + 1];
                                                                }
                                                                nombres[totalUsuarios - 1] = null;
                                                                cedulas[totalUsuarios - 1] = null;
                                                                correos[totalUsuarios - 1] = null;
                                                                passwords[totalUsuarios - 1] = null;
                                                                roles[totalUsuarios - 1] = null;
                                                                totalUsuarios--;
                                                                System.out.println("Usuario Eliminado con exito.....");
                                                                System.out.println("\n");
                                                                break;

                                                            }
                                                        }
                                                        break;
                                                    case 4: // mostramos todos los registros exitosos
                                                        if (totalUsuarios == 0) {
                                                            System.out.println("❌ No hay usuarios para actualizar.");
                                                            System.out.println("\n");
                                                            break;
                                                        }
                                                        System.out.println("✅Lista de usuarios registrados exitosamente");
                                                        System.out.println("\n");
                                                        for (int i = 0; i < totalUsuarios; i++) {
                                                            System.out.println("\n");
                                                            System.out.println("========================================");
                                                            System.out.println("        DATOS DEL USUARIO "+(i+1));
                                                            System.out.println("========================================");
                                                            System.out.println("========================================");
                                                            System.out.println("          Usuario encontrado:");
                                                            System.out.println(" Nombre: " + nombres[i]);
                                                            System.out.println(" Correo: " + correos[i]);
                                                            System.out.println(" Contraseña: " + passwords[i]);
                                                            System.out.println(" Rol: " + roles[i]);
                                                            System.out.println("========================================");
                                                        }
                                                        System.out.println("\n");
                                                        break;
                                                    case 5:
                                                        System.out.println("Volviendo al menú admin...");
                                                        System.out.println("\n");
                                                        break;
                                                    default:
                                                        System.out.println("Opción inválida.");
                                                        System.out.println("\n");
                                                        break;
                                                }
                                            } while (opCrudUser != 5);
                                            break;

                                        case 2: //LIBROS
                                            boolean opLibros = true;
                                            int opCrudLibros;
                                            do {
                                                System.out.println("""
                                                ===================================
                                                    Administracion para Libros
                                                ===================================
                                                        1) Crear libros
                                                        2) Actualizar libros
                                                        3) Eliminar libros
                                                        4) Ver libros
                                                        5) Atras 
                                                ===================================
                                                """);
                                                opCrudLibros = sc.nextInt();
                                                System.out.println("\n");
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
                                                            System.out.println("\n");
                                                            totalLibros++;
                                                        } else {
                                                            System.out.println("No se pueden crear mas Libros almacenamiento lleno");
                                                            System.out.println("\n");
                                                        }
                                                        break;
                                                    case 2: // Actualizar

                                                        boolean cont = true;

                                                        do {
                                                            System.out.println("Por favor ingrese el codigo del libro que desea actualizar");
                                                            String codBuscar = sc.next();
                                                            sc.nextLine();
                                                            System.out.println("\n");

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
                                                                    System.out.println("\n");
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
                                                        System.out.println("\n");

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
                                                                System.out.println("Libro Eliminado Exitosamente.....");
                                                                System.out.println("\n");
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    case 4: //Ver
                                                        System.out.println("==========================================================================================================");
                                                        System.out.println("                                            Lista de libros");
                                                        System.out.println("==========================================================================================================");

                                                        for (int i = 0; i < 10; i++) {
                                                            if (codLibros[i] == null) {
                                                                break;
                                                            }
                                                            System.out.println("Codigo:  " +codLibros [i] + "   Titulo:  " + titulos [i] + "   Disponibles:  " + disponibles [i]);
                                                        }
                                                        System.out.println("\n");

                                                        break;
                                                    default: // Volver atras
                                                        opLibros = false;
                                                        break;
                                                }
                                            } while (opLibros);
                                            break;

                                        case 3: // reservas
                                            int opCrudReservas;
                                            do {
                                                System.out.println("""
                                                ===================================
                                                    Administracion para Resevas
                                                ===================================
                                                        1) crear reserva
                                                        2) actualizar reserva
                                                        3) Finalizar Reserva
                                                        4) ver reservas
                                                        5) atras
                                                ===================================
                                                """);

                                                opCrudReservas = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("\n");

                                                switch (opCrudReservas) {

                                                    case 1: // crear reserva
                                                        if (totalReservas < cedulaReserva.length) {
                                                            System.out.println("cedula del usuario:");
                                                            String ced = sc.nextLine();

                                                            // buscar si existe
                                                            int existe = -1;
                                                            for (int i = 0; i < totalUsuarios; i++) {
                                                                if (cedulas[i].equalsIgnoreCase(ced)) {
                                                                    existe = i;
                                                                    break;
                                                                }
                                                            }

                                                            if (existe == -1) {
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
                                                            estadoReserva[totalReservas] = "Prestamo Activo";
                                                            totalReservas++;

                                                            disponibles[posLibro] = false;

                                                            System.out.println("reserva creada");
                                                            System.out.println("\n");
                                                        } else {
                                                            System.out.println("no se pueden crear mas reservas");
                                                            System.out.println("\n");
                                                        }
                                                        break;

                                                    case 2: // actualizar reserva

                                                        String continuar = "si";
                                                        do {
                                                            System.out.println("cedula del usuario a actualizar:");
                                                            String cedAct = sc.nextLine();

                                                            int posRes = -1;
                                                            for (int i = 0; i < totalReservas; i++) {
                                                                if (cedulaReserva[i].equalsIgnoreCase(cedAct)) {
                                                                    for (int j = 0; j < totalUsuarios; j++) {
                                                                        if (cedulas[j].equalsIgnoreCase(cedAct)) {
                                                                            System.out.println("Nombre de usuario: " + usuarios[j]);
                                                                            break;
                                                                        }
                                                                    }
                                                                    posRes = i;
                                                                    System.out.printf("""
                                                                        Libro reservado: %s
                                                                        Días devolución: %d
                                                                        Estado reserva: %s
                                                                        """,libroReserva[i],diasDevolucion[i],estadoReserva[i]);
                                                                }
                                                            }

                                                            if (posRes == -1) {
                                                                System.out.println("El usuario no tiene reservas");
                                                                break;
                                                            }
                                                            System.out.println("Ingrese el codigo del libro que desea actualizar");
                                                            String libroActualizar = sc.nextLine();

                                                            for (int i = 0; i < totalReservas; i++) {
                                                                if (codLibros[i].equalsIgnoreCase(libroActualizar)) {
                                                                    System.out.println("Actualización días de devolución de la reserva");
                                                                    diasDevolucion[i] = sc.nextInt();
                                                                    sc.nextLine();
                                                                    estadoReserva[i] = "Prestamo Activo";
                                                                    System.out.printf("""
                                                                        ===== Datos actualizados =====
                                                                        Cédula usuario: %s
                                                                        Código libro reservado: %s
                                                                        Días devolución: %d
                                                                        Estado reserva: %s
                                                                        """,cedulaReserva[i],libroReserva[i],diasDevolucion[i],estadoReserva[i]);
                                                                }
                                                            }
                                                            System.out.println("Desea actualizar otra reserva 'si' o 'no'");
                                                            continuar = sc.nextLine();


                                                        }while (!continuar.equalsIgnoreCase("no"));
                                                        break;

                                                    case 3: // eliminar reserva
                                                        String resFin = "si";
                                                        do {
                                                            System.out.println("cedula del usuario a finalizar:");
                                                            String cedAct = sc.nextLine();
                                                            System.out.println("Código del libro a devolver");
                                                            String codLib = sc.nextLine();


                                                            int posRes = -1;
                                                            for (int i = 0; i < totalReservas; i++) {
                                                                if (cedulaReserva[i].equalsIgnoreCase(cedAct) && libroReserva[i].equalsIgnoreCase(codLib)) {
                                                                    for (int j = 0; j < totalUsuarios; j++) {
                                                                        if (cedulas[j].equalsIgnoreCase(cedAct)) {
                                                                            System.out.println("Nombre de usuario: " + usuarios[j]);
                                                                            break;
                                                                        }
                                                                    }
                                                                    for (int j = 0; j < totalLibros; j++) {
                                                                        if (codLibros[j].equalsIgnoreCase(codLib)){
                                                                            System.out.println("Nombre del libro: " + titulos[j]);
                                                                            disponibles[i] = true;
                                                                            break;
                                                                        }
                                                                    }
                                                                    posRes = i;
                                                                }
                                                            }
                                                            if (posRes == -1){
                                                                System.out.println("Reserva no encontrada");
                                                            }else {
                                                                estadoReserva[posRes] = "Reserva finalizada";
                                                                System.out.println("Reserva finalizada con éxito");
                                                            }

                                                            System.out.println("Desea finalizar otra reserva 'si' o 'no'");
                                                            resFin = sc.nextLine();


                                                        }while (!resFin.equalsIgnoreCase("no"));
                                                        break;

                                                    case 4: // ver reservas
                                                        for (int i = 0; i < totalReservas; i++) {
                                                            System.out.printf("""
                                                                    Cédula usuario: %s
                                                                    Libros reservados: %s
                                                                    Días de devolución: %d
                                                                    Estado reserva: %s
                                                                    """,cedulaReserva[i],libroReserva[i],diasDevolucion[i],estadoReserva[i]);

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
                                            usuarioLoguado = "";
                                            cedulaLogueado = "";
                                            nombresLogueado = "";
                                            correosLogueado = "";
                                            rolLogueados = "";
                                            loginOk = false;
                                            break;
                                    }


                                    for (int i = 0; i < totalReservas; i++) {
                                        if(estadoReserva[i].equalsIgnoreCase("Entrega del Libro en Mora")){
                                            diasDevolucion[i] --;
                                        }
                                        if (diasDevolucion[i] <= -1 && estadoReserva[i].equalsIgnoreCase("Prestamo Activo")) {
                                            estadoReserva[i] = "Entrega del Libro en Mora";
                                            diasDevolucion[i] --;
                                        }
                                        if (estadoReserva [i].equalsIgnoreCase("Prestamo Activo") && diasDevolucion[i] >=0 ){
                                            diasDevolucion[i] --;
                                        }
                                    }
                                } while (loginOk);
                                break;

                            case "user":  // ================ USUARIO ===================

                                if (loginOk) {
                                    int menuUser;
                                    do {
                                        for (int i = 0; i < totalReservas; i++) {
                                            if (cedulaReserva[i].equalsIgnoreCase(cedulaLogueado)) {
                                                if (diasDevolucion[i] <= -1 && estadoReserva[i].equalsIgnoreCase("Entrega del Libro en Mora")) {
                                                    System.out.printf("""
                                                            =====================================================
                                                                URGENTE______________________________________
                                                                ENTREGAR LIBRO...
                                                                        CODIGO LIBRO: %S
                                                                        DIAS DE MORA: %d
                                                            =====================================================
                                                            """, libroReserva[i], diasDevolucion[i]);
                                                }
                                            }
                                        }
                                        System.out.println("""
                                                ===============================
                                                --------- MENÚ USUARIO --------
                                                ===============================
                                                    1) Ver perfil
                                                    2) editar perfil
                                                    3) Ver libros
                                                    4) Reservar
                                                    5) Ver mis reservas
                                                    6) cerrar sesion
                                                ===============================
                                                """);
                                        menuUser = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("\n");

                                        switch (menuUser) {
                                            case 1:// ver perfil
                                                System.out.printf("""
                                                                           PERFIL %s
                                                        =============================================
                                                            Usuario: %s
                                                            Cedula: %s
                                                            Nombres y Apellidos: %s 
                                                            Corroe Electronico: %s
                                                            Rol: %s
                                                        =============================================
                                                        """,usuarioLoguado, usuarioLoguado, cedulaLogueado, nombresLogueado, correosLogueado, rolLogueados);
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
                                                            Rol: %s
                                                        =============================================
                                                        """,usuarioLoguado, cedulaLogueado, nombresLogueado, correosLogueado, rolLogueados);
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
                                                System.out.println("===================================");
                                                System.out.println("        Libros Disponibles:");
                                                System.out.println("===================================");
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
                                                    System.out.println("===================================");
                                                    System.out.println("       Libros Disponibles:");
                                                    System.out.println("===================================");
                                                    for (int i = 0; i < totalLibros; i++) {
                                                        if (disponibles[i]){
                                                            System.out.printf("""
                                                                            Codigo: %s
                                                                                Titulo: %s
                                                                    """, codLibros[i], titulos[i]);
                                                        }
                                                    }
                                                    System.out.println("\n");
                                                    System.out.println("escribe el codigo del libro que deseas reservar:");
                                                    String cod = sc.next();
                                                    for (int i = 0; i < totalLibros; i++) {
                                                        if (codLibros[i].equalsIgnoreCase(cod)){
                                                            cedulaReserva[totalReservas] = cedulaLogueado;
                                                            libroReserva[totalReservas] = codLibros[i];
                                                            diasDevolucion[totalReservas] = 15;
                                                            disponibles[i] = false;
                                                            estadoReserva[totalReservas] = "Prestamo Activo";
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
                                                        =====================================          
                                                                     Mis Reservas
                                                        =====================================
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
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }

                                                System.out.println("\n\n");
                                                break;

                                            case 6:
                                                usuarioLoguado = "";
                                                cedulaLogueado = "";
                                                nombresLogueado = "";
                                                correosLogueado = "";
                                                rolLogueados = "";
                                                loginOk = false;
                                                break;
                                            default:
                                                break;
                                        }
                                        for (int i = 0; i < totalReservas; i++) {
                                            if(estadoReserva[i].equalsIgnoreCase("Entrega del Libro en Mora")){
                                                diasDevolucion[i] --;
                                            }
                                            if (diasDevolucion[i] <= -1 && estadoReserva[i].equalsIgnoreCase("Prestamo Activo")) {
                                                estadoReserva[i] = "Entrega del Libro en Mora";
                                                diasDevolucion[i] --;
                                            }
                                            if (estadoReserva [i].equalsIgnoreCase("Prestamo Activo") && diasDevolucion[i] >=0 ){
                                                diasDevolucion[i] --;
                                            }
                                        }
                                    } while (loginOk);
                                }
                                break;
                        }
                    }


                    break;

                default:
                    break;

            }

        }while(opcionPrincipal < 3);
    }
}
