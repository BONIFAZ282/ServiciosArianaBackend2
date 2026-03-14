package com.serviciosariana.app.personal.Repository.StoredProcedure;

public class StoredProcedureTipoDocumento {
    public static final String LST_TODOS = "{call PA_TipoDocumento_Lst_Todos}";
    public static final String INS_NUEVO = "{call PA_TipoDocumento_Ins_Nuevo(?,?,?,?)}";
}