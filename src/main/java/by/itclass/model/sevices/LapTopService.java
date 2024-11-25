package by.itclass.model.sevices;

import by.itclass.model.dao.LapTopDao;
import by.itclass.model.dao.TvDao;
import by.itclass.model.entities.Laptop;
import by.itclass.model.entities.Tv;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.Map;

import static by.itclass.constants.AppConst.*;
import static by.itclass.constants.AppConst.PRICE_TO_PARAM;

public class LapTopService {
    private static LapTopService service;
    private LapTopDao dao;

    private LapTopService(){
        dao = LapTopDao.getInstance();
    }
    public static LapTopService getInstance(){
        if(service == null){
            service = new LapTopService();
        }
        return service;
    }

    public List<Laptop> getLaptop(Map<String , String[]> params){
        var allLapTop = dao.selectAllLapTop();
        if(params.isEmpty()){
            return allLapTop;
        }
        var cpu = params.get(VENDOR_PARAM);
        var cpus = params.get(CPU_PARAM);
        var memory = params.get(MEMORY_PARAM);
        var from = params.get(PRICE_FROM_PARAM)[0];
        var to = params.get(PRICE_TO_PARAM)[0];
        return allLapTop.stream()
                .filter(laptop -> cpu == null || ArrayUtils.contains(cpu , laptop.getVendor()))
                .filter(laptop -> cpus == null || ArrayUtils.contains(cpus , laptop.getCpu()))
                .filter(laptop -> memory == null || ArrayUtils.contains(memory , String.valueOf(laptop.getMemorySize())))
                .filter(laptop -> from.isEmpty() || laptop.getPrice() > Double.parseDouble(from))
                .filter(laptop -> to.isEmpty() || laptop.getPrice() < Double.parseDouble(to))
                .toList();
    }


}
