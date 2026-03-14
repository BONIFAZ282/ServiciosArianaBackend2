package com.serviciosariana.app.personal.Repository.StoredProcedure;

public class StoredProcedureCargo {
    public static final String LST_TODOS = "{call PA_Cargo_Lst_Todos}";
    public static final String GET_POR_ID = "{call PA_Cargo_Get_PorId(?)}";
    public static final String INS_NUEVO = "{call PA_Cargo_Ins_Nuevo(?,?,?)}";
    public static final String UPD_ACTUALIZAR = "{call PA_Cargo_Upd_Actualizar(?,?,?,?,?)}";
    public static final String DEL_ELIMINAR = "{call PA_Cargo_Del_Eliminar(?)}";
}