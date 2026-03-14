package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureTipoServicio {
    public static final String LST_TODOS = "{call PA_TipoServicio_Lst_Todos}";
    public static final String INS_NUEVO = "{call PA_TipoServicio_Ins_Nuevo(?,?,?,?)}";
    public static final String UPD_ACTUALIZAR = "{call PA_TipoServicio_Upd_Actualizar(?,?,?,?,?,?)}";
    public static final String DEL_ELIMINAR = "{call PA_TipoServicio_Del_Eliminar(?)}";
    public static final String SP_LISTAR_COMBO = "{CALL PA_TipoServicio_Lst_Combo}";  // ← NUEVO

}