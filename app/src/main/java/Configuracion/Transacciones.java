package Configuracion;

public class Transacciones {

    //Nombre de la base de datos
    public static final String DBName = "PMQuiz";
    //Creación de las tablas de las bases de datos.
    public static final String TableFirmas = "firmas";
    //Creacion de los campos de base de datos
    public static final String id = "id";
    public static final String description = "description";
    public static final String firma = "firma";

    // DDL Create
    public static final String CreateTableFirmas = "Create table "+ TableFirmas +"("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT, description TEXT, firma BLOB)";

    //DDL Drop
    public static final String DropTableFirmas = "DROP TABLE IF EXISTS "+ TableFirmas;

    //DML
    public static final String SelectAllFirmas = "SELECT * FROM "+ TableFirmas;
}
