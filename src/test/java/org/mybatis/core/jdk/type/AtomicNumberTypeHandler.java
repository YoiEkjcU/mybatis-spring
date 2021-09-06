package org.mybatis.core.jdk.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

@MappedTypes({ AtomicInteger.class, AtomicLong.class })
public class AtomicNumberTypeHandler implements TypeHandler<Number> {

    public AtomicNumberTypeHandler(Class<?> type) {
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Number parameter, JdbcType jdbcType) throws SQLException {
    }

    @Override
    public Number getResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public Number getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Number getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

}
