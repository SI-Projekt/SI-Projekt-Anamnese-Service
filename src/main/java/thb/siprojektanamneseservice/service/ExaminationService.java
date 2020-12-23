package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.Examination;
import thb.siprojektanamneseservice.repository.ExaminationRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("ExaminationService")
@Transactional(rollbackOn = Exception.class)
public class ExaminationService {

    private final ExaminationRepository repository;

    @Autowired
    public ExaminationService(ExaminationRepository repository){
        this.repository = repository;
    }

    public List<Examination> listAll() {
        return  repository.findAll();
    }

    public Examination getOne(UUID examinationId) throws ResourceNotFoundException {
        Optional<Examination> examinationOP = repository.findById(examinationId);
        if (!examinationOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The examination with the id %s does not exist", examinationId.toString())
            );
        }
        return examinationOP.get();
    }

    public void delete(UUID examinationId) {
        getOne(examinationId);
        repository.deleteById(examinationId);
    }

    /**
     * @param newExamination
     * @return The new created examination
     */
    public Examination create(Examination newExamination) {
        checkForUniqueness(newExamination);
        newExamination.setId(null);
        return repository.save(newExamination);
    }


    public Examination update(UUID examinationId, Examination update) throws ResourceNotFoundException {
        Examination examinationFound = getOne(examinationId);

        if (!examinationFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(examinationId);
        return repository.save(update);
    }

    private void checkForUniqueness(Examination examination) {
        if (repository.countById(examination.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A examination with the id %s already exist", examination.getId())
            );
        }
    }
}
