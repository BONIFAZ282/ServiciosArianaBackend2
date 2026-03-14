package com.serviciosariana.app.security.Repository.StoredProcedure;

public class StoredProcedureUsuario {

    // Listados
    public static final String LST_TODOS = "{call PA_Usuario_Lst_Todos}";

    // Obtener
    public static final String GET_POR_ID = "{call PA_Usuario_Get_PorId(?)}";
    public static final String GET_POR_USUARIO = "{call PA_Usuario_Get_PorUsuario(?)}";
    public static final String GET_ESTA_BLOQUEADO = "{call PA_Usuario_Get_EstaBloqueado(?)}";

    // Insertar
    public static final String INS_NUEVO = "{call PA_Usuario_Ins_Nuevo(?,?,?)}";

    // Actualizar
    public static final String UPD_PASSWORD = "{call PA_Usuario_Upd_Password(?,?)}";
    public static final String UPD_ESTADO = "{call PA_Usuario_Upd_Estado(?,?)}";
    public static final String UPD_DESBLOQUEAR = "{call PA_Usuario_Upd_Desbloquear(?)}";
    public static final String UPD_INTENTO_FALLIDO = "{call PA_Usuario_Upd_IntentoFallido(?)}";
    public static final String UPD_ULTIMO_ACCESO = "{call PA_Usuario_Upd_UltimoAcceso(?)}";
}