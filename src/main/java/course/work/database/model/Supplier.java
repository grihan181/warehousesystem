package course.work.database.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Поставщик")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Название")
    private String name;

    @Column(name = "Адрес")
    private String address;

    @Column(name = "Телефон")
    private String phone;

    @Column(name = "Факс")
    private String fax;

    @Column(name = "Электронный_адрес")
    private String email;
}
