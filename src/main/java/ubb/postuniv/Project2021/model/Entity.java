package ubb.postuniv.Project2021.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

//@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Entity<ID extends Serializable> implements Serializable {

//    @Id
//    @SequenceGenerator(
//            name = "entity_sequence",
//            sequenceName = "entity_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "entity_sequence"
//    )
    private ID id;

    @Override
    public String toString() {
        return "id=" + id;
    }
}
