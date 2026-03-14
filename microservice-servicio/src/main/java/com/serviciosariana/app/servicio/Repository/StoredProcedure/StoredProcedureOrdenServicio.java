package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureOrdenServicio {
    public static final String SP_INSERTAR = "{CALL PA_OrdenServicio_Ins_Nuevo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    public static final String SP_ACTUALIZAR = "{CALL PA_OrdenServicio_Upd_Actualizar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    public static final String SP_CAMBIAR_ESTADO = "{CALL PA_OrdenServicio_Upd_CambiarEstado(?, ?, ?, ?)}";
    public static final String SP_ELIMINAR = "{CALL PA_OrdenServicio_Del_Eliminar(?)}";
    public static final String SP_OBTENER_POR_ID = "{CALL PA_OrdenServicio_Get_PorId(?)}";
    public static final String SP_LISTAR_TODOS = "{CALL PA_OrdenServicio_Lst_Todos}";
    public static final String SP_LISTAR_HISTORIAL = "{CALL PA_OrdenServicio_Lst_Historial(?)}";
    public static final String SP_EQUIPO_POR_LIDER = "{CALL PA_OrdenServicio_Lst_EquipoPorLider(?)}";
    public static final String SP_RESUMEN_POR_LIDER = "{CALL PA_OrdenServicio_Lst_ResumenPorLider(?)}";
}