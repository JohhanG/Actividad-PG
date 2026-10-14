public class CiclistaNoEncontradoException extends Exception {
    public CiclistaNoEncontradoException(int id) {
        super("No se encontró ningún ciclista con el identificador " + id);
    }
}