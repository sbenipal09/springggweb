package ca.sheridancollege.sin12743.springweb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private  int id;
    private String name;


}

