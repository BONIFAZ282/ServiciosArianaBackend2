package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureOrdenServicioPersonal {
    public static final String SP_ASIGNAR = "{CALL PA_OrdenServicioPersonal_Ins_Asignar(?, ?, ?)}";
    public static final String SP_DESASIGNAR = "{CALL PA_OrdenServicioPersonal_Upd_Desasignar(?, ?)}";
    public static final String SP_LISTAR_POR_ORDEN = "{CALL PA_OrdenServicioPersonal_Lst_PorOrden(?)}";
    public static final String SP_LISTAR_DISPONIBLES = "{CALL PA_OrdenServicioPersonal_Lst_Disponibles(?)}";
}