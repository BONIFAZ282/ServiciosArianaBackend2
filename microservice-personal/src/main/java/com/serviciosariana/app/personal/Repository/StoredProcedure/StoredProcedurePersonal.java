package com.serviciosariana.app.personal.Repository.StoredProcedure;

public class StoredProcedurePersonal {
    public static final String LST_TODOS = "{call PA_Personal_Lst_Todos}";
    public static final String LST_POR_CARGO = "{call PA_Personal_Lst_PorCargo(?)}";
    public static final String LST_POR_LIDER = "{call PA_Personal_Lst_PorLider(?)}";
    public static final String LST_LIDERES = "{call PA_Personal_Lst_Lideres}";
    public static final String GET_POR_ID = "{call PA_Personal_Get_PorId(?)}";
    public static final String INS_NUEVO = "{call PA_Personal_Ins_Nuevo(?,?,?,?,?,?)}";
    public static final String UPD_ACTUALIZAR = "{call PA_Personal_Upd_Actualizar(?,?,?,?,?,?,?,?)}";
    public static final String DEL_ELIMINAR = "{call PA_Personal_Del_Eliminar(?)}";
    public static final String SP_LISTAR_CON_LIDER = "{CALL PA_Personal_Lst_ConLider}";

}