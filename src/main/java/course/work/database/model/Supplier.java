package course.work.database.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Поставщик")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Название")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Сотрудник_для_связи")
    private SuppliersEmployee suppliersEmployee;

    @Column(name = "Адрес")
    private String address;

    @Column(name = "Телефон")
    private String phone;

    @Column(name = "Факс")
    private String fax;

    @Column(name = "Электронный_адрес")
    private String email;
}
