package com.serviciosariana.app.security.Repository.StoredProcedure;

public class StoredProcedureMenu {
    public static final String LST_TODOS = "{call PA_Menu_Lst_Todos}";
    public static final String LST_PADRES = "{call PA_Menu_Lst_Padres}";
    public static final String GET_POR_ID = "{call PA_Menu_Get_PorId(?)}";
    public static final String INS_NUEVO = "{call PA_Menu_Ins_Nuevo(?,?,?,?,?,?,?)}";
    public static final String UPD_ACTUALIZAR = "{call PA_Menu_Upd_Actualizar(?,?,?,?,?,?,?,?,?)}";
    public static final String DEL_ELIMINAR = "{call PA_Menu_Del_Eliminar(?)}";
}