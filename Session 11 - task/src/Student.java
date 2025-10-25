

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="student")
@NoArgsConstructor
@Setter
@Getter
public class Student {
    public Student(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Id
    @Column(name="id")
    private int id;

    @Column(name="f_name")
    private String first_name;

    @Column(name="l_name")
    private String last_name;


}
