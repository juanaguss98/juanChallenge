package camp.gladiator.challenge.juan.service;

import camp.gladiator.challenge.juan.model.Trainer;

import java.util.List;

public interface TrainerService {

    public Trainer findTrainerById (Long id);

    public Trainer addTrainer(Trainer trainer);

    public List<Trainer> findAllTrainer();
}
