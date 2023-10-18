package ru.mixaron.springtodolist.services;

import org.springframework.stereotype.Service;
import ru.mixaron.springtodolist.models.TDList;
import ru.mixaron.springtodolist.repositories.TDListRepo;

import java.util.List;

@Service
public class TDListService {

    private final TDListRepo tdListRepo;

    public TDListService(TDListRepo tdListRepo) {
        this.tdListRepo = tdListRepo;
    }

    public List<TDList> tdLists() {
       return tdListRepo.findAllByOrderById();
    }

    public TDList tdList(int id) {
        return tdListRepo.findById(id).orElse(null);
    }

    public void changeCompleted(int id) {
        TDList tdList = tdListRepo.findById(id).get();
            tdListRepo.save(tdList);
    }

    public TDList findOne(int id) {
       return tdListRepo.findById(id).orElse(null);
    }

    public void edit(int id, TDList tdList) {
        tdList.setId(id);
        tdListRepo.save(tdList);
    }

    public void save(TDList tdList) {
        tdList.setCompleted(false);
        tdListRepo.save(tdList);
    }


}
