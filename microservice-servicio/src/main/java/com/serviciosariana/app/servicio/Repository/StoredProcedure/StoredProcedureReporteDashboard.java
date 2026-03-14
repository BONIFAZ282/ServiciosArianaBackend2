package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureReporteDashboard {
    public static final String SP_RESUMEN = "{CALL PA_Reporte_Dashboard_Resumen}";
    public static final String SP_POR_ESTADO = "{CALL PA_Reporte_Dashboard_PorEstado}";
    public static final String SP_POR_PRIORIDAD = "{CALL PA_Reporte_Dashboard_PorPrioridad}";
    public static final String SP_POR_MES = "{CALL PA_Reporte_Dashboard_PorMes}";
    public static final String SP_TOP_CLIENTES = "{CALL PA_Reporte_Dashboard_TopClientes}";
    public static final String SP_TOP_SERVICIOS = "{CALL PA_Reporte_Dashboard_TopServicios}";
    public static final String SP_ORDENES_VENCIDAS = "{CALL PA_Reporte_Dashboard_OrdenesVencidas}";
}