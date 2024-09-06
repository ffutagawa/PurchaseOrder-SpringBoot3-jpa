package com.ffutagawa.PurchaseOrder.services;

import com.ffutagawa.PurchaseOrder.entities.User;
import com.ffutagawa.PurchaseOrder.repositories.UserRepository;
import com.ffutagawa.PurchaseOrder.services.exceptions.DataBaseException;
import com.ffutagawa.PurchaseOrder.services.exceptions.ResourceNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> finAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            User user = findById(id);
            repository.delete(user);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e1){
            throw new DataBaseException(e1.getMessage());
        }
    }

    public User update(Long id, User obj) {
        try {
            User entity = findById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityActionVetoException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }


}
