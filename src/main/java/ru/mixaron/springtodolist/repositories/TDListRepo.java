package ru.mixaron.springtodolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mixaron.springtodolist.models.TDList;

import java.util.List;

@Repository
public interface TDListRepo extends JpaRepository<TDList, Integer> {
    List<TDList> findAllByOrderById();
}
