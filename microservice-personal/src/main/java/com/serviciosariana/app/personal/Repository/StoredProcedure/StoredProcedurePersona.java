package com.serviciosariana.app.personal.Repository.StoredProcedure;

public class StoredProcedurePersona {
    public static final String GET_POR_ID = "{call PA_Persona_Get_PorId(?)}";
    public static final String GET_POR_DOCUMENTO = "{call PA_Persona_Get_PorDocumento(?)}";
    public static final String INS_NUEVO = "{call PA_Persona_Ins_Nuevo(?,?,?,?,?,?,?,?,?,?)}";
    public static final String UPD_ACTUALIZAR = "{call PA_Persona_Upd_Actualizar(?,?,?,?,?,?,?,?,?,?,?,?)}";
}