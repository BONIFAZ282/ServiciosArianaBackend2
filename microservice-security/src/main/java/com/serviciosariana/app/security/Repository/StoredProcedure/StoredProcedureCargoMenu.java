package com.serviciosariana.app.security.Repository.StoredProcedure;

public class StoredProcedureCargoMenu {
    public static final String LST_POR_CARGO = "{call PA_CargoMenu_Lst_PorCargo(?)}";
    public static final String LST_MENUS_SIDEBAR = "{call PA_CargoMenu_Lst_MenusSidebar(?)}";
    public static final String LST_MENUS_MAIN = "{call PA_CargoMenu_Lst_MenusPrincipal(?)}";
    public static final String INS_ASIGNAR = "{call PA_CargoMenu_Ins_Asignar(?,?,?,?,?,?)}";
    public static final String UPD_PERMISOS = "{call PA_CargoMenu_Upd_Permisos(?,?,?,?,?,?)}";
    public static final String DEL_ELIMINAR = "{call PA_CargoMenu_Del_Eliminar(?)}";
    public static final String DEL_TODOS_POR_CARGO = "{call PA_CargoMenu_Del_TodosPorCargo(?)}";
}