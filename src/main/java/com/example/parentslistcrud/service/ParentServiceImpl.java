package com.example.parentslistcrud.service;

import com.example.parentslistcrud.entity.Parent;
import com.example.parentslistcrud.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {


    private ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent getParentById(Long id) {
        return parentRepository.findById(id).get();
    }

    @Override
    public Parent updateParent(Parent parent) {
        return parentRepository.save(parent);
    }


    @Override
    public void deleteParentById(Long id) {
        parentRepository.deleteById(id);
    }






}
