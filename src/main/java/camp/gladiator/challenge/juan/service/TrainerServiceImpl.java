package camp.gladiator.challenge.juan.service;

import camp.gladiator.challenge.juan.model.Trainer;
import camp.gladiator.challenge.juan.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class TrainerServiceImpl implements TrainerService{

    @Autowired
    TrainerRepository trainerRepository;

    @Override
    public Trainer findTrainerById(Long id){
        Assert.notNull(id, "The value id must NOT be null");
        return trainerRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Trainer with ID " + " was not found"));
    }

    @Override
    public Trainer addTrainer(Trainer trainer) {
        trainer.setPersonalId("trainer-id-" + UUID.randomUUID().toString());
        return trainerRepository.save(trainer);
    }

    @Override
    public List<Trainer> findAllTrainer () {
        return trainerRepository.findAll();
    }

}
