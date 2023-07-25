package beans.transactional;

import beans.transactional.db.AddressEntity;
import beans.transactional.db.AddressRepository;
import beans.transactional.db.PersonEntity;
import beans.transactional.db.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionalService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public TransactionalService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public String save(RequestDto input) {
        PersonEntity personEntity = PersonEntity.builder().id(input.getId()).name(input.getName()).build();
        personRepository.save(personEntity);

        if (true) {
            throw new RuntimeException();
        }

        AddressEntity addressEntity = AddressEntity.builder().id(input.getId()).address(input.getAddress()).build();
        addressRepository.save(addressEntity);

        return "OK";
    }

    public String save2(RequestDto input) {
        return save(input);
    }
}
