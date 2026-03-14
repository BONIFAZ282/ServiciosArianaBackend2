package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureActividad {
    public static final String SP_INSERTAR = "{CALL PA_Actividad_Ins_Nuevo(?, ?, ?, ?, ?)}";
    public static final String SP_ACTUALIZAR = "{CALL PA_Actividad_Upd_Actualizar(?, ?, ?, ?)}";
    public static final String SP_ELIMINAR = "{CALL PA_Actividad_Del_Eliminar(?)}";
    public static final String SP_OBTENER_POR_ID = "{CALL PA_Actividad_Get_PorId(?)}";
    public static final String SP_LISTAR_POR_ORDEN = "{CALL PA_Actividad_Lst_PorOrden(?)}";
    public static final String SP_LISTAR_POR_PERSONAL = "{CALL PA_Actividad_Lst_PorPersonal(?)}";
}