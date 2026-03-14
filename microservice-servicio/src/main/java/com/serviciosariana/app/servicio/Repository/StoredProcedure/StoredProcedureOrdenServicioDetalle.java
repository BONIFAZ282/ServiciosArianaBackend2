package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureOrdenServicioDetalle {
    public static final String SP_AGREGAR = "{CALL PA_OrdenServicioDetalle_Ins_Agregar(?, ?, ?, ?, ?)}";
    public static final String SP_ACTUALIZAR = "{CALL PA_OrdenServicioDetalle_Upd_Actualizar(?, ?, ?, ?)}";
    public static final String SP_QUITAR = "{CALL PA_OrdenServicioDetalle_Del_Quitar(?)}";
    public static final String SP_LISTAR_POR_ORDEN = "{CALL PA_OrdenServicioDetalle_Lst_PorOrden(?)}";
    public static final String SP_TOTAL_ORDEN = "{CALL PA_OrdenServicioDetalle_Get_TotalOrden(?)}";
}