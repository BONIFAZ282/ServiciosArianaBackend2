package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureActividadEvidencia {
    public static final String SP_INSERTAR = "{CALL PA_ActividadEvidencia_Ins_Nuevo(?, ?, ?, ?, ?)}";
    public static final String SP_ELIMINAR = "{CALL PA_ActividadEvidencia_Del_Eliminar(?)}";
    public static final String SP_LISTAR_POR_ACTIVIDAD = "{CALL PA_ActividadEvidencia_Lst_PorActividad(?)}";
    public static final String SP_OBTENER_POR_ID = "{CALL PA_ActividadEvidencia_Get_PorId(?)}";
}