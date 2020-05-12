package com.example.jpamysqlencrypt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(columnDefinition= "LONGBLOB", name="cardNo")
    @ColumnTransformer(
            read = "cast(aes_decrypt(card_no, 'mysecret') as char(255))",
            write = "aes_encrypt(?, 'mysecret')"
    )
    private String cardNo;
}
