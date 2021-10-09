package dao;

import domain.HeyTea;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface HeyTeaMapper {

    public int queryForPageTotalCount() throws SQLException;
    public int addHeyTea(HeyTea heyTea);

    public int deleteHeyTeaById(int id);

    public int updateHeyTea(HeyTea heyTea);

    public HeyTea queryHeyTeaById(int id);

    public List<HeyTea> queryHeyTea();

    List<HeyTea> queryForPageItems(@Param("begin") int begin, @Param("pageSize") int pageSize) throws SQLException;

    int queryForPageTotalCountByPrice(@Param("min") int min, @Param("max") int max) throws SQLException;

    List<HeyTea> queryForPageItemsByPrice(@Param("begin") int begin, @Param("pageSize") int pageSize, @Param("min") int min, @Param("max") int max) throws SQLException;
}
