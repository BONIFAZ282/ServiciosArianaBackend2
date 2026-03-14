package com.serviciosariana.app.servicio.Repository.StoredProcedure;

public class StoredProcedureCatalogo {
    public static final String PRIORIDAD_LST_TODOS = "{call PA_Prioridad_Lst_Todos}";

    public static final String ESTADO_ORDEN_LST_TODOS = "{call PA_EstadoOrden_Lst_Todos}";
    public static final String ESTADO_ORDEN_LST_SIGUIENTES = "{call PA_EstadoOrden_Lst_SiguientesValidos(?)}";

    public static final String TIPO_ALERTA_LST_TODOS = "{call PA_TipoAlerta_Lst_Todos}";
}