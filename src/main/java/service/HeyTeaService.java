package service;

import domain.HeyTea;
import domain.Page;

import java.sql.SQLException;
import java.util.List;

public interface HeyTeaService {
    public void addHeyTea(HeyTea heyTea);
    public void deleteHeyTea(int id);
    public void updateHeyTea(HeyTea heyTea);
    public HeyTea queryHeyTeaById(int id);
    public List<HeyTea> queryHeyTea();

    Page<HeyTea> page(int pageNo, int pageSize) throws SQLException;

    Page<HeyTea> pageByPrice(int pageNo, int pageSize, int min, int max) throws SQLException;
}
