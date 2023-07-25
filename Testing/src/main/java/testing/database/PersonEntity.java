package testing.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "PERSON")
public class PersonEntity {

    @Id
    private Long id;

    private String name;
}
