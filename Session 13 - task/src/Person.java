
 import lombok.Getter;
 import lombok.NoArgsConstructor;
 import lombok.Setter;
 import lombok.ToString;

 import javax.persistence.*;
 import java.util.Date;

 @Entity
@Table(name = "person")
@Getter
@Setter
 @NoArgsConstructor
 @ToString
public class Person {

     public Person(String firstName, String lastName, Date birthDate) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.birthDate = birthDate;
     }

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

     @Column(name = "first_name")
     private String firstName;

     @Column(name = "last_name")
     private String lastName;

     @Column(name = "birth_date")
     private Date birthDate;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
   private Passport passport;
 }