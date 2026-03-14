package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.ResumenDashboardDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResumenDashboardRowMapper implements RowMapper<ResumenDashboardDTO> {

    @Override
    public ResumenDashboardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ResumenDashboardDTO.builder()
                .nTotalOrdenes(rs.getInt("nTotalOrdenes"))
                .nPendientes(rs.getInt("nPendientes"))
                .nEnProceso(rs.getInt("nEnProceso"))
                .nFinalizadas(rs.getInt("nFinalizadas"))
                .nResueltas(rs.getInt("nResueltas"))
                .nCanceladas(rs.getInt("nCanceladas"))
                .nObservadas(rs.getInt("nObservadas"))
                .nTotalEstimado(rs.getBigDecimal("nTotalEstimado"))
                .nTotalReal(rs.getBigDecimal("nTotalReal"))
                .nTotalClientes(rs.getInt("nTotalClientes"))
                .nTotalPersonal(rs.getInt("nTotalPersonal"))
                .build();
    }
}