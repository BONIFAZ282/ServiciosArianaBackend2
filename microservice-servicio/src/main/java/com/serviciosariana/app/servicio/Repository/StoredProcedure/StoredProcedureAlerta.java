package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureAlerta {
    public static final String SP_GENERAR_AUTOMATICAS = "{CALL PA_Alerta_Generar_Automaticas}";
    public static final String SP_LISTAR_TODOS = "{CALL PA_Alerta_Lst_Todos(?, ?)}";
    public static final String SP_CONTADOR_NO_LEIDAS = "{CALL PA_Alerta_Get_ContadorNoLeidas(?)}";
    public static final String SP_MARCAR_LEIDA = "{CALL PA_Alerta_Upd_MarcarLeida(?, ?)}";
    public static final String SP_MARCAR_TODAS_LEIDAS = "{CALL PA_Alerta_Upd_MarcarTodasLeidas(?, ?)}";
    public static final String SP_OBTENER_POR_ID = "{CALL PA_Alerta_Get_PorId(?)}";
    public static final String SP_MARCAR_RESUELTA = "{CALL PA_Alerta_Upd_MarcarResuelta(?, ?)}";

    public static final String SP_PENDIENTES_NOTIFICACION = "{CALL PA_Alerta_Lst_PendientesNotificacion}";
    public static final String SP_MARCAR_NOTIFICADA = "{CALL PA_Alerta_Upd_MarcarNotificada(?)}";

}