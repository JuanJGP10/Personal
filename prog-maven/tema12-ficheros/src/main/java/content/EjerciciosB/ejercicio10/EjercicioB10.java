package content.EjerciciosB.ejercicio10;

public class EjercicioB10 {
    public static void main(String[] args) {
        ConfigManager cm = new ConfigManager();
        cm.loadConfig();
        System.out.println(cm.getNombreEmpresa());
        System.out.println(cm.getMaximoIntentos());
        System.out.println(cm.getSesionTimeout());
    }
}
