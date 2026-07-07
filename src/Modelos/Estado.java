package Modelos;

public enum Estado {
    NUEVO("Nuevo"),
    PENDIENTE("Pendiente"),
    EN_ATENCION("En Atención"),
    EN_PROCESO("En Proceso"),
    ESPERANDO("Esperando respuesta del cliente"),
    RESUELTO("Resuelto"),
    CERRADO("Cerrado");

    private final String displayName;

    Estado(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
