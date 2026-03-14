package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureCliente {
    public static final String LST_TODOS = "{call PA_Cliente_Lst_Todos}";
    public static final String LST_COMBO = "{call PA_Cliente_Lst_Combo}";
    public static final String LST_BUSCAR = "{call PA_Cliente_Lst_Buscar(?)}";
    public static final String GET_POR_ID = "{call PA_Cliente_Get_PorId(?)}";
    public static final String GET_POR_DOCUMENTO = "{call PA_Cliente_Get_PorDocumento(?)}";
    public static final String GET_EXISTE_DOCUMENTO = "{call PA_Cliente_Get_ExisteDocumento(?,?)}";
    public static final String INS_NUEVO = "{call PA_Cliente_Ins_Nuevo(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    public static final String UPD_ACTUALIZAR = "{call PA_Cliente_Upd_Actualizar(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    public static final String DEL_ELIMINAR = "{call PA_Cliente_Del_Eliminar(?)}";
    public static final String SP_BUSCAR_POR_DOCUMENTO = "{CALL PA_Cliente_Get_BuscarPorDocumento(?)}";

}