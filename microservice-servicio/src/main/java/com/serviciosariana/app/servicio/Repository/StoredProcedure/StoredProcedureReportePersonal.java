package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureReportePersonal {
    public static final String SP_RESUMEN = "{CALL PA_Reporte_Personal_Resumen(?)}";
    public static final String SP_RANKING = "{CALL PA_Reporte_Personal_Ranking}";
    public static final String SP_CARGA_TRABAJO = "{CALL PA_Reporte_Personal_CargaTrabajo}";
    public static final String SP_ORDENES = "{CALL PA_Reporte_Personal_Ordenes(?)}";
}