import java.util.HashMap;
import java.util.Map;

public class Administrador {
    private static Map<String, String> administradores = new HashMap<>();

    static {
        administradores.put("admin1", "password1");
        administradores.put("admin2", "password2");
    }

    public static boolean autenticar(String id, String password) {
        return administradores.containsKey(id) && administradores.get(id).equals(password);
    }
}

