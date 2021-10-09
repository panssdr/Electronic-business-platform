package service.impl;

import dao.HeyTeaMapper;
import domain.HeyTea;
import domain.Page;
import org.junit.Test;
import service.HeyTeaService;

import java.sql.SQLException;
import java.util.List;

public class HeyTeaServiceImpl implements HeyTeaService {
    private HeyTeaMapper heyTeaMapper;

    public void setHeyTeaMapper(HeyTeaMapper heyTeaMapper) {
        this.heyTeaMapper = heyTeaMapper;
    }

    @Override
    public void addHeyTea(HeyTea heyTea) {
        heyTeaMapper.addHeyTea(heyTea);
    }

    @Override
    public void deleteHeyTea(int id) {
        heyTeaMapper.deleteHeyTeaById(id);
    }

    @Override
    public void updateHeyTea(HeyTea heyTea) {
        heyTeaMapper.updateHeyTea(heyTea);
    }

    @Override
    public HeyTea queryHeyTeaById(int id) {
        return heyTeaMapper.queryHeyTeaById(id);
    }

    @Override
    public List<HeyTea> queryHeyTea() {
        return heyTeaMapper.queryHeyTea();
    }

    @Override
    public Page<HeyTea> page(int pageNo, int pageSize) throws SQLException {
        Page<HeyTea> page=new Page<HeyTea>();

        //设置当前页码
        page.setPageNo(pageNo);

       //设置每页显示的数量
        page.setPageSize(pageSize);
          //求总记录数
        int pageTotalCount=heyTeaMapper.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
     //求总页码
         int pageTotal=pageTotalCount/pageSize;
     if(pageTotalCount%pageSize>0){
         pageTotal++;
     }
     //设置总页码
        if(pageNo<1){
            pageNo=1;
        }
        if(pageNo>pageTotal){
            pageNo=pageTotal;
        }
        //边界页码的检查
        page.setPageTotal(pageTotal);

        int begin=(page.getPageNo()-1)*pageSize;

        List<HeyTea> items= heyTeaMapper.queryForPageItems(begin,pageSize);
       page.setItems(items);
        return page;
    }

    @Override
    public Page<HeyTea> pageByPrice(int pageNo, int pageSize, int min, int max) throws SQLException {
        Page<HeyTea> page=new Page<HeyTea>();

        //设置当前页码
        page.setPageNo(pageNo);

        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        int pageTotalCount=heyTeaMapper.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        int pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal++;
        }
        //设置总页码
        if(pageNo<1){
            pageNo=1;
        }
        if(pageNo>pageTotal){
            pageNo=pageTotal;
        }
        //边界页码的检查
        page.setPageTotal(pageTotal);

        int begin=(page.getPageNo()-1)*pageSize;

        List<HeyTea> items= heyTeaMapper.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;

    }


    @Test
    public void test1() throws SQLException {
        System.out.println(new HeyTeaServiceImpl().page(1, Page.PAGE_SIZE));
    }
}
