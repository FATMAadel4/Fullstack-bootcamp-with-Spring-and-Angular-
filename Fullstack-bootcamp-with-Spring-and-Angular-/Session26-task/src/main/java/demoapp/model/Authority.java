package demoapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    private String username;
    private String authority;
}